package service.businessLayer.admUser;

import model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.dataLayer.admUser.AdmUserAccessService;
import service.dataLayer.admUser.AdmUserAccessServiceImpl;

@Component
public class AdmUserServiceImpl implements AdmUserService {

    @Autowired
    private AdmUserAccessService admUser = new AdmUserAccessServiceImpl();

    public User getUser(String login, String password) {
        User user;
        user = admUser.readUser(login);
        if(user != null && password.equals(user.getPassword())){
            return user;
        }
        throw new RuntimeException("Пользователь не найден");
    }

    public void createUser(User user) {
        admUser.createUser(user);
    }

    public void updateUser(User user) {

    }

    public void deleteUser(User user) {

    }
}
