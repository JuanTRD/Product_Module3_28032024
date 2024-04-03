package Controller;

import Model.Category;
import Model.Customer;
import Service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCustomerController", value = "AdminCustomer")
public class AdminCustomerController extends HttpServlet {
    CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean check = this.checkUser(req);
        if (check) {
            String action = req.getParameter("action");
            switch (action) {
                case "home":
                    showCustomerHomePage(req, resp);
                    break;
                case "add":
                    showCustomerAddPage(req, resp);
                    break;
                case "edit":
                    showCustomerEditPage(req, resp);
                    break;
            }
        } else {
            resp.sendRedirect("http://localhost:8080/user?action=login");
        }
    }

    private void showCustomerEditPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idEdit = Integer.parseInt(req.getParameter("idEdit"));
        req.setAttribute("idEdit", idEdit);
        Customer customerEdit = customerService.findById(idEdit);
        req.setAttribute("customerEdit", customerEdit);
        RequestDispatcher dispatcher = req.getRequestDispatcher("User/Admin/Customer/edit.jsp");
        dispatcher.forward(req, resp);
    }

    private void showCustomerAddPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("User/Admin/Customer/add.jsp");
        dispatcher.forward(req, resp);
    }

    private void showCustomerHomePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customers = customerService.viewAll();
        req.setAttribute("customers", customers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Users/Admin/Customer/home.jsp");
        dispatcher.forward(req, resp);

    }

    public boolean checkUser(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (session != null) {
            return session.getAttribute("idUser") != null;
        }
        return false;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {

            case "add":
                addCustomer(req, resp);
                break;
            case "edit":
                editCustomer(req, resp);
                break;
        }


    }

    private void editCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));
            Customer newCustomer = new Customer(id, name, age);
            customerService.edit(id, newCustomer);
            resp.sendRedirect("");

    }
    private void addCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        Customer newCustomer = new Customer(id,name, age);
        customerService.add(newCustomer);
        resp.sendRedirect("");
    }
}
