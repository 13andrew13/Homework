package my.prog.service;

import my.prog.model.User;

import java.util.Optional;

public interface UserService {
    User create(User user);

    User findById (long id);

    User delete (User user);

    User update(User user);

    Optional<String> checkUser (String email, String password);
}
