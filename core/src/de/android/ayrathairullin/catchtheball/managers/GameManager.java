package de.android.ayrathairullin.catchtheball.managers;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.android.ayrathairullin.catchtheball.gameobjects.Basket;

public class GameManager {
    private static final float BASKET_RESIZE_FACTOR = 3000;

    public static Basket basket;
    static Texture basketTexture;
    public static Sprite backgroundSprite;
    public static Texture backgroundTexture;

    public static void initialize(float width, float height) {
        basket = new Basket();
        basketTexture = new Texture(Gdx.files.internal("data/basket.png"));
        basket.basketSprite = new Sprite(basketTexture);
        basket.basketSprite.setSize(basket.basketSprite.getWidth() * (width / BASKET_RESIZE_FACTOR),
        basket.basketSprite.getHeight() * width / BASKET_RESIZE_FACTOR);
        basket.setPosition(0, 0);

        backgroundTexture = new Texture(Gdx.files.internal("data/background.jpg"));
        backgroundSprite = new Sprite(backgroundTexture);
        backgroundSprite.setSize(width, height);
    }

    public static void renderGame(SpriteBatch batch) {
        backgroundSprite.draw(batch);
        basket.render(batch);
    }

    public static void dispose() {
        backgroundTexture.dispose();
        basketTexture.dispose();
    }
}
