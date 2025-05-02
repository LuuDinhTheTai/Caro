package com.utc.btl.screen.impl.dark_mode;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.light_mode.LightProfileScreen;

import static com.utc.btl.constant.Assets.*;

public class DarkProfileScreen extends LightProfileScreen {

    public DarkProfileScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        background = new TextureRegion(darkBacgroundTexture);
        table = new Table();

        titleLabel = new Label("Profile", darkTitleStyle);
        xLabel = new Label("X Win: ", darkLabelStyle);
        oLabel = new Label("O Win: ", darkLabelStyle);
        drawLabel = new Label("Draw: ", darkLabelStyle);

        xInf = new Label("", lightInfLabelStyle);
        oInf = new Label("", lightInfLabelStyle);
        drawInf = new Label("", lightInfLabelStyle);

        menuBtn = new TextButton("Menu", darkImageTextButtonStyle);
    }
}
