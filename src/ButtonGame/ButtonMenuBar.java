package ButtonGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ButtonMenuBar{
	private int posX;
	private int posY;
	private int width;
	private int height;
	private boolean buttonPressed = false;
	private String title;
	private int plenty = 1;
	
	ButtonMenuBar(String title, int posX, int posY, int width, int height) {
		this.posX = posX;
		this.posY = posY;
		this.height = height;
		this.width = width;
		this.title = title;
	}
	
	public void render(Graphics2D g2) {
		if(buttonPressed) {
			g2.setColor(Color.BLACK);
		}else {
			g2.setColor(Color.GRAY);
		}
		g2.fillRect(posX, posY, width, height);
		g2.drawRect(posX, posY, width, height);
		drawTitle(g2);
	}
	
	private void drawTitle(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Ink Free", Font.BOLD, 20));
		FontMetrics metrics = g2.getFontMetrics(g2.getFont());
		g2.drawString(title + plenty, (posX+width - metrics.stringWidth(title + plenty))-40, (g2.getFont().getSize()) + posY+10);
	}
	
	public void mousePressed(int mPosX, int mPosY) {
		if(pressedButton(mPosX, mPosY)) {
			plenty++;
		}
	}
	private boolean pressedButton(int mPosX, int mPosY) {
		return mPosX>=posX && mPosX<=posX+width && mPosY>=posY && mPosY<=posY+height;
	}
}
