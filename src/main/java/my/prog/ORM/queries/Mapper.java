package my.prog.ORM.queries;

import my.prog.ORM.annotations.Annotations;
import my.prog.ORM.annotations.Column;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

public class Mapper<T> {
    private T o;

    public Mapper () {
    }

    public T castToT (ResultSet rs,T t) {
        Annotations<T> a = null;
        try {
            rs.first ();
            o = t;
            a = new Annotations<> (o);
            List<Field> fields = a.getFields ();
            ResultSetMetaData rsm = rs.getMetaData ();
            for(int i =1;i<fields.size ();i++){
                for (Field field : fields) {
                    if(field.getAnnotation (Column.class).value ().equals (rsm.getColumnName (i))){
                        field.set (field,rs.getString (i));
                    }
                }
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        return o;
    }

}
