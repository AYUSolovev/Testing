package service.dataLayer.normalUser;

import model.user.NormalUser;
import model.user.User;
import org.springframework.stereotype.Component;
import singleton.Singleton;

import java.sql.*;

@Component
public class NormalUserAccessServiceImpl implements NormalUserAccessService {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public void createUser(User normalUser) {
        String sql = "INSERT INTO normalUsers (name,login,password) VALUES(?,?,?)";
        try {
            preparedStatement = Singleton.getSingleton().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, normalUser.getName());
            preparedStatement.setString(2, normalUser.getLogin());
            preparedStatement.setString(3, normalUser.getPassword());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) {};
        }
    }

    public User readUser(String login) {
        String sql = "select * from normalUsers";
        User user = null;
        try {
            preparedStatement = Singleton.getSingleton().getConnection().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (login.equals(resultSet.getString("login"))) {
                    user = new NormalUser();
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

    public void updateUser() {

    }

    public void deleteUser() {

    }
}
