package com.utc.btl.screen.impl;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.utc.btl.Main;
import com.utc.btl.entity.Account;
import com.utc.btl.screen.IProfileScreen;
import com.utc.btl.screen.base.impl.BaseScreen;

public class ProfileScreen extends BaseScreen implements IProfileScreen {

    protected Table table;

    protected Label titleLabel;
    protected Label winLabel;
    protected Label lossLabel;
    protected Label drawLabel;

    protected Label win;
    protected Label loss;
    protected Label draw;

    protected Button menuBtn;

    protected Account account;

    public ProfileScreen(Main main) {
        super(main);
    }

    @Override
    public void show() {
        super.show();
        setAccount();
        setValues();
        table.clear();
        setUI();
    }

    @Override
    public void init() {
        table = new Table();

        titleLabel = new Label("Profile", skin);
        winLabel = new Label("Win: ", skin);
        lossLabel = new Label("Loss: ", skin);
        drawLabel = new Label("Draw: ", skin);

        win = new Label("", skin);
        loss = new Label("", skin);
        draw = new Label("", skin);

        menuBtn = new TextButton("Menu", skin);
    }

    @Override
    public void setUI() {
        table.setFillParent(true);
        table.setSize(300, 500);
        table.center();

        table.add(titleLabel).padTop(5).row();
        table.add(winLabel).width(table.getWidth()).padTop(10);
        table.add(win).row();
        table.add(lossLabel).width(table.getWidth()).padTop(10);
        table.add(loss).row();
        table.add(drawLabel).width(table.getWidth()).padTop(10);
        table.add(draw).row();
        table.add(menuBtn).width(table.getWidth()).padTop(10).row();

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
    public void setAccount() {
        this.account = main.loggedInAccount;
    }

    private void setValues() {
        if (account != null) {
            win.setText(account.getWin() + "");
            loss.setText(account.getLoss() + "");
            draw.setText(account.getDraw() + "");
        } else {
            win.setText("123");
            loss.setText("123");
            draw.setText("123");
        }
    }
}
