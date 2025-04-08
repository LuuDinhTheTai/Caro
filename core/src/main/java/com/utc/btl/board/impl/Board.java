package com.utc.btl.board.impl;

import com.utc.btl.board.IBoard;
import com.utc.btl.board.Piece;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Board implements IBoard {

    private Cell[][] cells;


}
