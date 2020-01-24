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

@WebServlet(urlPatterns = "/admin/edit", name = "editUserServlet")
public class EditUserServlet extends HttpServlet {
    UserService userService = UserService.getInstance(new UserDaoFactory().getUserDAO());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User userForEdit = userService.getUserById(id);
        userForEdit.setFirstName(req.getParameter("firstName"));
        userForEdit.setLastName(req.getParameter("lastName"));
        userForEdit.setBirthday(Date.valueOf(req.getParameter("birthday")));
        if (userService.editUser(userForEdit)) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        resp.sendRedirect("/admin/all");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user", userService.getUserById(Integer.parseInt(req.getParameter("id"))));
        req.getRequestDispatcher("/jsp/edit_user.jsp").forward(req, resp);
    }
}
