package com.utc.btl.board.impl;

import com.utc.btl.board.IBoard;
import com.utc.btl.board.Piece;
import com.utc.btl.constant.Constants;


public class Board implements IBoard {

    private Cell[][] cells;
    private int lastRow;
    private int lastCol;
    public Board() {
        cells = new Cell[Constants.ROW_SIZE][Constants.COL_SIZE];
        lastRow = -1;
        lastCol = -1;
        setValueBoard();
    }
    private void setValueBoard(){
        for (int i = 0; i < Constants.ROW_SIZE; i++) {
            for (int j = 0; j < Constants.COL_SIZE; j++) {
                cells[i][j] = new Cell(i,j, Piece.EMPTY);
            }
        }
    }
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }
    public boolean makeMove(int row, int col, int player) {
        if(getCell(row, col).getPiece() != Piece.FOCUS){return false;}
        if(player == 1){
            getCell(row, col).setPiece(Piece.X_CELL_FOCUS);
        }
        else {
            getCell(row, col).setPiece(Piece.O_CELL_FOCUS);
        }
        hideFocusLastMove(lastRow, lastCol);
        lastRow = row;
        lastCol = col;
        checkWin(row,col,player);
        return true;
    }
    private void checkWin(int row, int col, int player) {

    }
    private void hideFocusLastMove(int row, int col) {
        if(row == -1 || col == -1){return;}
        if(getCell(row, col).getPiece() == Piece.X_CELL_FOCUS){
            getCell(row, col).setPiece(Piece.X_CELL);
        }
        if(getCell(row, col).getPiece() == Piece.O_CELL_FOCUS){
            getCell(row, col).setPiece(Piece.O_CELL);
        }
    }
}
