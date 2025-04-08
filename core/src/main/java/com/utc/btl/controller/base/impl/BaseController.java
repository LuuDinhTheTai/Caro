package com.utc.btl.controller.base.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.utc.btl.Main;
import com.utc.btl.controller.base.Controller;

import static com.utc.btl.constant.Constants.INFO;

public abstract class BaseController implements Controller {

    protected Main main;
    protected Skin skin;

    public BaseController(Main main) {
        this.main = main;
        this.skin = new Skin(Gdx.files.internal("uiskin.json"));
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
    public void toMainMenuScreen() {
        Gdx.app.log(INFO, "Redirect to main menu screen");
        main.setScreen(main.mainMenuScreen);
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

    @Override
    public void popUpDialog(String title, String msg) {
        Gdx.app.log(INFO, "Pop up dialog");
        Stage stage = (Stage) Gdx.input.getInputProcessor();

        Dialog dialog = new Dialog(title, skin);
        dialog.text(msg);

        dialog.button("Ok");

        dialog.center();
        dialog.setSize(250, 100);

        dialog.show(stage);
    }
}
