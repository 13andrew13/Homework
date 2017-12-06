package my.prog.ORM.queries;

import my.prog.ORM.annotations.Annotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.StringJoiner;

public class Update<T> extends Query<T>{
    private final String start = "update ";
    private T t;

    public Update (T t, Connection connection) {
        super.connection = connection;
        this.t = t;
    }

    @Override
    public T execute () {
        Annotations<T> a = new Annotations<> (t);
        Map<String,String> columns = a.getColumnsAndValues ();
        StringBuilder builder = new StringBuilder (start);
        StringJoiner joiner = new StringJoiner (" , ");
        builder.append (a.getTableName ());
        builder.append (" Set " );
        int i =0;
        for (Map.Entry<String, String> entry : columns.entrySet ()) {
            if(!entry.getValue ().equals (null)&&!entry.getValue ().equals ("null")) {
                joiner.add (entry.getKey () + "='"+entry.getValue ()+"'");
            }
        }
        PreparedStatement statement = null;
        try {
            builder.append (joiner.toString () +" where id=" + a.getIdField ().getLong (t) + ";" );
            statement = connection.prepareStatement (builder.toString ());
            statement.executeUpdate ();

        } catch (SQLException e) {
            e.printStackTrace ();
        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        }

        return  t;

    }
}
