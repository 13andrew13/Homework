package my.prog.annotations;


import my.prog.model.User;

import java.lang.reflect.Field;

import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Mapper<T> {
    private T o;

    public Mapper () {
    }

    public List<T> castToT (ResultSet rs,T t) {
        Annotations<T> a = null;
        List<T> result = new ArrayList<> ();
        try {
            rs.first ();
            a = new Annotations<> (t);
            List<Field> fields = a.getFields ();
            while (rs.next ()){
                t = (T) t.getClass ().newInstance ();

                for (Field field : fields){
                    field.setAccessible (true);
                    switch (field.getType ().getSimpleName ()) {
                        case "Long":
                        case "Integer":
                            field.setLong (t, rs.getLong (field.getAnnotation (Column.class).value ().toUpperCase ()));
                            break;
                        case "String":
                            field.set (t, rs.getString (field.getAnnotation (Column.class).value ().toUpperCase ()));
                            break;
                        case "Date":
                            field.set (t, rs.getDate (field.getAnnotation (Column.class).value ().toUpperCase ()));
                            break;
                        case "Double":
                        case "Float":
                            field.setDouble (t, rs.getDouble (field.getAnnotation (Column.class).value ().toUpperCase ()));
                            break;
                    }

                }
                a.getIdField ().setAccessible (true);
                a.getIdField ().setLong (t,rs.getLong ("ID"));
                result.add (t);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        } catch (InstantiationException e) {
            e.printStackTrace ();
        }
        return result;
    }



}
