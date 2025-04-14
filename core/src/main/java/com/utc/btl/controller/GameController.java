package com.utc.btl.controller;

import com.utc.btl.game_model.GameModel;
import com.utc.btl.game_play.validator.IValidator;
import com.utc.btl.view_component.Cell;
import com.utc.btl.view_component.Piece;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameController {
    private GameModel model;
    private IValidator validator;
    public GameController(GameModel model, IValidator validator) {
        this.model = model;
        this.validator = validator;
    }

    // Xử lý sự kiện khi Cell được click
    public void onCellClicked(Cell cell) {
        Piece currentPiece = cell.getPiece();

        // Nếu cell trống: xử lý lấy focus
        if (currentPiece == Piece.EMPTY) {
            model.focusCell(cell);
        }
        // Nếu cell đang FOCUS, click lại sẽ xác nhận nước đi.
        else if (currentPiece == Piece.FOCUS) {
            // Chỉ xử lý nếu cell đang được focus
            if (model.getFocusedCell() == cell) {
                model.commitCell(cell);
                validator.validate();
            }
        }
    }
}
