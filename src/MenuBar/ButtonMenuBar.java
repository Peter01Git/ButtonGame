package MenuBar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;

public class ButtonMenuBar{
	private int posX;
	private int posY;
	private int width;
	private int height;
	private String title;
	private boolean buttonPressed;
	//extra for selling
	private int costs;
	private int stage;
	
	//constructor
	ButtonMenuBar() {
		title = "null";
		buttonPressed = false;
		costs = 0;
		stage = 0;
	}
	
	//communication methods
	
	public void render(Graphics2D g2) {
		renderButtonPressed(g2);
		renderButtonDesign(g2);
		drawText(g2);
	}
	
	private void renderButtonPressed(Graphics2D g2) {
		if(buttonPressed) {
			g2.setColor(Color.GRAY);
			//g2.setColor(Color.BLACK);
		}else {
			g2.setColor(Color.GRAY);
		}
		g2.fillRect(posX, posY, width, height);
	}
	
	private void renderButtonDesign(Graphics2D g2) {
		g2.setStroke(new BasicStroke(1));
		g2.setColor(Color.BLACK);
		g2.drawRect(posX, posY, width, height);
		g2.drawLine(posX, posY+(height/2), posX+width, posY+(height/2));
		g2.drawLine(posX+width/4, posY, posX+width/4, posY+height);
	}
	
	public void mousePressed(int mPosX, int mPosY) {
		if(pressedButton(mPosX, mPosY)) {
			buttonPressed = true;
		}
	}
	
	public void mouseReleased(int mPosX, int mPosY) {
			buttonPressed = false;
	}
	
	//help methods
	
	private void drawText(Graphics2D g2) {
		drawTitle(g2);
		drawCosts(g2);
		drawStage(g2);
	}
	
	private void drawTitle(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Akkurat", Font.BOLD + SwingConstants.CENTER, 18));
		FontMetrics metrics = g2.getFontMetrics(g2.getFont());
		g2.drawString(title, posX+width/2-(metrics.stringWidth(title)/2), posY-4);
	}
	
	private void drawCosts(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Akkurat", Font.BOLD + SwingConstants.CENTER, 18));
		FontMetrics metrics = g2.getFontMetrics(g2.getFont());
		System.out.println(5*width/8);
		g2.drawString("K", posX+width/8 - (metrics.stringWidth("k")/2), posY+height/4+(g2.getFont().getSize()/2));
		g2.drawString(""+costs, posX+(5*width/8) - (metrics.stringWidth("k")/2), posY+height/4+(g2.getFont().getSize()/2));
	}
	
	private void drawStage(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Akkurat", Font.BOLD + SwingConstants.CENTER, 18));
		FontMetrics metrics = g2.getFontMetrics(g2.getFont());
		g2.drawString("S", posX+width/8 - (metrics.stringWidth("S")/2), posY+3*height/4 +(g2.getFont().getSize()/2));
		g2.drawString(""+stage, posX+(5*width/8) - (metrics.stringWidth(""+stage)/2), posY+3*height/4 +(g2.getFont().getSize()/2));
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

	public int getCosts() {
		return costs;
	}

	public void setCosts(int costs) {
		this.costs = costs;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}
	
	
}
