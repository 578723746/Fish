package Game;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Game {
	
	public static Pool pool = new Pool();
	
	public void action() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {			
			@Override
			public void run() {
//				pool.step();
			}
		}, 10, 10);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(pool);
		frame.setSize(800,480);
		Game game = new Game();
		game.action();
		frame.setVisible(true);
		pool.action();
	}
}
