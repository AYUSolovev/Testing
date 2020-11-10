package service.businessLayer.normalUser;

import model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.dataLayer.normalUser.NormalUserAccessService;
import service.dataLayer.normalUser.NormalUserAccessServiceImpl;

@Component
public class NormalUserServiceImpl implements NormalUserService {

    @Autowired
    private NormalUserAccessService normalUser = new NormalUserAccessServiceImpl();

    public void addUser(User normalUser) {
        User user = this.normalUser.readUser(normalUser.getLogin());
        if (user == null){
            this.normalUser.createUser(normalUser);
            System.out.print("Создан новый пользователь");
        }
        else
            throw new RuntimeException("Такой пользователь уже существует");
    }

    public User getUser(String login, String password) {
        User user;
        user = normalUser.readUser(login);
        if(user != null && password.equals(user.getPassword())){
            return user;
        }
        throw new RuntimeException("Пользователь не найден");
    }

    public void updateUser() {

    }

    public void deleteUser() {

    }
}
