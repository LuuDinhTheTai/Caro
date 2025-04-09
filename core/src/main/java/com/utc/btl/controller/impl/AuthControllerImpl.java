package com.utc.btl.controller.impl;

import com.badlogic.gdx.Gdx;
import com.utc.btl.Main;
import com.utc.btl.controller.IAuthController;
import com.utc.btl.controller.base.impl.BaseController;
import com.utc.btl.dto.request.LoginRequest;
import com.utc.btl.dto.request.RegisterRequest;
import com.utc.btl.exception.GameException;

import static com.utc.btl.constant.Constants.DIALOG_ERROR_TITLE;
import static com.utc.btl.constant.Constants.INFO;

public class AuthControllerImpl extends BaseController implements IAuthController {

    public AuthControllerImpl(Main main) {
        super(main);
    }

    @Override
    public void login(LoginRequest rq) {
        try {
            Gdx.app.log(INFO, "(login) request: " + rq.toString());

            rq.validate();
            main.accountService.login(rq);
            toMainMenuScreen();

        } catch (GameException e) {
            popUpDialog(DIALOG_ERROR_TITLE, e.getMessage());

        } catch (Exception e) {
            Gdx.app.error(DIALOG_ERROR_TITLE, "(login) request: " + rq.toString(), e);
            popUpDialog(DIALOG_ERROR_TITLE, "An unexpected error occurred");
        }
    }

    @Override
    public void register(RegisterRequest rq) {
        try {
            Gdx.app.log(INFO, "(register) request: " + rq.toString());

            rq.validate();
            main.accountService.register(rq);
            toLoginScreen();

        } catch (GameException e) {
            popUpDialog(DIALOG_ERROR_TITLE, e.getMessage());

        } catch (Exception e) {
            Gdx.app.error(DIALOG_ERROR_TITLE, "(register) request: " + rq.toString(), e);
            popUpDialog(DIALOG_ERROR_TITLE, "An unexpected error occurred");
        }
    }
}
