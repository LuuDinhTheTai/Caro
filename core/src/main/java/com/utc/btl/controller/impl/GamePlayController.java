package com.utc.btl.controller.impl;

import com.badlogic.gdx.Gdx;
import com.utc.btl.Main;
import com.utc.btl.controller.IGamePlayController;
import com.utc.btl.controller.base.impl.BaseController;
import com.utc.btl.exception.GameException;
import com.utc.btl.view_component.Cell;

import static com.utc.btl.constant.Constants.ERROR;

public class GamePlayController extends BaseController implements IGamePlayController {

    public GamePlayController(Main main) {
        super(main);
    }

    @Override
    public void move(Cell cell) {
        try {
            main.gamePlay.move(cell);
            main.validator.validate(cell);

        } catch (Exception e) {
            Gdx.app.error(ERROR, "Move error: " + e.getMessage(), e);
            toResultScreen("Move error");
        }
    }

    @Override
    public void undo() {
        try {
            main.gamePlay.undo();

        } catch (GameException e) {
            Gdx.app.error(ERROR, e.getMessage(), e);

        } catch (Exception e) {
            Gdx.app.error(ERROR, e.getMessage(), e);
            toResultScreen("System error");
        }
    }

    @Override
    public void redo() {
        try {
            main.gamePlay.redo();
        } catch (GameException e) {
            Gdx.app.error(ERROR, e.getMessage(), e);

        } catch (Exception e) {
            Gdx.app.error(ERROR, e.getMessage(), e);
            toResultScreen("System error");
        }
    }

    @Override
    public void win(Cell cell) {
        try {
            if (cell.getPiece().isX()) {
                main.session.setXWin(main.session.getXWin() + 1);
                toResultScreen("X WIN");

            } else if (cell.getPiece().isO()) {
                main.session.setOWin(main.session.getOWin() + 1);
                toResultScreen("O WIN");
            }

            main.sessionService.update(main.session);

        } catch (GameException e) {
            Gdx.app.error(ERROR, e.getMessage(), e);
            toResultScreen(e.getMessage());

        } catch (Exception e) {
            Gdx.app.error(ERROR, e.getMessage(), e);
            toResultScreen("System error");
        }
    }

    @Override
    public void draw(Cell cell) {
        try {
            main.session.setDraw(main.session.getDraw() + 1);
            main.sessionService.update(main.session);
            toResultScreen("DRAW");

        } catch (GameException e) {
            Gdx.app.error(ERROR, e.getMessage(), e);
            toResultScreen(e.getMessage());

        } catch (Exception e) {
            Gdx.app.error(ERROR, e.getMessage(), e);
            toResultScreen("System error");
        }
    }

    @Override
    public void exit() {
        toMenuScreen();
    }
}
