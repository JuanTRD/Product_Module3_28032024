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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserProductController", value = "/userProduct")
public class UserProductController extends HttpServlet {
    private ProductService productService = new ProductService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        boolean check = this.checkUser(req);
//        if (check) {
            String action = req.getParameter("action");
            switch (action) {
                case "home":
                    showHomePage(req, resp);
                    break;


            }
//        } else {
//            resp.sendRedirect("http://localhost:8080/user?action=login");
//        }
    }
//    public boolean checkUser(HttpServletRequest req){
//        HttpSession session = req.getSession();
//        if(session != null){
//            return session.getAttribute("idUser") != null;
//        }
//        return false;
//    }




    private void showHomePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productService.viewAll();
        req.setAttribute("productList", productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Users/User/Product/home.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }



}
