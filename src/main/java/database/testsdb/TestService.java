package database.testsdb;

import tests.Test;

import java.util.List;

public interface TestService {
    void createTest(Test test);
    List<Test> readTest();
    void updateTest();
    void deleteTest();
}
