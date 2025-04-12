package com.utc.btl.controller;

import com.utc.btl.controller.base.IController;
import com.utc.btl.dto.request.LoginRequest;
import com.utc.btl.dto.request.RegisterRequest;

public interface IAuthController extends IController {

    void login(LoginRequest rq);
    void register(RegisterRequest rq);
    void logout();
}
