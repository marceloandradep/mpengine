package br.pereira.mpengine.core.gameloop;


public class GameLoop extends Thread {
	
	private int delay;
	private GameLoopListener listener;
	
	public GameLoop(int fps, GameLoopListener listener) {
		this.delay = 1000 / fps;
		this.listener = listener;
	}
	
	@Override
	public void run() {
		int updateTime;
		long lastUpdate;
		
		updateTime = update(0);
		lastUpdate = System.currentTimeMillis();
		
		while (true) {
			try {
				int timeLeft = delay - updateTime;
				
				if (timeLeft < 0) {
					timeLeft = 0;
				}
				
				sleep(timeLeft);
				
				updateTime = update((int)(System.currentTimeMillis() - lastUpdate));
				lastUpdate = System.currentTimeMillis();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
	private int update(int delta) {
		long start = System.currentTimeMillis();
		
		listener.update(delta);
		
		return (int)(System.currentTimeMillis() - start);
	}

}
