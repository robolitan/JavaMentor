package servlets;

import models.User;
import services.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/add", name = "userServlet")
public class AddUserServlet extends HttpServlet{
    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameters = req.getParameterMap();
        String first_name = parameters.get("firstName")[0];
        String second_name = parameters.get("lastName")[0];
        String password = parameters.get("password")[0];
        String birthday = parameters.get("birthday")[0];
        User user = new User(first_name, second_name, password, LocalDate.parse(birthday));

        if (userService.addUser(user)) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        List<User> list = userService.getAllUsers();
        req.setAttribute("usersList", list);
        req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/add_user.jsp").forward(req, resp);
    }
}
