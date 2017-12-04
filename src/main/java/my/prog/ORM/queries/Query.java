package my.prog.ORM.queries;

import java.sql.Connection;

public abstract class Query<T> {
    protected Connection connection;
    public abstract T execute();
}
