package com.tpappweb.app.dao;

import java.util.List;

public abstract class MySQLDAO<T> {

        public abstract boolean create(T x);
        public abstract T findById(Object x);
        public abstract boolean deleteById(int id);
        public abstract boolean delete(T x);
        public abstract boolean update(T x);
        public abstract List<T> findAll();


}
