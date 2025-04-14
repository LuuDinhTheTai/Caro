package com.utc.btl.screen.impl.dark_mode;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.utc.btl.Main;
import com.utc.btl.screen.IMenuScreen;
import com.utc.btl.screen.impl.light_mode.LightMenuScreen;

import static com.utc.btl.Assets.*;
import static com.utc.btl.Assets.lightImageTextButtonStyle;

public class DarkMenuScreen extends LightMenuScreen implements IMenuScreen {

    public DarkMenuScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        background = new TextureRegion(darkBacgroundTexture);

        table = new Table();

        titleLabel = new Label("C-Caro", darkTitleStyle);
        singlePlayerBtn = new ImageTextButton("Single Player", darkImageTextButtonStyle);
        multiPlayerBtn = new ImageTextButton("Multi Player", darkImageTextButtonStyle);
        profileBtn = new ImageTextButton("Profile", darkImageTextButtonStyle);
        settingBtn = new ImageTextButton("Settings", darkImageTextButtonStyle);
        exitBtn = new ImageTextButton("Exit", darkImageTextButtonStyle);
    }
}
