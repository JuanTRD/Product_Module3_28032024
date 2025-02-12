package Controller;

import Filter.SessionUser;
import Model.Category;

import Model.Product;
import Service.CategoryService;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCategoryController", value = "/adminCategory")
public class AdminCategoryController extends HttpServlet {

    CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean check = SessionUser.checkUser(req);
        if (check) {
            String action = req.getParameter("action");
            switch (action) {
                case "home":
                    showCategoryHomePage(req, resp);
                    break;
                case "add":
                    showCategoryAddPage(req, resp);
                    break;
                case "edit":
                    showCategoryEditPage(req, resp);
                    break;
            }
        } else {
            resp.sendRedirect("http://localhost:8080/login?action=login");
        }


    }

    private void showCategoryEditPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idEdit = Integer.parseInt(req.getParameter("idEdit"));
        req.setAttribute("idEdit", idEdit);
        Category categoryEdit = categoryService.findById(idEdit);
        req.setAttribute("categoryEdit", categoryEdit);
        RequestDispatcher dispatcher = req.getRequestDispatcher("User/Admin/Category/edit.jsp");
        dispatcher.forward(req, resp);
    }

    private void showCategoryAddPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("User/Admin/Category/add.jsp");
        dispatcher.forward(req, resp);
    }

    private void showCategoryHomePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = categoryService.viewAll();
        req.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("Users/Admin/Category/home.jsp");
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
                addCategory(req, resp);
                break;
            case "edit":
                editCategory(req, resp);
                break;
        }
    }
    private void editCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Category newCategory = new Category(id, name);
        categoryService.edit(id,newCategory);
        resp.sendRedirect("");
    }
    private void addCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Category newCategory = new Category(id, name);
        categoryService.add(newCategory);
        resp.sendRedirect("");
    }
}
