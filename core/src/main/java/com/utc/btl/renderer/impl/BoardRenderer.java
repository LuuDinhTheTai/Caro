package com.utc.btl.renderer.impl;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.utc.btl.board.Piece;
import com.utc.btl.board.impl.Board;
import com.utc.btl.board.impl.Cell;
import com.utc.btl.constant.Constants;
import com.utc.btl.renderer.IBoardRenderer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRenderer implements IBoardRenderer {

    private Board board;
    private float cellSize;
    private float startX, startY;

    public BoardRenderer(Board board, float boardX, float boardY, float cellSize) {
        this.board = board;
        this.cellSize = cellSize;
        this.startX = boardX;
        this.startY = boardY;
    }

    @Override
    public void draw(SpriteBatch batch) {
        for (int row = 0; row < Constants.ROW_SIZE; row++) {
            for (int col = 0; col < Constants.COL_SIZE; col++) {
                Cell cell = board.getCell(row, col);
                Piece piece = cell.getPiece();
                float x = startX + col * cellSize;
                float y = startY + (Constants.ROW_SIZE - 1 - row) * cellSize;

                batch.draw(piece.getTextureRegion(), x, y, cellSize, cellSize);
            }
        }
    }
}
