package service.dataLayer.admUser;

import model.user.AdmUser;
import model.user.User;
import org.springframework.stereotype.Component;
import singleton.Singleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AdmUserAccessServiceImpl implements AdmUserAccessService {

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

    public User readUser(String login){
        String sql = "select * from admUsers";
        User user = null;
        try {
            preparedStatement = Singleton.getSingleton().getConnection().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (login.equals(resultSet.getString("login"))) {
                    user = new AdmUser();
                    user.setName(resultSet.getString("name"));
                    user.setLogin(resultSet.getString("login"));
                    user.setPassword(resultSet.getString("password"));
                    return user;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            try { if (resultSet != null) resultSet.close(); } catch (Exception e) {};
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
        }
        return user;
    }

    public void updateUser(AdmUser admUser) {

    }

    public void deleteUser(AdmUser admUser) {

    }
}
