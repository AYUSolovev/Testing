package service.dataLayer.admUser;

import model.user.AdmUser;
import model.user.User;

public interface AdmUserAccessService {
    void createUser(User admUser);
    User readUser(String login);
    void updateUser(AdmUser admUser);
    void deleteUser(AdmUser admUser);
}
