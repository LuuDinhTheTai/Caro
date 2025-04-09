package com.utc.btl.controller.base;

public interface Controller {

    void toGameScreen();
    void toLoginScreen();
    void toMainMenuScreen();
    void toMenuScreen();
    void toRegisterScreen();
    void popUpDialog(String title, String msg);
    void showSettingPopup();
    void hideSettingPopup();
}
