package br.pereira.snake.model.snake;

import java.awt.Color;

import br.pereira.snake.util.Vector;
import br.pereira.snake.view.RenderingContext;

public class Snake {
	
	private static final Color DEFAULT_COLOR = Color.GREEN;
	
	private Head head;
	private Vector direction;
	
	public Snake(int x, int y, Vector direction) {
		head = new Head(x, y, direction);
		this.direction = direction;
	}
	
	public void update(boolean grow) {
		head.follow(direction, grow);
	}
	
	public Vector nextPosition() {
		return head.getPosition().add(direction);
	}
	
	public void render(RenderingContext rc) {
		head.render(rc, DEFAULT_COLOR);
	}
	
	public void turnTo(Vector turnToDirection) {
		if (!turnToDirection.isOpposite(direction)) {
			direction = turnToDirection;
		}
	}
	
	public boolean contains(Vector position) {
		return head.contains(position);
	}

}
