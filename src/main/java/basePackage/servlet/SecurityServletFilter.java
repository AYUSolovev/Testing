package basePackage.servlet;

import basePackage.model.user.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter(urlPatterns = "/user/*")
public class SecurityServletFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession(false);
        String str = ((HttpServletRequest) servletRequest).getRequestURI();
        if(str.equals("/user/login") || str.equals("/user/register")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else if(session != null) {
            User user = (User)session.getAttribute("user");
            String name = user.getName();
            if(name != null) {
                filterChain.doFilter(
                        servletRequest, servletResponse);
            }
        } else {
            throw new ServletException("You shall not pass!");
        }


    }
}
