package com.utc.btl.screen.impl;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
import com.utc.btl.Assets;
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

    protected Button backBtn;
    protected Button applyBtn;
    protected Button lightBtn;


    public SettingScreen(Main main) {
        super(main);
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

        lightBtn = new TextButton("Light", skin);
        backBtn = new TextButton("Back", skin);
        applyBtn = new TextButton("OK", skin);

        mainContainer.debug();
        bottomTable.debug();
    }

    @Override
    public void setUI() {

        mainContainer.setFillParent(true);
        mainContainer.center();

        titleLabel.setFontScale(2f);

        // Add title and volume slider
        mainContainer.add(titleLabel).pad(20).row();
        mainContainer.add(volumeLabel).left().row();
        mainContainer.add(volumeSlider).left().row();

        // Add music control
        mainContainer.add(musicLabel).padTop(10).left().row();
        mainContainer.add(musicCheckBox).padBottom(10).left().row();

        // Add sound control
        mainContainer.add(soundLabel).padTop(10).left().row();
        mainContainer.add(soundCheckBox).padBottom(10).left().row();

        // Add light button
        mainContainer.add(lightBtn).padTop(10).left().row();

        bottomTable.setFillParent(true);
        bottomTable.bottom().right();
        bottomTable.pad(20);
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
        lightBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.uiMode = main.LIGHT_MODE;
                main.setScreen(main.lightSettingScreen);
            }
        });
    }
}
