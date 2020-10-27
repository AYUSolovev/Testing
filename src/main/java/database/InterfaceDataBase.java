package database;

import tests.*;
import users.*;

public interface InterfaceDataBase {
    void registration(NormalUser newUser);
    void creatTest(Test newTest);
    void listTest();
    Test getTest(String nameTest);
    User authorization(String log,String pass);
    void updateTest(Test update);
}
