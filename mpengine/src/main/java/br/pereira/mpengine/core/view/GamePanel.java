package br.pereira.mpengine.core.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.pereira.mpengine.core.GameRenderer;

public abstract class GamePanel extends JPanel implements GameRenderer {
	private static final long serialVersionUID = 2146112437896690476L;

	public GamePanel() {
		setBackground(Color.BLACK);
	}

	public void render(int delta) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				repaint();
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		render(g);
	}
	
	public abstract void render(Graphics g);
}
