package com.utc.btl.view_component;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.Getter;

import static com.utc.btl.Assets.*;

@Getter
public enum Piece {

    EMPTY(Status.EMPTY, new TextureRegion(emptyCellTexture)),
    FOCUS(Status.FOCUS, new TextureRegion(focusCellTexture)),
    X_CELL(Status.EMPTY, new TextureRegion(xCellTexture)),
    X_CELL_FOCUS(Status.X_FOCUS, new TextureRegion(xCellFocusTexture)),
    O_CELL(Status.O, new TextureRegion(oCellTexture)),
    O_CELL_FOCUS(Status.O_FOCUS, new TextureRegion(oCellFocusTexture)),
    ;

    private Status status;
    private TextureRegion textureRegion;

    Piece(Status status, TextureRegion textureRegion) {
        this.status = status;
        this.textureRegion = textureRegion;
    }

    enum Status {
        EMPTY,
        FOCUS,
        X,
        X_FOCUS,
        O,
        O_FOCUS,
    }
}
