package com.utc.btl.screen.impl.light_mode;

import com.utc.btl.Main;
import com.utc.btl.screen.impl.SettingScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class LightSettingScreen extends SettingScreen{
    public LightSettingScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void setUI() {
        super.setUI();
        
        // Set text colors to black
        titleLabel.setColor(Color.BLACK);
        volumeLabel.setColor(Color.BLACK);
        musicLabel.setColor(Color.BLACK);
        musicCheckBox.setColor(Color.BLACK);
        soundLabel.setColor(Color.BLACK);
        soundCheckBox.setColor(Color.BLACK);
        
        // Set button colors
        backBtn.setColor(Color.BLACK);
        applyBtn.setColor(Color.BLACK);
        lightBtn.setColor(Color.BLACK);
                
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl20.glClearColor(1,1,1, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        stage.draw();
        batch.end();
    }
    @Override
    public void setListeners(){
        super.setListeners();
        lightBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.uiMode = main.DARK_MODE;
                main.setScreen(main.settingScreen);
            }
        });
    }
}