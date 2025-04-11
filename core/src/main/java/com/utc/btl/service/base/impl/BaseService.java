package com.utc.btl.service.base.impl;

import com.badlogic.gdx.Gdx;
import com.utc.btl.exception.ExceptionType;
import com.utc.btl.exception.GameException;
import com.utc.btl.service.base.IService;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.utc.btl.constant.Constants.DEBUG;
import static com.utc.btl.constant.Constants.INFO;

public abstract class BaseService<T, ID> implements IService<T, ID> {

    @Override
    public Optional<T> find(ID id) {
        Gdx.app.debug(DEBUG, "(find) id: " + id);
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "SELECT * FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ?")) {
            stmt.setObject(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(from(rs));
            }

        } catch (SQLException e) {
            throw new GameException(ExceptionType.ENTITY_NOT_FOUND_EXCEPTION);
        }

        return Optional.empty();
    }

    @Override
    public List<T> list() {
        Gdx.app.debug(DEBUG, "(list)");
        List<T> result = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM " + getTableName())) {
            while (rs.next()) {
                result.add(from(rs));
            }

            return result;

        } catch (SQLException e) {
            throw new GameException(ExceptionType.COULD_NOT_LIST_DATA_EXCEPTION);
        }
    }

    @Override
    public void delete(ID id) {
        Gdx.app.debug(DEBUG, "(delete) id: " + id);
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "DELETE FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ?")) {
            stmt.setObject(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new GameException(ExceptionType.COULD_NOT_DELETE_ENTITY_EXCEPTION);
        }
    }

    protected abstract Connection getConnection();
    protected abstract T from(ResultSet rs);
    protected abstract String getTableName();
    protected abstract String getIdColumnName();
}
