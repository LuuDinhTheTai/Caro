package com.utc.btl.screen.impl;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.utc.btl.Assets;
import com.utc.btl.Main;
import com.utc.btl.screen.IMainMenuScreen;
import com.utc.btl.screen.base.impl.BaseScreen;

public class MainMenuScreenImpl extends BaseScreen implements IMainMenuScreen {

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
        table = new Table();
        playerVsPlayerBtn = new TextButton("Player vs Player", skin);
        playerVsAIBtn = new TextButton("Player vs AI", skin);
    }

    @Override
    public void setUI() {
        table.setFillParent(true);
        table.center();
        table.setBackground(new TextureRegionDrawable(Assets.menuBackgroundTexture));

        Table container = new Table();

        container.add(new Image(Assets.menuLogoTexture)).size(250, 250).padBottom(20).row();

        Table buttonRow = new Table();
        buttonRow.add(playerVsPlayerBtn).width(120).padRight(10);
        buttonRow.add(playerVsAIBtn).width(120).padRight(10);

        container.add(buttonRow);

        table.add(container);

        stage.addActor(table);
    }

    @Override
    public void setListeners() {

    }
}
