package com.utc.btl.view_component;

import com.utc.btl.constant.Constants;

public class Board {

    private Cell[][] cells;

    public Board() {
        cells = new Cell[Constants.ROW_SIZE][Constants.COL_SIZE];
        for (int i = 0; i < Constants.ROW_SIZE; i++) {
            for (int j = 0; j < Constants.COL_SIZE; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getBoard() {
        return cells;
    }

    public void setBoard(Cell[][] cells) {
        this.cells = cells;
    }
}
