package basePackage.service.businessLayer.normalUser;

import basePackage.model.user.User;
import basePackage.service.dataLayer.normalUser.NormalUserAccessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import basePackage.service.dataLayer.normalUser.NormalUserAccessService;

@Component
public class NormalUserServiceImpl implements NormalUserService {

    @Autowired
    public NormalUserAccessService normalUser;

    @Override
    public void addUser(User normalUser) {
        User user = this.normalUser.readUser(normalUser.getLogin());
        if (user == null){
            this.normalUser.createUser(normalUser);
            System.out.print("Создан новый пользователь");
        }
        else
            throw new RuntimeException("Такой пользователь уже существует");
    }

    @Override
    public User getUser(String login, String password) {
        User user;
        user = normalUser.readUser(login);
        if(user != null && password.equals(user.getPassword())){
            return user;
        }
        throw new RuntimeException("Пользователь не найден");
    }

    @Override
    public void updateUser() {

    }

    @Override
    public void deleteUser() {

    }
}
