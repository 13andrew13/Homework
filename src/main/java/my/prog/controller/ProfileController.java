package my.prog.controller;

import my.prog.model.User;
import my.prog.service.UserService;
import my.prog.web.ViewModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static my.prog.web.Methods.GET;

public class ProfileController implements Controller{
    private UserService service;
    public ProfileController(UserService userService) {
        this.service = userService;
    }

    @Override
    public ViewModel process (HttpServletRequest request, HttpServletResponse response) {
        ViewModel vm = new ViewModel("profile");
        User user=null;
        String id = (String) request.getAttribute("UserId");
        if (request.getMethod().equals(GET.toString())) {
            user = service.findById(Long.parseLong(id));
            vm.setArgument("user", user);
            return vm;
        } else {
            String email = (String) request.getParameter("email");
            String name = (String) request.getParameter("name");
            user = service.findById(Long.parseLong(id));
            user.setEmail(email);
            user.setName(name);
            service.update(user);
            vm.setArgument("user", user);
            return vm;
        }
    }
}
