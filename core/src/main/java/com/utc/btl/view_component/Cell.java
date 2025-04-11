package com.utc.btl.view_component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cell extends ImageButton {

    private Piece piece;
    private final ImageButtonStyle style;

    // FIXME: This is temp rule for multi player mode
    private static Piece.Status currentPlayer = Piece.Status.X; // Theo dõi lượt hiện tại
    private static Cell focusedCell = null;    // Cell đang ở trạng thái FOCUS
    private static Cell lastPlayedCell = null; // Cell được đánh (play) cuối cùng

    public Cell() {
        super(imageButtonStyle());
        this.piece = Piece.EMPTY;
        this.style = new ImageButtonStyle(super.getStyle());
        updateStyle();
        setListeners();
    }

    private static ImageButtonStyle imageButtonStyle() {
        ImageButtonStyle style = new ImageButtonStyle();
        style.up = new TextureRegionDrawable(Piece.EMPTY.getTextureRegion());
        style.down = new TextureRegionDrawable(Piece.EMPTY.getTextureRegion());
        return style;
    }

    private void setListeners() {
        addListener(new InputListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
            }
        });

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                handleClick();
            }
        });
    }

    // FIXME: This is temp logic for multi player mode
    private void handleClick() {
        // Chỉ cho phép focus nếu cell trống (EMPTY)
        if (piece == Piece.EMPTY) {
            // Nếu có cell khác đang ở trạng thái FOCUS (và không phải là cell được đánh cuối cùng) thì xóa focus của cell đó
            if (focusedCell != null && focusedCell != this && focusedCell != lastPlayedCell) {
                focusedCell.setPiece(Piece.EMPTY);
                focusedCell.updateStyle();
            }
            setPiece(Piece.FOCUS);
            updateStyle();
            focusedCell = this;
        }
        // Nếu cell đang ở trạng thái FOCUS, click lần 2 sẽ chuyển sang đánh
        else if (piece == Piece.FOCUS) {
            if (focusedCell == this) {
                Piece newPiece = currentPlayer == Piece.Status.X ? Piece.X_CELL_FOCUS : Piece.O_CELL_FOCUS;
                setPiece(newPiece);
                updateStyle();
                lastPlayedCell = this;
                focusedCell = null;
                // Chuyển lượt chơi
                currentPlayer = currentPlayer == Piece.Status.X ? Piece.Status.O : Piece.Status.X;
            }
        }
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        updateStyle();
    }

    private void updateStyle() {
        style.up = new TextureRegionDrawable(piece.getTextureRegion());
        style.down = new TextureRegionDrawable(piece.getTextureRegion());
        setStyle(style);
    }
}
