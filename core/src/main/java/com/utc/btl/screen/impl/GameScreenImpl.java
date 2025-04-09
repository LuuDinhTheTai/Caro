package com.utc.btl.screen.impl;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.utc.btl.Main;
import com.utc.btl.screen.IGameScreen;
import com.utc.btl.screen.base.impl.BaseScreen;

public class GameScreenImpl extends BaseScreen implements IGameScreen {

    private Table hudTable;

    protected Button pauseBtn;

    public GameScreenImpl(Main main) {
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
        hudTable = new Table();
        pauseBtn = new TextButton("Pause", skin);
    }

    @Override
    public void setUI() {
        hudTable.top().right();
        hudTable.setFillParent(true);

        hudTable.add(pauseBtn).pad(10).row();

        stage.addActor(hudTable);
    }

    @Override
    public void setListeners() {
        pauseBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.screenController.toMenuScreen();
            }
        });
    }
}
