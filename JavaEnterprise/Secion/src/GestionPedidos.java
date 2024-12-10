
import java.math.BigDecimal;
import java.sql.*;

public class GestionPedidos {

    private Connection connection;

    public GestionPedidos(Connection connection) {
        this.connection = connection;
    }

    public int iniciarPedido(String cliente) throws SQLException {
        String sql = "INSERT INTO Pedidos (cliente, estado_pedido) VALUES (?, 'ABIERTO')";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, cliente);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);  // Retorna el ID del pedido nuevo
            }
        }
        throw new SQLException("No se pudo crear el pedido");
    }

    public void agregarDetallePedido(int idPedido, String idCaja, int cantidad) throws SQLException {
        // Obtener precio de la caja
        String sqlPrecio = "SELECT precio FROM Cajas WHERE id = ?";
        String sqlDetalle = "INSERT INTO Detalles_Pedido (id_pedido, id_caja, cantidad, precio_unitario, subtotal) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmtPrecio = connection.prepareStatement(sqlPrecio); PreparedStatement pstmtDetalle = connection.prepareStatement(sqlDetalle)) {

            pstmtPrecio.setString(1, idCaja);
            ResultSet rsPrecio = pstmtPrecio.executeQuery();

            if (rsPrecio.next()) {
                BigDecimal precio = rsPrecio.getBigDecimal("precio");
                BigDecimal subtotal = precio.multiply(new BigDecimal(cantidad));

                pstmtDetalle.setInt(1, idPedido);
                pstmtDetalle.setString(2, idCaja);
                pstmtDetalle.setInt(3, cantidad);
                pstmtDetalle.setBigDecimal(4, precio);
                pstmtDetalle.setBigDecimal(5, subtotal);

                pstmtDetalle.executeUpdate();

                // Actualizar total del pedido
                actualizarTotalPedido(idPedido);
            }
        }
    }

    private void actualizarTotalPedido(int idPedido) throws SQLException {
        String sql = "UPDATE Pedidos "
                + "SET total_pedido = (SELECT SUM(subtotal) FROM Detalles_Pedido WHERE id_pedido = ?) "
                + "WHERE id_pedido = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, idPedido);
            pstmt.setInt(2, idPedido);
            pstmt.executeUpdate();
        }
    }

    public void cerrarPedido(int idPedido) throws SQLException {
        String sql = "UPDATE Pedidos SET estado_pedido = 'CERRADO' WHERE id_pedido = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, idPedido);
            pstmt.executeUpdate();
        }
    }
}
