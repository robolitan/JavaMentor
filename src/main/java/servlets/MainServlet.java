package servlets;

import dao.UserJdbcDAO;
import services.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/main", name = "mainServlet")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("usersList", new UserService(new UserJdbcDAO()).getAllUsers());
        req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
    }
}
