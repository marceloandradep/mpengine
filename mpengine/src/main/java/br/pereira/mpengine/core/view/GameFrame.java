package br.pereira.mpengine.core.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

import br.pereira.mpengine.core.GameModel;
import br.pereira.mpengine.core.GameScreen;
import br.pereira.mpengine.core.gameloop.GameLoop;

public class GameFrame extends JFrame {
	private static final long serialVersionUID = -3459085175978544902L;
	
	private GameLoop loop;

	public GameFrame(String title, final GameModel model, GamePanel panel, int fps) {
		getContentPane().add(panel);
		loop = new GameLoop(fps, new GameScreen(model, panel));
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				model.keyPressed(e);
			}
		});
	}
	
	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		if (b) {
			loop.start();
		}
	}

}
