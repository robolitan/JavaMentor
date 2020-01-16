package services;

import dao.UserDAO;
import models.User;
import utils.Connector;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private Connection connection;

    public UserService() {
        this.connection = Connector.getConnection();
    }

    public boolean addUser(User user) {
        try {
            return getUserDAO().addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private UserDAO getUserDAO() {
        return new UserDAO(connection);
    }

    public List<User> getAllUsers() {
        try {
            return getUserDAO().getAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
            return List.of();
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
        }
        return false;
    }
}
