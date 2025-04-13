package com.utc.btl.dao.impl;

import com.badlogic.gdx.Gdx;
import com.utc.btl.dto.request.LoginRequest;
import com.utc.btl.dto.request.RegisterRequest;
import com.utc.btl.entity.Account;
import com.utc.btl.exception.GameException;
import com.utc.btl.exception.ExceptionType;
import com.utc.btl.dao.IAccountDao;
import com.utc.btl.dao.base.impl.BaseDao;
import com.utc.btl.util.DatabaseUtil;

import java.sql.*;
import java.util.Optional;

import static com.utc.btl.constant.Constants.DEBUG;

public class AccountDao extends BaseDao<Account, Long> implements IAccountDao {

    @Override
    protected Connection getConnection() {
        return DatabaseUtil.getConnection();
    }

    @Override
    protected Account from(ResultSet rs) {
        try {
            Account account = new Account();
            account.setId(rs.getLong("id"));
            account.setUsername(rs.getString("username"));
            account.setPassword(rs.getString("password"));
            account.setElo(rs.getLong("elo"));
            account.setWin(rs.getInt("win"));
            account.setLoss(rs.getInt("loss"));
            account.setDraw(rs.getInt("draw"));
            return account;

        } catch (SQLException e) {
            throw new GameException(ExceptionType.COULD_NOT_MAP_FROM_RESULT_EXCEPTION);
        }
    }

    @Override
    protected String getTableName() {
        return "account";
    }

    @Override
    protected String getIdColumnName() {
        return "id";
    }

    @Override
    public Account create(Account account) {
        String sql = "INSERT INTO account (username, password, elo, win, loss, draw) VALUES (?, ?, ?, ?, ?, ?)";
        Gdx.app.debug(DEBUG, sql);

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPassword());
            stmt.setLong(3, account.getElo());
            stmt.setInt(4, account.getWin());
            stmt.setInt(5, account.getLoss());
            stmt.setInt(6, account.getDraw());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating account failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    account.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating account failed, no ID obtained.");
                }
            }
            return account;

        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Account update(Account account) {
        String sql = "UPDATE account SET username=?, password=?, elo=?, win=?, loss=?, draw=? WHERE id=?";
        Gdx.app.debug(DEBUG, sql);
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, account.getUsername());
            stmt.setString(2, account.getPassword());
            stmt.setLong(3, account.getElo());
            stmt.setInt(4, account.getWin());
            stmt.setInt(5, account.getLoss());
            stmt.setInt(6, account.getDraw());
            stmt.setLong(7, account.getId());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating account failed, no rows affected.");
            }

            return account;

        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        String sql = "SELECT * FROM account WHERE username = ?";
        Gdx.app.debug(DEBUG, sql);
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Account account = from(rs);
                    return Optional.of(account);
                }
                return Optional.empty();
            }

        } catch (SQLException e) {
            return Optional.empty();
        }
    }
}
