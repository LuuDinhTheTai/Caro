package com.utc.btl.game_play.validator;

import com.badlogic.gdx.Gdx;
import com.utc.btl.Main;
import com.utc.btl.view_component.Board;
import com.utc.btl.view_component.Cell;
import com.utc.btl.view_component.Piece;
import lombok.Setter;

import static com.utc.btl.constant.Constants.DEBUG;
import static com.utc.btl.constant.Constants.DIALOG_INFO_TITLE;

@Setter
public class Validator implements IValidator {

    private Main main;
    private Board board;

    public Validator(Main main) {
        this.main = main;
    }

    @Override
    public void validate(Cell cell) {
        Gdx.app.debug(DEBUG, "validate move");
        checkDirection(cell, 0, 1);
        checkDirection(cell, 1, 0);
        checkDirection(cell, 1, 1);
        checkDirection(cell, 1, -1);
    }

    /*
     * 1 . . . 0 . . . 3
     * . 1 . . 0 . . 3 .
     * . . 1 . 0 . 3 . .
     * . . . 1 0 3 . . .
     * 2 2 2 2 x 2 2 2 2
     * . . . 3 0 1 . . .
     * . . 3 . 0 . 1 . .
     * . 3 . . 0 . . 1 .
     * 3 . . . 0 . . . 1
     * */

    private void checkDirection(Cell cell, int deltaRow, int deltaCol) {
        Piece target = cell.getPiece();
        int count = 1;

        // Duyệt theo hướng thuận
        int row = cell.getRow() + deltaRow;
        int col = cell.getCol() + deltaCol;
        while (isValid(row, col) && board.getBoard()[row][col].getPiece().getStatus() == target.getStatus()) {
            count++;
            row += deltaRow;
            col += deltaCol;
        }

        if (count >= 5) {
            main.screenController.toMenuScreen();
            String msg = target + " WIN";
            main.screenController.popUpDialog(DIALOG_INFO_TITLE, msg);
        }

        // Duyệt theo hướng nghịch
        row = cell.getRow() - deltaRow;
        col = cell.getCol() - deltaCol;
        while (isValid(row, col) && board.getBoard()[row][col].getPiece().getStatus() == target.getStatus()) {
            count++;
            row -= deltaRow;
            col -= deltaCol;
        }

        if (count >= 5) {
            main.screenController.toMenuScreen();
            String msg = target + " WIN";
            main.screenController.popUpDialog(DIALOG_INFO_TITLE, msg);
        }
    }

    private boolean isValid(int row, int col) {
        if (row < 0 || col < 0 || row >= board.getBoard().length || col >= board.getBoard()[0].length) {
            return false;
        }
        return true;
    }
}
