package servlet;

import model.user.NormalUser;
import model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import service.businessLayer.normalUser.NormalUserService;
import service.businessLayer.normalUser.NormalUserServiceImpl;
import service.dataLayer.normalUser.NormalUserAccessService;
import service.dataLayer.normalUser.NormalUserAccessServiceImpl;
import singleton.Singleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;


@WebServlet(name = "servletRegisterNormalUser", urlPatterns = "/user/register")
public class ServletRegisterNormalUser extends HttpServlet {

    @Autowired
    private NormalUserService normalUser = new NormalUserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        Singleton.getSingleton().setConnection("jdbc:h2:/C:/Users/tolya/Testing/DataBase/Testing");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new NormalUser();
        user.setLogin(login);
        user.setName(name);
        user.setPassword(password);
        normalUser.addUser(user);
    }
}
