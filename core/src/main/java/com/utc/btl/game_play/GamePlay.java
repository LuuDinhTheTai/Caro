package com.utc.btl.game_play;

import com.utc.btl.game_play.validator.IValidator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GamePlay implements IGamePlay {

    private IValidator validator;

    public GamePlay(IValidator validator) {
        this.validator = validator;
    }

    @Override
    public void move() {
        handleInput();
    }

    private void handleInput() {
//        if (Gdx.input.justTouched()) {
//            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
//            stage.getCamera().unproject(touchPos);
//
//            float startX = boardRenderer.getStartX();
//            float startY = boardRenderer.getStartY();
//            float cellSize = boardRenderer.getCellSize();
//
//            int col = (int)((touchPos.x - startX) / cellSize);
//            int row = Constants.ROW_SIZE - 1 - (int)((touchPos.y - startY) / cellSize);
//            if(col < 0 || row < 0 || col > Constants.COL_SIZE-1|| row > Constants.ROW_SIZE-1) {return;}
//            if(board.getCell(row,col) == null) {return;}
//            onClick(row,col);
//            if (board.getCell(row,col).getPiece() == Piece.EMPTY) {
//                board.getCell(row,col).setPiece(Piece.FOCUS);
//            }
//            hideLastFocus(lastRow,lastCol);
//            lastRow = row;
//            lastCol = col;
//        }
    }

    private void hideLastFocus(int row, int col) {
//        if(row == -1 || col == -1){return;}
//        if (board.getCell(row,col).getPiece() == Piece.FOCUS) {
//            board.getCell(row,col).setPiece(Piece.EMPTY);
//        }
    }
    private void onClick(int row, int col) {
//        if(!board.makeMove(row,col,gameStatus.player)){
//            return;
//        }
//        if(gameStatus.player == 1){
//            gameStatus.player = -1;
//        }
//        else if(gameStatus.player == -1){
//            gameStatus.player = 1;
//        }
    }
}
