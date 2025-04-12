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

public class MenuScreen extends BaseScreen implements IMenuScreen {

    protected Table table;

    protected Label titleLabel;

    protected Button singlePlayerBtn;
    protected Button multiPlayerBtn;
    protected Button profileBtn;
    protected Button settingBtn;
    protected Button exitBtn;

    public MenuScreen(Main main) {
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
        singlePlayerBtn = new TextButton("Single Player", skin);
        multiPlayerBtn = new TextButton("Multi Player", skin);
        profileBtn = new TextButton("Profile", skin);
        settingBtn = new TextButton("Setting", skin);
        exitBtn = new TextButton("Exit", skin);
    }

    @Override
    public void setUI() {
        table.setFillParent(true);
        table.setSize(400, 600);
        table.center();

        table.add(titleLabel).padTop(5).row();
        table.add(singlePlayerBtn).width(table.getWidth()).padTop(10).row();
        table.add(multiPlayerBtn).width(table.getWidth()).padTop(10).row();
        table.add(profileBtn).width(table.getWidth()).padTop(10).row();
        table.add(settingBtn).width(table.getWidth()).padTop(10).row();
        table.add(exitBtn).width(table.getWidth()).padTop(10).row();

        stage.addActor(table);
    }

    @Override
    public void setListeners() {
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
        profileBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.screenController.toProfileScreen();
            }
        });
        settingBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.screenController.toSettingScreen();
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
