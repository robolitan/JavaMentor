package dao;

import models.Gender;
import models.User;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addUser(User user) throws SQLException {
        if (userExist(user)) {
            return false;
        }
        String sql = "INSERT INTO users (name, password, birthday, gender) VALUES (?,?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getPassword());
        stmt.setDate(3, Date.valueOf(user.getBirthday()));
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
        String sql = "UPDATE users SET name = ?, birthday = ? WHERE id_user = ?;";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1,user.getName());
        stmt.setDate(2, Date.valueOf(user.getBirthday()));
        stmt.setInt(3,user.getId());
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

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String password = resultSet.getString(3);
        LocalDate birthday = resultSet.getDate(4).toLocalDate();
        return new User(id, name, password, birthday);
    }

    private boolean userExist(User user) throws SQLException    {
        String sql = "SELECT * FROM db_task_1.users WHERE name = ? AND password = ? ";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getPassword());
        return stmt.executeQuery().next();
    }

}
