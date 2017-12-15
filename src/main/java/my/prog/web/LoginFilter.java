package my.prog.web;




import my.prog.Factoy.Factory;
import my.prog.dao.UserDAO;
import my.prog.dao.UserDAOImpl;
import my.prog.model.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static my.prog.util.ApplicationConstants.TOKEN;


public class LoginFilter implements Filter {

    private UserDAO userDao;
    private final String protectedURL = "/servlet/profile";

    @Override
    public void init (FilterConfig filterConfig) throws ServletException {
        userDao = new UserDAOImpl (Factory.getConnection ());
    }

    @Override
    public void doFilter (ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Cookie[] cookies = request.getCookies ();
        String uri = request.getRequestURI ();
        if(uri.equals (protectedURL)){
            String token = null;
            for (Cookie cookie : cookies) {
                String name = cookie.getName ().toUpperCase ();
                if(name.equals (TOKEN)){
                    token = cookie.getValue ();
                    User user = userDao.getUserByToken(token);
                    request.setAttribute ("UserId",String.valueOf (user.getId ()));
                }
            }
            if(token == null){
                request.getRequestDispatcher ("");
            }
        }

    }

    @Override
    public void destroy () {

    }
}
