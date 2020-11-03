import database.admusersdb.*;
import singleton.Singleton;
import users.*;

import java.sql.SQLException;

public class TestAdmUserService {

    public static void main(String[] args) throws SQLException{
        Singleton.getSingleton().setConnection("jdbc:h2:/C:/Users/tolya/Testing/DataBase/Testing");
        TestAdmUserService testAdmUserService = new TestAdmUserService();
        //testAdmUserService.testCreate("Name2", "Login2", "Password2");
        testAdmUserService.testRead("Login1","Password1");
    }

    public void testCreate(String name, String login, String pass){
        AdmUser admUser = new AdmUser();
        admUser.setPassword(pass);
        admUser.setLogin(login);
        admUser.setName(name);
        AdmUserService admUserService = new AdmUserServiceImpl();
        admUserService.createUser(admUser);
    }

    public void testRead(String login, String pass){
        AdmUser admUser = new AdmUser();
        AdmUserService admUserService = new AdmUserServiceImpl();
        admUser = admUserService.readUser(login,pass);
        System.out.print(admUser.getName() + " " + admUser.getLogin() + " " + admUser.getPassword());
    }
}
