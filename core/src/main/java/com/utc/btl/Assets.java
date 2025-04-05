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

        xCellTexture = loadTexture("lm/lm_X_cell.png");
        xCellFocusTexture = loadTexture("lm/lm_X_focus.png");
        oCellTexture = loadTexture("lm/lm_O_cell.png");
        oCellFocusTexture = loadTexture("lm/lm_O_focus.png");
        emptyCellTexture = loadTexture("lm/lm_cell.png");
        focusCellTexture = loadTexture("lm/lm_cell_focus.png");
    }
}
