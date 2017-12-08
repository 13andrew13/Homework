package my.prog.Factoy;

import my.prog.controller.Controller;
import my.prog.controller.LoginUserController;

import my.prog.dao.UserDAO;
import my.prog.dao.UserDAOImpl;
import my.prog.service.UserService;
import my.prog.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Function;

public class Factory {
    static {
        try {
            Class.forName ("org.h2.Driver");
        } catch (Exception e){
            e.printStackTrace ();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection =  DriverManager.getConnection ("jdbc:h2:tcp://localhost/~/test","sa","");
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return connection;
    }
    public static <T,R> Function<T,R> getSomething(Function<T,R> f){
        return f;
    }

    public static UserService getUserSevice(UserDAO userDAO){
        return new UserServiceImpl (userDAO);
    }
    public static UserDAO getUserDAO(){
        return new UserDAOImpl (getConnection ());
    }
    public static Controller getController(UserService userService){
        return new LoginUserController (userService);

    }
}
