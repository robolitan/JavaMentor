package dao;

import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.dbconnection.HibernateConnector;
import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class UserHibernateDAO implements UserDAO {
    private SessionFactory sessionFactory;

    public UserHibernateDAO() {
        sessionFactory = new HibernateConnector().getSessionFactory();
    }

    @Override
    public boolean addUser(User user) throws SQLException {
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
        String hql = "UPDATE User SET " +
                " f_name = :f_name" +
                ",l_name = :l_name" +
                ",password = :password" +
                ",birthday =:birthday where id_user = :id";
        Query query = session.createQuery(hql);
        query.setParameter("f_name", user.getfirstName());
        query.setParameter("l_name", user.getLastName());
        query.setParameter("password", user.getPassword());
        query.setParameter("birthday", user.getBirthday());
        query.setParameter("id", user.getId());
        query.executeUpdate();
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteUserById(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(new User(id, null, null, null, null));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean userExist(User user) throws SQLException, NoResultException {
        Session session = sessionFactory.openSession();
        String hql = "FROM User WHERE f_name = :f_name AND l_name = :l_name AND password = :password";
        Query query = session.createQuery(hql);
        query.setParameter("f_name", user.getfirstName());
        query.setParameter("l_name", user.getfirstName());
        query.setParameter("password", user.getfirstName());
        User fUser = (User) query.getSingleResult();
        session.close();
        return true;
    }

    @Override
    public List<User> getAllUser() throws SQLException, NoResultException {
        String hql = "FROM User";
        Session session = sessionFactory.openSession();
        List<User> list = session.createQuery(hql).getResultList();
        session.close();
        return list;
    }

    @Override
    public User getUserById(int id) throws SQLException, NoResultException {
        String hql = "FROM User WHERE id_user = :id";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        User userByid = (User) query.setParameter("id", id).getSingleResult();
        session.close();
        return userByid;
    }
}
