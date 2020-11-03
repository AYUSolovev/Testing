package database.admusersdb;

import users.AdmUser;
import users.User;

import java.sql.SQLException;

public interface AdmUserService {
    void createUser(User admUser);
    AdmUser readUser(String login, String password);
    void updateUser(AdmUser admUser);
    void deleteUser(AdmUser admUser);
}
