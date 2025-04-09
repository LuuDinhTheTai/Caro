package com.utc.btl.service.base;

import java.util.Optional;

public interface IService<T, ID> {

    T create(T t);
    Optional<T> find(ID id);
    Optional<T> list();
    T update(T t);
    void delete(ID id);
}
