package br.pereira.snake.model;

import java.awt.Color;

import br.pereira.snake.util.Vector;
import br.pereira.snake.view.RenderingContext;

public abstract class GameObject {
	
	private Vector position;
	
	public GameObject() {
		this(0, 0);
	}
	
	public GameObject(int x, int y) {
		this.position = new Vector(x, y);
	}
	
	public Vector getPosition() {
		return position;
	}
	
	public void setPosition(int x, int y) {
		position.set(x, y);
	}
	
	public void setPosition(Vector position) {
		position.set(position);
	}
	
	public abstract void render(RenderingContext rc, Color color);
	
}
