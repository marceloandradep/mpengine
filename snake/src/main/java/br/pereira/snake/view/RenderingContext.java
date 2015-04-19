package br.pereira.snake.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import br.pereira.snake.model.GameObject;

public class RenderingContext {
	
	private Graphics graphics;
	
	private int[] xs;
	private int[] ys;
	
	private Rectangle frame;
	private int cellWidth, cellHeight;
	
	public RenderingContext(Graphics graphics, int screenWidth, int screenHeight, int numColumns, int numRows) {
		this.graphics = graphics;
		this.frame = new Rectangle();
		
		updateMeasures(screenWidth, screenHeight, numColumns, numRows);
	}
	
	private void updateMeasures(int screenWidth, int screenHeight, int numColumns, int numRows) {
		cellWidth = screenWidth / numColumns;
		cellHeight = screenHeight / numRows;
		
		frame.width = cellWidth * numColumns;
		frame.height = cellHeight * numRows;
		frame.x = (screenWidth - frame.width) / 2;
		frame.y = (screenHeight - frame.height) / 2;
		
		int step = frame.x;
		xs = new int[numColumns];
		
		for (int i = 0; i < numColumns; i++) {
			xs[i] = step;
			step += cellWidth;
		}
		
		step = frame.y;
		ys = new int[numRows];
		
		for (int i = 0; i < numRows; i++) {
			ys[i] = step;
			step += cellHeight;
		}
	}
	
	public void renderObjectAt(GameObject object, Color color) {
		graphics.setColor(color);
		graphics.drawRect(xs[object.getPosition().x()], ys[object.getPosition().y()], cellWidth, cellHeight);
	}
	
	public void renderFrame() {
		graphics.setColor(Color.WHITE);
		graphics.drawRect(frame.x, frame.y, frame.width, frame.height);
	}
	
	public void renderTextAtCorner(String text) {
		int width = graphics.getFontMetrics().stringWidth(text);
		
		int x = frame.x + frame.width - width - 10;
		int y = frame.y + 20;
		
		graphics.drawString(text, x, y);
	}
	
	public void renderTextAtCenter(String text) {
		int width = graphics.getFontMetrics().stringWidth(text);
		
		int x = (frame.width - width) / 2 + frame.x;
		int y = frame.height / 2 + frame.y;
		
		graphics.drawString(text, x, y);
	}
	
}
