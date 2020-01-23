package servlets;

import factories.UserDaoFactory;
import models.User;
import services.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(urlPatterns = "/admin/add", name = "userServlet")
public class AddUserServlet extends HttpServlet{
    UserService userService = UserService.getInstance(new UserDaoFactory().getUserDAO());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("firstName");
        String second_name = req.getParameter("lastName");
        String password = req.getParameter("password");
        String birthday = req.getParameter("birthday");
        User user = new User(first_name, second_name, password, Date.valueOf(birthday));

        if (userService.addUser(user)) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        resp.sendRedirect("/admin/all");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/add_user.jsp").forward(req,resp);
    }
}
