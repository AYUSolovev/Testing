package service.dataLayer.answer;

import model.question.Answer;
import org.springframework.stereotype.Component;
import singleton.Singleton;

import java.sql.*;
import java.util.*;

@Component
public class AnswerAccessServiceImpl implements AnswerAccessService {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public void createAnswer(Answer answer) {
        String sql = "INSERT INTO Answers (isCorrect,answer,questionId) VALUES(?,?,?)";
        try {
            preparedStatement = Singleton.getSingleton().getConnection().prepareStatement(sql);
            preparedStatement.setBoolean(1, answer.getIsCorrect());
            preparedStatement.setString(2, answer.getAnswer());
            preparedStatement.setInt(3, answer.getQuestionId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
        }
    }

    public List<Answer> readAnswer(int idQuestion)  {
        List<Answer> answersList = new ArrayList<Answer>();
        Answer answer;
        String sql = "select * from answers where questionId = "+idQuestion;
        try {
            preparedStatement = Singleton.getSingleton().getConnection().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                answer = new Answer();
                answer.setAnswer(resultSet.getString("answer"));
                answer.setIsCorrect(resultSet.getBoolean("isCorrect"));
                answer.setQuestionId(resultSet.getInt("questionId"));
                answersList.add(answer);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try{if (resultSet != null) resultSet.close();}catch (SQLException e){}
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
        }
        return answersList;
    }

    public void updateAnswer() {

    }

    public void deleteAnswer() {

    }
}