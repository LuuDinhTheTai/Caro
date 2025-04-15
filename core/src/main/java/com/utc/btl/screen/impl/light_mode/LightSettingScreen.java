package com.utc.btl.screen.impl.light_mode;

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
}
