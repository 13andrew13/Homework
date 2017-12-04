package my.prog.controller;


import my.prog.model.User;
import my.prog.service.UserService;

public class UserController {
    private UserService service;

    public UserController (UserService userService) {
        service = userService;
    }
    public User create(User user){
        return service.create (user);
    }
    public User findById(long id){
        return service.findById(id);
    }

    public User delete (User user) {
        return service.delete(user);
    }

    public User update (User del) {
        return service.update (del);
    }
}
