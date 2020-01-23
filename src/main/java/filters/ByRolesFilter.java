package filters;

import factories.UserDaoFactory;
import models.User;
import services.UserService;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/login", "/user", "/admin/*"})
public class ByRolesFilter implements Filter {
    UserService userService = UserService.getInstance(new UserDaoFactory().getUserDAO());
    FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String path = request.getServletPath();
        HttpSession httpSession = request.getSession(false);
        if (httpSession != null && httpSession.getAttribute("loggedUser") != null) {
            User user = (User) httpSession.getAttribute("loggedUser");
            if (path.contains("/admin") && user.getRole().equals("admin")) {
                request.getRequestDispatcher(path).forward(request,response);
            } else {
                request.getRequestDispatcher("/user").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/login").forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
