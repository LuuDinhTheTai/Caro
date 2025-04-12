package com.utc.btl.dao;

import com.utc.btl.dao.base.IDao;
import com.utc.btl.dto.request.LoginRequest;
import com.utc.btl.dto.request.RegisterRequest;
import com.utc.btl.entity.Account;

import java.util.Optional;

public interface IAccountDao<T, ID> extends IDao<T, ID> {

    Optional<Account> findByUsername(String username);
}
