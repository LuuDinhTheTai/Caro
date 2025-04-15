package com.utc.btl.screen.impl.dark_mode;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.light_mode.LightRegisterScreen;

import static com.utc.btl.Assets.*;

public class DarkRegisterScreen extends LightRegisterScreen {

    public DarkRegisterScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        table = new Table();

        titleLabel = new Label("REGISTER", darkTitleStyle);

        usernameLabel = new Label("Username:", darkLabelStyle);
        usernameField = new TextField("", skin);

        passwordLabel = new Label("Password:", darkLabelStyle);
        passwordField = new TextField("", skin);
        passwordField.setPasswordMode(true);
        passwordField.setPasswordCharacter('*');

        confirmPasswordLabel = new Label("Confirm password:", darkLabelStyle);
        confirmPasswordField = new TextField("", skin);
        confirmPasswordField.setPasswordMode(true);
        confirmPasswordField.setPasswordCharacter('*');

        registerBtn = new TextButton("Register", darkImageTextButtonStyle);
        toLoginBtn = new TextButton("Login", darkImageTextButtonStyle);
        toMenuScreen = new TextButton("Menu", darkImageTextButtonStyle);
    }
}
