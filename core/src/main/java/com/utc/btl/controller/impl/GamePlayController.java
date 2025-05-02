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
        main.gamePlay.move(cell);
        main.validator.validate(cell);
    }

    @Override
    public void win(Cell cell) {
        if (cell.getPiece().isX()) {
            toMenuScreen();
            popUpDialog("", "X WIN !");
            main.session.setXWin(main.session.getXWin() + 1);

        } else if (cell.getPiece().isO()) {
            toMenuScreen();
            popUpDialog("", "O WIN !");
            main.session.setOWin(main.session.getOWin() + 1);
        }

        try {
            main.sessionService.update(main.session);

        } catch (GameException e) {
            Gdx.app.error(ERROR,e.getMessage(), e);
            popUpDialog(ERROR, e.getMessage());

        } catch (Exception e) {
            Gdx.app.error(ERROR,e.getMessage(), e);
            popUpDialog(ERROR, "System error");
        }

    }

    @Override
    public void draw(Cell cell) {
        toMenuScreen();
        popUpDialog("", "DRAW !");
        main.session.setDraw(main.session.getDraw() + 1);

        try {
            main.sessionService.update(main.session);

        } catch (GameException e) {
            Gdx.app.error(ERROR,e.getMessage(), e);
            popUpDialog(ERROR, e.getMessage());

        } catch (Exception e) {
            Gdx.app.error(ERROR,e.getMessage(), e);
            popUpDialog(ERROR, "System error");
        }
    }

    @Override
    public void exit() {
        toMenuScreen();
    }
}
