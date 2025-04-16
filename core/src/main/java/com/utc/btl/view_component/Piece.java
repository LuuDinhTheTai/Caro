package com.utc.btl.view_component;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.Getter;

import static com.utc.btl.Assets.*;

@Getter
public enum Piece {

    EMPTY(Status.EMPTY, new TextureRegion(lightEmptyCellTexture)),
    FOCUS(Status.FOCUS, new TextureRegion(lightFocusCellTexture)),
    X(Status.X, new TextureRegion(lightXCellTexture)),
    X_FOCUS(Status.X, new TextureRegion(lightXCellFocusTexture)),
    O(Status.O, new TextureRegion(lightOCellTexture)),
    O_FOCUS(Status.O, new TextureRegion(lightOCellFocusTexture)),
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
        O,
    }
}
