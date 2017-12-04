package my.prog.ORM;

import my.prog.ORM.queries.*;

import java.sql.Connection;

public abstract class CRUDRepository<T> {
    protected Connection connection;
    private Query<T> query;
    public T create (T t){
        query = new Create<> (t,connection);
        return query.execute ();
    }
    public T findById (long id){
        query = new Find<T> (id,connection);
        return  query.execute ();
    }
    public T delete(T t){
        query = new Delete<> (t,connection);
        return query.execute ();
    }
    public T update (T t){
        query = new Update<> (t,connection);
        return query.execute ();
    }

}
