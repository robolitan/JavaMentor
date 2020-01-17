package dao;

import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.factory.HibernateConnectionFactory;
import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class UserHibernateDAO implements UserDAO {
    private Session session;

    public UserHibernateDAO() {
//        this.session = new HibernateConnectionFactory().createConnection().getConnection();
    }

    @Override
    public boolean addUser(User user) throws SQLException {
        if (userExist(user)) {
            return false;
        }
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        return true;
    }

    @Override
    public boolean editUser(User user) throws SQLException {
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
        return true;
    }

    @Override
    public boolean deleteUserById(int id) throws SQLException {
        Transaction transaction = session.beginTransaction();
        session.delete(new User(id, null, null, null, null));
        transaction.commit();
        return true;
    }

    @Override
    public boolean userExist(User user) throws SQLException, NoResultException {
        String hql = "FROM User WHERE f_name = :f_name AND l_name = :l_name AND password = :password";
        Query query = session.createQuery(hql);
        query.setParameter("f_name", user.getfirstName());
        query.setParameter("l_name", user.getfirstName());
        query.setParameter("password", user.getfirstName());
        return (User) query.getSingleResult() != null;
    }

    @Override
    public List<User> getAllUser() throws SQLException, NoResultException {
        String hql = "FROM User";
        return session.createQuery(hql).getResultList();
    }

    @Override
    public User getUserById(int id) throws SQLException {
        String hql = "FROM User WHERE id_user = :id";
        Query query = session.createQuery(hql);
        return (User) query.setParameter("id", id).getSingleResult();
    }
}
