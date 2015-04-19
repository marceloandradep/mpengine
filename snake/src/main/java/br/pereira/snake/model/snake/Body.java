package br.pereira.snake.model.snake;

import java.awt.Color;

import br.pereira.snake.util.Vector;
import br.pereira.snake.view.RenderingContext;

public class Body extends SnakePart {
	
	private SnakePart next;
	
	public Body(int x, int y, Vector direction) {
		super(x, y, direction);
	}
	
	public Body withTail() {
		Vector tailPosition = getPosition().add(getDirection().getOpposite());
		next = new Tail(tailPosition.x(), tailPosition.y(), getDirection());
		return this;
	}
	
	public Body withTail(SnakePart tail) {
		next = tail;
		return this;
	}
	
	@Override
	public SnakePart follow(Vector direction, boolean grow) {
		next = next.follow(getDirection(), grow);
		move().changeDirection(direction);
		
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
