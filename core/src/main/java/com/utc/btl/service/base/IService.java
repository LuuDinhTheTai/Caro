package com.utc.btl.service.base;

import java.util.List;
import java.util.Optional;

public interface IService<T, ID> {

    T create(T t);
    Optional<T> find(ID id);
    List<T> list();
    T update(T t);
    void delete(ID id);
}
