package br.pereira.snake.model.snake;

import br.pereira.snake.model.GameObject;
import br.pereira.snake.util.Vector;

public abstract class SnakePart extends GameObject {

	private Vector direction;
	
	public SnakePart(int x, int y, Vector direction) {
		super(x, y);
		this.direction = direction;
	}
	
	public void set(int x, int y, Vector direction) {
		getPosition().set(x, y);
		this.direction = direction;
	}
	
	public Vector getDirection() {
		return direction;
	}
	
	public SnakePart move() {
		getPosition().set(getPosition().add(direction));
		return this;
	}
	
	public SnakePart changeDirection(Vector direction) {
		this.direction = direction;
		return this;
	}
	
	public boolean contains(Vector position) {
		return getPosition().equals(position);
	}
	
	public abstract SnakePart follow(Vector direction, boolean grew);

}
