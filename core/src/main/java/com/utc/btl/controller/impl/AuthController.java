package com.utc.btl.controller.impl;

import com.badlogic.gdx.Gdx;
import com.utc.btl.Main;
import com.utc.btl.controller.IAuthController;
import com.utc.btl.controller.base.impl.BaseController;
import com.utc.btl.dto.request.LoginRequest;
import com.utc.btl.dto.request.RegisterRequest;
import com.utc.btl.exception.GameException;

import static com.utc.btl.constant.Constants.*;

public class AuthController extends BaseController implements IAuthController {

    public AuthController(Main main) {
        super(main);
    }

    @Override
    public void login(LoginRequest rq) {
        try {
            Gdx.app.log(INFO, "(login) request: " + rq.toString());

            rq.validate();
            main.loggedInAccount = main.accountService.login(rq);
            toMainMenuScreen();

        } catch (GameException e) {
            Gdx.app.error(ERROR, "Caused by: ", e);
            popUpDialog(DIALOG_ERROR_TITLE, e.getMessage());

        } catch (Exception e) {
            Gdx.app.error(ERROR, "Caused by: ", e);
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
            Gdx.app.error(ERROR, "Caused by: ", e);
            popUpDialog(DIALOG_ERROR_TITLE, e.getMessage());

        } catch (Exception e) {
            Gdx.app.error(ERROR, "Caused by: ", e);
            popUpDialog(DIALOG_ERROR_TITLE, "An unexpected error occurred");
        }
    }

    @Override
    public void toSettingScreen() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toSettingScreen'");
    }
}
