package com.utc.btl;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.utc.btl.entity.Account;
import com.utc.btl.game_play.validator.IValidator;
import com.utc.btl.controller.IAuthController;
import com.utc.btl.controller.IScreenController;
import com.utc.btl.controller.impl.AuthController;
import com.utc.btl.controller.impl.ScreenController;
import com.utc.btl.screen.*;
import com.utc.btl.screen.impl.*;
import com.utc.btl.dao.IAccountDao;
import com.utc.btl.dao.impl.AccountDao;
import com.utc.btl.screen.impl.dark_mode.DarkLoginScreen;
import com.utc.btl.screen.impl.dark_mode.DarkMainMenuScreen;
import com.utc.btl.screen.impl.dark_mode.DarkMenuScreen;
import com.utc.btl.screen.impl.dark_mode.DarkProfileScreen;
import com.utc.btl.screen.impl.light_mode.*;
import com.utc.btl.service.IAccountService;
import com.utc.btl.service.impl.AccountService;

import static com.utc.btl.constant.Constants.INFO;

public class Main extends Game {

    // UI MODE
    public final int DEFAULT_UI = 0;
    public final int LIGHT_MODE = 1;
    public final int DARK_MODE = 2;
    public int uiMode;

    // STATE
    public final int inGame = 0;
    public final int notInGame = 1;
    public final int pause = 2;
    public int state;

    // DAO
    private IAccountDao accountDao;

    // SERVICE
    public IAccountService accountService;

    public SpriteBatch batch;

    // SCREEN
    public IGameScreen gameScreen;
    public ILoginScreen loginScreen;
    public IMainMenuScreen mainMenuScreen;
    public IMenuScreen menuScreen;
    public IProfileScreen profileScreen;
    public IRegisterScreen registerScreen;
    public ISettingScreen settingScreen;

    public ILoginScreen lightLoginScreen;
    public IMainMenuScreen lightMainMenuScreen;
    public IMenuScreen lightMenuScreen;
    public IProfileScreen lightProfileScreen;
    public ISettingScreen lightSettingScreen;

    public ILoginScreen darkLoginScreen;
    public IMainMenuScreen darkMainMenuScreen;
    public IMenuScreen darkMenuScreen;
    public IProfileScreen darkProfileScreen;

    // RENDERER

    // CONTROLLER
    public IScreenController screenController;
    public IAuthController authController;

    // GAME PLAY
    public IValidator validator;

    // AUTH
    public Account loggedInAccount;

    @Override
    public void create() {
        Gdx.app.log(INFO, "Game creating...");

        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        Assets.load();

        // UI MODE
        uiMode = DARK_MODE;

        // STATE
        state = notInGame;

        // DAO
        accountDao = new AccountDao();

        // SERVICE
        accountService = new AccountService(accountDao);
        batch = new SpriteBatch();

        // SCREEN
        gameScreen = new GameScreen(this);
        loginScreen = new LoginScreen(this);
        mainMenuScreen = new MainMenuScreen(this);
        menuScreen = new MenuScreen(this);
        profileScreen = new ProfileScreen(this);
        registerScreen = new RegisterScreen(this);
        settingScreen = new SettingScreen(this);

        lightLoginScreen = new LightLoginScreen(this);
        lightMainMenuScreen = new LightMainMenuScreen(this);
        lightMenuScreen = new LightMenuScreen(this);
        lightProfileScreen = new LightProfileScreen(this);
        lightSettingScreen = new LightSettingScreen(this);

        darkLoginScreen = new DarkLoginScreen(this);
        darkMainMenuScreen = new DarkMainMenuScreen(this);
        darkMenuScreen = new DarkMenuScreen(this);
        darkProfileScreen = new DarkProfileScreen(this);

        // CONTROLLER
        screenController = new ScreenController(this);
        authController = new AuthController(this);

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

    @Override
    public void pause() {
        super.pause();
        state = pause;
    }
}
