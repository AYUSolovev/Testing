import database.testsdb.TestService;
import database.testsdb.TestServiceImpl;
import singleton.Singleton;
import tests.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTestService {
    public static void main(String[] args){
        Singleton.getSingleton().setConnection("jdbc:h2:/C:/Users/tolya/Testing/DataBase/Testing");
        TestTestService testTestService = new TestTestService();
        //testTestService.testCreate("Test1");
        testTestService.testRead();
    }


    public void testCreate(String str){
        Test test = new Test();
        test.setName(str);
        TestService testService = new TestServiceImpl();
        testService.createTest(test);
    }

    public void testRead(){
        TestService testService = new TestServiceImpl();
        List<Test> testsList = new ArrayList<Test>();
        testsList = testService.readTest();
        for(int i = 0; i < testsList.size(); i++){
            System.out.println(testsList.get(i).getId() + " " + testsList.get(i).getName());
        }
    }
}
