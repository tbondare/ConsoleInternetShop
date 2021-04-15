package dao;

import model.AbstractEntity;

import java.util.List;

public interface Dao<T extends AbstractEntity> {

    T add(T t);

    T getById(Long id);

    T delete(T t);

    List<T> getAll();
}
