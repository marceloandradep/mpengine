package br.pereira.snake.util;

public class KeyBuffer {
	
	private int[] buffer;
	
	private int beginIndex;
	private int endIndex;
	
	private int length;
	
	public KeyBuffer(int capacity) {
		if (capacity > 0) {
			buffer = new int[capacity];
			beginIndex = endIndex = length = 0;			
		} else {
			throw new IllegalArgumentException("Capacidade deve ser maior do que zero.");
		}
	}
	
	public void clear() {
		beginIndex = endIndex = length = 0;
	}
	
	public void add(int keyCode) {
		if (!isFull()) {
			buffer[endIndex] = keyCode;
			endIndex = (endIndex + 1) % buffer.length;
			length++;
		}
	}
	
	public int get() {
		if (!isEmpty()) {
			int value = buffer[beginIndex];
			
			beginIndex = (beginIndex + 1) % buffer.length;
			length--;
			
			return value;
		}
		
		return -1;
	}
	
	public int length() {
		return length;
	}
	
	public boolean isFull() {
		return length == buffer.length;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}

}
