package com.utc.btl.screen.impl.light_mode;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.ResultScreen;

import static com.utc.btl.constant.Assets.*;

public class LightResultScreen extends ResultScreen {

    public LightResultScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        table = new Table();
        titleLabel = new Label("Result", lightTitleStyle);
        messageLabel = new Label("", lightTitleStyle);
        menuBtn = new TextButton("Menu", lightImageTextButtonStyle);
    }

    @Override
    public void setUI() {
        super.setUI();
        table.setBackground(new TextureRegionDrawable(lightBackgroundTexture));
    }
}
