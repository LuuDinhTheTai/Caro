package com.utc.btl.dao.base;

import java.util.List;
import java.util.Optional;

public interface IDao<T, ID> {

    T create(T t);
    T find(ID id);
    List<T> list();
    T update(T t);
    void delete(ID id);
}
