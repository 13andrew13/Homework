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
                joiner.add (entry.getKey () + "=? ");
            }

        }
        builder.append (joiner.toString () +" where id =?" );
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
