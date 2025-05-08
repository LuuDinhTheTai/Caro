package com.utc.btl.screen.base.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.utc.btl.constant.Assets;
import com.utc.btl.Main;
import com.utc.btl.constant.Constants;
import com.utc.btl.screen.base.IBaseScreen;

public abstract class BaseScreen implements IBaseScreen {

    protected Main main;
    protected Stage stage;
    protected Skin skin;

    protected TextureRegion background;

    public BaseScreen(Main main) {
        this.main = main;
        this.stage = new Stage();
        this.skin = Assets.skin;
        init();
        setUI();
        setListeners();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
//        Constants.resize(width, height);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
