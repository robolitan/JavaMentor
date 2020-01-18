package servlets;

import dao.UserDaoFactory;
import models.User;
import services.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = "/add", name = "userServlet")
public class AddUserServlet extends HttpServlet{
    UserService userService = new UserService(UserDaoFactory.getInstance().getUserDAO());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("firstName");
        String second_name = req.getParameter("lastName");
        String password = req.getParameter("password");
        String birthday = req.getParameter("birthday");
        User user = new User(first_name, second_name, password, LocalDate.parse(birthday));

        if (userService.addUser(user)) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        resp.sendRedirect("/main");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/add_user.jsp").forward(req,resp);
    }
}
