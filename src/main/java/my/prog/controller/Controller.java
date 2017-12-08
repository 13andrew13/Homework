package my.prog.controller;

import my.prog.web.ViewModel;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
    ViewModel process(HttpServletRequest request , HttpServletResponse response);
}
