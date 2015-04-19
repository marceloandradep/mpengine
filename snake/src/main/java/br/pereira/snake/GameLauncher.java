package br.pereira.snake;

import br.pereira.mpengine.core.view.GameFrame;
import br.pereira.snake.model.SnakeGame;
import br.pereira.snake.view.SnakeView;

public class GameLauncher {
	
	public static void main(String[] args) {
		SnakeGame snakeGame = new SnakeGame(30, 30);
		SnakeView snakeView = new SnakeView(snakeGame);
		
		GameFrame frame = new GameFrame("Snake", snakeGame, snakeView, 10);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(GameFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
