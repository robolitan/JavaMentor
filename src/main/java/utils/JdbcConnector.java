package utils;

import java.sql.Connection;

public class JdbcConnector {
    private static Connection connection;
    private static JdbcConnector instance;

    private JdbcConnector() {
        connection = DBHelper.getInstance().getConnection();
    }

    public static JdbcConnector getInstance() {
        if (instance == null) {
            instance = new JdbcConnector();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
