package de.android.ayrathairullin.catchtheball.managers;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextManager {
    static BitmapFont font;
    static  float width, height;

    public static void initialize(float width, float height) {
        font = new BitmapFont(Gdx.files.internal("data/fonts/ken.fnt"));
        TextManager.width = width;
        TextManager.height = height;
        font.setColor(Color.RED);
        font.getData().setScale(width / 1400f);
    }

    public static void displayMessage(SpriteBatch batch) {
        float fontWidth = new GlyphLayout(font, "Score: " + GameManager.score).width;
        font.draw(batch, "Score: " + GameManager.score, width - fontWidth - width / 15f, height * .95f);
        font.draw(batch, "High Score: " + GameManager.highScore, width / 40f, height * .95f);
    }
}
