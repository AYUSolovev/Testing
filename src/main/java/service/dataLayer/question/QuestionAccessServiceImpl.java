package service.dataLayer.question;

import org.springframework.stereotype.Component;
import service.dataLayer.answer.AnswerAccessServiceImpl;
import service.dataLayer.answer.AnswerAccessService;
import model.question.Question;
import model.question.TypeQuestion;
import singleton.Singleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionAccessServiceImpl implements QuestionAccessService {

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
        AnswerAccessService answerInterface = new AnswerAccessServiceImpl();
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
                //question.setAnswersList(answerInterface.readAnswer(resultSet.getInt("id")));
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

    public void updateQuestions(Question question){
    }

    public void deleteQuestion(int id){

    }

}
