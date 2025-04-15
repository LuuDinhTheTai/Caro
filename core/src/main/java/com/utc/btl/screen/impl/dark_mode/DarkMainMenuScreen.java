package com.utc.btl.screen.impl.dark_mode;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.utc.btl.Assets;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.light_mode.LightMainMenuScreen;

import static com.utc.btl.Assets.darkBacgroundTexture;
import static com.utc.btl.Assets.darkImageTextButtonStyle;

public class DarkMainMenuScreen extends LightMainMenuScreen {

    public DarkMainMenuScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        background = new TextureRegion(darkBacgroundTexture);
        table = new Table();

        titleLabel = new Label("C-Caro", Assets.darkTitleStyle);

        multiPlayerBtn = new TextButton("Multi Player", darkImageTextButtonStyle);
        singlePlayerBtn = new TextButton("SinglePlayer", darkImageTextButtonStyle);
        profileBtn = new TextButton("Profile", darkImageTextButtonStyle);
        settingBtn = new TextButton("Setting", darkImageTextButtonStyle);
        exitBtn = new TextButton("Exit", darkImageTextButtonStyle);
    }
}
