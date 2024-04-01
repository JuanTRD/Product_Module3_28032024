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
    private List<Customer> customerList = new ArrayList<>();
    private Connection connection = ConnectToMySQL.getConnection();

    public List<Customer> viewAll(){
        String sql = "SELECT * FROM customer";
        List<Customer> list = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Customer customer = new Customer (id, name);
                list.add(customer);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add(Customer customer) {
customerList.add(customer);
    }
    public void edit(int id, Customer customer) {
        int index = findIndexById(id);
        customerList.set(index,customer);
    }

    public void delete(int id) {
        int index = findIndexById(id);
        customerList.remove(index);
    }
    public int findIndexById(int id){
        for(int i=0; i<customerList.size(); i++){
            if(customerList.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }
    public int findIndexByName(String name){
        for(int i=0; i<customerList.size();i++){
            if(customerList.get(i).getName()==name){
                return i;
            }
        }
        return -1;
    }
    public Customer findById(int id){
        return customerList.get(findIndexById(id));
    }
    public Customer findByName(String name){
        return customerList.get(findIndexByName(name));
    }
}
