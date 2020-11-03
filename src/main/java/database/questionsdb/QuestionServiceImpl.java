package database.questionsdb;

import database.answersdb.AnswerServiceImpl;
import database.answersdb.AnswerService;
import questions.Question;
import questions.TypeQuestion;
import singleton.Singleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class QuestionServiceImpl implements QuestionService {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public void createQuestion(Question question) {
        String sql = "INSERT INTO QUESTIONS (question,typeQuestion,authorQuestion,testId) VALUES(?,?,?,?)";
        try {
            preparedStatement = Singleton.getSingleton().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, question.getQuestion());
            preparedStatement.setString(2, question.getTypeQuestion().toString());
            preparedStatement.setString(3, question.getAuthorQuestion());
            preparedStatement.setInt(4, question.getTestId());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
        }

    }

    public List<Question> readQuestion(int testId) {
        String sql = "select * from questions where testId = " + testId;
        List<Question> questionsList = new ArrayList<Question>();
        AnswerService answerInterface = new AnswerServiceImpl();
        Question question;
        try {
            preparedStatement = Singleton.getSingleton().getConnection().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                question = new Question();
                question.setId(resultSet.getInt("id"));
                question.setTestId(testId);
                question.setQuestion(resultSet.getString("question"));
                question.setTypeQuestion(TypeQuestion.valueOf(resultSet.getString("typeQuestion")));
                question.setAnswersList(answerInterface.readAnswer(resultSet.getInt("id")));
                question.setAuthorQuestion(resultSet.getString("authorQuestion"));
                questionsList.add(question);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{if (resultSet != null) resultSet.close();}catch (SQLException e){}
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
        }
        return questionsList;
    }

    public void updateQuestions(){
    }

    public void deleteQuestion(int id){

    }

}
