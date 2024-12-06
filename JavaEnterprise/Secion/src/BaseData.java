
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseData {

    private String user, pass, descri, idC, path = "", result = "";
    private boolean cargarC = false, clicIdC = false;

    public BaseData(String user, String pass) {

        this.user = user;
        this.pass = pass;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            boolean esAdmin = false;

            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost/Basesita", "root", "1420");
            Statement miStatement = miConexion.createStatement();
            ResultSet miResultSet = miStatement
                    .executeQuery("SELECT * FROM usuarios WHERE nombre_usuario = '" + user + "'");

            if (miResultSet.next()) {

                String passDB = miResultSet.getString("contrasena");
                esAdmin = miResultSet.getBoolean("es_administrador");
                if (pass.equals(passDB)) {
                    result = esAdmin ? "admin" : "user";
                } else {
                    result = "incorrecta";
                }
            } else {
                result = "no existe";
            }
            if (esAdmin && clicIdC) {

                obtenerDescripcion(miStatement);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BaseData(String user, String pass, String idC, int cantidad, boolean clicIdC) {
        this.idC = idC;
        this.clicIdC = clicIdC;
        this.user = user;
        this.pass = pass;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            boolean esAdmin = false;

            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost/Basesita", "root", "1420");
            Statement miStatement = miConexion.createStatement();
            ResultSet miResultSet = miStatement
                    .executeQuery("SELECT * FROM usuarios WHERE nombre_usuario = '" + user + "'");

            if (miResultSet.next()) {

                String passDB = miResultSet.getString("contrasena");
                esAdmin = miResultSet.getBoolean("es_administrador");
                if (pass.equals(passDB)) {
                    result = esAdmin ? "admin" : "user";
                } else {
                    result = "incorrecta";
                }
            } else {
                result = "no existe";
            }
            if (esAdmin && clicIdC) {

                obtenerDescripcion(miStatement);
            } else {

                miStatement.executeUpdate("update Cajas set cantidad=" + cantidad + " where id=" + idC);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void obtenerDescripcion(Statement statement) throws SQLException {
        ResultSet idCaja = statement.executeQuery("select * from Cajas where id = '" + idC + "'");
        if (idCaja.next()) {

            descri = idCaja.getString("descripcion");

        }
    }

    public String getDescri() {
        return descri;
    }

    public BaseData(String user, String pass, boolean cargarC, String path) {
        this.cargarC = cargarC;
        this.path = path;
        this.user = user;
        this.pass = pass;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            Connection miConexion = DriverManager
                    .getConnection("jdbc:mysql://localhost/Basesita?allowLoadLocalInfile=true", "root", "1420");
            Statement miStatement = miConexion.createStatement();
            ResultSet miResultSet = miStatement
                    .executeQuery("SELECT * FROM usuarios WHERE nombre_usuario = '" + user + "'");

            if (miResultSet.next()) {

                String passDB = miResultSet.getString("contrasena");
                boolean esAdmin = miResultSet.getBoolean("es_administrador");
                if (pass.equals(passDB)) {
                    result = esAdmin ? "admin" : "user";
                } else {
                    result = "incorrecta";
                }
            } else {
                result = "no existe";
            }
            if (cargarC && !path.isEmpty()) {

                miStatement.execute("load data local infile '" + path
                        + "' into table Cajas CHARACTER SET utf8 fields terminated by ',' lines terminated by '\\n' ignore 1 lines ");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCargarC(boolean cargarC) {
        this.cargarC = cargarC;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getResult() {
        return result;
    }

}
