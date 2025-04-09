package com.utc.btl.board;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.utc.btl.constant.Constants;
import lombok.Getter;

import static com.utc.btl.Assets.*;
import static com.utc.btl.constant.Constants.*;

@Getter
public enum Piece {

    X_CELL(Constants.X_CELL, new TextureRegion(xCellTexture)),
    X_CELL_FOCUS(Constants.X_CELL, new TextureRegion(xCellFocusTexture)),
    O_CELL(Constants.O_CELL, new TextureRegion(oCellTexture)),
    O_CELL_FOCUS(Constants.O_CELL, new TextureRegion(oCellFocusTexture)),
    EMPTY(EMPTY_CELL, new TextureRegion(emptyCellTexture)),
    FOCUS(FOCUS_CELL, new TextureRegion(focusCellTexture)),
    ;

    private String status;
    private TextureRegion textureRegion;

    Piece(String status, TextureRegion textureRegion) {
        this.status = status;
        this.textureRegion = textureRegion;
    }
}
