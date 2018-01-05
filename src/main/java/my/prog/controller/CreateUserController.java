package my.prog.controller;


import my.prog.model.User;
import my.prog.service.UserService;
import my.prog.web.ViewModel;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static my.prog.web.Methods.GET;
import static my.prog.web.Methods.POST;

public class CreateUserController implements Controller{
    private UserService service;

    public CreateUserController (UserService userService) {
        service = userService;
    }


    @Override
    public ViewModel process (HttpServletRequest request, HttpServletResponse response) {
        ViewModel vm = new ViewModel ("login");
        if(request.getMethod ().equals (GET.toString ())){
            return new ViewModel ("register");
        }
        String name  = request.getParameter ("name");
        String email = request.getParameter ("email");
        String password = request.getParameter ("password");
        service.create (new User (name,email,password));
        return vm;
    }
}
