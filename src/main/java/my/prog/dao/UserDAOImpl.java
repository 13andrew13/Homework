package my.prog.dao;

import my.prog.annotations.Annotations;
import my.prog.annotations.Mapper;
import my.prog.model.User;

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
}




