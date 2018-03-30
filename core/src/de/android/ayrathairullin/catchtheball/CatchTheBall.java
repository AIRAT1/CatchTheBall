package de.android.ayrathairullin.catchtheball;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.android.ayrathairullin.catchtheball.managers.GameManager;
import de.android.ayrathairullin.catchtheball.managers.InputManager;

public class CatchTheBall extends ApplicationAdapter {
	SpriteBatch batch;
	OrthographicCamera camera;

	public CatchTheBall() {
		Gdx.input.setInputProcessor(new InputManager(camera));
	}

	@Override
	public void create () {
		float height = Gdx.graphics.getHeight();
		float width = Gdx.graphics.getWidth();
		camera = new OrthographicCamera(width, height);
		camera.setToOrtho(false);
		batch = new SpriteBatch();
		GameManager.initialize(width, height);
	}

	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();
		GameManager.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		GameManager.renderGame(batch);
		batch.end();
	}
}
