package service.dataLayer.normalUser;

import model.user.User;

public interface NormalUserAccessService {
    void createUser(User normalUser);
    User readUser(String login);
    void updateUser();
    void deleteUser();
}
