package my.prog.controller;

import my.prog.web.ViewModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileController implements Controller{

    @Override
    public ViewModel process (HttpServletRequest request, HttpServletResponse response) {
        ViewModel model = new ViewModel ("profile");
        return  model;
    }
}
