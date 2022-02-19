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
	private int[] costs;
	private boolean[] ButtonSetub;
	
	static MenuBar menuBar;
	
	Marketplace(int posX, int posY, int width, int height) {
		this.posX = posX;
		this.posY = posY;
		this.height = height;
		this.width = width;
		menuBar = new MenuBar(posX, posY, width, height);
		costs = new int[menuBar.getAmoundOfButton()];
		ButtonSetub = new boolean[menuBar.getAmoundOfButton()];
		for(int i=0; i<=menuBar.getAmoundOfButton()-1; i++) {
			ButtonSetub[i] = true;
			System.out.println(ButtonSetub[i]);
			}
		factor = 1;
		oma();
		Baker();
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
	
	private void shopping() {
//		"Oma" button
		oma();
		Baker();
//		if(menuBar.mButton[0].isButtonPressed() && monny>=costs[0] && monny>=0) {
//			int oma = 1;
//			minuend=costs[0];
//			costs[0] = costs[0] + oma;
//			menuBar.mButton[0].setMass(costs[0]);
//			factor = factor + oma;
//		}
	}
	
	private void oma() {
		int oma = 1;
		int buttonNumber = 0; // is the start number of the button and it isn´t allowt to be bigger then "menuBar.getAmoundOfButton()"  
		if(ButtonSetub[buttonNumber]) { // starts one time
			costs[buttonNumber] = 1; // tells how big is the costs of the button 
			menuBar.mButton[buttonNumber].setTitle("Oma (je +1)");
			menuBar.mButton[buttonNumber].setMass(1);
			ButtonSetub[buttonNumber] = false;
		}else if(!ButtonSetub[buttonNumber]) {
			if(menuBar.mButton[buttonNumber].getCounter()==100) {
				oma = 100;
			}
			if(menuBar.mButton[buttonNumber].isButtonPressed() && monny>=costs[buttonNumber] && monny>=0) {
				minuend=costs[buttonNumber];
				costs[buttonNumber] = costs[buttonNumber] + oma;
				menuBar.mButton[buttonNumber].setMass(costs[buttonNumber]);
				factor = factor + oma;
			}
		}
	}
	
	private void Baker() {
		int buttonNumber = 1; // is the start number of the button and it isn´t allowt to be bigger then "menuBar.getAmoundOfButton()"  
		if(ButtonSetub[buttonNumber]) { // starts one time
			costs[buttonNumber] = 10; // tells how big is the costs of the button 
			menuBar.mButton[buttonNumber].setTitle("Bäcker (je +2)");
			menuBar.mButton[buttonNumber].setMass(10);
			ButtonSetub[buttonNumber] = false;
		}else if(!ButtonSetub[buttonNumber]) {
			if(menuBar.mButton[buttonNumber].isButtonPressed() && monny>=costs[buttonNumber] && monny>=0) {
				int oma = 2;
				minuend=costs[buttonNumber];
				costs[buttonNumber] = costs[buttonNumber] + oma;
				menuBar.mButton[buttonNumber].setMass(costs[buttonNumber]);
				factor = factor + oma;
			}
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
