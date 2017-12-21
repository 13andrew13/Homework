package my.prog.dao;

import my.prog.Factoy.Factory;
import my.prog.annotations.Annotations;
import my.prog.annotations.Mapper;
import my.prog.model.User;
import my.prog.service.UserService;
import my.prog.service.UserServiceImpl;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl extends AbstractDAO<User>  implements UserDAO {
    public UserDAOImpl (Connection connection) {
        super.connection = connection;
    }

    @Override
    public  User findByEmail (String email) {
        User user = new User ();
        Mapper<User> mapper = new Mapper<> ();

        Annotations<User> a = new Annotations<User> (user);
        StringBuilder builder = new StringBuilder ("select * from ");

        builder.append (a.getTableName ());
        builder.append (" WHERE " );
        builder.append (" EMAIL='" +email + "';");
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement (builder.toString ());
            ResultSet rs = statement.executeQuery ();

            user = mapper.castToT (rs,user).get (0);

        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return  user;
    }
    @Override
    public User getUserByToken (String value) {
        User user = new User ();
        Mapper<User> mapper = new Mapper<> ();

        Annotations<User> a = new Annotations<User> (user);
        StringBuilder builder = new StringBuilder ("select * from ");

        builder.append (a.getTableName ());
        builder.append (" WHERE " );
        builder.append (" TOKEN='" +value + "';");
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement (builder.toString ());
            ResultSet rs = statement.executeQuery ();
            user = mapper.castToT (rs,user).get (0);

        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return  user;
    }

    public static void main (String[] args) {
        UserDAO service = Factory.getSomething(UserDAOImpl::new)
                .apply (Factory.getConnection ());
        User user = service.findByEmail ("dsada");
        System.out.println (user);

    }
}




