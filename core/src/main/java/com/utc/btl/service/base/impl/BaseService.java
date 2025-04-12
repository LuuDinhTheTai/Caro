package com.utc.btl.service.base.impl;

import com.badlogic.gdx.Gdx;
import com.utc.btl.dao.base.IDao;
import com.utc.btl.dao.base.impl.BaseDao;
import com.utc.btl.service.base.IService;

import java.util.List;

import static com.utc.btl.constant.Constants.INFO;

public class BaseService<T, ID> implements IService<T, ID> {

    private IDao<T, ID> baseDao;

    public BaseService(IDao<T, ID> dao) {
        this.baseDao = dao;
    }

    @Override
    public T create(T t) {
        Gdx.app.log(INFO, "(create) object: " + t.toString());
        return baseDao.create(t);
    }

    @Override
    public T find(ID id) {
        Gdx.app.log(INFO, "(find) object: " + id);
        return baseDao.find(id);
    }

    @Override
    public List<T> list() {
        Gdx.app.log(INFO, "(list) ");
        return baseDao.list();
    }

    @Override
    public T update(T t) {
        Gdx.app.log(INFO, "(update) object: " + t.toString());
        return baseDao.update(t);
    }

    @Override
    public void delete(ID id) {
        Gdx.app.log(INFO, "(delete) id: " + id);
        baseDao.delete(id);
    }
}
