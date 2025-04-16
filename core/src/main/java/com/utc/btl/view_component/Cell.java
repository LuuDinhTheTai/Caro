package com.utc.btl.view_component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.utc.btl.Main;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cell extends ImageButton {

    private Main main;
    private Piece piece;
    private final ImageButtonStyle style;
    private int row;
    private int col;


    public Cell(Main main, int row, int col) {
        super(imageButtonStyle());
        this.main = main;
        this.piece = Piece.EMPTY;
        this.style = new ImageButtonStyle(super.getStyle());
        this.row = row;
        this.col = col;
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
                main.gamePlayController.move(Cell.this);
            }
        });
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
