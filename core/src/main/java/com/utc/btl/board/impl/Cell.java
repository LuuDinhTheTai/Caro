package com.utc.btl.board.impl;

import com.utc.btl.board.Piece;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cell {

    private int x;
    private int y;
    private Piece piece;

    public Cell(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }
}
