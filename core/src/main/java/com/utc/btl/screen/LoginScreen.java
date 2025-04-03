package com.utc.btl.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.utc.btl.Main;
import com.utc.btl.screen.base.BaseScreen;

public class LoginScreen extends BaseScreen {

    public LoginScreen(Main main) {
        super(main);
        createLoginForm();
    }

    private void createLoginForm() {
        Skin skin = new Skin(Gdx.files.internal("uiskin.json")); // Cần file skin cho UI

        Table table = new Table();
        table.setFillParent(true);

        Label usernameLabel = new Label("Username:", skin);
        TextField usernameField = new TextField("", skin);

        Label passwordLabel = new Label("Password:", skin);
        TextField passwordField = new TextField("", skin);
        passwordField.setPasswordMode(true);
        passwordField.setPasswordCharacter('*');

        TextButton loginButton = new TextButton("Login", skin);
        loginButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                System.out.println("Logging in with: " + username + " / " + password);
                // Xử lý đăng nhập tại đây
            }
        });

        table.add(usernameLabel).pad(10);
        table.add(usernameField).width(200).pad(10);
        table.row();
        table.add(passwordLabel).pad(10);
        table.add(passwordField).width(200).pad(10);
        table.row();
        table.add(loginButton).colspan(2).pad(10);

        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
    }
}
