package com.utc.btl.constant;

import com.badlogic.gdx.Gdx;

public class Constants {

    public static final int ROW_SIZE = 50;
    public static final int COL_SIZE = 50;

    // LOGGING
    public static final String INFO = "INFO";
    public static final String DEBUG = "DEBUG";
    public static final String WARN = "WARN";
    public static final String ERROR = "ERROR";

    // DIALOG
    public static final String DIALOG_INFO_TITLE = "Info";
    public static final String DIALOG_ERROR_TITLE = "Error";
    public static final String DIALOG_SUCCESS_TITLE = "Success";
    public static final String DIALOG_WARNING_TITLE = "Warn";

    // SIZE
    public static float WINDOW_W = Gdx.graphics.getWidth();
    public static float WINDOW_H = Gdx.graphics.getHeight();

    public static float TABLE_W = WINDOW_W / 3;
    public static float TABLE_H = WINDOW_H / 3;

    public static float SMALL_BUTTON_W = (TABLE_W - 10) / 2;
    public static float SMALL_BUTTON_H = (TABLE_H - 0) / 4;
    public static float BIG_BUTTON_W = (TABLE_W - 10);
    public static float BIG_BUTTON_H = (TABLE_H - 0) / 4;

    public static void resize(float w, float h) {
        WINDOW_W = w;
        WINDOW_H = h;
        TABLE_W = WINDOW_W / 3;
        TABLE_H = WINDOW_H / 3;
        SMALL_BUTTON_W = (TABLE_W - 10) / 2;
        SMALL_BUTTON_H = (TABLE_H - 0) / 4;
        BIG_BUTTON_W = (TABLE_W - 10);
        BIG_BUTTON_H = (TABLE_H - 0) / 4;
    }
}
