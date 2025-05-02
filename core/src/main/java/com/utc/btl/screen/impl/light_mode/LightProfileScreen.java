package com.utc.btl.screen.impl.light_mode;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.utc.btl.constant.Assets;
import com.utc.btl.Main;
import com.utc.btl.screen.impl.ProfileScreen;

import static com.utc.btl.constant.Assets.*;
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
        xLabel = new Label("X Win: ", lightLabelStyle);
        oLabel = new Label("O Win: ", lightLabelStyle);
        drawLabel = new Label("Draw: ", lightLabelStyle);

        xInf = new Label("", lightInfLabelStyle);
        oInf = new Label("", lightInfLabelStyle);
        drawInf = new Label("", lightInfLabelStyle);

        menuBtn = new TextButton("Menu", lightImageTextButtonStyle);
    }

    @Override
    public void setUI() {
        table.setFillParent(true);
        table.center();

        table.setBackground(new TextureRegionDrawable(new TextureRegion(Assets.tableBackgroundTexture)));

        table.add(titleLabel).padTop(5).row();

        table.add(xLabel).padTop(10).row();
        table.add(xInf).row();
        table.add(oLabel).padTop(10).row();
        table.add(oInf).row();
        table.add(drawLabel).padTop(10).row();
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
