package my.prog.web;

import my.prog.Factoy.Factory;
import my.prog.controller.Controller;
import my.prog.controller.CreateUserController;
import my.prog.controller.LoginUserController;

import my.prog.dao.UserDAOImpl;
import my.prog.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainServlet extends HttpServlet{

    private static final Map<Request,Controller>  CONTROLLER_MAP = new HashMap<> ();

    @Override
    public void init () throws ServletException {
        CONTROLLER_MAP.put (new Request ("/servlet/login","GET"), Factory.getSomething (LoginUserController::new)
                .compose(UserServiceImpl::new)
                .compose (UserDAOImpl::new)
                .apply (Factory.getConnection ()));
        CONTROLLER_MAP.put (new Request ("/servlet/login","POST"), Factory.getSomething (LoginUserController::new)
                .compose(UserServiceImpl::new)
                .compose (UserDAOImpl::new)
                .apply (Factory.getConnection ()));
        CONTROLLER_MAP.put (new Request ("/servlet/signUp","GET"), Factory.getSomething (CreateUserController::new)
                .compose(UserServiceImpl::new)
                .compose (UserDAOImpl::new)
                .apply (Factory.getConnection ()));
        CONTROLLER_MAP.put (new Request ("/servlet/signUp","POST"), Factory.getSomething (CreateUserController::new)
                .compose(UserServiceImpl::new)
                .compose (UserDAOImpl::new)
                .apply (Factory.getConnection ()));
    }

    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest (req,resp);
/*

        if(req.getRequestURI ().equals ("/servlet/home")){
            req.getRequestDispatcher ("/WEB-INF/home.jsp").forward (req,resp);
        }
        else {

        }
*/
    }

    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    private void processRequest (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Request request = new Request (req.getRequestURI (),req.getMethod ());

        Controller controller = CONTROLLER_MAP.get (request);
        if(controller == null){
            req.getRequestDispatcher ("/WEB-INF/error.jsp").forward (req,resp);
        }
        ViewModel vm = controller.process (req,resp);
        forward(req,resp,vm);
    }

    private void forward (HttpServletRequest req, HttpServletResponse resp, ViewModel vm) throws ServletException, IOException {
        //processAttribute(req,vm);
        req.getRequestDispatcher (vm.getView ()).forward (req,resp);

    }

    private void processAttribute (HttpServletRequest req, ViewModel vm) {
        if(vm.getArgumentsMap ().isEmpty ()){
            return;
        }
        //vm.getArgumentsMap ();
    }
}
