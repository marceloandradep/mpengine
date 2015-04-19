package br.pereira.snake.model;

import static br.pereira.snake.util.Vector.DOWN;
import static br.pereira.snake.util.Vector.LEFT;
import static br.pereira.snake.util.Vector.RIGHT;
import static br.pereira.snake.util.Vector.UP;

import java.awt.Color;
import java.awt.event.KeyEvent;

import br.pereira.mpengine.core.GameModel;
import br.pereira.snake.model.snake.Snake;
import br.pereira.snake.util.KeyBuffer;
import br.pereira.snake.util.Vector;
import br.pereira.snake.view.RenderingContext;

public class SnakeGame implements GameModel {
	
	private static final Vector STARTING_POSITION = new Vector(3, 0);
	private static final Vector STARTING_DIRECTION = Vector.RIGHT;
	
	private GameState state;
	
	private Snake snake;
	private GameObject apple;
	
	private int numColumns;
	private int numRows;
	
	private int score;
	
	private KeyBuffer buffer;
	
	public SnakeGame(int numColumns, int numRows) {
		this.numColumns = numColumns;
		this.numRows = numRows;
		
		buffer = new KeyBuffer(10);
		
		ready();
	}
	
	public void ready() {
		snake = new Snake(STARTING_POSITION.x(), STARTING_POSITION.y(), STARTING_DIRECTION);
		buffer.clear();
		score = 0;
		state = GameState.READY;
	}
	
	public void start() {
		state = GameState.PLAYING;
		newApple();
	}
	
	public void gameOver() {
		state = GameState.GAMEOVER;
	}
	
	public boolean isReady() {
		return GameState.READY.equals(state);
	}
	
	public boolean isPlaying() {
		return GameState.PLAYING.equals(state);
	}
	
	public boolean isGameOver() {
		return GameState.GAMEOVER.equals(state);
	}
	
	public void newApple() {
		if (apple == null) {
			Vector applePosition = Vector.random(getNumColumns(), getNumRows());
			apple = new Apple(applePosition.x(), applePosition.y());
		}
		
		while (snake.contains(apple.getPosition())) {
			apple.getPosition().setRandom(getNumColumns(), getNumRows());
		}
	}

	public void update(int delta) {
		if (isPlaying()) {
			processInput();
			
			if (hasSnakeCollided()) {
				gameOver();
				return;
			}
			
			boolean grew = hasSnakeEatedApple();
			snake.update(hasSnakeEatedApple());
			
			if (grew) {
				score++;
				newApple();				
			}
		}
	}

	private boolean hasSnakeEatedApple() {
		return snake.nextPosition().equals(apple.getPosition());
	}
	
	private boolean hasSnakeCollided() {
		return snake.contains(snake.nextPosition()) || isPositionOutOfBounds(snake.nextPosition());
	}
	
	private boolean isPositionOutOfBounds(Vector position) {
		return position.x() < 0 || position.y() < 0 || position.x() >= numColumns || position.y() >= numRows;
	}
	
	public void render(RenderingContext rc) {
		snake.render(rc);
		rc.renderTextAtCorner(String.valueOf(score));
		
		if (isPlaying()) {
			apple.render(rc, Color.RED);
		} else if (isReady()) {
			rc.renderTextAtCenter("READY!");
		} else if (isGameOver()) {
			rc.renderTextAtCenter("GAME OVER!");
		}
	}
	
	public int getNumColumns() {
		return numColumns;
	}
	
	public int getNumRows() {
		return numRows;
	}

	public void keyPressed(KeyEvent e) {
		if (isReady()) {
			start();
		} else if (isGameOver()) {
			ready();
		} else {
			buffer.add(e.getKeyCode());			
		}
	}
	
	private void processInput() {
		if (!buffer.isEmpty()) {
			int nextKey = buffer.get();
			
			switch (nextKey) {
				case KeyEvent.VK_LEFT:
					snake.turnTo(LEFT);
					break;
					
				case KeyEvent.VK_RIGHT:
					snake.turnTo(RIGHT);
					break;
					
				case KeyEvent.VK_UP:
					snake.turnTo(UP);
					break;
					
				case KeyEvent.VK_DOWN:
					snake.turnTo(DOWN);
					break;
			}
		}
	}
}
