package com.utc.btl.service.base.impl;

import com.badlogic.gdx.Gdx;
import com.utc.btl.service.base.IService;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.utc.btl.constant.Constants.INFO;

public abstract class BaseService<T, ID> implements IService<T, ID> {

    @Override
    public Optional<T> find(ID id) {
        Gdx.app.log(INFO, "(find) id: " + id);
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "SELECT * FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ?")) {
            stmt.setObject(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(from(rs));
            }
            return Optional.empty();
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<T> list() {
        Gdx.app.log(INFO, "(list)");
        List<T> result = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM " + getTableName())) {
            while (rs.next()) {
                result.add(from(rs));
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(ID id) {
        Gdx.app.log(INFO, "(delete) id: " + id);
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                 "DELETE FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ?")) {
            stmt.setObject(1, id);
            stmt.executeUpdate();
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected abstract Connection getConnection() throws SQLException, IOException, ClassNotFoundException;
    protected abstract T from(ResultSet rs) throws SQLException;
    protected abstract String getTableName();
    protected abstract String getIdColumnName();
}
