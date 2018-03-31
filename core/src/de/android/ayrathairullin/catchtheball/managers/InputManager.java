package de.android.ayrathairullin.catchtheball.managers;


import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

import de.android.ayrathairullin.catchtheball.CatchTheBall;
import de.android.ayrathairullin.catchtheball.MenuScreen;

public class InputManager extends InputAdapter {
    OrthographicCamera camera;
    static Vector3 temp = new Vector3();

    public InputManager(OrthographicCamera camera) {
        this.camera = camera;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        temp.set(screenX, screenY, 0);
        camera.unproject(temp);
        float touchX = temp.x;
        float touchY = temp.y;
        GameManager.basket.handleTouch(touchX, touchY);
        handleBackButton(touchX, touchY);
        return false;
    }

    public void handleBackButton(float touchX, float touchY) {
        if((touchX>=GameManager.backButtonSprite.getX())
                && touchX<=(GameManager.backButtonSprite.getX() + GameManager.backButtonSprite.getWidth())
                && (touchY>=GameManager.backButtonSprite.getY())
                && touchY<=(GameManager.backButtonSprite.getY()+GameManager.backButtonSprite.getHeight()) ){
            CatchTheBall.game.setScreen(new MenuScreen(CatchTheBall.game));
        }
    }
}
