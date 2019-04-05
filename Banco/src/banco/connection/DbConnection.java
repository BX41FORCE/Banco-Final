package banco.connection;


import java.sql.*;

public class DbConnection {

    /**
     * Parametros de conexion
     */
    static String bd = "Banco";
    static String login = "postgres";
    static String password = "12345";
    static String url = "jdbc:postgresql://localhost/" + bd;

    Connection connection = null;

    /**
     * Constructor de DbConnection
     */
    public DbConnection() {
        try {
            //obtenemos el driver de para postgreSQL
            Class.forName("org.postgresql.Driver");
            //obtenemos la conexión
            connection = DriverManager.getConnection(url, login, password);

            if (connection != null) {
                System.out.println("Conexión a base de datos " + bd + " OK\n");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Permite retornar la conexión
     * @return 
     */
    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {
        connection = null;
    }
}

