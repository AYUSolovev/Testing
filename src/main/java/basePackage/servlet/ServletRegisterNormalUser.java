package basePackage.servlet;

import basePackage.model.user.NormalUser;
import basePackage.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import basePackage.service.businessLayer.normalUser.NormalUserService;
import basePackage.service.businessLayer.normalUser.NormalUserServiceImpl;
import basePackage.singleton.Singleton;

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
