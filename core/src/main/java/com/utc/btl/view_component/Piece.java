package com.utc.btl.view_component;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.Getter;

import static com.utc.btl.Assets.*;

@Getter
public enum Piece {

    EMPTY(Status.EMPTY, new TextureRegion(lightEmptyCellTexture)),
    FOCUS(Status.FOCUS, new TextureRegion(lightFocusCellTexture)),
    X_CELL(Status.EMPTY, new TextureRegion(lightXCellTexture)),
    X_CELL_FOCUS(Status.X_FOCUS, new TextureRegion(lightXCellFocusTexture)),
    O_CELL(Status.O, new TextureRegion(lightOCellTexture)),
    O_CELL_FOCUS(Status.O_FOCUS, new TextureRegion(lightOCellFocusTexture)),
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
