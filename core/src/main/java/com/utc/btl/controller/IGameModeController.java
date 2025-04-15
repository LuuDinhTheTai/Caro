package com.utc.btl.controller;

import com.utc.btl.controller.base.IController;

public interface IGameModeController extends IController {

    void toDefaultMode();
    void toLightMode();
    void toDarkMode();
}
