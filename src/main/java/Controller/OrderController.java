//package Controller;
//
//import Model.Category;
//import Model.Order;
//import Model.Product;
//import Service.OrderService;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet (name = "orderController", value = "/order")
//public class OrderController extends HttpServlet {
//    private OrderService orderService = new OrderService();
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String action = req.getParameter("action");
//        switch (action) {
//            case "home":
//                showHomePage(req, resp);
//                break;
//            case "add":
//                showAddPage(req, resp);
//                break;
//            case "edit":
//                showEditPage(req, resp);
//                break;
//            case "delete":
//                deleteOrder(req, resp);
//                break;
//
//        }
//
//    }
//    private void deleteOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        int idDelete = Integer.parseInt(req.getParameter("idDelete"));
//        orderService.delete(idDelete);
//        resp.sendRedirect("http://localhost:8080/adminProduct?action=home");
//    }
//    private void showEditPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int idEdit = Integer.parseInt(req.getParameter("idEdit"));
//        req.setAttribute("idEdit", idEdit);
//        Product productEdit = productService.findById(idEdit);
//        req.setAttribute("productEdit", productEdit);
//        List<Category> list = categoryService.viewAll();
//        req.setAttribute("list", list);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("Users/Admin/Order/edit.jsp");
//        dispatcher.forward(req, resp);
//
//    }
//
//    private void showAddPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher dispatcher = req.getRequestDispatcher("Users/Admin/Order/add.jsp");
//        dispatcher.forward(req, resp);
//    }
//
//    private void showHomePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Order> orderList = orderService.viewAll();
//        req.setAttribute("orderList", orderList);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("Users/Admin/Order/home.jsp");
//        dispatcher.forward(req, resp);
//    }
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        switch (action) {
//            case "add":
//                addProduct(req, resp);
//                break;
//            case "edit":
//                editProduct(req, resp);
//                break;
//
//        }
//    }
//    private void editProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        String name = req.getParameter("name");
//        double price = Double.parseDouble(req.getParameter("price"));
//        String image = req.getParameter("image");
//        int quantity = Integer.parseInt(req.getParameter("quantity"));
//        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
//        Category category = new Category(idCategory);
//        Product newProduct = new Product(name, price, quantity, image, category);
//        productService.edit(id, newProduct);
//        resp.sendRedirect("http://localhost:8080/order?action=home");
//    }
//
//    private void addProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//
//        String name = req.getParameter("name");
//        double price = Double.parseDouble(req.getParameter("price"));
//        String image = req.getParameter("image");
//        int quantity = Integer.parseInt(req.getParameter("quantity"));
//        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
//        Category category = new Category(idCategory);
//        Product newProduct = new Product(name, price, quantity, image, category);
//        productService.add(newProduct);
//        resp.sendRedirect("http://localhost:8080/order?action=home");
//    }
//
//}
