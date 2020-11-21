/*

import service.admuser.*;
import Singleton;
import user.*;

import java.sql.SQLException;

public class TestAdmUserService {

    public static void main(String[] args) throws SQLException{
        Singleton.getSingleton().setConnection("jdbc:h2:/C:/Users/tolya/Testing/DataBase/Testing");
        TestAdmUserService testAdmUserService = new TestAdmUserService();
        testAdmUserService.testCreate("Name5", "Login5", "Password5");
        //testAdmUserService.testRead("Login1","Password1");
    }

    public void testCreate(String name, String login, String pass){
        User user = new AdmUser();
        user.setPassword(pass);
        user.setLogin(login);
        user.setName(name);
        AdmUserAccessService admUserService = new AnswerAccessServiceImpl();
        admUserService.createUser(user);
    }

    public void testRead(String login, String pass){
        User user = new AdmUser();
        AdmUserAccessService admUserService = new AnswerAccessServiceImpl();
        user = admUserService.readUser(login,pass);
        System.out.print(user.getName() + " " + user.getLogin() + " " + user.getPassword());
    }
}
*/