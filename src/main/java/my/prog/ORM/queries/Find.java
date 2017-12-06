package my.prog.ORM.queries;

import my.prog.ORM.annotations.Annotations;
import java.lang.reflect.ParameterizedType;
import java.sql.*;


public class Find<T> extends Query<T> {
    private final String start = "select * from ";
    private long id;
    private Mapper<T> mapper;
    public Find ( long id,Connection connection) {
        this.id = id;
        super.connection = connection;

    }

    @Override
    public T execute () {
        T o = null;
        Mapper<T> mapper = new Mapper<> ();
        try {
            o = createInstance ();
        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        } catch (InstantiationException e) {
            e.printStackTrace ();
        }
        Annotations<T> a = new Annotations<> ((T)o);
        StringBuilder builder = new StringBuilder (start);

        builder.append (a.getTableName ());
        builder.append (" WHERE " );
        builder.append (" id=" +id + ";");
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement (builder.toString ());
            ResultSet rs = statement.executeQuery ();
            o = mapper.castToT (rs,o);

        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return  o;

    }
    public T createInstance() throws IllegalAccessException, InstantiationException {
        T res = (T) ((Class)((ParameterizedType)this.getClass ().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
        return res;
    }


}
