package com.utc.btl.service;

import com.utc.btl.dto.request.LoginRequest;
import com.utc.btl.dto.request.RegisterRequest;
import com.utc.btl.entity.Account;
import com.utc.btl.service.base.IService;

public interface IAccountService<T, ID> extends IService<T, ID> {

    Account register(RegisterRequest rq);
    Account login(LoginRequest rq);

    void logout();
}
