package my.prog.Factoy;

import my.prog.controller.UserController;
import my.prog.dao.UserDAO;
import my.prog.dao.UserDAOImpl;
import my.prog.service.UserService;
import my.prog.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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


    public static UserService getUserSevice(UserDAO userDAO){
        return new UserServiceImpl (userDAO);
    }
    public static UserDAO getUserDAO(){
        return new UserDAOImpl (getConnection ());
    }
    public static UserController getController(UserService userService){
        return new UserController (userService);

    }
}
