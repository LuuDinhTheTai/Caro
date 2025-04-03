package com.utc.btl.controller;

import com.utc.btl.controller.base.Controller;
import com.utc.btl.dto.request.LoginRequest;
import com.utc.btl.dto.request.RegisterRequest;

public interface AuthController extends Controller {

    void login(LoginRequest rq);
    void register(RegisterRequest rq);
}
