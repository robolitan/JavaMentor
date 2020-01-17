package utils.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnector {
    private static Connection connection;
    private static JdbcConnector jdbcConnector;

    private JdbcConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(getConfiguration());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static JdbcConnector getInstance() {
        if (jdbcConnector == null) {
            jdbcConnector = new JdbcConnector();
        }
        return jdbcConnector;
    }

    private String getConfiguration() {
        StringBuilder URL = new StringBuilder("jdbc:mysql://");
        URL.append("localhost:")
                .append("1111/")
                .append("db_task_1?")
                .append("user=root&")
                .append("password=admin&")
                .append("serverTimezone=UTC");
        return URL.toString();
    }

    public Connection getConnection() {
        return connection;
    }
}
