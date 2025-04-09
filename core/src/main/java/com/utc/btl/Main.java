package com.utc.btl;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.utc.btl.game_play.IGamePlay;
import com.utc.btl.game_play.validator.IValidator;
import com.utc.btl.renderer.IBoardRenderer;
import com.utc.btl.controller.IAuthController;
import com.utc.btl.controller.IScreenController;
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

    // STATE
    public final int inGame = 0;
    public final int notInGame = 1;
    public final int pause = 2;
    public int state;

    // SERVICE
    public IAccountService accountService;

    public SpriteBatch batch;

    // SCREEN
    public IGameScreen gameScreen;
    public ILoginScreen loginScreen;
    public IMainMenuScreen mainMenuScreen;
    public IMenuScreen menuScreen;
    public IRegisterScreen registerScreen;

    public IMenuScreen lightMenuScreen;

    // RENDERER
    public IBoardRenderer boardRenderer;

    // CONTROLLER
    public IScreenController screenController;
    public IAuthController authController;

    // GAME PLAY
    public IGamePlay gamePlay;
    public IValidator validator;

    @Override
    public void create() {

        Gdx.app.log(INFO, "Game creating...");
        Assets.load();

        // UI MODE
        uiMode = LIGHT_MODE;

        // STATE
        state = notInGame;

        // SERVICE
        accountService = new AccountService();
        batch = new SpriteBatch();

        // SCREEN
        gameScreen = new GameScreenImpl(this);
        loginScreen = new LoginScreenImpl(this);
        mainMenuScreen = new MainMenuScreenImpl(this);
        menuScreen = new MenuScreenImpl(this);
        registerScreen = new RegisterScreenImpl(this);

        lightMenuScreen = new LightMenuScreen(this);

        // CONTROLLER
        screenController = new ScreenControllerImpl(this);
        authController = new AuthControllerImpl(this);

        screenController.toMenuScreen();
    }

    @Override
    public void render() {
        GL20 gl = Gdx.gl;
        gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        switch (state) {
            case inGame:
                // TODO: vẽ board ở đây hay ở controller ???
//                boardRenderer.draw(batch);
                super.render();
                break;
            case notInGame:

                super.render();
                break;
            case pause:

                super.render();
                break;
        }
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
