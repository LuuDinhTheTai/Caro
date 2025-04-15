package com.utc.btl.screen.impl.light_mode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.RegisterScreen;

import static com.utc.btl.Assets.*;

public class LightRegisterScreen extends RegisterScreen {

    public LightRegisterScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
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
        toMenuScreen = new TextButton("Menu", lightImageTextButtonStyle);
    }

    @Override
    public void setUI() {
        table.setSize(350, 450);

        table.setPosition((Gdx.graphics.getWidth() - table.getWidth()) / 2,
            (Gdx.graphics.getHeight() - table.getHeight()) / 2);

        table.setBackground(new TextureRegionDrawable(new TextureRegion(tableBackgroundTexture)));

        table.add(titleLabel).padTop(5).row();
        table.add(usernameLabel).padTop(10).align(Align.left).row();
        table.add(usernameField).width(280).align(Align.left).padTop(0).row();
        table.add(passwordLabel).padTop(10).align(Align.left).row();
        table.add(passwordField).width(280).align(Align.left).padTop(0).row();
        table.add(confirmPasswordLabel).padTop(10).align(Align.left).row();
        table.add(confirmPasswordField).width(280).align(Align.left).padTop(0).row();
        table.add(registerBtn).width(280).padTop(10).row();
        table.add(toLoginBtn).width(280).padTop(10).row();
        table.add(toMenuScreen).width(280).padTop(10).row();

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
