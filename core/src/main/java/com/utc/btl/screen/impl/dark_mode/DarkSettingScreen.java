package com.utc.btl.screen.impl.dark_mode;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.light_mode.LightSettingScreen;

import static com.utc.btl.Assets.*;

public class DarkSettingScreen extends LightSettingScreen {

    public DarkSettingScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        background = new TextureRegion(darkBacgroundTexture);
        mainContainer = new Table();
        bottomTable = new Table();

        titleLabel = new Label("Setting", darkTitleStyle);

        volumeLabel = new Label("Volume", darkSettingLabelStyle);
        volumeSlider = new Slider(0, 100, 1, false, skin);

        musicLabel = new Label("Music", darkSettingLabelStyle);
        musicCheckBox = new CheckBox("Music", skin);

        soundLabel = new Label("Sound", darkSettingLabelStyle);
        soundCheckBox = new CheckBox("Sound", skin);

        themeLabel = new Label("Theme: ", darkSettingLabelStyle);
        defaultThemeBtn = new TextButton("Default", darkImageTextButtonStyle);
        lightThemButton = new TextButton("Light", darkImageTextButtonStyle);
        darkThemeBtn = new TextButton("Dark", darkImageTextButtonStyle);

        backBtn = new TextButton("Back", darkImageTextButtonStyle);
        applyBtn = new TextButton("OK", darkImageTextButtonStyle);
    }
}
