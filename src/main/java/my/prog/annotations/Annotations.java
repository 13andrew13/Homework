package my.prog.annotations;

import java.lang.reflect.Field;
import java.util.*;

public class Annotations<T> {
    private T t ;

    public Annotations () {
    }

    public Annotations (T t) {
        this.t = t;
    }

    public List<Field> getFields(){
        Field[] fields = t.getClass ().getDeclaredFields ();
        List<Field> fieldList = new ArrayList<> ();
        for (Field field : fields) {
            if(field.getAnnotation (Column.class)!=null){
                fieldList.add (field);
            }
        }
        return fieldList;
    }



    public  Map<String,String> getColumnsAndValues(){
        Field[] fields = t.getClass ().getDeclaredFields ();
        Map<String,String > map = new HashMap<String, String> ();

        for (Field field : fields) {
            field.setAccessible (true);
            Column an = field.getDeclaredAnnotation (Column.class);
            if(an!=null){
                try {
                    map.put (an.value (),String.valueOf (field.get (t)));

                } catch (IllegalAccessException e) {
                    e.printStackTrace ();
                } finally {

                }
            }

        }

        return map;

    }
    public String getTableName(){
        String name ;
        name = t.getClass ().getAnnotation (Table.class).name () ;
        return name;
    }


    public Field getIdField(){
        Field res = null;
        for (Field field : t.getClass ().getDeclaredFields ()) {
            field.setAccessible (true);
            ID c = field.getAnnotation (ID.class);
            if(c!=null){
                res = field;
            }
              }
              return res;
          }
}
