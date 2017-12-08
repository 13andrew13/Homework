package my.prog.service;

import my.prog.dao.UserDAO;
import my.prog.model.User;

import java.sql.Connection;
import java.time.LocalTime;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl (UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User create (User user) {
        return userDAO.create (user);
    }

    @Override
    public User findById (long id) {
        return userDAO.findById (id);
    }

    @Override
    public User delete (User user) {
        return userDAO.delete (user);
    }

    @Override
    public User update (User user) {
        return userDAO.update (user);
    }

    @Override
    public Optional<String> checkUser (String email, String password) {
        User user = userDAO.findByEmail(email).get (0);
        if(user.getPassword ().equals (password)){//TODO check password using hashing
           String token = LocalTime.now ().toString ();
           user.setToken(token);
           userDAO.update (user);
            return Optional.of (token);
        }


        return Optional.empty ();
    }
}
