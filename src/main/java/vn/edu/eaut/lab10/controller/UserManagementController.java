package vn.edu.eaut.lab10.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import vn.edu.eaut.lab10.model.Role;
import vn.edu.eaut.lab10.model.User;
import vn.edu.eaut.lab10.repository.UserRepository;

@WebServlet(urlPatterns = {"/logout", "/admin/users"})
public class UserManagementController extends HttpServlet {
    private final UserRepository repository = new UserRepository();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getServletPath().equals("/logout")) {
            HttpSession session = req.getSession(false);
            if (session != null) session.invalidate();
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }
        req.setAttribute("users", repository.findAll());
        req.getRequestDispatcher("/admin/users.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        User user = repository.findById(Integer.valueOf(req.getParameter("id")));
        if (user != null) {
            user.setFullName(req.getParameter("fullName"));
            user.setRole(Role.valueOf(req.getParameter("role")));
            user.setActive("true".equals(req.getParameter("active")));
            repository.update(user);
        }
        resp.sendRedirect(req.getContextPath() + "/admin/users");
    }
}
