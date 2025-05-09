package com.utc.btl.game_play;

import com.utc.btl.view_component.Cell;

public interface IGamePlay {

    void move(Cell cell);
    void undo();
    void redo();
}
