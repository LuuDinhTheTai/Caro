package com.utc.btl.screen.impl.light_mode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.LoginScreen;

import static com.utc.btl.Assets.*;
import static com.utc.btl.constant.Constants.*;

public class LightLoginScreen extends LoginScreen {

    public LightLoginScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        table = new Table();

        titleLabel = new Label("LOGIN", lightTitleStyle);

        usernameLabel = new Label("Username:", lightLabelStyle);
        usernameField = new TextField("", skin);

        passwordLabel = new Label("Password:", lightLabelStyle);
        passwordField = new TextField("", skin);
        passwordField.setPasswordMode(true);
        passwordField.setPasswordCharacter('*');

        loginBtn = new TextButton("Login", lightImageTextButtonStyle);
        toRegisterBtn = new TextButton("Register", lightImageTextButtonStyle);
        toMenuBtn = new TextButton("Menu", lightImageTextButtonStyle);
    }

    @Override
    public void setUI() {
        table.setSize(TABLE_W, TABLE_H);

        table.setPosition((Gdx.graphics.getWidth() - table.getWidth()) / 2,
            (Gdx.graphics.getHeight() - table.getHeight()) / 2);

        table.setBackground(new TextureRegionDrawable(new TextureRegion(tableBackgroundTexture)));

        table.add(titleLabel).padTop(5).row();
        table.add(usernameLabel).padTop(10).left().row();
        table.add(usernameField).width(280).padTop(5).row();
        table.add(passwordLabel).padTop(10).left().row();
        table.add(passwordField).width(280).padTop(5).row();
        table.add(loginBtn).width(BIG_BUTTON_W).height(BIG_BUTTON_H).padTop(10).row();
        table.add(toRegisterBtn).width(BIG_BUTTON_W).height(BIG_BUTTON_H).padTop(10).row();
        table.add(toMenuBtn).width(BIG_BUTTON_W).height(BIG_BUTTON_H).padTop(10).row();

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        main.batch.begin();
        main.batch.draw(lightBackgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        main.batch.end();
        super.render(delta);
    }
}
