package br.pereira.mpengine.sample;

import java.awt.event.KeyEvent;

import br.pereira.mpengine.core.GameModel;

public class SampleModel implements GameModel {

	public void update(int delta) {
		System.out.println(delta);
	}

	public void keyPressed(KeyEvent e) {
		
	}

}
