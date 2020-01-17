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
import java.util.Map;

@WebServlet(urlPatterns = "/edit", name = "editUserServlet")
public class EditUserServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameters = req.getParameterMap();
        int id = Integer.parseInt(parameters.get("id")[0]);
        String firstName = parameters.get("firstName")[0];
        String lastName = parameters.get("lastName")[0];
        String password = parameters.get("password")[0];
        String birthday = parameters.get("birthday")[0];
        User user = new User(id, firstName,lastName,password, LocalDate.parse(birthday));

        if (userService.editUser(user)) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        resp.sendRedirect("/main");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", userService.getUserById(Integer.parseInt(req.getParameter("id"))));
        req.getRequestDispatcher("jsp/edit_user.jsp").forward(req, resp);
    }
}
