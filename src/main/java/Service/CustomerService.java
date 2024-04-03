package Service;

import Model.Customer;
import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private Connection connection = ConnectToMySQL.getConnection();
public CustomerService(){}
    public List<Customer> viewAll(){
        String sql = "SELECT * FROM customer";
        List<Customer> list = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Customer customer = new Customer (id, name, age);
                list.add(customer);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(Customer customer) {
        String sql = "INSERT INTO Customer(id,name,age) values (?,?,?);";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setInt(3, customer.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void edit(int id, Customer customer) {
        String sql = "UPDATE customer set name = ?, age = ?, where id = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setInt(2, customer.getAge());
            preparedStatement.setInt(3,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        }
    public int findIndexById(int id){

        return -1;
    }
    public int findIndexByName(String name){

        return -1;
    }
    public Customer findById(int id){ return null;
    }
    public Customer findByName(String name){
        return null;
    }
}
