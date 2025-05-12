package com.utc.btl.game_play.validator;

import com.utc.btl.Main;
import com.utc.btl.view_component.Board;
import com.utc.btl.view_component.Cell;
import com.utc.btl.view_component.Piece;
import lombok.Setter;

@Setter
public class Validator implements IValidator {

    private Main main;
    private Board board;

    public Validator(Main main) {
        this.main = main;
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public void validate(Cell cell) {
        checkDirection(cell, 0, 1);
        checkDirection(cell, 1, 0);
        checkDirection(cell, 1, 1);
        checkDirection(cell, 1, -1);
        checkDraw();
    }

    private void checkDirection(Cell cell, int deltaRow, int deltaCol) {
        Piece target = cell.getPiece();
        int count = 1;

        // Duyệt theo hướng thuận
        int row = cell.getRow() + deltaRow;
        int col = cell.getCol() + deltaCol;
        while (isValid(row, col) && board.getBoard()[row][col].getPiece().equals(target)) {
            count++;
            row += deltaRow;
            col += deltaCol;
        }

        // Duyệt theo hướng nghịch
        row = cell.getRow() - deltaRow;
        col = cell.getCol() - deltaCol;
        while (isValid(row, col) && board.getBoard()[row][col].getPiece().equals(target)) {
            count++;
            row -= deltaRow;
            col -= deltaCol;
        }

        if (count >= 5) {
            main.gamePlayController.win(cell);
        }
    }

    private void checkDraw() {
        int count = 0;
        Cell cell = null;
        for (Cell[] row : board.getBoard()) {
            for (Cell c : row) {
                if (c.getPiece().isEmpty()
                        || c.getPiece().isFocus()) {
                    count++;
                    cell = c;
                    if (count > 0) {
                        break;
                    }
                }
            }
        }
        if (count == 0) {
            main.gamePlayController.draw(cell);
        }
    }

    private boolean isValid(int row, int col) {
        if (row < 0 || col < 0 || row >= board.getBoard().length || col >= board.getBoard()[0].length) {
            return false;
        }
        return true;
    }
}
