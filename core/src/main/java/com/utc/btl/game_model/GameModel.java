package com.utc.btl.game_model;

import com.utc.btl.view_component.Board;
import com.utc.btl.view_component.Cell;
import com.utc.btl.view_component.Piece;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameModel {
    private Board board;
    private Cell focusedCell;
    private Cell lastPlayedCell;
    private Piece currentPlayer;
    private int gameStatus;

    public GameModel() {
        board = new Board();
        currentPlayer = Piece.X_CELL;
        focusedCell = null;
        lastPlayedCell = null;
        gameStatus = 0;
    }
    public void focusCell(Cell cell) {
        if (focusedCell != null && focusedCell != cell && focusedCell != lastPlayedCell) {
            focusedCell.setPiece(Piece.EMPTY);
        }
        cell.setPiece(Piece.FOCUS);
        focusedCell = cell;
    }

    public void commitCell(Cell cell) {
        // Nếu có cell vừa đánh trước đó thì cập nhật lại trạng thái của cell đó
        if (lastPlayedCell != null) {
            Piece lastPiece = lastPlayedCell.getPiece();
            if (lastPiece == Piece.X_CELL_FOCUS) {
                lastPlayedCell.setPiece(Piece.X_CELL);
            } else if (lastPiece == Piece.O_CELL_FOCUS) {
                lastPlayedCell.setPiece(Piece.O_CELL);
            }
        }
        // Xác định trạng thái mới của cell dựa trên người chơi hiện tại
        Piece newPiece = (currentPlayer == Piece.X_CELL) ? Piece.X_CELL_FOCUS : Piece.O_CELL_FOCUS;
        cell.setPiece(newPiece);
        lastPlayedCell = cell;
        focusedCell = null;
        switchPlayer();
    }
    public void switchPlayer() {
        currentPlayer = (currentPlayer == Piece.X_CELL) ? Piece.O_CELL : Piece.X_CELL;
    }
}
