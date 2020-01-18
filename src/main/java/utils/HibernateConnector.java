package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateConnector {
    private static HibernateConnector instance;
    private static SessionFactory sessionFactory;

    private HibernateConnector() {
        sessionFactory = createSessionFactory();
    }

    private SessionFactory createSessionFactory() {
        Configuration cfg = DBHelper.getInstance().getConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties());
        return cfg.buildSessionFactory(builder.build());
    }

    public static HibernateConnector getInstance() {
        if (instance == null) {
            instance = new HibernateConnector();
        }
        return instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
