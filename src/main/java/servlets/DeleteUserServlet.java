package servlets;

import models.User;
import services.UserService;
import utils.ReqHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/delete", name = "deleteUserPatern")
public class DeleteUserServlet extends HttpServlet implements ReqHelper {
    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = getParametrs(req,"id");
        if (userService.deleteUserById(Integer.parseInt(req.getParameter("id")))) {
            resp.setStatus(HttpServletResponse.SC_OK);
        }else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        List<User> list = userService.getAllUsers();
        req.setAttribute("usersList", list);
        req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/edit_user.jsp").forward(req, resp);
    }

}
