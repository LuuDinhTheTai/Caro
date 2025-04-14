package com.utc.btl.screen.impl.light_mode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.utc.btl.Assets;
import com.utc.btl.Main;
import com.utc.btl.screen.IMenuScreen;
import com.utc.btl.screen.impl.MenuScreen;

import static com.utc.btl.Assets.*;

public class LightMenuScreen extends MenuScreen implements IMenuScreen {

    public LightMenuScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        background = new TextureRegion(lightBackgroundTexture);

        table = new Table();

        titleLabel = new Label("C-Caro", lightTitleStyle);
        singlePlayerBtn = new ImageTextButton("Single Player", lightImageTextButtonStyle);
        multiPlayerBtn = new ImageTextButton("Multi Player", lightImageTextButtonStyle);
        profileBtn = new ImageTextButton("Profile", lightImageTextButtonStyle);
        settingBtn = new ImageTextButton("Settings", lightImageTextButtonStyle);
        exitBtn = new ImageTextButton("Exit", lightImageTextButtonStyle);
    }

    @Override
    public void setUI() {
        table.setFillParent(true);
        table.center();

        table.add(titleLabel).padTop(5).row();

        table.add(singlePlayerBtn).width(300).height(64).padTop(10).center().row();

        table.add(multiPlayerBtn).width(300).height(64).padTop(10).center().row();

        Table subTable = new Table();
        subTable.add(profileBtn).width(145).height(64);
        subTable.add().width(10);
        subTable.add(settingBtn).width(145).height(64);

        table.add(subTable).width(300).height(64).padTop(10).center().row();

        table.add(exitBtn).width(300).height(64).padTop(10).center().row();

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
