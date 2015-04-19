package br.pereira.snake.model;

import java.awt.Color;

import br.pereira.snake.view.RenderingContext;

public class Apple extends GameObject {

	public Apple(int x, int y) {
		super(x, y);
	}

	@Override
	public void render(RenderingContext rc, Color color) {
		rc.renderObjectAt(this, color);
	}

}
