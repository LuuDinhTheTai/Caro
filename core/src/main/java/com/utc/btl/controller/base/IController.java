package com.utc.btl.controller.base;

public interface IController {

    void toGameScreen();
    void toMenuScreen();
    void toProfileScreen();
    void toSettingScreen();
    void popUpDialog(String title, String msg);
}
