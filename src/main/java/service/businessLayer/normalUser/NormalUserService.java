package service.businessLayer.normalUser;

import model.user.User;

public interface NormalUserService {
    void addUser(User normalUser);
    User getUser(String login,String password);
    void updateUser();
    void deleteUser();
}
