package singleton;

import java.sql.*;


public class Singleton {

    private static Singleton singleton;
    private static Connection connection;

    private Singleton(){}

    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized (Singleton.class) {
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public void setConnection(String DB_URL){
        try {
            DriverManager.registerDriver(new org.h2.Driver());
            connection = DriverManager.getConnection(DB_URL);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Connection getConnection(){
        return this.connection;
    }




}
