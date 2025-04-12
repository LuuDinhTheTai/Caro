package com.utc.btl.screen.impl;

import java.security.PublicKey;

import org.w3c.dom.Text;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.utc.btl.Assets;
import com.utc.btl.Main;
import com.utc.btl.screen.ISettingScreen;
import com.utc.btl.screen.base.impl.BaseScreen;
import com.utc.btl.screen.impl.light_mode.LightSettingScreen;

public class SettingScreen extends BaseScreen implements ISettingScreen{
    protected Table mainContainer;
    protected SpriteBatch batch;

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
        batch = new SpriteBatch();

        mainContainer = new Table();

        titleLabel = new Label("Setting", Assets.skin);

        volumeLabel = new Label("Volume", Assets.skin);
        volumeSlider = new Slider(0, 100, 1, false, Assets.skin);

        musicLabel = new Label("Music", Assets.skin);
        musicCheckBox = new CheckBox("Music", Assets.skin);

        soundLabel = new Label("Sound", Assets.skin);
        soundCheckBox = new CheckBox("Sound", Assets.skin);

        lightBtn = new TextButton("Light", Assets.skin);
        backBtn = new TextButton("Back", Assets.skin);
        applyBtn = new TextButton("OK", Assets.skin);
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
        
        Table bottomTable = new Table();
        bottomTable.setFillParent(true);
        bottomTable.bottom().right();
        bottomTable.pad(20);
        bottomTable.add(backBtn).padRight(10);
        bottomTable.add(applyBtn);

        stage.addActor(bottomTable);
        stage.addActor(mainContainer);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl20.glClearColor(0, 0 ,0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        stage.draw();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void setListeners() {
        volumeSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                float value = volumeSlider.getValue();
                System.out.println("Volume changed to: " + value);
                // TODO: Add volume adjustment logic here
            }
        });
        
        musicCheckBox.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println(musicCheckBox.isChecked());
            }
        });
        soundCheckBox.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println(soundCheckBox.isChecked());
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

    @Override
    public void show() {
        super.show();
    }
    
}
