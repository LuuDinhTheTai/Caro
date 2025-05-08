package com.utc.btl.controller.impl;

import com.badlogic.gdx.Gdx;
import com.utc.btl.Main;
import com.utc.btl.controller.IUIModeController;
import com.utc.btl.controller.base.impl.BaseController;
import com.utc.btl.screen.impl.*;
import com.utc.btl.screen.impl.dark_mode.*;
import com.utc.btl.screen.impl.light_mode.*;

import static com.utc.btl.constant.Constants.INFO;

public class UIModeController extends BaseController implements IUIModeController {

    public UIModeController(Main main) {
        super(main);
    }

    @Override
    public void toDefaultMode() {
        Gdx.app.log(INFO, "to default UI mode.");
        if (main.uiMode != main.DEFAULT_UI) {
            main.uiMode = main.DEFAULT_UI;

            main.gameScreen = new GameScreen(main);
            main.menuScreen = new MenuScreen(main);
            main.profileScreen = new ProfileScreen(main);
            main.resultScreen = new ResultScreen(main);
            main.settingScreen = new SettingScreen(main);
        }
    }

    public void toLightMode() {
        Gdx.app.log(INFO, "to light UI mode.");
        if (main.uiMode != main.LIGHT_MODE) {
            main.uiMode = main.LIGHT_MODE;

            main.gameScreen = new LightGameScreen(main);
            main.menuScreen = new LightMenuScreen(main);
            main.profileScreen = new LightProfileScreen(main);
            main.resultScreen = new LightResultScreen(main);
            main.settingScreen = new LightSettingScreen(main);
        }
    }

    @Override
    public void toDarkMode() {
        Gdx.app.log(INFO, "to dark UI mode.");
        if (main.uiMode != main.DARK_MODE) {
            main.uiMode = main.DARK_MODE;

            main.gameScreen = new DarkGameScreen(main);
            main.menuScreen = new DarkMenuScreen(main);
            main.profileScreen = new DarkProfileScreen(main);
            main.resultScreen = new DarkResultScreen(main);
            main.settingScreen = new DarkSettingScreen(main);
        }
    }
}
