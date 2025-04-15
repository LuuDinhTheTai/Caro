package com.utc.btl.screen.impl.light_mode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.RegisterScreen;

import static com.utc.btl.Assets.*;
import static com.utc.btl.constant.Constants.*;
import static com.utc.btl.constant.Constants.BIG_BUTTON_H;

public class LightRegisterScreen extends RegisterScreen {

    public LightRegisterScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        background = new TextureRegion(lightBackgroundTexture);
        table = new Table();

        titleLabel = new Label("REGISTER", lightTitleStyle);

        usernameLabel = new Label("Username:", lightLabelStyle);
        usernameField = new TextField("", skin);

        passwordLabel = new Label("Password:", lightLabelStyle);
        passwordField = new TextField("", skin);
        passwordField.setPasswordMode(true);
        passwordField.setPasswordCharacter('*');

        confirmPasswordLabel = new Label("Confirm password:", lightLabelStyle);
        confirmPasswordField = new TextField("", skin);
        confirmPasswordField.setPasswordMode(true);
        confirmPasswordField.setPasswordCharacter('*');

        registerBtn = new TextButton("Register", lightImageTextButtonStyle);
        toLoginBtn = new TextButton("Login", lightImageTextButtonStyle);
        toMenuBtn = new TextButton("Menu", lightImageTextButtonStyle);
    }

    @Override
    public void setUI() {
        table.setSize(TABLE_W, TABLE_H + 100);

        table.setPosition((Gdx.graphics.getWidth() - table.getWidth()) / 2,
            (Gdx.graphics.getHeight() - table.getHeight()) / 2);

        table.setBackground(new TextureRegionDrawable(new TextureRegion(tableBackgroundTexture)));

        table.add(titleLabel).padTop(5).row();
        table.add(usernameLabel).padLeft(25).padTop(10).left().row();
        table.add(usernameField).width(TEXTFIELD_W).height(TEXTFIELD_H).padTop(5).row();
        table.add(passwordLabel).padLeft(25).padTop(10).left().row();
        table.add(passwordField).width(TEXTFIELD_W).height(TEXTFIELD_H).padTop(5).row();
        table.add(confirmPasswordLabel).padLeft(25).padTop(10).left().row();
        table.add(confirmPasswordField).width(TEXTFIELD_W).height(TEXTFIELD_H).padTop(5).row();
        table.add(registerBtn).width(BIG_BUTTON_W).height(BIG_BUTTON_H).padTop(20).row();

        Table subTable = new Table();
        subTable.add(toMenuBtn).width(BIG_BUTTON_W/2f - 5).height(BIG_BUTTON_H);
        subTable.add().width(10);
        subTable.add(toLoginBtn).width(BIG_BUTTON_W/2f - 5).height(BIG_BUTTON_H);

        table.add(subTable).width(TABLE_W).height(BIG_BUTTON_H).padTop(10).row();

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
