package servlets;

import dao.UserJdbcDAO;
import services.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete", name = "deleteUserPatern")
public class DeleteUserServlet extends HttpServlet {
    UserService userService = new UserService(new UserJdbcDAO());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (userService.deleteUserById(Integer.parseInt(req.getParameter("id")))) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        resp.sendRedirect("/main");
    }
}
