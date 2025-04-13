package com.utc.btl.screen.impl.light_mode;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.utc.btl.Main;
import com.utc.btl.screen.ILoginScreen;
import com.utc.btl.screen.impl.LoginScreen;

import static com.utc.btl.Assets.lightDownButtonTexture;
import static com.utc.btl.Assets.lightUpButtonTexture;

public class LightLoginScreen extends LoginScreen implements ILoginScreen {

    private Label.LabelStyle labelStyle;
    private ImageTextButton.ImageTextButtonStyle imageTextButtonStyle;
    private TextField.TextFieldStyle textFieldStyle;

    public LightLoginScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        setLabelStyle();
        setImageTextButtonStyle();
        setTextFieldStyle();

        table = new Table();

        titleLabel = new Label("LOGIN", skin);
        titleLabel.setFontScale(1.5f);

        usernameLabel = new Label("Username:", labelStyle);
        usernameField = new TextField("", textFieldStyle);

        passwordLabel = new Label("Password:", labelStyle);
        passwordField = new TextField("", textFieldStyle);
        passwordField.setPasswordMode(true);
        passwordField.setPasswordCharacter('*');

        loginBtn = new TextButton("Login", imageTextButtonStyle);
        toRegisterBtn = new TextButton("Register", imageTextButtonStyle);
        toMenuBtn = new TextButton("Menu", imageTextButtonStyle);
    }

    private void setLabelStyle() {
        labelStyle = new Label.LabelStyle();
        labelStyle = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
    }

    private void setImageTextButtonStyle() {
        imageTextButtonStyle = new ImageTextButton.ImageTextButtonStyle();
        imageTextButtonStyle.up = new TextureRegionDrawable(lightUpButtonTexture);
        imageTextButtonStyle.down = new TextureRegionDrawable(lightDownButtonTexture);
        imageTextButtonStyle.font = new BitmapFont();
        imageTextButtonStyle.fontColor = Color.WHITE;
    }

    private void setTextFieldStyle() {
        textFieldStyle = new TextField.TextFieldStyle();
        textFieldStyle.font = new BitmapFont();
        textFieldStyle.fontColor = Color.BLACK;
        textFieldStyle.background = new TextureRegionDrawable(lightUpButtonTexture);
    }
}
