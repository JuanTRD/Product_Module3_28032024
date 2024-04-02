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

    private List<Role> roleList = new ArrayList<>();
    private RoleService roleService = new RoleService();

    public UserService() {
    }

    public void addUser(User user) {
        String sql = "insert into user(?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, roleService.findIdRole());
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
                Role role = roleService.findById(idRole);
                User user = new User(id, username, password, role);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }


    public boolean checkUser(String username, String password) {
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
                return true;
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
                user = new User(id, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public int getIdUser(String username, String password) {
        ;
    }
}
