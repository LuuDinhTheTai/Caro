package com.utc.btl.controller.base.impl;

import com.badlogic.gdx.Gdx;
import com.utc.btl.Main;
import com.utc.btl.controller.base.Controller;

import static com.utc.btl.constant.Constants.INFO;

public abstract class BaseController implements Controller {

    protected Main main;

    public BaseController(Main main) {
        this.main = main;
    }

    @Override
    public void toGameScreen() {
        Gdx.app.log(INFO, "Redirect to game screen");
        main.setScreen(main.gameScreen);
    }

    @Override
    public void toLoginScreen() {
        Gdx.app.log(INFO, "Redirect to login screen");
        main.setScreen(main.loginScreen);
    }

    @Override
    public void toMenuScreen() {
        Gdx.app.log(INFO, "Redirect to menu screen");
        main.setScreen(main.menuScreen);
    }

    @Override
    public void toRegisterScreen() {
        Gdx.app.log(INFO, "Redirect to register screen");
        main.setScreen(main.registerScreen);
    }
}
