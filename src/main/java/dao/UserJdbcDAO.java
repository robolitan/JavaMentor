package dao;

import models.User;
import utils.dbconnection.JdbcConnector;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {
    private Connection connection;

    public UserJdbcDAO() {
        this.connection = JdbcConnector.getInstance().getConnection();
    }

    public boolean addUser(User user) throws SQLException {
        if (userExist(user)) {
            return false;
        }
        String sql = "INSERT INTO users (f_name,l_name, password, birthday) VALUES (?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, user.getfirstName());
        stmt.setString(2, user.getLastName());
        stmt.setString(3, user.getPassword());
        stmt.setDate(4, Date.valueOf(user.getBirthday()));
        return stmt.executeUpdate() > 0;
    }

    public List<User> getAllUser() throws SQLException {
        String sql = "SELECT * FROM db_task_1.users";
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        List<User> list = new ArrayList<>();
        while (!resultSet.isLast()) {
            resultSet.next();
            User user = getUserFromResultSet(resultSet);
            list.add(user);
        }
        return list;
    }

    public boolean deleteUserById(int id) throws SQLException {
        String sql = "DELETE FROM users WHERE id_user = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        return stmt.executeUpdate() > 0;
    }

    public boolean editUser(User user) throws SQLException {
        String sql = "UPDATE users SET f_name = ?,l_name = ?, birthday = ? WHERE id_user = ?;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, user.getfirstName());
        stmt.setString(2, user.getLastName());
        stmt.setDate(3, Date.valueOf(user.getBirthday()));
        stmt.setInt(4, user.getId());
        return stmt.executeUpdate() > 0;
    }

    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id_user = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet resultSet = stmt.executeQuery();
        User user = null;
        if (resultSet.next()) {
            user = getUserFromResultSet(resultSet);
        }
        return user;
    }

    public boolean userExist(User user) throws SQLException {
        String sql = "SELECT * FROM db_task_1.users WHERE f_name = ? AND l_name = ? AND password = ? ";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, user.getfirstName());
        stmt.setString(2, user.getLastName());
        stmt.setString(3, user.getPassword());
        return stmt.executeQuery().next();
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String first_name = resultSet.getString(2);
        String second_name = resultSet.getString(3);
        String password = resultSet.getString(4);
        LocalDate birthday = resultSet.getDate(5).toLocalDate();
        return new User(id, first_name,second_name, password, birthday);
    }
}
