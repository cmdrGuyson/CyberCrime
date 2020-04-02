package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Connection {

    public static Connection connectToDatabase() {

        /*Credentials*/
        String URL = "jdbc:mysql://localhost:3306/cyber_crime";
        String username = "root";
        String password = "";

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, username, password);
            return connection;

        } catch (ClassNotFoundException | SQLException e) {

            System.out.println(e);
            return null;
        }
    }

    public static void disconnectFromDatabase(Connection connection) {

        try {

            connection.close();

        } catch (SQLException e) {

            System.out.println(e);
        }
    }
}
