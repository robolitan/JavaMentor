package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static Connection connection;

    private Connector() {
    }

    private static String getConfiguration() {
        StringBuilder URL = new StringBuilder("jdbc:mysql://");
        URL.append("localhost:")
                .append("1111/")
                .append("db_task_1?")
                .append("user=root&")
                .append("password=admin&")
                .append("serverTimezone=UTC");
        return URL.toString();
    }

    public static Connection getConnection(){
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(getConfiguration());
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
