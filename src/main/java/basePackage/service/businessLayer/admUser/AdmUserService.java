package basePackage.service.businessLayer.admUser;

import basePackage.model.user.User;

public interface AdmUserService {
    User getUser(String login, String password);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
}
