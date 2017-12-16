package my.prog.dao;

import my.prog.Factoy.Factory;
import my.prog.annotations.Annotations;
import my.prog.annotations.Mapper;
import my.prog.model.User;


import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.Map;
import java.util.StringJoiner;

public abstract class AbstractDAO<T> implements GenericDAO<T> {
    Connection connection;

    @Override
    public T create (T t) {
        Annotations<T> a = new Annotations<> (t);
        Map<String,String> columns = a.getColumnsAndValues ();
        StringBuilder builder = new StringBuilder ("insert into ");
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

    @Override
    public T findById (long id) {
        T o = null;
        Mapper<T> mapper = new Mapper<> ();
        try {
            o = (T) ((Class)((ParameterizedType)this.getClass().
                    getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        } catch (InstantiationException e) {
            e.printStackTrace ();
        }
        Annotations<T> a = new Annotations<> ((T)o);
        StringBuilder builder = new StringBuilder ("select * from ");

        builder.append (a.getTableName ());
        builder.append (" WHERE " );
        builder.append (" id=" +id + ";");
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement (builder.toString ());
            ResultSet rs = statement.executeQuery ();
            o = mapper.castToT (rs,o).get (1);

        } catch (SQLException e) {
            e.printStackTrace ();
        }

        return  o;
    }

    @Override
    public T update (T t) {
        Annotations<T> a = new Annotations<> (t);
        Map<String,String> columns = a.getColumnsAndValues ();
        StringBuilder builder = new StringBuilder ("update ");
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

    @Override
    public T delete (T t) {
        Annotations<T> a = new Annotations<> (t);
        Map<String,String> columns = a.getColumnsAndValues ();
        StringBuilder builder = new StringBuilder ("delete from ");
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
