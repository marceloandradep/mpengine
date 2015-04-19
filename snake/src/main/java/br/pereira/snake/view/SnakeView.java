package br.pereira.snake.view;

import java.awt.Graphics;

import br.pereira.mpengine.core.view.GamePanel;
import br.pereira.snake.model.SnakeGame;

public class SnakeView extends GamePanel {
	private static final long serialVersionUID = 5475441070767725309L;
	
	private SnakeGame game;
	
	public SnakeView(SnakeGame game) {
		this.game = game;
	}

	@Override
	public void render(Graphics g) {
		RenderingContext rc = new RenderingContext(g, getWidth(), getHeight(), game.getNumColumns(), game.getNumRows());
		game.render(rc);
		
		rc.renderFrame();
	}

}
