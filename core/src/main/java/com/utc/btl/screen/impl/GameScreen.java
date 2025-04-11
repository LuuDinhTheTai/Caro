package com.utc.btl.screen.impl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.utc.btl.Main;
import com.utc.btl.view_component.Board;
import com.utc.btl.screen.IGameScreen;
import com.utc.btl.screen.base.impl.BaseScreen;

public class GameScreen extends BaseScreen implements IGameScreen {

    protected Table hudTable;
    protected Table boardTable;

    protected Button pauseBtn;

    protected Board board;

    public GameScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        hudTable = new Table();
        boardTable = new Table();
        pauseBtn = new TextButton("Pause", skin);
    }

    @Override
    public void show() {
        super.show();
        clearScreen();
        board = new Board();
        boardTable = new Table();
        setBoardTableUI();
        setUI();
        setDragBoardListener();
    }

    @Override
    public void setUI() {
        hudTable.top().right();
        hudTable.setFillParent(true);

        hudTable.add(pauseBtn).pad(10).row();

        stage.addActor(hudTable);
    }

    private void setBoardTableUI() {
        boardTable.left();
        boardTable.setFillParent(true);
        boardTable.setSize(Gdx.graphics.getWidth() * 0.7f, Gdx.graphics.getHeight());

        int row = board.getBoard().length;
        int col = board.getBoard()[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boardTable.add(board.getBoard()[i][j]);
            }
            boardTable.row();
        }

        stage.addActor(boardTable);
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

    private void setDragBoardListener() {
        boardTable.addListener(new DragListener() {
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                boardTable.moveBy(getDeltaX(), getDeltaY());
            }
        });
    }

    private void clearScreen() {
        stage.clear();
        hudTable.clear();
        boardTable.clear();
    }
}
