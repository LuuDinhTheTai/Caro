package com.utc.btl.view_component;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import lombok.Getter;

import static com.utc.btl.constant.Assets.*;

@Getter
public enum Piece {

    EMPTY(Status.EMPTY, new TextureRegion(lightEmptyCellTexture)),
    FOCUS(Status.FOCUS, new TextureRegion(lightFocusCellTexture)),
    X(Status.X, new TextureRegion(lightXCellTexture)),
    X_FOCUS(Status.X_FOCUS, new TextureRegion(lightXCellFocusTexture)),
    O(Status.O, new TextureRegion(lightOCellTexture)),
    O_FOCUS(Status.O_FOCUS, new TextureRegion(lightOCellFocusTexture)),
    ;

    private Status status;
    private TextureRegion textureRegion;

    Piece(Status status, TextureRegion textureRegion) {
        this.status = status;
        this.textureRegion = textureRegion;
    }

    public boolean equals(Piece other) {
        if (this.status == other.status) {
            return true;
        }
        if (this.status == Status.X && other.status == Status.X_FOCUS) {
            return true;
        }
        if (this.status == Status.O && other.status == Status.O_FOCUS) {
            return true;
        }
        return false;
    }

    public boolean isX() {
        if (this.status == Status.X || this.status == Status.X_FOCUS) {
            return true;
        }
        return false;
    }

    public boolean isO() {
        if (this.status == Status.O || this.status == Status.O_FOCUS) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return this.status == Status.EMPTY;
    }

    public boolean isFocus() {
        return this.status == Status.FOCUS;
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
