package com.utc.btl;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.utc.btl.controller.AuthController;
import com.utc.btl.controller.ScreenController;
import com.utc.btl.controller.impl.AuthControllerImpl;
import com.utc.btl.controller.impl.ScreenControllerImpl;
import com.utc.btl.screen.*;
import com.utc.btl.screen.impl.*;

import static com.utc.btl.constant.Constants.INFO;

public class Main extends Game {

    public SpriteBatch batch;

    public GameScreen gameScreen;
    public LoginScreen loginScreen;
    public MainMenuScreen mainMenuScreen;
    public MenuScreen menuScreen;
    public RegisterScreen registerScreen;

    public ScreenController screenController;
    public AuthController authController;

    @Override
    public void create() {
        Gdx.app.log(INFO, "Game creating...");
        batch = new SpriteBatch();

        gameScreen = new GameScreenImpl(this);
        loginScreen = new LoginScreenImpl(this);
        mainMenuScreen = new MainMenuScreenImpl(this);
        menuScreen = new MenuScreenImpl(this);
        registerScreen = new RegisterScreenImpl(this);

        screenController = new ScreenControllerImpl(this);
        authController = new AuthControllerImpl(this);

        screenController.toMenuScreen();
    }

    @Override
    public void render() {
        GL20 gl = Gdx.gl;
        gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f); // Màu tối để dễ nhìn
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
    }

    @Override
    public void dispose() {
        Gdx.app.log(INFO, "Game disposing...");
        batch.dispose();

        gameScreen.dispose();
        loginScreen.dispose();
        mainMenuScreen.dispose();
        menuScreen.dispose();
        registerScreen.dispose();
    }
}
