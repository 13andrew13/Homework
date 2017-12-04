package my.prog.service;

import my.prog.model.User;

public interface UserService {
    User create(User user);

    User findById (long id);

    User delete (User user);

    User update(User user);
}
