package basePackage.model.user;

public abstract class User {
    protected int id;
    protected String name;
    protected String login;
    protected String password;

    public User() {
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public final int getId() {
        return id;
    }

    public final void setName(String arg){
        this.name = arg;
    }

    public final String getName(){
        return this.name;
    }

    public final void setLogin(String arg){
        this.login = arg;
    }

    public final String getLogin(){
        return this.login;
    }

    public final void setPassword(String arg){
        this.password = arg;
    }

    public final String getPassword(){
        return this.password;
    }

}
