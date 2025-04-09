package com.utc.btl.service.impl;

import com.utc.btl.entity.Account;
import com.utc.btl.service.IAccountService;
import com.utc.btl.service.base.impl.BaseService;
import com.utc.btl.util.DatabaseUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
