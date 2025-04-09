package com.utc.btl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import static com.utc.btl.constant.Constants.INFO;

public class Assets {

    public static Texture xCellTexture;
    public static Texture xCellFocusTexture;
    public static Texture oCellTexture;
    public static Texture oCellFocusTexture;
    public static Texture emptyCellTexture;
    public static Texture focusCellTexture;

    public static Texture loadTexture(String file) {
        return new Texture(Gdx.files.internal(file));
    }

    public static void load() {
        Gdx.app.log(INFO, "Assets loading...");

        xCellTexture = loadTexture("light_mode/lm_X_cell.png");
        xCellFocusTexture = loadTexture("light_mode/lm_X_cell_focus.png");
        oCellTexture = loadTexture("light_mode/lm_O_cell.png");
        oCellFocusTexture = loadTexture("light_mode/lm_O_cell_focus.png");
        emptyCellTexture = loadTexture("light_mode/lm_cell.png");
        focusCellTexture = loadTexture("light_mode/lm_cell_focus.png");
    }
}
