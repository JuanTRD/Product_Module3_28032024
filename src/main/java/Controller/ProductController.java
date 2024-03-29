package Controller;

import Model.Category;
import Model.Product;
import Service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "productController", value = "/product")
public class ProductController extends HttpServlet {
    private ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "home":
                showHomePage(req, resp);
                break;
            case "add":
                showAddPage(req, resp);
                break;
            case "edit":
                showEditPage(req, resp);
                break;
        }
    }

    private void showEditPage(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void showAddPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/add.jsp");
        dispatcher.forward(req, resp);
    }

    private void showHomePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        req.setAttribute("product", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/home.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "add":
                addProduct(req, resp);
                break;
        }
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String image = req.getParameter("image");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int idCategory = Integer.parseInt(req.getParameter("Category"));
        Category category = new Category(idCategory);
        Product newProduct = new Product(id, name, price, quantity,image, category);
        resp.sendRedirect("");
    }
}
