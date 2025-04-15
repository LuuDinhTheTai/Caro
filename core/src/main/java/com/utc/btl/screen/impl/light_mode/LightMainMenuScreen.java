package com.utc.btl.screen.impl.light_mode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.MainMenuScreen;

import static com.utc.btl.Assets.*;

public class LightMainMenuScreen extends MainMenuScreen {

    public LightMainMenuScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        background = new TextureRegion(lightBackgroundTexture);
        table = new Table();

        titleLabel = new Label("C-Caro", lightTitleStyle);

        multiPlayerBtn = new TextButton("Multi Player", lightImageTextButtonStyle);
        singlePlayerBtn = new TextButton("SinglePlayer", lightImageTextButtonStyle);
        profileBtn = new TextButton("Profile", lightImageTextButtonStyle);
        settingBtn = new TextButton("Setting", lightImageTextButtonStyle);
        exitBtn = new TextButton("Exit", lightImageTextButtonStyle);
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
