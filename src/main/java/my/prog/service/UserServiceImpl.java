package my.prog.service;

import my.prog.dao.UserDAO;
import my.prog.model.User;

import java.sql.Connection;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl (UserDAO connection) {
        userDAO = connection;
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
}
