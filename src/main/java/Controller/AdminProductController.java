package Controller;

import Model.Category;
import Model.Product;
import Service.CategoryService;
import Service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productController", value = "/adminProduct")
public class AdminProductController extends HttpServlet {
    private ProductService productService = new ProductService();
    private CategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        boolean check = this.checkUser(req);
//        if (check) {
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
                    case "delete":
                        deleteProduct(req, resp);
                        break;
                case "searchName":
                    showSearchNamePage(req, resp);
                    break;
            }
//        } else {
//            resp.sendRedirect("http://localhost:8080/login?action=login");
//        }
    }

    private void showSearchNamePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputName = req.getParameter("inputName");
        List<Product> searchProductList = productService.searchByName(inputName);
        System.out.println(searchProductList.size());
        req.setAttribute("list", searchProductList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Users/Admin/Product/searchName.jsp");
        dispatcher.forward(req, resp);
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idDelete = Integer.parseInt(req.getParameter("idDelete"));
        productService.delete(idDelete);
        resp.sendRedirect("http://localhost:8080/adminProduct?action=home");
    }

    //public boolean checkUser(HttpServletRequest req){
//        HttpSession session = req.getSession();
//        if(session != null){
//            return session.getAttribute("idUser") != null;
//        }
//        return false;
//}
    private void showEditPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idEdit = Integer.parseInt(req.getParameter("idEdit"));
        req.setAttribute("idEdit", idEdit);
        Product productEdit = productService.findById(idEdit);
        req.setAttribute("productEdit", productEdit);
        List<Category> list = categoryService.viewAll();
        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Users/Admin/Product/edit.jsp");
        dispatcher.forward(req, resp);

    }

    private void showAddPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> list = this.categoryService.viewAll();
        req.setAttribute("list",list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Users/Admin/Product/add.jsp");
        dispatcher.forward(req, resp);
    }

    private void showHomePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productService.viewAll();
        req.setAttribute("productList", productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Users/Admin/Product/home.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "add":
                addProduct(req, resp);
                break;
            case "edit":
                editProduct(req, resp);
                break;

        }
    }

    private void editProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String image = req.getParameter("image");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        Category category = new Category(idCategory);
        Product newProduct = new Product(name, price, quantity, image, category);
        productService.edit(id, newProduct);
        resp.sendRedirect("http://localhost:8080/adminProduct?action=home");
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String image = req.getParameter("image");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        Category category = new Category(idCategory);
        Product newProduct = new Product(name, price, quantity, image, category);
        productService.add(newProduct);
        resp.sendRedirect("http://localhost:8080/adminProduct?action=home");
    }
}
