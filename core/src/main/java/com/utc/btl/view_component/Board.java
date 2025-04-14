package com.utc.btl.view_component;

import com.utc.btl.constant.Constants;
import com.utc.btl.controller.GameController;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {

    private Cell[][] cells;
    private GameController controller;

    public Board() {
        cells = new Cell[Constants.ROW_SIZE][Constants.COL_SIZE];
        for (int i = 0; i < Constants.ROW_SIZE; i++) {
            for (int j = 0; j < Constants.COL_SIZE; j++) {
                cells[i][j] = new Cell(null,i,j);
            }
        }
    }

    public Cell[][] getBoard() {
        return cells;
    }

    public void setBoard(Cell[][] cells) {
        this.cells = cells;
    }

    public void setController(GameController controller) {
        this.controller = controller;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j].setController(controller);
            }
        }
    }
}
