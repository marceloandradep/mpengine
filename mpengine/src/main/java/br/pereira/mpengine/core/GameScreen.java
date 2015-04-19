package br.pereira.mpengine.core;

import br.pereira.mpengine.core.gameloop.GameLoopListener;

public class GameScreen implements GameLoopListener {
	
	private GameModel model;
	private GameRenderer renderer;
	
	public GameScreen(GameModel model, GameRenderer renderer) {
		this.model = model;
		this.renderer = renderer;
	}

	public void update(int delta) {
		model.update(delta);
		renderer.render(delta);
	}

}
