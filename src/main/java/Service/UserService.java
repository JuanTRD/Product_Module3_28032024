package Service;

import Model.Product;
import Model.User;
import Model.subModel.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private Connection connection = ConnectToMySQL.getConnection();
    public UserService() {
    }

    public void addUser(User user) {
        String sql = "insert into user(id,username, password,idRole) values (?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getIdRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> viewAll() {
        String sql = "select * from user;";
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int idRole = rs.getInt("IDRole");
                User user = new User(id, username, password, idRole);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public boolean checkUser(String username, String password) {
        String sql = "select * from user;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String username1 = rs.getString("username");
                String password1 = rs.getString("password");
                if (username1 == username && password1 == password) {
                return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void edit(int id, User user) {
    }


    public void delete(int id) {
    }

    public int findIndexById(int id) {
        return -1;
    }
    public int getIdUser(String username, String password) {
        String sql = "SELECT * from user where username =? and password=?;";
        int id=-1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    public User findById(int id) {
        String sql = "SELECT * from user where id =?;";
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                Integer idRole = rs.getInt("idrole");
                user = new User(id, username, password,idRole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
