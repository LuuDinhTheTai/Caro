package com.utc.btl.screen.impl.light_mode;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.GameScreen;

import static com.utc.btl.constant.Assets.lightImageTextButtonStyle;

public class LightGameScreen extends GameScreen {

    public LightGameScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        hudTable = new Table();
        boardTable = new Table();
        pauseBtn = new TextButton("Exit", lightImageTextButtonStyle);
    }
}
