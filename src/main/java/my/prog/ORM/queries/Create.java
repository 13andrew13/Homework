package my.prog.ORM.queries;

import my.prog.ORM.annotations.Annotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class Create<T> extends Query<T> {

    private final String start = "insert into ";
    private T t;

    public Create (T t, Connection connection) {
        super.connection = connection;
        this.t = t;
    }
    @Override
    public T execute () {
        Annotations<T> a = new Annotations<> (t);
        Map<String,String> columns = a.getColumnsAndValues ();
        StringBuilder builder = new StringBuilder (start);
        builder.append (a.getTableName ());
        builder.append (" ( ");
        for (String s : columns.keySet ()) {
            builder.append (s +",");
        }

        builder.append (") VALUES (");

        for (String s:columns.values ())
            builder.append ("?,");
        builder.append (");");
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement (builder.toString ());

            int i =1;
            for(String s: columns.values ()){
                statement.setString (i,s);
                i++;
            }
            statement.execute ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return t;
    }
}
