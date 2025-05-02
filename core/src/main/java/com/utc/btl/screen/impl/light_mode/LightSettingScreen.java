package com.utc.btl.screen.impl.light_mode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.SettingScreen;

import static com.utc.btl.constant.Assets.*;
import static com.utc.btl.constant.Constants.*;

public class LightSettingScreen extends SettingScreen {

    public LightSettingScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        background = new TextureRegion(lightBackgroundTexture);
        mainContainer = new Table();
        bottomTable = new Table();

        titleLabel = new Label("Setting", lightTitleStyle);

        volumeLabel = new Label("Volume", lightSettingLabelStyle);
        volumeSlider = new Slider(0, 100, 1, false, skin);

        musicLabel = new Label("Music", lightSettingLabelStyle);
        musicCheckBox = new CheckBox("", skin);

        soundLabel = new Label("Sound", lightSettingLabelStyle);
        soundCheckBox = new CheckBox("", skin);

        themeLabel = new Label("Theme: ", lightSettingLabelStyle);
        defaultThemeBtn = new TextButton("Default", lightImageTextButtonStyle);
        lightThemButton = new TextButton("Light", lightImageTextButtonStyle);
        darkThemeBtn = new TextButton("Dark", lightImageTextButtonStyle);

        backBtn = new TextButton("Back", lightImageTextButtonStyle);
        applyBtn = new TextButton("OK", lightImageTextButtonStyle);
    }

    @Override
    public void setUI() {
        mainContainer.setFillParent(true);
        mainContainer.center();

        mainContainer.add(titleLabel).padBottom(20);
        mainContainer.row();

//        mainContainer.add(volumeLabel);
//        mainContainer.add().width(10);
//        mainContainer.add(volumeSlider);
//        mainContainer.row();
//
//        mainContainer.add(musicLabel);
//        mainContainer.add().width(10);
//        mainContainer.add(musicCheckBox);
//        mainContainer.row();
//
//        mainContainer.add(soundLabel);
//        mainContainer.add().width(10);
//        mainContainer.add(soundCheckBox);
//        mainContainer.row();

        mainContainer.add(themeLabel);
        mainContainer.row();
        mainContainer.add(defaultThemeBtn).width(SMALL_BUTTON_W).height(SMALL_BUTTON_H);
        mainContainer.add().width(5);
        mainContainer.add(lightThemButton).width(SMALL_BUTTON_W).height(SMALL_BUTTON_H);
        mainContainer.add().width(5);
        mainContainer.add(darkThemeBtn).width(SMALL_BUTTON_W).height(SMALL_BUTTON_H);
        mainContainer.row();

        bottomTable.setFillParent(true);
        bottomTable.bottom().right().pad(20);
        bottomTable.add(backBtn).width(SMALL_BUTTON_W).height(SMALL_BUTTON_H).padRight(10);
        bottomTable.add(applyBtn).width(SMALL_BUTTON_W).height(SMALL_BUTTON_H);

        stage.addActor(mainContainer);
        stage.addActor(bottomTable);
    }

    @Override
    public void render(float delta) {
        main.batch.begin();
        main.batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        main.batch.end();
        super.render(delta);
    }
}
