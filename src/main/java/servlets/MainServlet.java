package servlets;

import services.UserService;
import utils.ReqHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/main", name = "mainServlet" )
public class MainServlet extends HttpServlet implements ReqHelper {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("usersList", new UserService().getAllUsers());
        req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
    }
}
