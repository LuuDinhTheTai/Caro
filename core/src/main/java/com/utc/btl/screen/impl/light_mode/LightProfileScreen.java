package com.utc.btl.screen.impl.light_mode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.utc.btl.Assets;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.ProfileScreen;

import static com.utc.btl.Assets.*;
import static com.utc.btl.constant.Constants.*;

public class LightProfileScreen extends ProfileScreen {

    public LightProfileScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        background = new TextureRegion(lightBackgroundTexture);
        table = new Table();

        titleLabel = new Label("Profile", lightTitleStyle);
        xLabel = new Label("X: ", lightLabelStyle);
        oLabel = new Label("O: ", lightLabelStyle);
        drawLabel = new Label("Draw: ", lightLabelStyle);

        xInf = new Label("", lightInfLabelStyle);
        oInf = new Label("", lightInfLabelStyle);
        drawInf = new Label("", lightInfLabelStyle);

        menuBtn = new TextButton("Menu", lightImageTextButtonStyle);
    }

    @Override
    public void setUI() {
        table.setSize(TABLE_W, TABLE_H);

        table.setPosition((Gdx.graphics.getWidth() - table.getWidth()) / 2,
            (Gdx.graphics.getHeight() - table.getHeight()) / 2);

        table.setBackground(new TextureRegionDrawable(new TextureRegion(Assets.tableBackgroundTexture)));

        table.add(titleLabel).padTop(5).row();

        table.add(xLabel).width(table.getWidth()).padTop(10);
        table.add(xInf).row();
        table.add(oLabel).width(table.getWidth()).padTop(10);
        table.add(oInf).row();
        table.add(drawLabel).padTop(5).row();
        table.add(drawInf).row();

        table.add(menuBtn).width(BIG_BUTTON_W).height(BIG_BUTTON_H).padTop(10).row();

        stage.addActor(table);
    }


    @Override
    public void render(float delta) {
        main.batch.begin();
        main.batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        main.batch.end();
        super.render(delta);
    }
}
