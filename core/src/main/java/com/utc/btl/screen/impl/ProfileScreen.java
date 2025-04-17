package com.utc.btl.screen.impl;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.utc.btl.Main;
import com.utc.btl.entity.Session;
import com.utc.btl.screen.IProfileScreen;
import com.utc.btl.screen.base.impl.BaseScreen;

public class ProfileScreen extends BaseScreen implements IProfileScreen {

    protected Table table;

    protected Label titleLabel;
    protected Label xLabel;
    protected Label oLabel;
    protected Label drawLabel;

    protected Label xInf;
    protected Label oInf;
    protected Label drawInf;

    protected Button menuBtn;

    protected Session session;

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
        xLabel = new Label("X: ", skin);
        oLabel = new Label("O: ", skin);
        drawLabel = new Label("Draw: ", skin);

        xInf = new Label("", skin);
        oInf = new Label("", skin);
        drawInf = new Label("", skin);

        menuBtn = new TextButton("Menu", skin);
    }

    @Override
    public void setUI() {
        table.setFillParent(true);
        table.setSize(300, 400);
        table.center();

        table.add(titleLabel).padTop(5).row();
        table.add(xLabel).width(table.getWidth()).padTop(10);
        table.add(xInf).row();
        table.add(oLabel).width(table.getWidth()).padTop(10);
        table.add(oInf).row();
        table.add(drawLabel).padTop(5).row();
        table.add(drawInf).row();
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
        this.session = main.session;
    }

    private void setValues() {
        xInf.setText(session.getXWin());
        oInf.setText(session.getOWin());
        drawInf.setText(session.getDraw());
    }
}
