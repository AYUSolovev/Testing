package basePackage.service.dataLayer.normalUser;

import basePackage.model.user.User;

import java.sql.PreparedStatement;

public interface NormalUserAccessService {
    void createUser(User normalUser);
    User readUser(String login);
    void updateUser();
    void deleteUser();
}
