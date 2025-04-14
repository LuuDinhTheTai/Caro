package com.utc.btl.screen.impl.dark_mode;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.utc.btl.Assets;
import com.utc.btl.Main;
import com.utc.btl.screen.IProfileScreen;
import com.utc.btl.screen.impl.light_mode.LightProfileScreen;

public class DarkProfileScreen extends LightProfileScreen implements IProfileScreen {

    public DarkProfileScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        table = new Table();

        titleLabel = new Label("Profile", Assets.darkTitleStyle);
        usernameLabel = new Label("Username: ", Assets.lightInfLabelStyle);
        eloLabel = new Label("Elo: ", Assets.lightInfLabelStyle);
        winLabel = new Label("Win: ", Assets.lightInfLabelStyle);
        lossLabel = new Label("Loss: ", Assets.lightInfLabelStyle);
        drawLabel = new Label("Draw: ", Assets.lightInfLabelStyle);

        username = new Label("", Assets.lightInfLabelStyle);
        elo = new Label("", Assets.lightInfLabelStyle);
        win = new Label("", Assets.lightInfLabelStyle);
        loss = new Label("", Assets.lightInfLabelStyle);
        draw = new Label("", Assets.lightInfLabelStyle);

        menuBtn = new TextButton("Menu", Assets.darkImageTextButtonStyle);
        loginBtn = new TextButton("Login", Assets.darkImageTextButtonStyle);
        logoutBtn = new TextButton("Logout", Assets.darkImageTextButtonStyle);
    }
}
