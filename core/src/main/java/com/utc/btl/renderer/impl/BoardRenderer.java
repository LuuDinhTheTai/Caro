package com.utc.btl.renderer.impl;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.utc.btl.board.Piece;
import com.utc.btl.board.Board;
import com.utc.btl.board.Cell;
import com.utc.btl.constant.Constants;
import com.utc.btl.renderer.IBoardRenderer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRenderer implements IBoardRenderer {

    private Board board;
    private float cellSize = 32;
    private float startX = 30 , startY = 30;

    public BoardRenderer(Board board, float boardX, float boardY, float cellSize) {
        this.board = board;
        this.cellSize = cellSize;
        this.startX = boardX;
        this.startY = boardY;
    }

    public BoardRenderer() {
        board = new Board();
    }

    // Trong BoardRenderer.java
    @Override
    public void draw(SpriteBatch batch) {
        for (int row = 0; row < Constants.ROW_SIZE; row++) {
            for (int col = 0; col < Constants.COL_SIZE; col++) {
                Cell cell = board.getBoard()[row][col];
                float x = startX + col * cellSize;
                float y = startY + (Constants.ROW_SIZE - 1 - row) * cellSize;

                // Set vị trí và kích thước cho Cell
                cell.setBounds(x, y, cellSize, cellSize); // Thêm dòng này
                cell.setPosition(x, y); // Hoặc chỉ cần setBounds

                batch.draw(cell.getPiece().getTextureRegion(), x, y);
            }
        }
    }
}
