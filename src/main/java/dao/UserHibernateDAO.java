package dao;

import models.User;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateConnector;

import javax.persistence.NoResultException;
import java.sql.*;
import java.util.List;

public class UserHibernateDAO implements UserDAO {
    private SessionFactory sessionFactory;

    public UserHibernateDAO() {
        sessionFactory = HibernateConnector.getInstance().getSessionFactory();
    }

    @Override
    public boolean addUser(User user) throws SQLException, NoResultException {
        if (userExist(user)) {
            return false;
        }
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean editUser(User user) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.replicate(user, ReplicationMode.OVERWRITE);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteUserById(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.get(User.class, id));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean userExist(User user) throws SQLException {
        Session session = sessionFactory.openSession();
        User existUser = session.get(User.class, user.getId());
        session.close();
        return existUser != null;
    }

    @Override
    public List<User> getAllUser() throws SQLException, NoResultException {
        Session session = sessionFactory.openSession();
        List<User> list = session.createQuery("FROM User").list();
        session.close();
        return list;
    }

    @Override
    public User getUserById(int id) throws SQLException, NoResultException {
        Session session = sessionFactory.openSession();
        User userByid = session.get(User.class, id);
        session.close();
        return userByid;
    }

    @Override
    public User authUser(String name, String password) throws SQLException, NoResultException {
        Session session = sessionFactory.openSession();
        String hql = "FROM User WHERE f_name = :name AND password = :password";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        query.setParameter("password", password);
        User user =(User) query.getSingleResult();
        return user;
    }
}
