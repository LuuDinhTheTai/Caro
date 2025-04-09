package com.utc.btl.screen.impl;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.utc.btl.Main;
import com.utc.btl.dto.request.LoginRequest;
import com.utc.btl.screen.ILoginScreen;
import com.utc.btl.screen.base.impl.BaseScreen;

public class LoginScreenImpl extends BaseScreen implements ILoginScreen {

    protected Table table;
    protected Label titleLabel;
    protected Label usernameLabel;
    protected Label passwordLabel;
    protected TextField usernameField;
    protected TextField passwordField;
    protected Button loginBtn;
    protected Button toMenuBtn;

    public LoginScreenImpl(Main main) {
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

        titleLabel = new Label("LOGIN", skin);

        usernameLabel = new Label("Username:", skin);
        usernameField = new TextField("", skin);

        passwordLabel = new Label("Password:", skin);
        passwordField = new TextField("", skin);
        passwordField.setPasswordMode(true);
        passwordField.setPasswordCharacter('*');

        loginBtn = new TextButton("Login", skin);
        toMenuBtn = new TextButton("Menu", skin);
    }

    @Override
    public void setUI() {
        table.setFillParent(true);
        table.setSize(200, 400);
        table.center();

        table.add(titleLabel).colspan(2).padTop(5).row();
        table.add(usernameLabel).padTop(10).align(Align.left).row();
        table.add(usernameField).width(table.getWidth()).align(Align.left).padTop(0).row();
        table.add(passwordLabel).padTop(10).align(Align.left).row();
        table.add(passwordField).width(table.getWidth()).align(Align.left).padTop(0).row();
        table.add(loginBtn).colspan(2).width(table.getWidth()).padTop(10).row();
        table.add(toMenuBtn).colspan(2).width(table.getWidth()).padTop(10).row();

        stage.addActor(table);
    }

    @Override
    public void setListeners() {
        loginBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                LoginRequest rq = new LoginRequest(username, password);
                main.authController.login(rq);
            }
        });
        toMenuBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.screenController.toMenuScreen();
            }
        });
    }
}
