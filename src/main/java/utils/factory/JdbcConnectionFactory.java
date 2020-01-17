package utils.factory;

import utils.dbconnection.Connector;
import utils.dbconnection.JdbcConnector;
import utils.factory.ConnectionFactory;

public class JdbcConnectionFactory implements ConnectionFactory {
    @Override
    public Connector createConnection() {
        return new JdbcConnector();
    }
}
