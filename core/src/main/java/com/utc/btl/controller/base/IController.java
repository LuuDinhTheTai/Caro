package com.utc.btl.controller.base;

public interface IController {

    void toGameScreen();
    void toLoginScreen();
    void toMainMenuScreen();
    void toMenuScreen();
    void toRegisterScreen();
    void popUpDialog(String title, String msg);
}
