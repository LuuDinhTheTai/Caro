package com.utc.btl.game_play.validator;

import com.utc.btl.view_component.Board;
import com.utc.btl.view_component.Cell;

public interface IValidator {

    void validate(Cell cell);
    void setBoard(Board board);
}
