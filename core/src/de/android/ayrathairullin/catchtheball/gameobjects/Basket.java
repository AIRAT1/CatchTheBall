package de.android.ayrathairullin.catchtheball.gameobjects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Basket {
    public Sprite basketSprite;
    public Rectangle basketRectangle = new Rectangle();

    public void render(SpriteBatch batch) {
        basketSprite.draw(batch);
    }

    public void setPosition(float x, float y) {
        basketSprite.setPosition(x, y);
        basketRectangle.setPosition(x, y);
    }

    public void handleTouch(float x, float y) {
        if (x - (basketSprite.getWidth() / 2) > 0.0 && x + (basketSprite.getWidth()) <= Gdx.graphics.getWidth()) {
            setPosition(x - (basketSprite.getWidth() / 2), 0);
        }else if (x + (basketSprite.getWidth()) > Gdx.graphics.getWidth()) {
            setPosition(Gdx.graphics.getWidth() - basketSprite.getWidth(), 0);
        }else {
            setPosition(0, 0);
        }
    }
}
