package ButtonGame;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	GameWindow() {
		this.add(new Game());
		this.setTitle("Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
}
