package com.utc.btl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.utc.btl.exception.GameException;
import com.utc.btl.exception.ExceptionType;

import static com.utc.btl.constant.Constants.ERROR;
import static com.utc.btl.constant.Constants.INFO;

public class Assets {

    // SKIN
    public static Skin skin;

    // CELL
    public static Texture xCellTexture;
    public static Texture xCellFocusTexture;
    public static Texture oCellTexture;
    public static Texture oCellFocusTexture;
    public static Texture emptyCellTexture;
    public static Texture focusCellTexture;

    // BUTTON
    public static Texture lightUpButtonTexture;
    public static Texture lightDownButtonTexture;

    //game UI
    public static Texture playBtnTexture;
    public static Texture settingsBtnTexture;
    public static Texture exitBtnTexture;
    public static Texture buttonBackgroundTexture;

    //menu screen
    public static Texture menuBackgroundTexture;
    public static Texture menuLogoTexture;

    public static Texture loadTexture(String file) {
        return new Texture(Gdx.files.internal(file));
    }

    public static void load() {
        Gdx.app.log(INFO, "Assets loading...");

        try {
            // SKIN
            skin = new Skin(Gdx.files.internal("uiskin.json"));
            // CELL
            xCellTexture = loadTexture("light_mode/lm_X_cell.png");
            xCellFocusTexture = loadTexture("light_mode/lm_X_cell_focus.png");
            oCellTexture = loadTexture("light_mode/lm_O_cell.png");
            oCellFocusTexture = loadTexture("light_mode/lm_O_cell_focus.png");
            emptyCellTexture = loadTexture("light_mode/lm_cell.png");
            focusCellTexture = loadTexture("light_mode/lm_cell_focus.png");

            // BUTTON
            lightUpButtonTexture = loadTexture("button/lm_up_button.png");
            lightDownButtonTexture = loadTexture("button/lm_down_button.png");

//            menuBackgroundTexture = new Texture("assets/General/menu_background.png");
//            menuLogoTexture = new Texture("assets/General/menu_logo.png");
//            buttonBackgroundTexture = new Texture("assets/UI/btn_background.png");

        } catch (Exception e) {
            Gdx.app.error(ERROR, "Caused by: ", e);
        }
    }
}
