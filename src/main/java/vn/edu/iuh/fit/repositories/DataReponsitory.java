package vn.edu.iuh.fit.repositories;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public abstract class DataReponsitory<T,ID> {
    public abstract T findOne(ID id);
    public abstract List<T> getAll();
    public abstract boolean insert(T t);
    public abstract boolean delete(ID id);
    public abstract boolean update(T t);
}
