package basePackage.service.dataLayer.question;

import basePackage.service.dataLayer.answer.AnswerAccessService;
import basePackage.service.dataLayer.answer.AnswerAccessServiceImpl;
import org.springframework.stereotype.Component;
import basePackage.model.question.Question;
import basePackage.model.question.TypeQuestion;
import basePackage.singleton.Singleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionAccessServiceImpl implements QuestionAccessService {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public void createQuestion(Question question) {
        String sql = "INSERT INTO QUESTIONS (question,type_question,author_question,test_id) VALUES(?,?,?,?)";
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
                question.setTypeQuestion(TypeQuestion.valueOf(resultSet.getString("type_question")));
                //question.setAnswersList(answerInterface.readAnswer(resultSet.getInt("id")));
                question.setAuthorQuestion(resultSet.getString("author_question"));
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

    public Question findQuestion(String textQuestion){
        Question question;
        String sql = "select * from questions";
        try {
            preparedStatement = Singleton.getSingleton().getConnection().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                if (resultSet.getString("question").equals(textQuestion)){
                    question = new Question();
                    question.setId(resultSet.getInt("id"));
                    question.setTestId(resultSet.getInt("test_id"));
                    question.setQuestion(resultSet.getString("question"));
                    question.setTypeQuestion(TypeQuestion.valueOf(resultSet.getString("type_question")));
                    question.setAuthorQuestion(resultSet.getString("author_question"));
                    return question;
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{if (resultSet != null) resultSet.close();}catch (SQLException e){}
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
        }
        return null;
    }
    public void updateQuestions(Question question){
    }

    public void deleteQuestion(int id){

    }

}
