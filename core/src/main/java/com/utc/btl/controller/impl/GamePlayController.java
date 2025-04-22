package com.utc.btl.controller.impl;

import com.utc.btl.Main;
import com.utc.btl.constant.Constants;
import com.utc.btl.controller.IGamePlayController;
import com.utc.btl.controller.base.impl.BaseController;
import com.utc.btl.view_component.Cell;
import com.utc.btl.view_component.Piece;

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
        main.sessionService.update(main.session);
    }

    @Override
    public void draw(Cell cell) {
        toMenuScreen();
        popUpDialog("", "DRAW !");
        main.session.setDraw(main.session.getDraw() + 1);
        main.sessionService.update(main.session);
    }
}
