package com.utc.btl;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import static com.utc.btl.constant.Constants.ERROR;
import static com.utc.btl.constant.Constants.INFO;

public class Assets {

    // SKIN
    public static Skin skin;

    // BACKGROUND
    public static Texture lightBackgroundTexture;
    public static Texture darkBacgroundTexture;
    public static Texture lightTextfieldBackgroundTexture;
    public static Texture darkTextfieldBackgroundTexture;
    public static Texture tableBackgroundTexture;

    // BUTTON
    public static Texture lightUpButtonTexture;
    public static Texture lightDownButtonTexture;
    public static Texture darkUpButtonTexture;
    public static Texture darkDownButtonTexture;
    public static Texture disableButtonTexture;

    // CELL
    public static Texture lightXCellTexture;
    public static Texture lightXCellFocusTexture;
    public static Texture lightOCellTexture;
    public static Texture lightOCellFocusTexture;
    public static Texture lightEmptyCellTexture;
    public static Texture lightFocusCellTexture;
    public static Texture darkXCellTexture;
    public static Texture darkXCellFocusTexture;
    public static Texture darkOCellTexture;
    public static Texture darkOCellFocusTexture;
    public static Texture darkEmptyCellTexture;
    public static Texture darkFocusCellTexture;

    // FONT
    public static BitmapFont WHITE_16;
    public static BitmapFont WHITE_24;
    public static BitmapFont WHITE_32;
    public static BitmapFont WHITE_48;
    public static BitmapFont WHITE_64;
    public static BitmapFont BLACK_16;
    public static BitmapFont BLACK_24;
    public static BitmapFont BLACK_32;
    public static BitmapFont BLACK_48;
    public static BitmapFont BLACK_64;
    public static BitmapFont BLUE_16;
    public static BitmapFont BLUE_32;
    public static BitmapFont BLUE_48;
    public static BitmapFont BLUE_64;

    // STYLE
    public static Label.LabelStyle lightTitleStyle;
    public static Label.LabelStyle darkTitleStyle;
    public static Label.LabelStyle lightLabelStyle;
    public static Label.LabelStyle darkLabelStyle;
    public static Label.LabelStyle lightInfLabelStyle;
    public static TextField.TextFieldStyle lightTextfieldStyle;
    public static TextField.TextFieldStyle darkTextfieldStyle;
    public static ImageTextButton.ImageTextButtonStyle lightImageTextButtonStyle;
    public static ImageTextButton.ImageTextButtonStyle darkImageTextButtonStyle;

    public static void load() {
        Gdx.app.log(INFO, "Assets loading...");

        try {
            // SKIN
            skin = new Skin(Gdx.files.internal("uiskin.json"));

            // BACKGROUND
            lightBackgroundTexture = loadTexture("background/lm_background.png");
            darkBacgroundTexture = loadTexture("background/dm_background.png");
            tableBackgroundTexture = getTableBackgroundTexture();

            // BUTTON
            lightUpButtonTexture = loadTexture("main/lm_up_button.png");
            lightDownButtonTexture = loadTexture("main/lm_down_button.png");
            darkUpButtonTexture = loadTexture("main/dm_up_button.png");
            darkDownButtonTexture = loadTexture("main/dm_down_button.png");
            disableButtonTexture = loadTexture("main/disable_button.png");

            // CELL
            lightXCellTexture = loadTexture("light_mode/lm_X_cell.png");
            lightXCellFocusTexture = loadTexture("light_mode/lm_X_cell_focus.png");
            lightOCellTexture = loadTexture("light_mode/lm_O_cell.png");
            lightOCellFocusTexture = loadTexture("light_mode/lm_O_cell_focus.png");
            lightEmptyCellTexture = loadTexture("light_mode/lm_cell.png");
            lightFocusCellTexture = loadTexture("light_mode/lm_cell_focus.png");

            darkXCellTexture = loadTexture("dark_mode/dm_X_cell.png");
            darkXCellFocusTexture = loadTexture("dark_mode/dm_X_cell_focus.png");
            darkOCellTexture = loadTexture("dark_mode/dm_O_cell.png");
            darkOCellFocusTexture = loadTexture("dark_mode/dm_O_cell_focus.png");
            darkEmptyCellTexture = loadTexture("dark_mode/dm_cell.png");
            darkFocusCellTexture = loadTexture("dark_mode/dm_cell_focus.png");

            // FONT
            WHITE_16 = loadFont("font/VT323-Regular.ttf", 16, Color.WHITE);
            WHITE_24 = loadFont("font/VT323-Regular.ttf", 24, Color.WHITE);
            WHITE_32 = loadFont("font/VT323-Regular.ttf", 32, Color.WHITE);
            WHITE_48 = loadFont("font/VT323-Regular.ttf", 48, Color.WHITE);
            WHITE_64 = loadFont("font/VT323-Regular.ttf", 64, Color.WHITE);
            BLACK_16 = loadFont("font/VT323-Regular.ttf", 16, Color.BLACK);
            BLACK_24 = loadFont("font/VT323-Regular.ttf", 24, Color.BLACK);
            BLACK_32 = loadFont("font/VT323-Regular.ttf", 32, Color.BLACK);
            BLACK_48 = loadFont("font/VT323-Regular.ttf", 48, Color.BLACK);
            BLACK_64 = loadFont("font/VT323-Regular.ttf", 64, Color.BLACK);
            BLUE_16 = loadFont("font/VT323-Regular.ttf", 16, Color.BLUE);
            BLUE_32 = loadFont("font/VT323-Regular.ttf", 32, Color.BLUE);
            BLUE_48 = loadFont("font/VT323-Regular.ttf", 48, Color.BLUE);
            BLUE_64 = loadFont("font/VT323-Regular.ttf", 64, Color.BLUE);

            // STYLE
            lightTitleStyle = getLightTitleStyle();
            darkTitleStyle = getDarkTitleStyle();
            lightLabelStyle = getLightLabelStyle();
            darkLabelStyle = getDarkLabelStyle();
            lightInfLabelStyle = getLightInfLabelStyle();
            lightTextfieldStyle = getLightTextFieldStyle();
            darkTextfieldStyle = getDarkTextFieldStyle();
            lightImageTextButtonStyle = getLightImageTextButtonStyle();
            darkImageTextButtonStyle = getDarkImageTextButtonStyle();

        } catch (Exception e) {
            Gdx.app.error(ERROR, "Caused by: ", e);
        }
    }

    private static Texture loadTexture(String file) {
        return new Texture(Gdx.files.internal(file));
    }

    private static BitmapFont loadFont(String filePath, int size, Color color) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(filePath));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        parameter.color = color;

        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();

        return font;
    }

    private static Texture getTableBackgroundTexture() {
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);

        pixmap.setColor(new Color(0, 0, 0, 0.7f));
        pixmap.fill();

        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return texture;
    }

    private static Label.LabelStyle getLightTitleStyle() {
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = WHITE_64;
        style.fontColor = Color.BLACK;
        return style;
    }

    private static Label.LabelStyle getDarkTitleStyle() {
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = WHITE_64;
        style.fontColor = Color.WHITE;
        return style;
    }

    private static Label.LabelStyle getLightLabelStyle() {
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = WHITE_16;
        return style;
    }

    private static Label.LabelStyle getDarkLabelStyle() {
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = WHITE_16;
        style.fontColor = Color.WHITE;
        return style;
    }

    private static TextField.TextFieldStyle getLightTextFieldStyle() {
        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        style.font = BLACK_32;
        style.fontColor = Color.BLACK;

        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.LIGHT_GRAY);
        pixmap.fill();
        style.background = new TextureRegionDrawable(new TextureRegion(new Texture(pixmap)));
        pixmap.dispose();

        return style;
    }

    private static TextField.TextFieldStyle getDarkTextFieldStyle() {
        TextField.TextFieldStyle style = new TextField.TextFieldStyle();
        style.font = WHITE_16;
        style.fontColor = Color.WHITE;
        return style;
    }

    private static Label.LabelStyle getLightInfLabelStyle() {
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = WHITE_24;
        style.fontColor = Color.WHITE;
        return style;
    }

    private static ImageTextButton.ImageTextButtonStyle getLightImageTextButtonStyle() {
        ImageTextButton.ImageTextButtonStyle style = new ImageTextButton.ImageTextButtonStyle();

        style.up = new TextureRegionDrawable(new TextureRegion(lightUpButtonTexture));
        style.down = new TextureRegionDrawable(new TextureRegion(lightDownButtonTexture));
        style.disabled = new TextureRegionDrawable(new TextureRegion(disableButtonTexture));

        style.font = BLACK_24;

        return style;
    }

    private static ImageTextButton.ImageTextButtonStyle getDarkImageTextButtonStyle() {
        ImageTextButton.ImageTextButtonStyle style = new ImageTextButton.ImageTextButtonStyle();

        style.up = new TextureRegionDrawable(new TextureRegion(darkUpButtonTexture));
        style.down = new TextureRegionDrawable(new TextureRegion(darkDownButtonTexture));
        style.disabled = new TextureRegionDrawable(new TextureRegion(disableButtonTexture));

        style.font = WHITE_24;
//        style.fontColor = Color.WHITE;

        return style;
    }
//    private static Texture createRoundedRectTexture(int width, int height, int radius, Color color) {
//        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
//
//        pixmap.setBlending(Pixmap.Blending.None);
//        pixmap.setColor(0, 0, 0, 0);
//        pixmap.fill();
//
//        pixmap.setBlending(Pixmap.Blending.SourceOver);
//        pixmap.setColor(color);
//
//
//        pixmap.fillRectangle(radius, 0, width - 2 * radius, height);
//        pixmap.fillRectangle(0, radius, width, height - 2 * radius);
//
//
//        pixmap.fillCircle(radius, radius, radius);
//        pixmap.fillCircle(width - radius, radius, radius);
//        pixmap.fillCircle(radius, height - radius, radius);
//        pixmap.fillCircle(width - radius, height - radius, radius);
//
//        Texture texture = new Texture(pixmap);
//        pixmap.dispose();
//        return texture;
//    }
}
