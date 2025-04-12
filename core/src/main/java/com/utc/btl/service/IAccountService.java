package com.utc.btl.service;

import com.utc.btl.dto.request.LoginRequest;
import com.utc.btl.dto.request.RegisterRequest;
import com.utc.btl.entity.Account;
import com.utc.btl.service.base.IService;

public interface IAccountService extends IService<Account, Long> {

    Account register(RegisterRequest rq);
    Account login(LoginRequest rq);

    Account logout();
}
