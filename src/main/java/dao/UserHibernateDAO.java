package dao;

import models.User;

import java.sql.SQLException;
import java.util.List;

public class UserHibernateDAO implements UserDAO {
    @Override
    public boolean addUser(User user) throws SQLException {
        return false;
    }

    @Override
    public boolean editUser(User user) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteUserById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean userExist(User user) throws SQLException {
        return false;
    }

    @Override
    public List<User> getAllUser() throws SQLException {
        return null;
    }

    @Override
    public User getUserById(int id) throws SQLException {
        return null;
    }
}
