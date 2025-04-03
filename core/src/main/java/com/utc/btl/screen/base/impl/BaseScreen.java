package com.utc.btl.screen.base.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.utc.btl.Main;
import com.utc.btl.screen.base.IBaseScreen;

public abstract class BaseScreen implements IBaseScreen {

    protected Main main;
    protected Stage stage;
    protected Skin skin;

    protected Label.LabelStyle labelStyle;
    protected TextField.TextFieldStyle textFieldStyle;
    protected Button.ButtonStyle buttonStyle;
    protected TextButton.TextButtonStyle textButtonStyle;
    protected ImageTextButton.ImageTextButtonStyle imageTextButtonStyle;

    public BaseScreen(Main main) {
        this.main = main;
        this.stage = new Stage();
        this.skin = new Skin(Gdx.files.internal("uiskin.json"));
    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        init();
        setUI();
        setListeners();
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }

    @Override
    public void init() {

    }

    @Override
    public void setUI() {

    }

    @Override
    public void setListeners() {

    }
}
