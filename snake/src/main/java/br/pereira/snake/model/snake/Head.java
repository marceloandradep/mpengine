package br.pereira.snake.model.snake;

import java.awt.Color;

import br.pereira.snake.util.Vector;
import br.pereira.snake.view.RenderingContext;

public class Head extends SnakePart {
	
	private SnakePart next;
	
	public Head(int x, int y, Vector direction) {
		super(x, y, direction);
		next = new Body(x - 1, y, direction).withTail();
	}
	
	@Override
	public SnakePart follow(Vector direction, boolean grow) {
		changeDirection(direction).move();
		next = next.follow(getDirection(), grow);
		
		return this;
	}
	
	@Override
	public boolean contains(Vector position) {
		if (!super.contains(position)) {
			return next.contains(position);
		} else {
			return true;
		}
	}
	
	@Override
	public void render(RenderingContext rc, Color color) {
		rc.renderObjectAt(this, color);
		next.render(rc, color);
	}

}
