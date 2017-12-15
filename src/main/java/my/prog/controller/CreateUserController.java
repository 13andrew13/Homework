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
        ViewModel vm = new ViewModel ("register");
        if(request.getMethod ().equals (POST)){
            return new ViewModel ("login");
        }
        String name  = request.getParameter ("name");
        String email = request.getParameter ("email");
        String password = request.getParameter ("password");
        String token = service.checkUser(email,password).orElse ("unauthorised");
        service.create (new User (name,email,password));
        response.addCookie (new Cookie ("MyApp",token));
        return vm;
    }
}
