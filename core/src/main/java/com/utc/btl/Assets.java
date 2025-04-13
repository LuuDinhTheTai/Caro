package com.utc.btl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import static com.utc.btl.constant.Constants.ERROR;
import static com.utc.btl.constant.Constants.INFO;

public class Assets {

    // SKIN
    public static Skin skin;

    // BACKGROUND
    public static Texture lightBackgroundTexture;
    public static Texture darkBacgroundTexture;

    // BUTTON
    public static Texture lightUpButtonTexture;
    public static Texture lightDownButtonTexture;
    public static Texture darkUpButtonTexture;
    public static Texture darkDownButtonTexture;

    // CELL
    public static Texture lightXCellTexture;
    public static Texture lightXCellFocusTexture;
    public static Texture lightOCellTexture;
    public static Texture lightOCellFocusTexture;
    public static Texture lightEmptyCellTexture;
    public static Texture lightFocusCellTexture;
    public static Texture darkXCellTexture;
    public static Texture darkXCellFocusTexture;
    public static Texture darkOCellTexture;
    public static Texture darkOCellFocusTexture;
    public static Texture darkEmptyCellTexture;
    public static Texture darkFocusCellTexture;


    public static Texture loadTexture(String file) {
        return new Texture(Gdx.files.internal(file));
    }

    public static void load() {
        Gdx.app.log(INFO, "Assets loading...");

        try {
            // SKIN
            skin = new Skin(Gdx.files.internal("uiskin.json"));

            // BACKGROUND
            lightBackgroundTexture = loadTexture("background/lm_background.png");
            darkBacgroundTexture = loadTexture("background/dm_background.png");

            // BUTTON
            lightUpButtonTexture = loadTexture("button/lm_up_button.png");
            lightDownButtonTexture = loadTexture("button/lm_down_button.png");
            darkUpButtonTexture = loadTexture("button/dm_up_button.png");
            darkDownButtonTexture = loadTexture("button/dm_down_button.png");

            // CELL
            lightXCellTexture = loadTexture("light_mode/lm_X_cell.png");
            lightXCellFocusTexture = loadTexture("light_mode/lm_X_cell_focus.png");
            lightOCellTexture = loadTexture("light_mode/lm_O_cell.png");
            lightOCellFocusTexture = loadTexture("light_mode/lm_O_cell_focus.png");
            lightEmptyCellTexture = loadTexture("light_mode/lm_cell.png");
            lightFocusCellTexture = loadTexture("light_mode/lm_cell_focus.png");

            darkXCellTexture = loadTexture("dark_mode/dm_X_cell.png");
            darkXCellFocusTexture = loadTexture("dark_mode/dm_X_cell_focus.png");
            darkOCellTexture = loadTexture("dark_mode/dm_O_cell.png");
            darkOCellFocusTexture = loadTexture("dark_mode/dm_O_cell_focus.png");
            darkEmptyCellTexture = loadTexture("dark_mode/dm_cell.png");
            darkFocusCellTexture = loadTexture("dark_mode/dm_cell_focus.png");


        } catch (Exception e) {
            Gdx.app.error(ERROR, "Caused by: ", e);
        }
    }
}
