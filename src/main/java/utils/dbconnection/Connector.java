package utils.dbconnection;

import java.sql.Connection;

public interface Connector<T> {
    Connection getConnection();
}
