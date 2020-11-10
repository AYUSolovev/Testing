package service.dataLayer.test;

import service.dataLayer.question.QuestionAccessService;
import service.dataLayer.question.QuestionAccessServiceImpl;
import singleton.Singleton;
import model.test.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestAccessServiceImpl implements TestAccessService {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public void createTest(Test test) {
        try {
            String sql = "INSERT INTO Tests (name) VALUES(?)";
            PreparedStatement preparedStatement = Singleton.getSingleton().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, test.getName());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
        }
    }

    public List<Test> readTest() {
        List<Test> testsList = new ArrayList<Test>();
        String sql = "select * from tests";
        Test test;
        QuestionAccessService questionService = new QuestionAccessServiceImpl();
        try {
            preparedStatement = Singleton.getSingleton().getConnection().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                test = new Test();
                test.setName(resultSet.getString("name"));
                test.setId(resultSet.getInt("id"));
                test.setQuestionsList(questionService.readQuestion(resultSet.getInt("id")));
                testsList.add(test);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{if (resultSet != null) resultSet.close();}catch (SQLException e){}
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
        }
        return testsList;
    }

    public void updateTest() {

    }

    public void deleteTest() {

    }
}
