package com.utc.btl.controller.impl;

import com.utc.btl.Main;
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
}
