package com.utc.btl.screen.impl.dark_mode;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.light_mode.LightResultScreen;

import static com.utc.btl.constant.Assets.*;

public class DarkResultScreen extends LightResultScreen {

    public DarkResultScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        table = new Table();
        titleLabel = new Label("Result", darkTitleStyle);
        messageLabel = new Label("", darkTitleStyle);
        menuBtn = new TextButton("Menu", darkImageTextButtonStyle);
    }

    @Override
    public void setUI() {
        super.setUI();
        table.setBackground(new TextureRegionDrawable(darkBacgroundTexture));
    }
}
