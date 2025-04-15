package com.utc.btl.controller.impl;

import com.utc.btl.Main;
import com.utc.btl.controller.IGameModeController;
import com.utc.btl.controller.base.impl.BaseController;

public class GameModeController extends BaseController implements IGameModeController {

    public GameModeController(Main main) {
        super(main);
    }

    @Override
    public void toDefaultMode() {
        if (main.uiMode != main.DEFAULT_UI) {
            main.uiMode = main.DEFAULT_UI;
        }
    }

    public void toLightMode() {
        if (main.uiMode != main.LIGHT_MODE) {
            main.uiMode = main.LIGHT_MODE;
        }
    }

    @Override
    public void toDarkMode() {
        if (main.uiMode != main.DARK_MODE) {
            main.uiMode = main.DARK_MODE;
        }
    }
}
