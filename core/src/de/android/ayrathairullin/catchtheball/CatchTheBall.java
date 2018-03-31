package de.android.ayrathairullin.catchtheball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.android.ayrathairullin.catchtheball.managers.GameManager;
import de.android.ayrathairullin.catchtheball.managers.InputManager;

public class CatchTheBall implements Screen {
	SpriteBatch batch;
	OrthographicCamera camera;
	public static MainGame game;

	public CatchTheBall(MainGame game) {
		CatchTheBall.game = game;

		float height = Gdx.graphics.getHeight();
		float width = Gdx.graphics.getWidth();
		camera = new OrthographicCamera(width, height);
		camera.setToOrtho(false);
		batch = new SpriteBatch();
		GameManager.initialize(width, height);
		Gdx.input.setInputProcessor(new InputManager(camera));
	}

	@Override
	public void dispose () {
		batch.dispose();
		GameManager.backgroundMusic.stop();
		GameManager.dispose();
	}

	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		GameManager.renderGame(batch);
		batch.end();
	}

	@Override
	public void show() {

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {
		dispose();
	}
}
