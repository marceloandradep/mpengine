package br.pereira.snake.model.snake;

import java.awt.Color;

import br.pereira.snake.util.Vector;
import br.pereira.snake.view.RenderingContext;

public class Tail extends SnakePart {
	
	public Tail(int x, int y, Vector direction) {
		super(x, y, direction);
	}
	
	@Override
	public SnakePart follow(Vector direction, boolean grow) {
		SnakePart partToReturn;
		
		if (grow) {
			partToReturn = new Body(getPosition().x(), getPosition().y(), getDirection()).withTail(this);
		} else {
			partToReturn = this;
		}
		
		partToReturn.move().changeDirection(direction);
		
		return partToReturn;
	}
	
	@Override
	public void render(RenderingContext rc, Color color) {
		rc.renderObjectAt(this, color);
	}
}
