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
        main.state = main.inGame;
        main.setScreen(main.gameScreen);
        // TODO: vẽ board ở đây hay ở Main ???, board tĩnh thì có cần phải vẽ đi vẽ lại trong gameloop không ???
//        main.batch.begin();
//        boardRenderer.draw(main.batch);
//        main.batch.end();

    }

    @Override
    public void toLoginScreen() {
        Gdx.app.log(INFO, "Redirect to login screen");
        main.state = main.notInGame;

        if (main.uiMode == main.DEFAULT_UI) {
            main.setScreen(main.loginScreen);

        } else if (main.uiMode == main.LIGHT_MODE) {
            main.setScreen(main.loginScreen);

        } else if (main.uiMode == main.DARK_MODE) {
            main.setScreen(main.loginScreen);

        }
    }

    @Override
    public void toMainMenuScreen() {
        Gdx.app.log(INFO, "Redirect to main menu screen");
        main.state = main.notInGame;

        if (main.uiMode == main.DEFAULT_UI) {
            main.setScreen(main.mainMenuScreen);
        } else if (main.uiMode == main.LIGHT_MODE) {
            main.setScreen(main.mainMenuScreen);

        } else if (main.uiMode == main.DARK_MODE) {
            main.setScreen(main.mainMenuScreen);

        }
    }

    @Override
    public void toMenuScreen() {
        Gdx.app.log(INFO, "Redirect to menu screen");
        main.state = main.notInGame;

        if (main.uiMode == main.DEFAULT_UI) {
            main.setScreen(main.menuScreen);

        } else if (main.uiMode == main.LIGHT_MODE) {
            main.setScreen(main.lightMenuScreen);

        } else if (main.uiMode == main.DARK_MODE) {
            main.setScreen(main.menuScreen);

        }
    }

    @Override
    public void toRegisterScreen() {
        Gdx.app.log(INFO, "Redirect to register screen");
        main.state = main.notInGame;

        if (main.uiMode == main.DEFAULT_UI) {
            main.setScreen(main.registerScreen);

        } else if (main.uiMode == main.LIGHT_MODE) {
            main.setScreen(main.registerScreen);

        } else if (main.uiMode == main.DARK_MODE) {
            main.setScreen(main.registerScreen);

        }
    }

    @Override
    public void toProfileScreen() {
        main.state = main.notInGame;
        main.setScreen(main.profileScreen);
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
