package com.utc.btl.screen.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.utc.btl.Main;
import com.utc.btl.board.BoardRenderer;
import com.utc.btl.board.GameStatus;
import com.utc.btl.board.Piece;
import com.utc.btl.board.impl.Board;
import com.utc.btl.constant.Constants;
import com.utc.btl.screen.GameScreen;
import com.utc.btl.screen.base.impl.BaseScreen;

public class GameScreenImpl extends BaseScreen implements GameScreen {

    private Table hudTable;

    protected Button pauseBtn;
    Board board;
    BoardRenderer boardRenderer;
    private int lastRow;
    private int lastCol;
    private GameStatus gameStatus;

    public GameScreenImpl(Main main) {
        super(main);
        lastRow = -1;
        lastCol = -1;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        handleInput();
        main.batch.begin();
        boardRenderer.render(main.batch);
        main.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void init() {
        hudTable = new Table();
        pauseBtn = new TextButton("Pause", skin);
        board = new Board();
        float cellSize = 32;
        float boardWidth = Constants.COL_SIZE * cellSize;
        float boardHeight = Constants.ROW_SIZE * cellSize;
        float boardX = (Gdx.graphics.getWidth() -boardWidth) / 2f;
        float boardY = (Gdx.graphics.getHeight() - boardHeight) / 2f;

        boardRenderer = new BoardRenderer(board, boardX, boardY, cellSize);
        gameStatus = new GameStatus();
    }

    @Override
    public void setUI() {
        hudTable.top().right();
        hudTable.setFillParent(true);

        hudTable.add(pauseBtn).pad(10).row();

        stage.addActor(hudTable);
    }

    @Override
    public void setListeners() {
        pauseBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.screenController.toMenuScreen();
            }
        });
    }
    private void handleInput() {
        if (Gdx.input.justTouched()) {
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            stage.getCamera().unproject(touchPos);

            float startX = boardRenderer.getStartX();
            float startY = boardRenderer.getStartY();
            float cellSize = boardRenderer.getCellSize();

            int col = (int)((touchPos.x - startX) / cellSize);
            int row = Constants.ROW_SIZE - 1 - (int)((touchPos.y - startY) / cellSize);
            if(col < 0 || row < 0 || col > Constants.COL_SIZE-1|| row > Constants.ROW_SIZE-1) {return;}
            if(board.getCell(row,col) == null) {return;}
            onClick(row,col);
            if (board.getCell(row,col).getPiece() == Piece.EMPTY) {
                board.getCell(row,col).setPiece(Piece.FOCUS);
            }
            hideLastFocus(lastRow,lastCol);
            lastRow = row;
            lastCol = col;
        }
    }
    private void hideLastFocus(int row, int col) {
        if(row == -1 || col == -1){return;}
        if (board.getCell(row,col).getPiece() == Piece.FOCUS) {
            board.getCell(row,col).setPiece(Piece.EMPTY);
        }
    }
    private void onClick(int row, int col) {
        if(!board.makeMove(row,col,gameStatus.player)){
            return;
        }
        if(gameStatus.player == 1){
            gameStatus.player = -1;
        }
        else if(gameStatus.player == -1){
            gameStatus.player = 1;
        }
    }
}
