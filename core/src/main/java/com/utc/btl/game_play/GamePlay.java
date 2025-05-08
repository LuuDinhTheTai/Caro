package com.utc.btl.game_play;

import com.utc.btl.Main;
import com.utc.btl.view_component.Cell;
import com.utc.btl.view_component.Piece;

public class GamePlay implements IGamePlay {

    private Main main;
    private Cell focusedCell;
    private Cell lastPlayedCell;
    private Piece currentPlayer;

    public GamePlay(Main main) {
        this.main = main;
        currentPlayer = Piece.X;
        focusedCell = null;
        lastPlayedCell = null;
    }

    @Override
    public void move(Cell cell) {
        if (cell.getPiece() == Piece.EMPTY) {
            toFocus(cell);

        } else if (cell.getPiece() == Piece.FOCUS) {
            if (focusedCell == cell) {
                commit(cell);
            }
            switchPlayer();
        }
    }

    private void toFocus(Cell cell) {
        if (focusedCell != null && focusedCell != cell && focusedCell != lastPlayedCell) {
            focusedCell.setPiece(Piece.EMPTY);
        }
        cell.setPiece(Piece.FOCUS);
        focusedCell = cell;
    }

    private void commit(Cell cell) {
        // Nếu có cell vừa đánh trước đó thì cập nhật lại trạng thái của cell đó
        if (lastPlayedCell != null) {
            Piece lastPiece = lastPlayedCell.getPiece();
            if (lastPiece == Piece.X_FOCUS) {
                lastPlayedCell.setPiece(Piece.X);
            } else if (lastPiece == Piece.O_FOCUS) {
                lastPlayedCell.setPiece(Piece.O);
            }
        }
        // Xác định trạng thái mới của cell dựa trên người chơi hiện tại
        Piece newPiece = (currentPlayer == Piece.X) ? Piece.X_FOCUS : Piece.O_FOCUS;
        cell.setPiece(newPiece);
        main.soundController.moveSound();
        lastPlayedCell = cell;
        focusedCell = null;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == Piece.X) ? Piece.O : Piece.X;
    }
}
