package ButtonGame;

import java.awt.Graphics2D;

import MenuBar.MenuBar;

public class Marketplace {
	private int posX;
	private int posY;
	private int width;
	private int height;
	
	static MenuBar menuBar;
	
	Marketplace(int posX, int posY, int width, int height) {
		this.posX = posX;
		this.posY = posY;
		this.height = height;
		this.width = width;
		menuBar = new MenuBar(posX, posY, width, height);
	}
	
	public void render(Graphics2D g2d) {
		menuBar.render(g2d);
	}
	
	public void mousePressed(int mPosX, int mPosY) {
		menuBar.mousePressed(mPosX, mPosY);
		System.out.println(menuBar.mButton[0].isButtonPressed());
		System.out.println(menuBar.mButton[1].isButtonPressed());
		System.out.println(" ");
	}
	
	public void mouseReleased(int mPosX, int mPosY) {
		menuBar.mouseReleased(mPosX, mPosY);
	}
	
	private void shopping() {
//		Oma tach
		int costs;
		menuBar.mButton[0].setTitle("oma");
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
	
}
