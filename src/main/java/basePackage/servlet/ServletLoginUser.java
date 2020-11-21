package basePackage.servlet;

import basePackage.service.businessLayer.normalUser.NormalUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import basePackage.service.businessLayer.normalUser.NormalUserService;
import basePackage.singleton.Singleton;
import basePackage.model.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;


@WebServlet(name = "servletLoginUser", urlPatterns = "/user/login")
public class ServletLoginUser extends HttpServlet {

    @Autowired
    private NormalUserService normalUser = new NormalUserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        Singleton.getSingleton().setConnection("jdbc:h2:/C:/Users/tolya/Testing/DataBase/Testing");
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        User user;
        user = normalUser.getUser(login,password);
        PrintWriter pw = res.getWriter();
        if(user.getName() != null){
            session.setAttribute("user",user);
            pw.println("<body>");
            pw.println("<h1>Авторизация прошла успешно </h1>");
            pw.println("</body>");
        }
    }
}
