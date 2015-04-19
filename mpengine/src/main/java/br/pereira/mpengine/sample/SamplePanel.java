package br.pereira.mpengine.sample;

import java.awt.Graphics;

import br.pereira.mpengine.core.view.GamePanel;

public class SamplePanel extends GamePanel {
	private static final long serialVersionUID = 7675702051510094505L;

	@Override
	public void render(Graphics g) {
		g.drawOval(50, 50, 50, 50);
	}
	
}
