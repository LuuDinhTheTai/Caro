package com.utc.btl.dao;

import com.utc.btl.dao.base.IDao;
import com.utc.btl.entity.Account;

import java.util.Optional;

public interface IAccountDao extends IDao<Account, Long> {

    Optional<Account> findByUsername(String username);
}
