package my.prog.ORM;

import java.lang.reflect.InvocationTargetException;

public class InstanceFactory<T> {
    private Class<T> tClass;

    public InstanceFactory (Class<T> tClass) {
        this.tClass = tClass;
    }
    public T getInstance() {
        T t = null;
        try {
            t = (T) tClass.getConstructors ()[0].newInstance ();
        } catch (IllegalAccessException e) {
            e.printStackTrace ();
        } catch (InstantiationException e) {
            e.printStackTrace ();
        } catch (InvocationTargetException e) {
            e.printStackTrace ();
        }
        return t;
    }
}

