package com.utc.btl.board.impl;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.utc.btl.board.ICell;
import com.utc.btl.board.Piece;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cell implements ICell {

    private float x;
    private float y;
    private Piece piece;

    @Override
    public void move() {

    }

    public void draw(SpriteBatch batch) {
        // Vẽ ô trống hoặc highlight
        batch.draw(Piece.EMPTY_CELL.getTextureRegion(), x, y, 40, 40);

        // Vẽ quân cờ nếu có
        if (piece != null && piece != Piece.EMPTY_CELL) {
            batch.draw(piece.getTextureRegion(), x, y, 40, 40);
        }
    }
}
