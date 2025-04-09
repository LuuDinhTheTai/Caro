package com.utc.btl.screen.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.utc.btl.Main;
import com.utc.btl.screen.IMenuScreen;
import com.utc.btl.screen.base.impl.BaseScreen;

public class MenuScreenImpl extends BaseScreen implements IMenuScreen {

    protected Table table;

    protected Label titleLabel;

    protected Button loginBtn;
    protected Button registerBtn;
    protected Button singlePlayerBtn;
    protected Button multiPlayerBtn;
    protected Button exitBtn;

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

        titleLabel = new Label("C-Caro", skin);
        loginBtn = new TextButton("Login", skin);
        registerBtn = new TextButton("Register", skin);
        singlePlayerBtn = new TextButton("Single Player", skin);
        multiPlayerBtn = new TextButton("Multi Player", skin);
        exitBtn = new TextButton("Exit", skin);
    }

    @Override
    public void setUI() {
        table.setFillParent(true);
        table.setSize(400, 600);
        table.center();

        table.add(titleLabel).padTop(5).row();
        table.add(loginBtn).width(table.getWidth()).padTop(10).row();
        table.add(registerBtn).width(table.getWidth()).padTop(10).row();
        table.add(singlePlayerBtn).width(table.getWidth()).padTop(10).row();
        table.add(multiPlayerBtn).width(table.getWidth()).padTop(10).row();
        table.add(exitBtn).width(table.getWidth()).padTop(10).row();

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
        singlePlayerBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.screenController.toGameScreen();
            }
        });
        multiPlayerBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.screenController.toGameScreen();
            }
        });
        exitBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
    }
}
