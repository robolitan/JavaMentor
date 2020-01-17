package utils.factory;

import utils.dbconnection.Connector;
import utils.dbconnection.HibernateConnector;
import utils.factory.ConnectionFactory;

public class HibernateConnectionFactory implements ConnectionFactory {
    @Override
    public Connector createConnection() {
        return new HibernateConnector();
    }
}
