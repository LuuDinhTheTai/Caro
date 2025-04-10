package com.utc.btl.service.impl;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.utc.btl.dto.request.LoginRequest;
import com.utc.btl.dto.request.RegisterRequest;
import com.utc.btl.entity.Account;
import com.utc.btl.exception.GameException;
import com.utc.btl.exception.ExceptionType;
import com.utc.btl.service.IAccountService;
import com.utc.btl.service.base.impl.BaseService;
import com.utc.btl.util.DatabaseUtil;

import java.io.IOException;
import java.sql.*;
import java.util.Optional;

import static com.utc.btl.constant.Constants.INFO;

public class AccountService extends BaseService<Account, Long> implements IAccountService<Account, Long> {

    @Override
    protected Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
        return DatabaseUtil.getConnection();
    }

    @Override
    protected Account from(ResultSet rs) throws SQLException {
        Account account = new Account();
        account.setId(rs.getLong("id"));
        account.setUsername(rs.getString("username"));
        account.setPassword(rs.getString("password"));
        account.setElo(rs.getLong("elo"));
        account.setWin(rs.getInt("win"));
        account.setLoss(rs.getInt("loss"));
        account.setDraw(rs.getInt("draw"));
        return account;
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
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Account update(Account account) {
        String sql = "UPDATE account SET username=?, password=?, elo=?, win=?, loss=?, draw=? WHERE id=?";
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
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Account register(RegisterRequest rq) {
        Gdx.app.log(INFO, "(register) object: " + rq.toString());

        Optional<Account> existingAccount = findByUsername(rq.getUsername());
        if (existingAccount.isPresent()) {
            throw new GameException(ExceptionType.USERNAME_EXISTED);
        }

        Account account = new Account();
        account.setUsername(rq.getUsername());
        account.setPassword(rq.getPassword());
        account.setElo(500);
        account.setWin(0);
        account.setLoss(0);
        account.setDraw(0);

        return account;
    }

    @Override
    public Account login(LoginRequest rq) {
        Gdx.app.log(INFO, "(login) object: " + rq.toString());

        Optional<Account> account = findByUsername(rq.getUsername());
        if (account.isEmpty()) {
            throw new GameException(ExceptionType.ACCOUNT_NOT_EXISTED);
        }

        if (!account.get().getPassword().equals(rq.getPassword())) {
            throw new GameException(ExceptionType.WRONG_PASSWORD_EXCEPTION);
        }

        return account.get();
    }

    @Override
    public void logout() {
        Gdx.app.log(INFO, "(logout) ");

    }

    private Optional<Account> findByUsername(String username) {
        Gdx.app.log(INFO, "(find) username: " + username);
        String sql = "SELECT * FROM account WHERE username = ?";
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
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
