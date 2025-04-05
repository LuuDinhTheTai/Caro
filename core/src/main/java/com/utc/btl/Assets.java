package com.utc.btl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import static com.utc.btl.constant.Constants.INFO;

public class Assets {

    public static Texture xCellTexture;
    public static Texture xCellFocusTexture;
    public static Texture oCellTexture;
    public static Texture oCellFocusTexture;
    public static Texture emptyCellTexture;
    public static Texture focusCellTexture;

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

        // xCellTexture = new Texture(Gdx.files.internal("lm/lm_X_cell.png"));
        // xCellFocusTexture = new Texture(Gdx.files.internal("lm/lm_X_focus.png"));
        // oCellTexture = new Texture(Gdx.files.internal("lm/lm_O_cell.png"));
        // oCellFocusTexture = new Texture(Gdx.files.internal("lm/lm_O_focus.png"));
        // emptyCellTexture = new Texture(Gdx.files.internal("lm/lm_cell.png"));
        // focusCellTexture = new Texture(Gdx.files.internal("lm/lm_cell_focus.png"));

        menuBackgroundTexture = new Texture("assets/General/menu_background.png");
        menuLogoTexture = new Texture("assets/General/menu_logo.png");
        buttonBackgroundTexture = new Texture("assets/UI/btn_background.png");
        Gdx.app.log(INFO, "Assets loaded successfully");
    }
}
