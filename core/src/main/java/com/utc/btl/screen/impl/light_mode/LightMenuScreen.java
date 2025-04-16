package com.utc.btl.screen.impl.light_mode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.MenuScreen;

import static com.utc.btl.Assets.*;
import static com.utc.btl.constant.Constants.*;

public class LightMenuScreen extends MenuScreen {

    public LightMenuScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        background = new TextureRegion(lightBackgroundTexture);

        table = new Table();

        titleLabel = new Label("C-Caro", lightTitleStyle);
        playBtn = new ImageTextButton("Play", lightImageTextButtonStyle);
        profileBtn = new ImageTextButton("Profile", lightImageTextButtonStyle);
        settingBtn = new ImageTextButton("Settings", lightImageTextButtonStyle);
        exitBtn = new ImageTextButton("Exit", lightImageTextButtonStyle);
    }

    @Override
    public void setUI() {
        table.setFillParent(true);
        table.center();

        table.add(titleLabel).padTop(5).row();

        table.add(playBtn).width(BIG_BUTTON_W).height(BIG_BUTTON_H).padTop(10).center().row();

        Table subTable = new Table();
        subTable.add(profileBtn).width(SMALL_BUTTON_W).height(SMALL_BUTTON_H);
        subTable.add().width(10);
        subTable.add(settingBtn).width(SMALL_BUTTON_W).height(SMALL_BUTTON_H);

        table.add(subTable).width(BIG_BUTTON_W).height(BIG_BUTTON_H).padTop(10).center().row();

        table.add(exitBtn).width(BIG_BUTTON_W).height(BIG_BUTTON_H).padTop(10).center().row();

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        main.batch.begin();
        main.batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        main.batch.end();
        super.render(delta);
    }
}
