package my.prog.dao;

import my.prog.ORM.CRUDRepository;
import my.prog.ORM.annotations.Column;
import my.prog.ORM.annotations.Table;
import my.prog.ORM.queries.Create;
import my.prog.ORM.queries.Query;


import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDAO<T> extends CRUDRepository<T> implements GenericDAO<T> {



}
