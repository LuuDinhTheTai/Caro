package com.utc.btl.screen.impl.light_mode;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.utc.btl.Main;
import com.utc.btl.screen.IMenuScreen;
import com.utc.btl.screen.impl.MenuScreen;

import static com.utc.btl.Assets.lightDownButtonTexture;
import static com.utc.btl.Assets.lightUpButtonTexture;

public class LightMenuScreen extends MenuScreen implements IMenuScreen {

    protected Label.LabelStyle labelStyle;
    protected ImageTextButton.ImageTextButtonStyle imageTextButtonStyle;

    public LightMenuScreen(Main main) {
        super(main);
    }

    @Override
    public void init() {
        setLabelStyle();
        setImageTextButtonStyle();

        table = new Table();

        titleLabel = new Label("C-Caro", labelStyle);
        singlePlayerBtn = new ImageTextButton("Single Player", imageTextButtonStyle);
        multiPlayerBtn = new ImageTextButton("Multi Player", imageTextButtonStyle);
        exitBtn = new ImageTextButton("Exit", imageTextButtonStyle);
    }

    private void setLabelStyle() {
        labelStyle = new Label.LabelStyle();
        labelStyle = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
    }

    private void setImageTextButtonStyle() {
        imageTextButtonStyle = new ImageTextButton.ImageTextButtonStyle();
        imageTextButtonStyle.up = new TextureRegionDrawable(lightUpButtonTexture);
        imageTextButtonStyle.down = new TextureRegionDrawable(lightDownButtonTexture);
        imageTextButtonStyle.font = new BitmapFont();
        imageTextButtonStyle.fontColor = Color.WHITE;
    }
}
