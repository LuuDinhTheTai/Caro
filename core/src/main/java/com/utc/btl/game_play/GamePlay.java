package com.utc.btl.game_play;

import com.utc.btl.Main;
import com.utc.btl.view_component.Cell;
import com.utc.btl.view_component.Piece;

import java.util.Deque;
import java.util.LinkedList;

public class GamePlay implements IGamePlay {

    private Main main;
    private Cell focusedCell;
    private Cell lastPlayedCell;
    private Piece currentPlayer;

    private Deque<MoveAction> undoStack = new LinkedList<>();
    private Deque<MoveAction> redoStack = new LinkedList<>();

    private static class MoveAction {
        Cell cell;
        Piece prevPiece;        // thường là FOCUS
        Cell prevLastPlayed;
        Piece prevLastPlayedPiece;
        Piece playerBefore;     // ai đã đi
        Cell prevFocusedCell;   // cell đang focus trước khi commit

        MoveAction(Cell cell, Piece prevPiece,
                   Cell prevLastPlayed, Piece prevLastPlayedPiece,
                   Piece playerBefore, Cell prevFocusedCell) {
            this.cell = cell;
            this.prevPiece = prevPiece;
            this.prevLastPlayed = prevLastPlayed;
            this.prevLastPlayedPiece = prevLastPlayedPiece;
            this.playerBefore = playerBefore;
            this.prevFocusedCell = prevFocusedCell;
        }
    }

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
                // trước khi commit thì lưu trạng thái
                Cell prevLast = lastPlayedCell;
                Piece prevLastPiece = (lastPlayedCell != null ? lastPlayedCell.getPiece() : null);
                Piece beforePlayer = currentPlayer;
                Cell prevFocus = focusedCell;

                commit(cell);

                // đẩy action vào undo, clear redo
                undoStack.push(new MoveAction(cell, Piece.FOCUS, prevLast, prevLastPiece, beforePlayer, prevFocus));
                redoStack.clear();
            }
            switchPlayer();
        }
    }

    public void undo() {
        if (undoStack.isEmpty()) return;

        MoveAction act = undoStack.pop();

        // 1. Dọn sạch trạng thái của ô vừa commit:
        //    luôn chuyển về EMPTY để có thể đánh lại
        act.cell.setPiece(Piece.EMPTY);

        // 2. Phục hồi lastPlayedCell cũ
        if (lastPlayedCell != null) {
            // xoá focus/đánh dấu của nước hiện tại (nếu có)
            lastPlayedCell.setPiece(Piece.EMPTY);
        }
        if (act.prevLastPlayed != null) {
            act.prevLastPlayed.setPiece(act.prevLastPlayedPiece);
        }
        lastPlayedCell = act.prevLastPlayed;

        // 3. Phục hồi focus cũ:
        //    trước đó có thể đang focus ở một ô khác, nếu null thì không focus ô nào
        if (focusedCell != null && focusedCell != act.prevFocusedCell) {
            focusedCell.setPiece(Piece.EMPTY);
        }
        focusedCell = act.prevFocusedCell;
        if (focusedCell != null) {
            focusedCell.setPiece(Piece.FOCUS);
        }

        // 4. Phục hồi người chơi
        currentPlayer = act.playerBefore;

        // 5. Đẩy action này vào redoStack để có thể redo
        redoStack.push(act);
    }

    public void redo() {
        if (redoStack.isEmpty()) return;

        MoveAction act = redoStack.pop();

        // 1. Xóa bất cứ focus còn sót lại
        if (focusedCell != null) {
            focusedCell.setPiece(Piece.EMPTY);
        }

        // 2. Khôi phục currentPlayer trước khi commit nước này
        currentPlayer = act.playerBefore;

        // 3. Gọi lại commit như lần đánh ban đầu
        //    - commit() sẽ tự chuyển trạng thái của lastPlayedCell cũ
        //      (act.prevLastPlayed) từ X_FOCUS/O_FOCUS → X/O
        //    - setPiece(X_FOCUS/O_FOCUS) lên act.cell
        //    - cập nhật lastPlayedCell = act.cell, focusedCell = null
        commit(act.cell);  // :contentReference[oaicite:0]{index=0}

        // 4. Đổi lượt người chơi (giống y hệt move(...))
        switchPlayer();

        // 5. Đẩy lại hành động vào undoStack để có thể undo tiếp
        undoStack.push(act);
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
