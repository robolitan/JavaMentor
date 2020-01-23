package services;

import dao.UserDAO;
import models.User;
import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static UserService instance;
    private UserDAO userDAO;

    private UserService(UserDAO dao) {
        this.userDAO = dao;
    }

    public boolean addUser(User user) {
        try {
            return getUserDAO().addUser(user);
        } catch (SQLException e) {
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
            return false;
        }
    }

    public User getUserById(int id) {
        try {
            return getUserDAO().getUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean editUser(User user) {
        try {
            return getUserDAO().editUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User authUser(String name, String password){
        try {
            return getUserDAO().authUser(name,password);
        } catch (SQLException | NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    private UserDAO getUserDAO() {
        return userDAO;
    }

    public static UserService getInstance(UserDAO dao) {
        if (instance == null) {
            instance = new UserService(dao);
        }
        return instance;
    }
}
