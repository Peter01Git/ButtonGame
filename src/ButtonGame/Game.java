package ButtonGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Game extends JPanel implements ActionListener{
	static final int SCREEN_WIDTH = 800;
	static final int SCREEN_HEIGHT = 600;
	static final int BUTTON_POSX = SCREEN_WIDTH/3;
	static final int BUTTON_POSY = SCREEN_HEIGHT/2;
	static final int MEASURE = 400;
	static final Color BACKROUNDCOLOR = new Color(167, 185, 24);
	static MenuBar menuBar;
	boolean raning;
	boolean buttonPressed;
	private int counter = 0;
	
	Game() {
		super();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(BACKROUNDCOLOR);
		this.setFocusable(true);
		this.addMouseListener(new MyMouseAdapter());
		startGame();
		menuBar = new MenuBar(SCREEN_WIDTH, SCREEN_HEIGHT, SCREEN_WIDTH*2/3, 0);
	}
	
	public void startGame() {
		raning = true;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
		menuBar.render(g);
	}
	
	public void draw(Graphics g) {
		DrawButton(g);
		drawCounter(g);
	}
	
	public Boolean isButtonPressed(int posX, int posY) {
		//BUTTON_POSX - ((int)(MEASURE/2)) <= posX && BUTTON_POSY - ((int)(MEASURE/2)) <= posY && BUTTON_POSX - ((int)(MEASURE/2)) + MEASURE >= posX && BUTTON_POSY - ((int)(MEASURE/2)) + MEASURE >= posY;	
		return (int)(Math.pow(Math.pow((double)(posX - BUTTON_POSX), 2) + Math.pow((double)(posY - BUTTON_POSY), 2), 0.5)) <= (MEASURE/2) -1;	

	}
	
	public void DrawButton(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Color inside;
		Color frame;
		if (buttonPressed) { 
			inside = (new Color(213, 131, 21));
			frame = (new Color(0, 0, 0));
		}else {
			inside = (new Color(255, 132, 41));
			frame = (new Color(102, 102, 102));
		}
		g2.setColor(inside);
		g2.fillOval(BUTTON_POSX - ((int)(MEASURE/2)), BUTTON_POSY - ((int)(MEASURE/2)), MEASURE, MEASURE);
		g2.setColor(frame);
		g2.setStroke(new BasicStroke(5));
		g2.drawOval(BUTTON_POSX - ((int)(MEASURE/2))+2, BUTTON_POSY - ((int)(MEASURE/2))+2, MEASURE-4, MEASURE-4);
	}
	
	public void drawCounter(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("Ink Free", Font.BOLD, 20));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Counter: " + counter, (SCREEN_WIDTH - metrics.stringWidth("Counter: " + counter))/3, (getFont().getSize()) + 20);
	}
	
	public void endGame() {
		if(counter>=100) {
			counter = 0;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("test2");
		
	}
	
	public class MyMouseAdapter extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			if(isButtonPressed(e.getX(), e.getY())) {
				buttonPressed = true;
				repaint();
				counter++;
			}
			menuBar.mousePressed(e.getX(), e.getY());
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			buttonPressed = false;
			repaint();
			endGame();
		}
	}
}
