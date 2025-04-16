package com.utc.btl;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.utc.btl.controller.IGameModeController;
import com.utc.btl.controller.IGamePlayController;
import com.utc.btl.controller.impl.GameModeController;
import com.utc.btl.controller.impl.GamePlayController;
import com.utc.btl.entity.Account;
import com.utc.btl.exception.GameException;
import com.utc.btl.game_play.GamePlay;
import com.utc.btl.game_play.validator.IValidator;
import com.utc.btl.controller.IScreenController;
import com.utc.btl.controller.impl.ScreenController;
import com.utc.btl.game_play.validator.Validator;
import com.utc.btl.screen.*;
import com.utc.btl.screen.impl.*;
import com.utc.btl.dao.IAccountDao;
import com.utc.btl.dao.impl.AccountDao;
import com.utc.btl.screen.impl.dark_mode.*;
import com.utc.btl.screen.impl.light_mode.*;
import com.utc.btl.service.IAccountService;
import com.utc.btl.service.impl.AccountService;

import static com.utc.btl.constant.Constants.ERROR;
import static com.utc.btl.constant.Constants.INFO;

public class Main extends Game {

    // UI MODE
    public final int DEFAULT_UI = 0;
    public final int LIGHT_MODE = 1;
    public final int DARK_MODE = 2;
    public int uiMode;

    // DAO
    private IAccountDao accountDao;

    // SERVICE
    public IAccountService accountService;

    public SpriteBatch batch;

    // SCREEN
    public IGameScreen gameScreen;
    public IMenuScreen menuScreen;
    public IProfileScreen profileScreen;
    public ISettingScreen settingScreen;

    public IMenuScreen lightMenuScreen;
    public IProfileScreen lightProfileScreen;
    public ISettingScreen lightSettingScreen;

    public IMenuScreen darkMenuScreen;
    public IProfileScreen darkProfileScreen;
    public ISettingScreen darkSettingScreen;

    // CONTROLLER
    public IScreenController screenController;
    public IGameModeController gameModeController;
    public IGamePlayController gamePlayController;

    // GAME PLAY
    public IValidator validator;
    public GamePlay gamePlay;

    // AUTH
    public Account loggedInAccount;

    @Override
    public void create() {
        Gdx.app.log(INFO, "Game creating...");
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        try {
            Assets.load();

            // UI MODE
            uiMode = LIGHT_MODE;

            // DAO
            accountDao = new AccountDao();

            // SERVICE
            accountService = new AccountService(accountDao);
            batch = new SpriteBatch();

            // SCREEN
            gameScreen = new GameScreen(this);
            menuScreen = new MenuScreen(this);
            profileScreen = new ProfileScreen(this);
            settingScreen = new SettingScreen(this);

            lightMenuScreen = new LightMenuScreen(this);
            lightProfileScreen = new LightProfileScreen(this);
            lightSettingScreen = new LightSettingScreen(this);

            darkMenuScreen = new DarkMenuScreen(this);
            darkProfileScreen = new DarkProfileScreen(this);
            darkSettingScreen = new DarkSettingScreen(this);

            // CONTROLLER
            gameModeController = new GameModeController(this);
            gamePlayController = new GamePlayController(this);
            screenController = new ScreenController(this);

            // VALIDATOR
            validator = new Validator(this);
            gamePlay = new GamePlay(this);

            screenController.toMenuScreen();

        } catch (GameException e) {
            Gdx.app.error(ERROR, e.getMessage(), e);
        }
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
        menuScreen.dispose();
        profileScreen.dispose();
        settingScreen.dispose();
        lightMenuScreen.dispose();
        lightProfileScreen.dispose();
        lightSettingScreen.dispose();
        darkMenuScreen.dispose();
        darkProfileScreen.dispose();
        darkSettingScreen.dispose();
    }
}
