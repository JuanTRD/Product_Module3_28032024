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
    public void add(Product product) {
        String sql = "insert into product(name, price , quantity, image, IDCATEGORY) values (?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getImage());
            preparedStatement.setInt(5, product.getCategory().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> viewAll() {
        String sql = "select product.*, c.name as nameCategory from product join category c on c.id = product.IDCATEGORY order by product.id asc;";
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String image = rs.getString("image");
                int idCategory = rs.getInt("idcategory");
                String nameCategory = rs.getString("nameCategory");
                Category category = new Category(idCategory, nameCategory);
                Product product = new Product(id, name, price, quantity, image, category);
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    public void edit(int id, Product product) {
        String sql = "UPDATE product SET name = ?, price = ?, quantity = ?, image = ?, idCategory = ? WHERE id = ?;";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, product.getName());
                preparedStatement.setDouble(2, product.getPrice());
                preparedStatement.setInt(3, product.getQuantity());
                preparedStatement.setString(4, product.getImage());
                Category category = product.getCategory();
                preparedStatement.setInt(5, category.getId());
                preparedStatement.setInt(6, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }


    public void delete(int id) {
        String sql = "DELETE FROM product WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Product findById(int id) {
        String sql = "select product.*, c.name as nameCategory from product join category c on c.id = product.IDCATEGORY where product.id=?;";
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String image = rs.getString("image");
                int idCategory = rs.getInt("idcategory");
                String nameCategory = rs.getString("nameCategory");
                Category category = new Category(idCategory, nameCategory);
                product = new Product(id, name, price, quantity, image, category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    public List<Product> searchByName(String str) {
        List<Product> list = new ArrayList<Product>();
        String sql = "select * from product where name like ?;";
        String str2 = "%" + str + "%";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, str2);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String image = resultSet.getString("image");
                int idCategory = resultSet.getInt("idcategory");
                String nameCategory = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, nameCategory);
                Product product = new Product(id, name, price, quantity, image, category);
                list.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
