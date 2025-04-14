package com.utc.btl.screen.impl.light_mode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.utc.btl.Assets;
import com.utc.btl.Main;
import com.utc.btl.screen.IProfileScreen;
import com.utc.btl.screen.impl.ProfileScreen;

public class LightProfileScreen extends ProfileScreen implements IProfileScreen {

    public LightProfileScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        table = new Table();

        titleLabel = new Label("Profile", Assets.lightTitleStyle);
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

        menuBtn = new TextButton("Menu", Assets.lightImageTextButtonStyle);
        loginBtn = new TextButton("Login", Assets.lightImageTextButtonStyle);
        logoutBtn = new TextButton("Logout", Assets.lightImageTextButtonStyle);
    }

    @Override
    public void setUI() {
        table.setSize(400, 500);
        table.setPosition((Gdx.graphics.getWidth() - table.getWidth()) / 2,
            (Gdx.graphics.getHeight() - table.getHeight()) / 2);

        table.setBackground(new TextureRegionDrawable(new TextureRegion(Assets.tableBackgroundTexture)));

        table.top().pad(20);
        table.add(titleLabel).colspan(2).padBottom(20);
        table.row();

        table.add(usernameLabel).left().padBottom(10);
        table.add(username).left().padBottom(10);
        table.row();

        table.add(eloLabel).left().padBottom(10);
        table.add(elo).left().padBottom(10);
        table.row();

        table.add(winLabel).left().padBottom(10);
        table.add(win).left().padBottom(10);
        table.row();

        table.add(lossLabel).left().padBottom(10);
        table.add(loss).left().padBottom(10);
        table.row();

        table.add(drawLabel).left().padBottom(10);
        table.add(draw).left().padBottom(10);
        table.row();

        table.add(menuBtn).width(200).padTop(10).center().row();
        if (account != null) {
            table.add(logoutBtn).width(200).padTop(10).center().row();
        }
        if (account == null) {
            table.add(loginBtn).width(200).padTop(10).center().row();
        }
        stage.addActor(table);
    }


    @Override
    public void render(float delta) {
        main.batch.begin();
        main.batch.draw(Assets.lightBackgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        main.batch.end();
        super.render(delta);
    }
}
