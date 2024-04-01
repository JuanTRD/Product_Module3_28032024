package Service;

import Model.Product;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private Connection connection = ConnectToMySQL.getConnection();
    private List<Product> productList = new ArrayList<>();

    public ProductService() {
    }
    public void add(Product product) {

    }
    public List<Product> viewAll() {
        return null;
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
