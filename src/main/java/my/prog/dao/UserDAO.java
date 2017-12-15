package my.prog.dao;

import my.prog.model.User;

public interface UserDAO extends GenericDAO<User>{
    User findByEmail (String email);

    User getUserByToken (String value);
}
