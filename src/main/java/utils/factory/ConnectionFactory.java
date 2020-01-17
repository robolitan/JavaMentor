package utils.factory;

import utils.dbconnection.Connector;

public interface ConnectionFactory {
    Connector createConnection();
}
