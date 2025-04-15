package com.utc.btl.screen.impl.dark_mode;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.light_mode.LightProfileScreen;

import static com.utc.btl.Assets.*;

public class DarkProfileScreen extends LightProfileScreen {

    public DarkProfileScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        background = new TextureRegion(darkBacgroundTexture);
        table = new Table();

        titleLabel = new Label("Profile", darkTitleStyle);
        usernameLabel = new Label("Username: ", lightInfLabelStyle);
        eloLabel = new Label("Elo: ", lightInfLabelStyle);
        winLabel = new Label("Win: ", lightInfLabelStyle);
        lossLabel = new Label("Loss: ", lightInfLabelStyle);
        drawLabel = new Label("Draw: ", lightInfLabelStyle);

        username = new Label("", lightInfLabelStyle);
        elo = new Label("", lightInfLabelStyle);
        win = new Label("", lightInfLabelStyle);
        loss = new Label("", lightInfLabelStyle);
        draw = new Label("", lightInfLabelStyle);

        menuBtn = new TextButton("Menu", darkImageTextButtonStyle);
        loginBtn = new TextButton("Login", darkImageTextButtonStyle);
        logoutBtn = new TextButton("Logout", darkImageTextButtonStyle);
    }
}
