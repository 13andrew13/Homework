package my.prog.ORM.queries;

import my.prog.ORM.annotations.Annotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.StringJoiner;

public class Delete<T>  extends Query<T> {
    private final String start = "delete from ";
    private T t;

    public Delete (T t, Connection connection) {
        this.t = t;
        super.connection = connection;
    }

    @Override
    public T execute () {
        Annotations<T> a = new Annotations<> (t);
        Map<String,String> columns = a.getColumnsAndValues ();
        StringBuilder builder = new StringBuilder (start);
        StringJoiner joiner = new StringJoiner (" and ");
        builder.append (a.getTableName ());
        builder.append (" WHERE " );
        int i =0;
        for (Map.Entry<String, String> entry : columns.entrySet ()) {
            if(!entry.getValue ().equals ("")&&!entry.getValue ().equals ("null")) {
                joiner.add (entry.getKey () + "=? ");
            }

        }
        builder.append (joiner.toString () +";" );
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement (builder.toString ());

            i =1;
            for(String s: columns.values ()){
                if(s !=null&& !s.equals ("null")){
                     statement.setString (i,s);
                    i++;
                }
            }

            statement.execute ();

        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return  t;
    }
}
