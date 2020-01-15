package servlets;

import services.UserService;
import utils.ReqHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/edit", name = "editUserServlet")
public class EditUserServlet extends HttpServlet implements ReqHelper {
    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (userService.editUser(getUserFromReq(req))) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        }
        req.setAttribute("usersList", userService.getAllUsers());
        req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", userService.getUserById(Integer.parseInt(getParametrs(req, "id"))));
        req.getRequestDispatcher("jsp/edit_user.jsp").forward(req, resp);
    }
}
