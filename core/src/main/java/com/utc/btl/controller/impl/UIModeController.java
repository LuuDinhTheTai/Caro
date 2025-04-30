package com.utc.btl.controller.impl;

import com.badlogic.gdx.Gdx;
import com.utc.btl.Main;
import com.utc.btl.controller.IUIModeController;
import com.utc.btl.controller.base.impl.BaseController;
import com.utc.btl.screen.impl.MenuScreen;
import com.utc.btl.screen.impl.ProfileScreen;
import com.utc.btl.screen.impl.SettingScreen;
import com.utc.btl.screen.impl.dark_mode.DarkMenuScreen;
import com.utc.btl.screen.impl.dark_mode.DarkProfileScreen;
import com.utc.btl.screen.impl.dark_mode.DarkSettingScreen;
import com.utc.btl.screen.impl.light_mode.LightMenuScreen;
import com.utc.btl.screen.impl.light_mode.LightProfileScreen;
import com.utc.btl.screen.impl.light_mode.LightSettingScreen;

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

            main.menuScreen = new MenuScreen(main);
            main.profileScreen = new ProfileScreen(main);
            main.settingScreen = new SettingScreen(main);
        }
    }

    public void toLightMode() {
        Gdx.app.log(INFO, "to light UI mode.");
        if (main.uiMode != main.LIGHT_MODE) {
            main.uiMode = main.LIGHT_MODE;

            main.menuScreen = new LightMenuScreen(main);
            main.profileScreen = new LightProfileScreen(main);
            main.settingScreen = new LightSettingScreen(main);
        }
    }

    @Override
    public void toDarkMode() {
        Gdx.app.log(INFO, "to dark UI mode.");
        if (main.uiMode != main.DARK_MODE) {
            main.uiMode = main.DARK_MODE;

            main.menuScreen = new DarkMenuScreen(main);
            main.profileScreen = new DarkProfileScreen(main);
            main.settingScreen = new DarkSettingScreen(main);
        }
    }
}
