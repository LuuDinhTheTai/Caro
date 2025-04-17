package com.utc.btl.dao.base.impl;

import com.badlogic.gdx.Gdx;
import com.utc.btl.exception.ExceptionType;
import com.utc.btl.exception.GameException;
import com.utc.btl.dao.base.IDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.utc.btl.constant.Constants.DEBUG;

public abstract class BaseDao<T, ID> implements IDao<T, ID> {

    @Override
    public T find(ID id) {
        String sql = "SELECT * FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ?";
        Gdx.app.debug(DEBUG, sql);
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setObject(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return from(rs);
            }

        } catch (SQLException e) {
            throw new GameException(ExceptionType.ENTITY_NOT_FOUND_EXCEPTION);
        }

        return null;
    }

    @Override
    public List<T> list() {
        String sql = "SELECT * FROM " + getTableName();
        Gdx.app.debug(DEBUG, sql);
        List<T> result = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                result.add(from(rs));
            }

            return result;

        } catch (SQLException e) {
            throw new GameException(ExceptionType.LIST_ENTITY_EXCEPTION);
        }
    }

    @Override
    public void delete(ID id) {
        String sql = "DELETE FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ?";
        Gdx.app.debug(DEBUG, sql);
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setObject(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new GameException(ExceptionType.DELETE_ENTITY_EXCEPTION);
        }
    }

    protected abstract Connection getConnection();
    protected abstract T from(ResultSet rs);
    protected abstract String getTableName();
    protected abstract String getIdColumnName();
}
