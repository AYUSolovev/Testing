package database.admusersdb;

import database.answersdb.AnswerService;
import database.answersdb.AnswerServiceImpl;
import questions.Question;
import questions.TypeQuestion;
import singleton.Singleton;
import users.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdmUserServiceImpl implements AdmUserService {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public void createUser(User admUser){
        String sql = "INSERT INTO AdmUsers (name,login,password) VALUES(?,?,?)";
        try {
            preparedStatement = Singleton.getSingleton().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, admUser.getName());
            preparedStatement.setString(2, admUser.getLogin());
            preparedStatement.setString(3, admUser.getPassword());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
        }
    }

    public AdmUser readUser(String login, String password){
        String sql = "select * from admUsers";
        AdmUser admUser = new AdmUser();
        try {
            preparedStatement = Singleton.getSingleton().getConnection().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (login.equals(resultSet.getString("login")) && password.equals(resultSet.getString("password"))) {
                    admUser.setName(resultSet.getString("name"));
                    admUser.setLogin(resultSet.getString("login"));
                    admUser.setPassword(resultSet.getString("password"));
                    break;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            try { if (resultSet != null) resultSet.close(); } catch (Exception e) {};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
        }
        return admUser;

    }

    public void updateUser(AdmUser admUser) {

    }

    public void deleteUser(AdmUser admUser) {

    }
}
