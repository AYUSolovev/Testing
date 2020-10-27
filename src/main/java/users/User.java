package users;

public abstract class User {
    protected String name;
    protected String login;
    protected String password;

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
