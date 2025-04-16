package com.utc.btl.screen.impl;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.utc.btl.Main;
import com.utc.btl.screen.ISettingScreen;
import com.utc.btl.screen.base.impl.BaseScreen;

public class SettingScreen extends BaseScreen implements ISettingScreen{

    protected Table mainContainer;
    protected Table bottomTable;

    protected Label titleLabel;

    protected Label volumeLabel;
    protected Slider volumeSlider;

    protected Label musicLabel;
    protected CheckBox musicCheckBox;

    protected Label soundLabel;
    protected CheckBox soundCheckBox;

    protected Label themeLabel;
    protected Button defaultThemeBtn;
    protected Button lightThemButton;
    protected Button darkThemeBtn;

    protected Button backBtn;
    protected Button applyBtn;


    public SettingScreen(Main main) {
        super(main);
    }

    @Override
    public void show() {
        super.show();
        if (main.uiMode == main.DEFAULT_UI) {
            defaultThemeBtn.setDisabled(true);
            lightThemButton.setDisabled(false);
            darkThemeBtn.setDisabled(false);
        } else if (main.uiMode == main.LIGHT_MODE) {
            defaultThemeBtn.setDisabled(false);
            lightThemButton.setDisabled(true);
            darkThemeBtn.setDisabled(false);
        } else if (main.uiMode == main.DARK_MODE) {
            defaultThemeBtn.setDisabled(false);
            lightThemButton.setDisabled(false);
            darkThemeBtn.setDisabled(true);
        }
        clearScreen();
        setUI();
    }

    @Override
    public void init() {
        mainContainer = new Table();
        bottomTable = new Table();

        titleLabel = new Label("Setting", skin);

        volumeLabel = new Label("Volume", skin);
        volumeSlider = new Slider(0, 100, 1, false, skin);

        musicLabel = new Label("Music", skin);
        musicCheckBox = new CheckBox("Music", skin);

        soundLabel = new Label("Sound", skin);
        soundCheckBox = new CheckBox("Sound", skin);

        themeLabel = new Label("Theme: ", skin);
        defaultThemeBtn = new TextButton("Default", skin);
        lightThemButton = new TextButton("Light", skin);
        darkThemeBtn = new TextButton("Dark", skin);

        backBtn = new TextButton("Back", skin);
        applyBtn = new TextButton("OK", skin);
    }

    @Override
    public void setUI() {
        // Thiết lập mainContainer là bảng chính
        mainContainer.setFillParent(true);
        mainContainer.center().pad(20);

        // Tiêu đề, căn giữa và để lề đều
        titleLabel.setFontScale(2f);
        mainContainer.add(titleLabel).colspan(4).center().padBottom(20);
        mainContainer.row();

        // Dòng chỉnh âm lượng với nhãn và Slider
        mainContainer.add(volumeLabel).left().padRight(10);
        mainContainer.add(volumeSlider).colspan(3).expandX().fillX();
        mainContainer.row().padBottom(15);

        // Dòng chế độ âm nhạc: nhãn và checkbox
        mainContainer.add(musicLabel).left().padRight(10);
        mainContainer.add(musicCheckBox).colspan(3).left();
        mainContainer.row().padBottom(15);

        // Dòng chế độ âm thanh: nhãn và checkbox
        mainContainer.add(soundLabel).left().padRight(10);
        mainContainer.add(soundCheckBox).colspan(3).left();
        mainContainer.row().padBottom(15);

        // Dòng chọn theme: nhãn và 3 button
        mainContainer.add(themeLabel).left().padRight(10);
        mainContainer.add(defaultThemeBtn).padRight(10);
        mainContainer.add(lightThemButton).padRight(10);
        mainContainer.add(darkThemeBtn).left();
        mainContainer.row();

        // Bảng bottom đặt các nút điều hướng: Back và OK
        bottomTable.setFillParent(true);
        bottomTable.bottom().right().pad(20);
        bottomTable.add(backBtn).padRight(10);
        bottomTable.add(applyBtn);

        stage.addActor(mainContainer);
        stage.addActor(bottomTable);
    }

    @Override
    public void setListeners() {
        volumeSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                float value = volumeSlider.getValue();
                // TODO: Add volume adjustment logic here
            }
        });

        musicCheckBox.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
//                System.out.println(musicCheckBox.isChecked());
            }
        });
        soundCheckBox.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
//                System.out.println(soundCheckBox.isChecked());
            }
        });
        backBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.screenController.toMenuScreen();
            }
        });
        defaultThemeBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.gameModeController.toDefaultMode();
                main.screenController.toSettingScreen();
            }
        });
        lightThemButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.gameModeController.toLightMode();
                main.screenController.toSettingScreen();
            }
        });
        darkThemeBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.gameModeController.toDarkMode();
                main.screenController.toSettingScreen();
            }
        });
    }

    protected void clearScreen() {
        stage.clear();
        mainContainer.clear();
        bottomTable.clear();
    }
}
