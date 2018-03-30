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
}
