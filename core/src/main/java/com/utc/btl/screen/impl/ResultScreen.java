package com.utc.btl.screen.impl;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.utc.btl.Main;
import com.utc.btl.screen.IResultScreen;
import com.utc.btl.screen.base.impl.BaseScreen;

import static com.utc.btl.constant.Constants.BIG_BUTTON_H;
import static com.utc.btl.constant.Constants.BIG_BUTTON_W;

public class ResultScreen extends BaseScreen implements IResultScreen {

    protected String message;

    protected Table table;
    protected Label titleLabel;
    protected Label messageLabel;

    protected Button menuBtn;

    public ResultScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        table = new Table();
        titleLabel = new Label("Result", skin);
        messageLabel = new Label("", skin);
        menuBtn = new TextButton("Menu", skin);
    }

    @Override
    public void setUI() {
        table.setFillParent(true);
        table.setSize(300, 400);
        table.center();

        table.add(titleLabel).padTop(5).row();
        table.add(messageLabel).padTop(5).row();
        table.add(menuBtn).width(BIG_BUTTON_W).height(BIG_BUTTON_H).padTop(10).row();

        stage.addActor(table);
    }

    @Override
    public void setListeners() {
        menuBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.screenController.toMenuScreen();
            }
        });
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
        messageLabel.setText(message);
    }
}
