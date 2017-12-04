package my.prog.ORM.queries;

import my.prog.ORM.annotations.Annotations;
import my.prog.ORM.annotations.Column;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Find<T> extends Query<T> {
    private final String start = "select * from ";
    private long id;
    private T o;
    private Mapper<T> mapper;
    public Find ( long id,Connection connection) {
        this.id = id;
        super.connection = connection;

    }

    @Override
    public T execute () {
        Mapper<T> mapper = new Mapper<> ();
        try {
            o = mapper.createInstance ();
        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        } catch (InstantiationException e) {
            e.printStackTrace ();
        }
        Annotations<T> a = new Annotations<> (o);
        StringBuilder builder = new StringBuilder (start);
        StringJoiner joiner = new StringJoiner (" and ");
        builder.append (a.getTableName ());
        builder.append (" WHERE " );
        joiner.add ("id = ?");
        builder.append (joiner.toString () +";" );
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement (builder.toString ());


            ResultSet rs = statement.executeQuery ();
            o = mapper.castToT (rs);

        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return  o;

    }


}
