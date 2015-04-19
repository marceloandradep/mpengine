package br.pereira.snake.util;

public class Vector {
	
	public static final Vector RIGHT = new Vector(1, 0);
	public static final Vector LEFT = new Vector(-1, 0);
	public static final Vector UP = new Vector(0, -1);
	public static final Vector DOWN = new Vector(0, 1);
	
	private int x, y;

	public Vector() {
		this(0, 0);
	}
	
	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Vector random(int xLimit, int yLimit) {
		return new Vector().setRandom(xLimit, yLimit);
	}
	
	public Vector setRandom(int xLimit, int yLimit) {
		x = (int)(Math.random() * xLimit);
		y = (int)(Math.random() * yLimit);
		return this;
	}
	
	public Vector add(Vector anotherVector) {
		return new Vector(this.x + anotherVector.x, this.y + anotherVector.y);
	}
	
	public Vector getOpposite() {
		return new Vector(-this.x, -this.y);
	}
	
	public boolean isOpposite(Vector anotherVector) {
		return (this.x + anotherVector.x) == 0 && (this.y + anotherVector.y) == 0;
	}
	
	public int x() {
		return x;
	}
	
	public int y() {
		return y;
	}
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(Vector position) {
		set(position.x, position.y);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector) {
			Vector anotherVector = (Vector) obj;
			
			return anotherVector.x == this.x && anotherVector.y == this.y;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}

}
