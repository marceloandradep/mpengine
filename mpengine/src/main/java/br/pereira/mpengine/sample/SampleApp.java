package br.pereira.mpengine.sample;

import br.pereira.mpengine.core.view.GameFrame;

public class SampleApp  {
	
	public static void main(String[] args) {
		SamplePanel panel = new SamplePanel();
		SampleModel model = new SampleModel();
		
		GameFrame frame = new GameFrame("Sample", model, panel, 60);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(GameFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
