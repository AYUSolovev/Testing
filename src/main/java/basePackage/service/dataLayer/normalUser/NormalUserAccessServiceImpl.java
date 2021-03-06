package basePackage.service.dataLayer.normalUser;

import basePackage.model.user.NormalUser;
import basePackage.model.user.User;
import org.springframework.stereotype.Component;
import basePackage.singleton.Singleton;

import java.sql.*;

@Component
public class NormalUserAccessServiceImpl implements NormalUserAccessService {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public void createUser(User normalUser) {
        String sql = "INSERT INTO normal_users (name,login,password) VALUES(?,?,?)";
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

    @Override
    public User readUser(String login) {
        String sql = "select * from normal_users";
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

    @Override
    public void updateUser() {

    }

    @Override
    public void deleteUser() {

    }
}
