package basePackage.service.dataLayer.admUser;

import basePackage.model.user.AdmUser;
import basePackage.model.user.User;

public interface AdmUserAccessService {
    void createUser(User admUser);
    User readUser(String login);
    void updateUser(AdmUser admUser);
    void deleteUser(AdmUser admUser);
}
