package my.prog.controller;


import my.prog.model.User;
import my.prog.service.UserService;
import my.prog.web.ViewModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateUserController implements Controller{
    private UserService service;

    public CreateUserController (UserService userService) {
        service = userService;
    }


    @Override
    public ViewModel process (HttpServletRequest request, HttpServletResponse response) {

        return null;
    }
}
