package services;

import dao.UserDAO;
import models.User;
import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO dao) {
        this.userDAO = dao;
    }

    public boolean addUser(User user) {
        try {
            return getUserDAO().addUser(user);
        } catch (SQLException| NoResultException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<User> getAllUsers() {
        try {
            return getUserDAO().getAllUser();
        } catch (SQLException | NoResultException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public boolean deleteUserById(int id) {
        try {
            return getUserDAO().deleteUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUserById(int id) {
        try {
            return getUserDAO().getUserById(id);
        } catch (SQLException | NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean editUser(User user) {
        try {
            return getUserDAO().editUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private UserDAO getUserDAO() {
        return userDAO;
    }
}
