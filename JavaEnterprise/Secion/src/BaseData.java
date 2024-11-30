
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseData {

    private String user, pass, path = "", result = "";
    private boolean cargarC = false;

    public BaseData(String user, String pass) {

        this.user = user;
        this.pass = pass;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost/Basesita", "root", "1420");
            Statement miStatement = miConexion.createStatement();
            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM usuarios WHERE nombre_usuario = '" + user + "'");
            if (cargarC && !path.isEmpty()) {
                System.out.println("funciona");
                miStatement.execute("load data local infile '" + path + "' into table Cajas fields terminated by ',' lines terminated by '\\n' ignore 1 line ");
                cargarC = false;
                System.out.println("cargado");
            }
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
            if (miResultSet != null) {
                miResultSet.close();
            }
            if (miStatement != null) {
                miStatement.close();
            }
            if (miConexion != null) {
                miConexion.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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

            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost/Basesita?allowLoadLocalInfile=true", "root", "1420");
            Statement miStatement = miConexion.createStatement();
            ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM usuarios WHERE nombre_usuario = '" + user + "'");

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

                miStatement.execute("load data local infile '" + path + "' into table Cajas CHARACTER SET utf8 fields terminated by ',' lines terminated by '\\n' ignore 1 lines ");
                
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

    public void CheckPass(String user, String pass, boolean type) {

        if (this.user.equals(user)) {
            if (this.pass.equals(pass)) {

                if (type) {
                    result = "admin";
                } else {

                    result = "user";
                }
            } else {

            }

        }
    }
}
