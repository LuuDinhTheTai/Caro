package com.utc.btl.screen.impl.dark_mode;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.utc.btl.Assets;
import com.utc.btl.Main;
import com.utc.btl.screen.IMainMenuScreen;
import com.utc.btl.screen.impl.light_mode.LightMainMenuScreen;

public class DarkMainMenuScreen extends LightMainMenuScreen implements IMainMenuScreen {

    public DarkMainMenuScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        table = new Table();

        titleLabel = new Label("C-Caro", Assets.darkTitleStyle);

        multiPlayerBtn = new TextButton("Multi Player", Assets.darkImageTextButtonStyle);
        singlePlayerBtn = new TextButton("SinglePlayer", Assets.darkImageTextButtonStyle);
        profileBtn = new TextButton("Profile", Assets.darkImageTextButtonStyle);
        settingBtn = new TextButton("Setting", Assets.darkImageTextButtonStyle);
        exitBtn = new TextButton("Exit", Assets.darkImageTextButtonStyle);
    }
}
