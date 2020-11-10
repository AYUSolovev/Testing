/*
import service.admuser.*;
import service.dataLayer.normalUser.NormalUserAccessService;
import service.dataLayer.normalUser.NormalUserAccessServiceImpl;
import singleton.Singleton;
import user.*;

import java.sql.SQLException;

public class TestNormalUserService {

    public static void main(String[] args) throws SQLException{
        Singleton.getSingleton().setConnection("jdbc:h2:/C:/Users/tolya/Testing/DataBase/Testing");
        TestNormalUserService testAdmUserService = new TestNormalUserService();
        //testAdmUserService.testCreate("Name1", "Login1", "Password1");
        testAdmUserService.testRead("login1","password1");
    }

    public void testCreate(String name, String login, String pass){
        User user = new NormalUser();
        user.setPassword(pass);
        user.setLogin(login);
        user.setName(name);
        AdmUserAccessService admUserService = new AnswerAccessServiceImpl();
        admUserService.createUser(user);
    }

    public void testRead(String login, String pass){
        User user = new NormalUser();
        NormalUserAccessService normalUserService = new NormalUserAccessServiceImpl();
        user = normalUserService.readUser(login,pass);
        System.out.print(user.getName() + " " + user.getLogin() + " " + user.getPassword());
    }
}
*/