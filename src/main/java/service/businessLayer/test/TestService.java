package service.businessLayer.test;

import model.test.Test;

import java.util.List;

public interface TestService {
    void addTest(Test test);
    void deleteTest(int id);
    List<Test> listTest();
    void updateTest(Test test);
}
