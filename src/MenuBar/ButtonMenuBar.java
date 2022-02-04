package MenuBar;

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
	private String title = "null";
	private boolean buttonPressed = false;
	//extra for selling
	private int mass = 1;
	
	//constructor
	ButtonMenuBar() {
	}
	
	//communication methods
	
	public void render(Graphics2D g2) {
		if(buttonPressed) {
			g2.setColor(Color.GRAY);
			//g2.setColor(Color.BLACK);
		}else {
			g2.setColor(Color.GRAY);
		}
		g2.fillRect(posX, posY, width, height);
		g2.drawRect(posX, posY, width, height);
		drawTitle(g2);
	}
	
	public void mousePressed(int mPosX, int mPosY) {
		if(pressedButton(mPosX, mPosY)) {
			buttonPressed = true;
		}
	}
	
	public void mouseReleased(int mPosX, int mPosY) {
		if(pressedButton(mPosX, mPosY)) {
			buttonPressed = false;
		}
	}
	
	//help methods 
	
	private void drawTitle(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Ink Free", Font.BOLD, 20));
		FontMetrics metrics = g2.getFontMetrics(g2.getFont());
		g2.drawString(title + mass, (posX+width - metrics.stringWidth(title + mass))-25, (g2.getFont().getSize()) + posY+10);
	}
	
	private boolean pressedButton(int mPosX, int mPosY) {
		return mPosX>=posX && mPosX<=posX+width && mPosY>=posY && mPosY<=posY+height;
	}
	
	public void ConsolePrintln(String title) {
		System.out.println(title);
	}
	
	// setters and getters 
	
	public void setLocation(int positionX, int positionY) {
		this.posX = positionX;
		this.posY = positionY;
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isButtonPressed() {  
		return buttonPressed;
	}

	public void setButtonPressed(boolean buttonPressed) {
		this.buttonPressed = buttonPressed;
	}
	
	
}
