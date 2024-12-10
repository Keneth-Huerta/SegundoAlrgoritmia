
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

class BaseData {

    private static final String DB_URL = "jdbc:mysql://localhost/Basesita";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1420";

    private String user;
    private String pass;
    private String result = "";
    private String descri = "";
    public String idPedido = "";
    private Connection conexion;
    private String[] productos = new String[9];
    private String[] productosId = new String[9];

    public BaseData(String user, String pass, TipoOperacion operacion, String parametro, int parametro2, ArrayList<String> productosPedido, ArrayList<Integer> cantidadProducto) {
        this.user = user;
        this.pass = pass;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
            return;
        }

        try {

            try (Statement statement = conexion.createStatement()) {
                ResultSet resultado = statement
                        .executeQuery("SELECT * FROM usuarios WHERE nombre_usuario = '" + user + "'");

                if (resultado.next()) {
                    String passDB = resultado.getString("contrasena");
                    boolean esAdmin = resultado.getBoolean("es_administrador");
                    int idUser = resultado.getInt("id");

                    if (pass.equals(passDB)) {
                        result = esAdmin ? "admin" : "user";

                        if (esAdmin) {
                            switch (operacion) {
                                case OBTENER_DESCRIPCION_CAJA:
                                    obtenerDescripcion(statement, parametro);
                                    break;
                                case CARGAR_ARCHIVO:
                                    cargarArchivo(statement, parametro);
                                    break;
                                case UPDATE_CAJAS:
                                    updateCajas(statement, parametro, parametro2);
                                default:
                            }
                        } else {
                            switch (operacion) {
                                case OBTENER_DESCRIPCION_CAJA:
                                    obtenerDescripcion(statement, parametro);
                                    break;
                                case CREAR_PEDIDO:
                                    crearPedido(idUser, productosPedido, cantidadProducto);
                                    int txt = JOptionPane.showConfirmDialog(null, "Quieres sacar tu ticket");
                                    if (txt == 0) {

                                        generarTicketPedido(Integer.parseInt(idPedido));
                                    }
                                    break;

                                default:
                            }
                        }
                    } else {
                        result = "incorrecta";
                    }
                } else {
                    result = "no existe";
                }
                resultado.close();
                statement.close();
            }
            conexion.close();
        } catch (SQLException e) {
            System.err.println("Error de base de datos: " + e.getMessage());
        }
    }

    private void crearPedido(int idUser, ArrayList<String> idCaja, ArrayList<Integer> cantidad) throws SQLException {
        int cantidadTotal = 0;

        String sqlPedido = "INSERT INTO Pedidos (id_cliente) VALUES (?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, idUser);
            pstmt.execute();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idPedido = rs.getInt(1) + "";
            } else {
                throw new SQLException("No generated keys found");
            }
        }
        String sqlProducto = "INSERT INTO productos_pedido (id_pedido, id_caja, cantidad) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sqlProducto)) {

            for (int i = 0; i < idCaja.size(); i++) {

                String sqlCantidad = "SELECT * FROM almacen WHERE id_caja=?";
                try (PreparedStatement pstmt2 = conexion.prepareStatement(sqlCantidad)) {

                    pstmt2.setInt(1, Integer.parseInt(idCaja.get(i)));
                    ResultSet rs = pstmt2.executeQuery();
                    if (rs.next()) {
                        cantidadTotal = rs.getInt("cantidad");
                    }
                }

                if (cantidadTotal >= cantidad.get(i)) {
                    String sqlUpdate = "UPDATE almacen SET cantidad=? WHERE id_caja=?";
                    try (PreparedStatement pstmt2 = conexion.prepareStatement(sqlUpdate)) {

                        pstmt2.setInt(1, cantidadTotal - cantidad.get(i));
                        pstmt2.setInt(2, Integer.parseInt(idCaja.get(i)));
                        pstmt2.executeUpdate();
                    }
                    pstmt.setString(1, idPedido);
                    pstmt.setInt(2, Integer.parseInt(idCaja.get(i)));
                    pstmt.setInt(3, cantidad.get(i));
                    pstmt.addBatch();

                }

            }
            pstmt.executeBatch();
        }

    }

    public enum TipoOperacion {
        AUTENTICACION_BASICA, OBTENER_DESCRIPCION_CAJA, CARGAR_ARCHIVO, UPDATE_CAJAS, CREAR_PEDIDO, CERRAR_PEDIDO, GENERAR_TICKET
    }

    public BaseData(String user, String pass) {
        this(user, pass, TipoOperacion.AUTENTICACION_BASICA, null, 0, null, null);
    }

    private void obtenerDescripcion(Statement statement, String idCaja) throws SQLException {
        if (idCaja == null) {
            return;
        }
        if (idCaja.equalsIgnoreCase("todas")) {
            ResultSet resultadoCaja = statement.executeQuery("SELECT * FROM Cajas");
            int i = 0;
            while (resultadoCaja.next()) {
                productos[i] = resultadoCaja.getString("descripcion");
                productosId[i] = resultadoCaja.getString("id");
                i++;
            }
        } else {
            ResultSet resultadoCaja = statement.executeQuery("SELECT * FROM Cajas WHERE id = '" + idCaja + "'");
            if (resultadoCaja.next()) {
                descri = resultadoCaja.getString("descripcion");
            }
        }
    }

    private void generarTicketPedido(int idPedido) throws SQLException {
        try {
            String sqlPedido = "SELECT p.id_pedido, p.fecha_pedido, p.estado_pedido, u.nombre_usuario "
                    + "FROM Pedidos p "
                    + "JOIN usuarios u ON p.id_cliente = u.id "
                    + "WHERE p.id_pedido = ?";

            String sqlProductos = "SELECT c.descripcion, c.presentacion, pp.cantidad "
                    + "FROM productos_pedido pp "
                    + "JOIN Cajas c ON pp.id_caja = c.id "
                    + "WHERE pp.id_pedido = ?";

            try (PreparedStatement pstmtPedido = conexion.prepareStatement(sqlPedido); PreparedStatement pstmtProductos = conexion.prepareStatement(sqlProductos)) {

                pstmtPedido.setInt(1, idPedido);
                pstmtProductos.setInt(1, idPedido);

                ResultSet rsPedido = pstmtPedido.executeQuery();
                ResultSet rsProductos = pstmtProductos.executeQuery();

                if (!rsPedido.next()) {
                    throw new SQLException("Pedido no encontrado");
                }

                String nombreArchivo = "ticket_pedido_" + idPedido + ".txt";
                try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
                    writer.println("===================================");
                    writer.println("           TICKET DE PEDIDO");
                    writer.println("===================================");
                    writer.println("Número de Pedido: " + rsPedido.getInt("id_pedido"));
                    writer.println("Fecha de Pedido: " + rsPedido.getTimestamp("fecha_pedido"));
                    writer.println("Estado del Pedido: " + rsPedido.getString("estado_pedido"));
                    writer.println("Cliente: " + rsPedido.getString("nombre_usuario"));
                    writer.println("-----------------------------------");
                    writer.println("Detalle de Productos:");

                    while (rsProductos.next()) {
                        writer.println("- " + rsProductos.getString("descripcion")
                                + "-- Presentación: " + rsProductos.getString("presentacion")
                                + " Cantidad: " + rsProductos.getInt("cantidad"));
                    }

                    writer.println("===================================");
                    writer.println("         ¡GRACIAS POR SU COMPRA!");
                    writer.println("===================================");
                }
            }
        } catch (IOException e) {
            throw new SQLException("Error al generar el archivo de ticket: " + e.getMessage());
        }
    }

    private void cargarArchivo(Statement statement, String path) throws SQLException {
        if (path == null || path.isEmpty()) {
            return;
        }

        statement.execute("LOAD DATA LOCAL INFILE '" + path + "' INTO TABLE Cajas CHARACTER SET utf8 "
                + "FIELDS TERMINATED BY ',' LINES TERMINATED BY '\\n' IGNORE 1 LINES");
    }

    private void updateCajas(Statement statement, String idCaja, int cantidad) throws SQLException {
        if (idCaja == null) {
            return;
        }
        statement.executeUpdate("update almacen set cantidad=" + cantidad + " where id=" + idCaja);
    }

    public String getResult() {
        return result;
    }

    public String getDescri() {
        return descri;
    }

    public String[] getProductos() {
        return productos;
    }

    public String[] getProductosId() {
        return productosId;
    }
}
