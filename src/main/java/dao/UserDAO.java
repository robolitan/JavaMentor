package dao;

import models.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

interface UserDAO {
    boolean addUser(User user) throws SQLException;

    boolean editUser(User user) throws SQLException;

    boolean deleteUserById(int id) throws SQLException;

    boolean userExist(User user) throws SQLException;

    List<User> getAllUser() throws SQLException;

    User getUserById(int id) throws SQLException;
}
