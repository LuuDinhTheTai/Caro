package com.utc.btl.controller.base.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.utc.btl.Assets;
import com.utc.btl.Main;
import com.utc.btl.controller.base.IController;

import static com.utc.btl.constant.Constants.DEBUG;
import static com.utc.btl.constant.Constants.INFO;

public abstract class BaseController implements IController {

    protected Main main;
    protected Skin skin;

    public BaseController(Main main/*, BoardRenderer boardRenderer*/) {
        this.main = main;
        this.skin = Assets.skin;
    }

    @Override
    public void toGameScreen() {
        Gdx.app.log(INFO, "Redirect to game screen");

        if (main.uiMode == main.DEFAULT_UI) {
            main.setScreen(main.gameScreen);

        } else if (main.uiMode == main.LIGHT_MODE) {
            main.setScreen(main.gameScreen);

        } else if (main.uiMode == main.DARK_MODE) {
            main.setScreen(main.gameScreen);

        }
    }

    @Override
    public void toLoginScreen() {
        Gdx.app.log(INFO, "Redirect to login screen");

        if (main.uiMode == main.DEFAULT_UI) {
            main.setScreen(main.loginScreen);

        } else if (main.uiMode == main.LIGHT_MODE) {
            main.setScreen(main.lightLoginScreen);

        } else if (main.uiMode == main.DARK_MODE) {
            main.setScreen(main.darkLoginScreen);

        }
    }

    @Override
    public void toMainMenuScreen() {
        Gdx.app.log(INFO, "Redirect to main menu screen");

        if (main.uiMode == main.DEFAULT_UI) {
            main.setScreen(main.mainMenuScreen);

        } else if (main.uiMode == main.LIGHT_MODE) {
            main.setScreen(main.lightMainMenuScreen);

        } else if (main.uiMode == main.DARK_MODE) {
            main.setScreen(main.darkMainMenuScreen);

        }
    }

    @Override
    public void toMenuScreen() {
        Gdx.app.log(INFO, "Redirect to menu screen");

        if (main.uiMode == main.DEFAULT_UI) {
            main.setScreen(main.menuScreen);

        } else if (main.uiMode == main.LIGHT_MODE) {
            main.setScreen(main.lightMenuScreen);

        } else if (main.uiMode == main.DARK_MODE) {
            main.setScreen(main.darkMenuScreen);

        }
    }

    @Override
    public void toRegisterScreen() {
        Gdx.app.log(INFO, "Redirect to register screen");

        if (main.uiMode == main.DEFAULT_UI) {
            main.setScreen(main.registerScreen);

        } else if (main.uiMode == main.LIGHT_MODE) {
            main.setScreen(main.lightRegisterScreen);

        } else if (main.uiMode == main.DARK_MODE) {
            main.setScreen(main.darkRegisterScreen);

        }
    }

    @Override
    public void toProfileScreen() {
        Gdx.app.log(INFO, "Redirect to profile screen");

        if (main.uiMode == main.DEFAULT_UI) {
            main.setScreen(main.profileScreen);

        } else if (main.uiMode == main.LIGHT_MODE) {
            main.setScreen(main.lightProfileScreen);

        } else if (main.uiMode == main.DARK_MODE) {
            main.setScreen(main.darkProfileScreen);

        }
    }

    @Override
    public void toSettingScreen() {
        Gdx.app.log(INFO, "Redirect to setting screen");

        if (main.uiMode == main.DEFAULT_UI) {
            main.setScreen(main.settingScreen);

        } else if (main.uiMode == main.LIGHT_MODE) {
            main.setScreen(main.lightSettingScreen);

        } else if (main.uiMode == main.DARK_MODE) {
            main.setScreen(main.darkSettingScreen);

        }
    }

    @Override
    public void popUpDialog(String title, String msg) {
        Gdx.app.debug(DEBUG, "Pop up dialog");
        Stage stage = (Stage) Gdx.input.getInputProcessor();

        Dialog dialog = new Dialog(title, skin);
        dialog.text(msg);

        dialog.button("Ok");

        dialog.center();
        dialog.setSize(250, 100);

        dialog.show(stage);
    }
}
