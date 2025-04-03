package com.utc.btl.controller.impl;

import com.badlogic.gdx.Gdx;
import com.utc.btl.Main;
import com.utc.btl.controller.AuthController;
import com.utc.btl.controller.base.impl.BaseController;
import com.utc.btl.dto.request.LoginRequest;
import com.utc.btl.dto.request.RegisterRequest;

import static com.utc.btl.constant.Constants.INFO;

public class AuthControllerImpl extends BaseController implements AuthController {

    public AuthControllerImpl(Main main) {
        super(main);
    }

    @Override
    public void login(LoginRequest rq) {
        Gdx.app.log(INFO, "(login) request: " + rq.toString());

    }

    @Override
    public void register(RegisterRequest rq) {
        Gdx.app.log(INFO, "(register) request: " + rq.toString());

    }
}
