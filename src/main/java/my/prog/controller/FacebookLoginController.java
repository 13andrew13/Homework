package my.prog.controller;


import my.prog.model.User;
import my.prog.service.UserService;
import my.prog.web.ViewModel;
import my.prog.web.facebookLogin.Facebook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FacebookLoginController implements Controller{
    UserService service;

    public FacebookLoginController (UserService service) {
        this.service = service;
    }

    @Override
    public ViewModel process (HttpServletRequest request, HttpServletResponse response) {
        ViewModel vm = new ViewModel ("facebookLoginPage");
        Facebook facebook = new Facebook ();
        User user = facebook.fetchObject ();
       // service.checkUser (user.getEmail (),user.getPassword ());
        request.setAttribute ("name",user.getName ());
        request.setAttribute ("email",user.getEmail ());
        return vm;
    }
}
