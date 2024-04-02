package Service;

import Model.Category;
import Model.Product;
import Model.User;
import Model.subModel.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private Connection connection = ConnectToMySQL.getConnection();
    private CategoryService categoryService = new CategoryService();

    public ProductService() {
    }
    public void addUser(Product product) {
        String sql = "insert into Product(?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setString(5, product.getImage());
            preparedStatement.setInt(6, );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> viewAll() {
        String sql = "select * from product;";
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
                String image = rs.getString("image");
                Category category = categoryService.findById(rs.getInt("idcategory"));
                Product product = new Product(id, name, price, quantity, image, category);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public void edit(int id, Product product) {
    }


    public void delete(int id) {
    }

    public int findIndexById(int id) {
        return -1;
    }

    public Product findById(int id) {
        return null;
    }


}
