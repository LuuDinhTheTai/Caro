package com.utc.btl.controller;

import com.utc.btl.controller.base.IController;
import com.utc.btl.view_component.Cell;

public interface IGamePlayController extends IController {

    void move(Cell cell);
    void win(Cell cell);
    void draw(Cell cell);
    void exit();
}
