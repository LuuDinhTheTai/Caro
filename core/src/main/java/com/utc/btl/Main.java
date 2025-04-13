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
import com.utc.btl.screen.impl.light_mode.LightSettingScreen;
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

    public IMenuScreen lightMenuScreen;
    public ISettingScreen lightSettingScreen;

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
        uiMode = DEFAULT_UI;

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

//        lightMenuScreen = new LightMenuScreen(this);
        lightSettingScreen = new LightSettingScreen(this);

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

//        batch.begin();
//        switch (state) {
//            case inGame:
//                super.render();
//                break;
//            case notInGame:
//                super.render();
//                break;
//            case pause:
//                super.render();
//                break;
//        }
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
