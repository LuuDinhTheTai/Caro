package com.utc.btl.screen.impl;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.utc.btl.Main;
import com.utc.btl.dto.request.RegisterRequest;
import com.utc.btl.screen.RegisterScreen;
import com.utc.btl.screen.base.impl.BaseScreen;

public class RegisterScreenImpl extends BaseScreen implements RegisterScreen {

    protected Table table;
    protected Label titleLabel;
    protected Label usernameLabel;
    protected Label passwordLabel;
    protected Label confirmPasswordLabel;
    protected TextField usernameField;
    protected TextField passwordField;
    protected TextField confirmPasswordField;
    protected Button registerBtn;
    protected Button toMenuScreen;


    public RegisterScreenImpl(Main main) {
        super(main);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void init() {
        table = new Table();
        table.setFillParent(true);

        titleLabel = new Label("REGISTER", skin);

        usernameLabel = new Label("Username:", skin);
        usernameField = new TextField("", skin);

        passwordLabel = new Label("Password:", skin);
        passwordField = new TextField("", skin);
        passwordField.setPasswordMode(true);
        passwordField.setPasswordCharacter('*');

        confirmPasswordLabel = new Label("Confirm password:", skin);
        confirmPasswordField = new TextField("", skin);
        confirmPasswordField.setPasswordMode(true);
        confirmPasswordField.setPasswordCharacter('*');

        registerBtn = new TextButton("Register", skin);
        toMenuScreen = new TextButton("Menu", skin);
    }

    @Override
    public void setUI() {
        table.setSize(200, 400);
        table.center();

        table.add(titleLabel).colspan(2).padTop(5).row();
        table.add(usernameLabel).padTop(10).align(Align.left).row();
        table.add(usernameField).width(table.getWidth()).align(Align.left).padTop(0).row();
        table.add(passwordLabel).padTop(10).align(Align.left).row();
        table.add(passwordField).width(table.getWidth()).align(Align.left).padTop(0).row();
        table.add(confirmPasswordLabel).padTop(10).align(Align.left).row();
        table.add(confirmPasswordField).width(table.getWidth()).align(Align.left).padTop(0).row();
        table.add(registerBtn).colspan(2).width(table.getWidth()).padTop(10).row();
        table.add(toMenuScreen).colspan(2).width(table.getWidth()).padTop(10).row();

        stage.addActor(table);
    }

    @Override
    public void setListeners() {
        registerBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                String confirmPassword = confirmPasswordField.getText();
                RegisterRequest rq = new RegisterRequest(username, password, confirmPassword);
                main.authController.register(rq);
            }
        });
        toMenuScreen.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.screenController.toMenuScreen();
            }
        });
    }
}
