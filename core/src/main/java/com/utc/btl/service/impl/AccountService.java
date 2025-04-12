package com.utc.btl.service.impl;

import com.badlogic.gdx.Gdx;
import com.utc.btl.dao.IAccountDao;
import com.utc.btl.dao.impl.AccountDao;
import com.utc.btl.dto.request.LoginRequest;
import com.utc.btl.dto.request.RegisterRequest;
import com.utc.btl.entity.Account;
import com.utc.btl.exception.ExceptionType;
import com.utc.btl.exception.GameException;
import com.utc.btl.service.IAccountService;
import com.utc.btl.service.base.impl.BaseService;

import java.util.Optional;

import static com.utc.btl.constant.Constants.DEBUG;

public class AccountService extends BaseService<Account, Long> implements IAccountService {

    private IAccountDao accountDao;

    public AccountService(IAccountDao accountDao) {
        super(accountDao);
        this.accountDao = accountDao;
    }

    @Override
    public Account register(RegisterRequest rq) {
        Gdx.app.debug(DEBUG, "(register) object: " + rq.toString());

        Optional<Account> existingAccount = accountDao.findByUsername(rq.getUsername());
        if (existingAccount.isPresent()) {
            throw new GameException(ExceptionType.USERNAME_EXISTED_EXCEPTION);
        }

        Account account = new Account();
        account.setUsername(rq.getUsername());
        account.setPassword(rq.getPassword());
        account.setElo(500);
        account.setWin(0);
        account.setLoss(0);
        account.setDraw(0);

        return create(account);
    }

    @Override
    public Account login(LoginRequest rq) {
        Gdx.app.debug(DEBUG, "(login) object: " + rq.toString());

        Optional<Account> account = accountDao.findByUsername(rq.getUsername());
        if (account.isEmpty()) {
            throw new GameException(ExceptionType.ACCOUNT_NOT_EXISTED_EXCEPTION);
        }

        if (!account.get().getPassword().equals(rq.getPassword())) {
            throw new GameException(ExceptionType.WRONG_PASSWORD_EXCEPTION);
        }

        return account.get();
    }

    @Override
    public Account logout() {
        Gdx.app.debug(DEBUG, "(logout) ");
        return null;
    }
}
