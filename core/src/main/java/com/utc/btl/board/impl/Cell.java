package com.utc.btl.board.impl;

import com.utc.btl.board.ICell;
import com.utc.btl.board.Piece;
import lombok.Getter;
import lombok.Setter;

public class Cell implements ICell {

    @Setter
    @Getter
    private int x;
    @Setter
    @Getter
    private int y;
    @Setter
    @Getter
    private Piece piece;

    public Cell(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }
    @Override
    public void move() {

    }


}
