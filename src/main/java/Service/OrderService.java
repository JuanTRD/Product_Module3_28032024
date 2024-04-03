package Service;

import Model.Customer;
import Model.Order;
import Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private Connection connection = ConnectToMySQL.getConnection();
    private List<Order> orderList = new ArrayList<>();

    public List<Order> viewAll(){
        String sql = "select order.*, c.name as nameCustomer from order join customer c on c.id =orders.idcustomer";
        List<Order> list = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                Timestamp time = Timestamp.valueOf(resultSet.getString("time"));
                int total = resultSet.getInt("total");
                int idCustomer = resultSet.getInt("idCustomer");
                String nameCustomer = resultSet.getString("nameCustomer");
                Customer customer = new Customer(idCustomer, nameCustomer);
                Order order = new Order (id, time, total,customer);
                list.add(order);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void creat(Order order) {
        orderList.add(order);
    }
    public int findIndexById(int id) {
        for(int i=0; i<orderList.size(); i++) {
            if(orderList.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    public Order findById(int id){
return orderList.get(findIndexById(id));
    }

}
