package ButtonGame;

import java.awt.Graphics2D;

import MenuBar.MenuBar;

public class Marketplace {
	private int posX;
	private int posY;
	private int width;
	private int height;
	private int minuend;
	private int monny;
	private int factor;
	
	static MenuBar menuBar;
	
	Marketplace(int posX, int posY, int width, int height) {
		this.posX = posX;
		this.posY = posY;
		this.height = height;
		this.width = width;
		menuBar = new MenuBar(posX, posY, width, height);
		menuBar.mButton[0].setTitle("Oma (je x1)");
		menuBar.mButton[0].setMass(1);
		factor = 1;
	}
	
	public void render(Graphics2D g2d) {
		menuBar.render(g2d);
	}
	
	public void mousePressed(int mPosX, int mPosY) {
		menuBar.mousePressed(mPosX, mPosY);
		System.out.println(menuBar.mButton[0].isButtonPressed());
		System.out.println(menuBar.mButton[1].isButtonPressed());
		System.out.println(" ");
		shopping();
	}
	
	public void mouseReleased(int mPosX, int mPosY) {
		menuBar.mouseReleased(mPosX, mPosY);
	}
	
	private int costs = 1;
	private void shopping() {
//		Oma tach
		int oma = 1;
		System.out.println(monny);
		if(menuBar.mButton[0].isButtonPressed() && monny>=costs && monny>=0) {
//			System.out.println(costs);
			minuend=costs;
			costs = costs + oma;
			menuBar.mButton[0].setMass(costs);
			factor = factor + oma;
		}
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

	public int getMinuend() {
		if(minuend>=0) {
		return minuend;
		}else return 0;
	}

	public void setMinuendZero() {
		this.minuend = 0;
	}

	public void setMonny(int monny) {
		this.monny = monny;
	}

	public int getFactor() {
		if(factor>0) {
			return factor;
			//TODO
		}else return -1;
	}
	
	public void setFactorZero() {
		this.factor = 0;
	}
	
}
