package com.utc.btl.service.base.impl;

import com.utc.btl.service.base.IService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public abstract class BaseService<T, ID> implements IService<T, ID> {

    @Override
    public Optional<T> find(ID id) {
        return Optional.empty();
    }

    @Override
    public T create(T t) {
        return null;
    }

    @Override
    public Optional<T> list() {
        return Optional.empty();
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public void delete(ID id) {

    }

    protected abstract Connection getConnection() throws SQLException, IOException, ClassNotFoundException;
    protected abstract T from(ResultSet rs) throws SQLException;
    protected abstract String getTableName();
    protected abstract String getIdColumnName();
}
