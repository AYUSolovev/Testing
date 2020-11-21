package basePackage.service.dataLayer.answer;

import basePackage.model.question.Answer;
import org.springframework.stereotype.Component;
import basePackage.singleton.Singleton;

import java.sql.*;
import java.util.*;

@Component
public class AnswerAccessServiceImpl implements AnswerAccessService {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public void createAnswer(Answer answer) {
        String sql = "INSERT INTO Answers (is_correct,answer,question_id) VALUES(?,?,?)";
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

    public List<Answer> readAnswer(int questionId)  {
        List<Answer> answersList = new ArrayList<Answer>();
        Answer answer;
        String sql = "select * from answers where question_id = "+questionId;
        try {
            preparedStatement = Singleton.getSingleton().getConnection().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                answer = new Answer();
                answer.setAnswer(resultSet.getString("answer"));
                answer.setIsCorrect(resultSet.getBoolean("is_correct"));
                answer.setQuestionId(resultSet.getInt("question_id"));
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
