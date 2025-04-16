package com.utc.btl.view_component;

import com.utc.btl.Main;
import com.utc.btl.constant.Constants;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {

    private Main main;
    private Cell[][] board;

    public Board(Main main) {
        this.main = main;
        board = new Cell[Constants.ROW_SIZE][Constants.COL_SIZE];
        for (int i = 0; i < Constants.ROW_SIZE; i++) {
            for (int j = 0; j < Constants.COL_SIZE; j++) {
                board[i][j] = new Cell(main,i,j);
            }
        }
    }
}
