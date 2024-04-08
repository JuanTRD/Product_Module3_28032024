
package Controller;

import Service.RoleService;
import Service.UserService;
import org.omg.CORBA.StringHolder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "userController", value = "/login")
public class UserController extends HttpServlet {
    private UserService userService = new UserService();
    private RoleService roleService = new RoleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String action = req.getParameter("action");

        switch (action) {
            case "login":
                showLoginForm(req, resp);
                break;


        }

    }

    private void showLoginForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("Users/Login/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "login":
                login(req, resp);
                break;

        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(userService.checkUser(username, password)){
            int id = userService.getIdUser(username, password);
            HttpSession session = req.getSession();
            session.setAttribute("idUser", id);
            System.out.println(id);
            System.out.println(userService.checkRole(id));
            if(userService.checkRole(id)==1){
                resp.sendRedirect("http://localhost:8080/adminProduct?action=home");
            } else {
                resp.sendRedirect("http://localhost:8080/userProduct?action=home");
            }

        } else {
            resp.sendRedirect("http://localhost:8080/login?action=login");
        }
    }
}
