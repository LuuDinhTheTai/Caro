package com.utc.btl.screen.impl.dark_mode;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.light_mode.LightGameScreen;

import static com.utc.btl.constant.Assets.darkImageTextButtonStyle;

public class DarkGameScreen extends LightGameScreen {

    public DarkGameScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        hudTable = new Table();
        boardTable = new Table();
        pauseBtn = new TextButton("Exit", darkImageTextButtonStyle);
    }
}
