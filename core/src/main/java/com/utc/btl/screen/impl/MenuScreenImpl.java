package com.utc.btl.screen.impl;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.utc.btl.Main;
import com.utc.btl.screen.MenuScreen;
import com.utc.btl.screen.base.impl.BaseScreen;

public class MenuScreenImpl extends BaseScreen implements MenuScreen {

    protected Table table;

    protected Label titleLabel;

    protected Button loginBtn;
    protected Button registerBtn;
    protected Button playerVsPlayerBtn;
    protected Button playerVsAIBtn;


    public MenuScreenImpl(Main main) {
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

        titleLabel = new Label("C-CARO", skin);

        loginBtn = new TextButton("Login", skin);
        registerBtn = new TextButton("Register", skin);
        playerVsPlayerBtn = new TextButton("Player Vs Player", skin);
        playerVsAIBtn = new TextButton("Player Vs AI", skin);
    }

    @Override
    public void setUI() {
        table.setFillParent(true);
        table.setSize(200, 400);
        table.center();

        table.add(titleLabel).padTop(5).row();
        table.add(loginBtn).width(table.getWidth()).padTop(10).row();
        table.add(registerBtn).width(table.getWidth()).padTop(10).row();
        table.add(playerVsPlayerBtn).width(table.getWidth()).padTop(10).row();
        table.add(playerVsAIBtn).width(table.getWidth()).padTop(10).row();

        stage.addActor(table);
    }

    @Override
    public void setListeners() {
        loginBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.screenController.toLoginScreen();
            }
        });
        registerBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.screenController.toRegisterScreen();
            }
        });
        playerVsPlayerBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.screenController.toGameScreen();
            }
        });
        playerVsAIBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.screenController.toGameScreen();
            }
        });
    }
}
