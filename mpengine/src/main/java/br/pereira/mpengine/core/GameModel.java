package br.pereira.mpengine.core;

import java.awt.event.KeyEvent;

public interface GameModel {
	
	public void update(int delta);
	public void keyPressed(KeyEvent e);

}
