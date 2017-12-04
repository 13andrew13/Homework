package my.prog.dao;

import my.prog.model.User;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;

public class UserDAOImpl extends AbstractDAO<User>  implements UserDAO {
    public UserDAOImpl (Connection connection) {
        super.connection = connection;
    }
}



