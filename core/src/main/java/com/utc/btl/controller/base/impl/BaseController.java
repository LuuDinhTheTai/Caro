package com.utc.btl.controller.base.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.utc.btl.Assets;
import com.utc.btl.Main;
import com.utc.btl.controller.base.IController;

import static com.utc.btl.Assets.*;
import static com.utc.btl.constant.Constants.DEBUG;
import static com.utc.btl.constant.Constants.INFO;

public abstract class BaseController implements IController {

    protected Main main;
    protected Skin skin;

    public BaseController(Main main) {
        this.main = main;
        this.skin = Assets.skin;
    }

    @Override
    public void toGameScreen() {
        Gdx.app.log(INFO, "Redirect to game screen");
        main.setScreen(main.gameScreen);
    }

    @Override
    public void toMenuScreen() {
        Gdx.app.log(INFO, "Redirect to menu screen");
        main.setScreen(main.menuScreen);
    }

    @Override
    public void toProfileScreen() {
        Gdx.app.log(INFO, "Redirect to profile screen");
        main.setScreen(main.profileScreen);
    }

    @Override
    public void toSettingScreen() {
        Gdx.app.log(INFO, "Redirect to setting screen");
        main.setScreen(main.settingScreen);
    }

    @Override
    public void popUpDialog(String title, String msg) {
        Gdx.app.debug(DEBUG, "Pop up dialog");
        Stage stage = (Stage) Gdx.input.getInputProcessor();

        Dialog dialog = new Dialog(title, skin);

        if (main.uiMode == main.DEFAULT_UI) {
            dialog.text(msg);

        } else if (main.uiMode == main.LIGHT_MODE) {
            dialog.setStyle(lightDialogStyle);
            dialog.text(msg, lightDialogTextStyle);

        } else if (main.uiMode == main.DARK_MODE) {
            dialog.setStyle(darkDialogStyle);
            dialog.text(msg, darkDialogTextStyle);
        }

        dialog.button("OK");
        dialog.show(stage);
        dialog.setSize(350, 200);
        dialog.setPosition(
            (stage.getViewport().getWorldWidth()  - dialog.getWidth())  / 2,
            (stage.getViewport().getWorldHeight() - dialog.getHeight()) / 2
        );
    }
}
