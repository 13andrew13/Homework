package my.prog.controller;

import my.prog.service.UserService;
import my.prog.web.ViewModel;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static my.prog.web.Methods.*;

public class LoginUserController implements Controller{
    private UserService service;

    public LoginUserController (UserService service) {
        this.service = service;
    }

    @Override
    public ViewModel process (HttpServletRequest request, HttpServletResponse response) {
        ViewModel vm = new ViewModel ("login");
        if(request.getMethod ().equals (GET.toString ())){
            return new ViewModel ("login");
        }
        String email = request.getParameter ("email");
        String password = request.getParameter ("password");
        String token = service.checkUser(email,password).orElse ("unauthorised");
        response.addCookie (new Cookie ("MyApp",token));
        return vm;
    }
}
