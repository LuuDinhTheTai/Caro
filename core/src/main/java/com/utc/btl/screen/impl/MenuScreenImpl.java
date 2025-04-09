package com.utc.btl.screen.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.utc.btl.Assets;
import com.utc.btl.Main;
import com.utc.btl.screen.MenuScreen;
import com.utc.btl.screen.base.impl.BaseScreen;

public class MenuScreenImpl extends BaseScreen implements MenuScreen {

    protected Table table;

    protected Label titleLabel;
    
    protected Button singlePlayButton;
    protected Button multiPlayButton;
    protected Button settingsButton;
    protected Button exitButton;

    public MenuScreenImpl(Main main) {
        super(main);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void hide() {
        super.hide();
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
    public void dispose() {
        super.dispose();
    }

    @Override
    public void init() {
        table = new Table();

        singlePlayButton = new TextButton("Single Player", skin);
        multiPlayButton = new TextButton("Multi Player", skin);
        settingsButton = new TextButton("Settings", skin);
        exitButton = new TextButton("Exit", skin);  

        singlePlayButton.getStyle().up = new TextureRegionDrawable(Assets.buttonBackgroundTexture);
        multiPlayButton.getStyle().up = new TextureRegionDrawable(Assets.buttonBackgroundTexture);
        settingsButton.getStyle().up = new TextureRegionDrawable(Assets.buttonBackgroundTexture);
        exitButton.getStyle().up = new TextureRegionDrawable(Assets.buttonBackgroundTexture);
        
    }

    @Override
    public void setUI() {
        table.setFillParent(true);
        table.center();

        table.setBackground(new TextureRegionDrawable(Assets.menuBackgroundTexture));

        // Create a vertical container for logo and buttons
        Table container = new Table();
        
        // Add logo at the top
        container.add(new Image(Assets.menuLogoTexture)).size(250, 250).padBottom(20).row();
        
        // Create horizontal button layout
        Table buttonRow = new Table();
        buttonRow.add(singlePlayButton).width(120).padRight(10);
        buttonRow.add(multiPlayButton).width(120).padRight(10);
        buttonRow.add(exitButton).width(120);
        
        container.add(buttonRow);

        table.add(container);

        stage.addActor(table);
    }

    @Override
    public void setListeners() {
        singlePlayButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.screenController.toGameScreen();
            }
        });
        multiPlayButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.screenController.toGameScreen();
            }
        });
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });
        
        
    }
}
