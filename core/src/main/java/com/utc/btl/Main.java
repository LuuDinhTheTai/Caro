package com.utc.btl;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.utc.btl.controller.AuthController;
import com.utc.btl.controller.ScreenController;
import com.utc.btl.controller.impl.AuthControllerImpl;
import com.utc.btl.controller.impl.ScreenControllerImpl;
import com.utc.btl.screen.GameScreen;
import com.utc.btl.screen.LoginScreen;
import com.utc.btl.screen.MenuScreen;
import com.utc.btl.screen.RegisterScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {

    public SpriteBatch batch;

    public Screen gameScreen;
    public Screen loginScreen;
    public Screen menuScreen;
    public Screen registerScreen;

    public ScreenController screenController;
    public AuthController authController;

    @Override
    public void create() {
        batch = new SpriteBatch();

        gameScreen = new GameScreen(this);
        loginScreen = new LoginScreen(this);
        menuScreen = new MenuScreen(this);
        registerScreen = new RegisterScreen(this);

        screenController = new ScreenControllerImpl(this);
        authController = new AuthControllerImpl(this);

        setScreen(loginScreen);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
