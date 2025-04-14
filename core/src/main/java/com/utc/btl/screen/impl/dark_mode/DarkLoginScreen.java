package com.utc.btl.screen.impl.dark_mode;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.utc.btl.Main;
import com.utc.btl.screen.ILoginScreen;
import com.utc.btl.screen.impl.light_mode.LightLoginScreen;

import static com.utc.btl.Assets.*;

public class DarkLoginScreen extends LightLoginScreen implements ILoginScreen {

    public DarkLoginScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        table = new Table();

        titleLabel = new Label("LOGIN", darkTitleStyle);

        usernameLabel = new Label("Username:", darkLabelStyle);
        usernameField = new TextField("", darkTextfieldStyle);

        passwordLabel = new Label("Password:", darkLabelStyle);
        passwordField = new TextField("", darkTextfieldStyle);
        passwordField.setPasswordMode(true);
        passwordField.setPasswordCharacter('*');

        loginBtn = new TextButton("Login", darkImageTextButtonStyle);
        toRegisterBtn = new TextButton("Register", darkImageTextButtonStyle);
        toMenuBtn = new TextButton("Menu", darkImageTextButtonStyle);
    }
}
