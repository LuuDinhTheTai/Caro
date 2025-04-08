package com.utc.btl.service;

import com.utc.btl.dto.request.LoginRequest;
import com.utc.btl.dto.request.RegisterRequest;
import com.utc.btl.dto.response.AccountResponse;
import com.utc.btl.service.base.IService;

public interface IAccountService<T, ID> extends IService<T, ID> {

    AccountResponse register(RegisterRequest rq);
    AccountResponse login(LoginRequest rq);
}
