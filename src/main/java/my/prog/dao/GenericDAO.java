package my.prog.dao;

import java.sql.SQLException;

public interface GenericDAO<T> {
    T create(T t) ;

    T findById(long id);

    T update(T t);

    T delete(T t);
}
