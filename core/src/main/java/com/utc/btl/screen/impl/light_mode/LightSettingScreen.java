package com.utc.btl.screen.impl.light_mode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.SettingScreen;

import static com.utc.btl.Assets.*;

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

        volumeLabel = new Label("Volume", skin);
        volumeSlider = new Slider(0, 100, 1, false, skin);

        musicLabel = new Label("Music", lightLabelStyle);
        musicCheckBox = new CheckBox("Music", skin);

        soundLabel = new Label("Sound", lightLabelStyle);
        soundCheckBox = new CheckBox("Sound", skin);

        themeLabel = new Label("Theme: ", lightLabelStyle);
        defaultThemeBtn = new TextButton("Default", lightImageTextButtonStyle);
        lightThemButton = new TextButton("Light", lightImageTextButtonStyle);
        darkThemeBtn = new TextButton("Dark", lightImageTextButtonStyle);

        backBtn = new TextButton("Back", lightImageTextButtonStyle);
        applyBtn = new TextButton("OK", lightImageTextButtonStyle);
    }

    @Override
    public void render(float delta) {
        main.batch.begin();
        main.batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        main.batch.end();
        super.render(delta);
    }
}
