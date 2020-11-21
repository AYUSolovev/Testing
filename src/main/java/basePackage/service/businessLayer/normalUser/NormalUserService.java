package basePackage.service.businessLayer.normalUser;

import basePackage.model.user.User;

public interface NormalUserService {
    void addUser(User normalUser);
    User getUser(String login,String password);
    void updateUser();
    void deleteUser();
}
