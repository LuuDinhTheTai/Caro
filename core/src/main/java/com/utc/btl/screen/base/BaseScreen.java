package com.utc.btl.screen.base;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.utc.btl.Main;

public class BaseScreen extends ScreenAdapter {

    protected Main main;
    protected Stage stage;

    public BaseScreen(Main main) {
        this.main = main;
        this.stage = new Stage();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        stage.getViewport().update(width, height, true);
    }
}
