package com.utc.btl;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.utc.btl.constant.Assets;
import com.utc.btl.controller.IUIModeController;
import com.utc.btl.controller.IGamePlayController;
import com.utc.btl.controller.impl.UIModeController;
import com.utc.btl.controller.impl.GamePlayController;
import com.utc.btl.entity.Session;
import com.utc.btl.exception.ExceptionType;
import com.utc.btl.exception.GameException;
import com.utc.btl.game_play.GamePlay;
import com.utc.btl.game_play.IGamePlay;
import com.utc.btl.game_play.validator.IValidator;
import com.utc.btl.controller.IScreenController;
import com.utc.btl.controller.ISoundController;
import com.utc.btl.controller.impl.ScreenController;
import com.utc.btl.controller.impl.SoundController;
import com.utc.btl.game_play.validator.Validator;
import com.utc.btl.game_play.validator.Validator2;
import com.utc.btl.screen.*;
import com.utc.btl.screen.impl.*;
import com.utc.btl.dao.ISessionDao;
import com.utc.btl.dao.impl.SessionDao;
import com.utc.btl.screen.impl.dark_mode.*;
import com.utc.btl.service.ISessionService;
import com.utc.btl.service.impl.SessionService;

import static com.utc.btl.constant.Constants.*;

public class Main extends Game {

    // UI MODE
    public final int DEFAULT_UI = 0;
    public final int LIGHT_MODE = 1;
    public final int DARK_MODE = 2;
    public int uiMode;

    // DAO
    private ISessionDao sessionDao;
    public ISessionService sessionService;

    public SpriteBatch batch;

    // SCREEN
    public IGameScreen gameScreen;
    public IMenuScreen menuScreen;
    public IProfileScreen profileScreen;
    public IResultScreen resultScreen;
    public ISettingScreen settingScreen;

    // CONTROLLER
    public IScreenController screenController;
    public IUIModeController gameModeController;
    public IGamePlayController gamePlayController;
    public ISoundController soundController;

    // GAME PLAY
    public IValidator validator;
    public IGamePlay gamePlay;

    // AUTH
    public Session session;

    @Override
    public void create() {
        Gdx.app.log(INFO, "Game creating...");
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        try {
            Assets.load();
            // UI MODE
            uiMode = DARK_MODE;

            // DAO
            sessionDao = new SessionDao();
            sessionService = new SessionService(sessionDao);
            session = new Session(0, 0, 0);
            sessionService.create(session);

            batch = new SpriteBatch();

            // SCREEN
            gameScreen = new DarkGameScreen(this);
            menuScreen = new DarkMenuScreen(this);
            profileScreen = new DarkProfileScreen(this);
            resultScreen = new DarkResultScreen(this);
            settingScreen = new DarkSettingScreen(this);

            // CONTROLLER
            gameModeController = new UIModeController(this);
            gamePlayController = new GamePlayController(this);
            screenController = new ScreenController(this);
            soundController = new SoundController(this);

            // VALIDATOR
            validator = new Validator(this);
            gamePlay = new GamePlay(this);

            screenController.toMenuScreen();

        } catch (GameException e) {
            Gdx.app.error(ERROR, e.getMessage(), e);
            Gdx.app.exit();
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
        sessionService.update(session);
        batch.dispose();
        gameScreen.dispose();
        menuScreen.dispose();
        profileScreen.dispose();
        settingScreen.dispose();
    }
}
