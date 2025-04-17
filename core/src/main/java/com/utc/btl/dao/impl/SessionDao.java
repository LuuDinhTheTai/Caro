package com.utc.btl.dao.impl;

import com.badlogic.gdx.Gdx;
import com.utc.btl.entity.Session;
import com.utc.btl.exception.GameException;
import com.utc.btl.exception.ExceptionType;
import com.utc.btl.dao.ISessionDao;
import com.utc.btl.dao.base.impl.BaseDao;
import com.utc.btl.util.DatabaseUtil;

import java.sql.*;
import java.util.Optional;

import static com.utc.btl.constant.Constants.DEBUG;

public class SessionDao extends BaseDao<Session, Long> implements ISessionDao {

    @Override
    protected Connection getConnection() {
        return DatabaseUtil.getConnection();
    }

    @Override
    protected Session from(ResultSet rs) {
        try {
            Session s = new Session();
            s.setId(rs.getLong("id"));
            s.setXWin(rs.getInt("xWin"));
            s.setOWin(rs.getInt("oWin"));
            s.setDraw(rs.getInt("draw"));
            return s;

        } catch (SQLException e) {
            throw new GameException(ExceptionType.COULD_NOT_MAP_FROM_RESULT_EXCEPTION);
        }
    }

    @Override
    protected String getTableName() {
        return "session";
    }

    @Override
    protected String getIdColumnName() {
        return "id";
    }

    @Override
    public Session create(Session session) {
        String sql = "INSERT INTO session (xWin, oWin, draw) VALUES (?, ?, ?)";
        Gdx.app.debug(DEBUG, sql);

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, session.getXWin());
            stmt.setInt(2, session.getOWin());
            stmt.setInt(3, session.getDraw());
            int rows = stmt.executeUpdate();
            if (rows == 0)
                throw new SQLException("Creating session failed.");

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    session.setId(keys.getLong(1));
                } else {
                    throw new SQLException("No ID obtained.");
                }
            }
            return session;

        } catch (SQLException e) {
            throw new GameException(ExceptionType.CREATE_ENTITY_EXCEPTION);
        }
    }

    @Override
    public Session update(Session session) {
        String sql = "UPDATE session SET xWin=?, oWin=?, draw=? WHERE id=?";
        Gdx.app.debug(DEBUG, sql);

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, session.getXWin());
            stmt.setInt(2, session.getOWin());
            stmt.setInt(3, session.getDraw());
            stmt.setLong(4, session.getId());

            if (stmt.executeUpdate() == 0) {
                throw new SQLException("Updating session failed.");
            }
            return session;

        } catch (SQLException e) {
            throw new GameException(ExceptionType.UPDATE_ENTITY_EXCEPTION);
        }
    }
}
