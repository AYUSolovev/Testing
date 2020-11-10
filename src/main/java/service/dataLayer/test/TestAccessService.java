package service.dataLayer.test;

import model.test.Test;

import java.util.List;

public interface TestAccessService {
    void createTest(Test test);
    List<Test> readTest();
    void updateTest();
    void deleteTest();
}
