package my.prog.dao;

import my.prog.annotations.Annotations;
import my.prog.annotations.Mapper;
import my.prog.model.User;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl extends AbstractDAO<User>  implements UserDAO {
    public UserDAOImpl (Connection connection) {
        super.connection = connection;
    }

    @Override
    public List<User> findByEmail (String email) {
        User o = null;
        List<User> users = null;
        Mapper<User> mapper = new Mapper<> ();
        try {
            o = (User) ((Class)((ParameterizedType)this.getClass().
                    getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        } catch (InstantiationException e) {
            e.printStackTrace ();
        }
        Annotations<User> a = new Annotations<User> (o);
        StringBuilder builder = new StringBuilder ("select * from ");

        builder.append (a.getTableName ());
        builder.append (" WHERE " );
        builder.append (" EMAIL='" +email + "';");
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement (builder.toString ());
            ResultSet rs = statement.executeQuery ();
            users = mapper.castToT (rs,o);

        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return  users;
    }
}




