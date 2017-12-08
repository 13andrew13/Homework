package my.prog.dao;

import my.prog.model.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User>{
    List<User> findByEmail (String email);
}
