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
import com.utc.btl.screen.impl.light_mode.LightMenuScreen;
import com.utc.btl.service.IAccountService;
import com.utc.btl.service.impl.AccountService;

import static com.utc.btl.constant.Constants.INFO;

public class Main extends Game {

    // UI MODE
    public final int DEFAULT_UI = 0;
    public final int LIGHT_MODE = 1;
    public final int DARK_MODE = 2;
    public int uiMode;

    // SERVICE
    public IAccountService accountService;

    public SpriteBatch batch;

    // SCREEN
    public GameScreen gameScreen;
    public LoginScreen loginScreen;
    public MainMenuScreen mainMenuScreen;
    public MenuScreen menuScreen;
    public RegisterScreen registerScreen;

    public MenuScreen lightMenuScreen;

    // CONTROLLER
    public ScreenController screenController;
    public AuthController authController;

    @Override
    public void create() {
        Gdx.app.log(INFO, "Game creating...");
        uiMode = LIGHT_MODE;

        accountService = new AccountService();
        batch = new SpriteBatch();

        Assets.load();

        // SCREEN
        gameScreen = new GameScreenImpl(this);
        loginScreen = new LoginScreenImpl(this);
        mainMenuScreen = new MainMenuScreenImpl(this);
        menuScreen = new MenuScreenImpl(this);
        registerScreen = new RegisterScreenImpl(this);

        lightMenuScreen = new LightMenuScreen(this);

        screenController = new ScreenControllerImpl(this);
        authController = new AuthControllerImpl(this);

        screenController.toMenuScreen();
    }

    @Override
    public void render() {
        GL20 gl = Gdx.gl;
        gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
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
