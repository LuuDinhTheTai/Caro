package com.utc.btl.screen.impl;

import com.badlogic.gdx.maps.tiled.renderers.IsometricStaggeredTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.utc.btl.Main;
import com.utc.btl.screen.MainMenuScreen;
import com.utc.btl.screen.base.impl.BaseScreen;

import javax.management.StandardMBean;

public class MainMenuScreenImpl extends BaseScreen implements MainMenuScreen {

    protected Table table;

    protected Button playerVsPlayerBtn;
    protected Button playerVsAIBtn;

    public MainMenuScreenImpl(Main main) {
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
        playerVsPlayerBtn = new TextButton("Player vs Player", skin);
        playerVsAIBtn = new TextButton("Player vs AI", skin);
    }

    @Override
    public void setUI() {

    }

    @Override
    public void setListeners() {

    }
}
