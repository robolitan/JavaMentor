package utils.dbconnection;

import models.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateConnector implements Connector {
    private static HibernateConnector hibernateConnector;
    private static SessionFactory sessionFactory;

    private HibernateConnector() {
        sessionFactory = createSessionFactory();
    }

    private Configuration getConfiguration() {
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(User.class);
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:1111/db_task_1?serverTimezone=UTC");
        cfg.setProperty("hibernate.connection.username", "root");
        cfg.setProperty("hibernate.connection.password", "admin");
        cfg.setProperty("hibernate.show_sql", "true");
        cfg.setProperty("hibernate.hbm2ddl.auto", "update");
        return cfg;
    }

    private SessionFactory createSessionFactory() {
        Configuration cfg = getConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties());
        return cfg.buildSessionFactory(builder.build());
    }

    public static HibernateConnector getInstance() {
        if (hibernateConnector == null) {
            hibernateConnector = new HibernateConnector();
        }
        return hibernateConnector;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
