package de.android.ayrathairullin.catchtheball.gameobjects;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Basket {
    public Sprite basketSprite;

    public void render(SpriteBatch batch) {
        basketSprite.draw(batch);
    }

    public void setPosition(float x, float y) {
        basketSprite.setPosition(x, y);
    }

    public void handleTouch(float x, float y) {
        if (x - (basketSprite.getWidth() / 2) > 0.0) {
            setPosition(x - (basketSprite.getWidth() / 2), 0);
        }else {
            setPosition(0, 0);
        }
    }
}
