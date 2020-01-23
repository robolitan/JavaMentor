package servlets;

import factories.UserDaoFactory;
import models.User;
import services.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {
    UserService userService = UserService.getInstance(new UserDaoFactory().getUserDAO());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user;
        if ((user = userService.authUser(name, password)) != null) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("loggedUser", user);
            if (user.getRole().equals("admin")) {
                resp.sendRedirect("/admin/all");
            } else {
                resp.sendRedirect("/user");
            }
        } else {
            resp.sendRedirect("/login");
        }
    }
}

