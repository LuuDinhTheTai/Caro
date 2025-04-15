package com.utc.btl.screen.impl.light_mode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.utc.btl.Assets;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.ProfileScreen;

import static com.utc.btl.Assets.*;
import static com.utc.btl.constant.Constants.*;

public class LightProfileScreen extends ProfileScreen {

    public LightProfileScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        background = new TextureRegion(lightBackgroundTexture);
        table = new Table();

        titleLabel = new Label("Profile", lightTitleStyle);
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

        menuBtn = new TextButton("Menu", lightImageTextButtonStyle);
        loginBtn = new TextButton("Login", lightImageTextButtonStyle);
        logoutBtn = new TextButton("Logout", lightImageTextButtonStyle);
    }

    @Override
    public void setUI() {
        table.setSize(TABLE_W, TABLE_H);

        table.setPosition((Gdx.graphics.getWidth() - table.getWidth()) / 2,
            (Gdx.graphics.getHeight() - table.getHeight()) / 2);

        table.setBackground(new TextureRegionDrawable(new TextureRegion(Assets.tableBackgroundTexture)));

        table.add(titleLabel).padTop(5).row();

        Table subTable = new Table();

        subTable.add(usernameLabel).left();
        subTable.add(username).right();
        subTable.row();
        subTable.add(eloLabel).left();
        subTable.add(elo).right();
        subTable.row();
        subTable.add(winLabel).left();
        subTable.add(win).right();
        subTable.row();
        subTable.add(lossLabel).left();
        subTable.add(loss).right();
        subTable.row();
        subTable.add(drawLabel).left();
        subTable.add(draw).right();
        table.add(subTable).padTop(10).padBottom(10).row();

        table.add(menuBtn).width(BIG_BUTTON_W).height(BIG_BUTTON_H).padTop(10).row();

        if (account != null) {
            table.add(logoutBtn).width(BIG_BUTTON_W).height(BIG_BUTTON_H).padTop(10).row();
        }
        if (account == null) {
            table.add(loginBtn).width(BIG_BUTTON_W).height(BIG_BUTTON_H).padTop(10).row();
        }
        stage.addActor(table);
    }


    @Override
    public void render(float delta) {
        main.batch.begin();
        main.batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        main.batch.end();
        super.render(delta);
    }
}
