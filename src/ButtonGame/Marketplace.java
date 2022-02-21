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
	private boolean[] ButtonSetub;
	private String[][] buttonData;
	
	static MenuBar menuBar;
	
	//constructor
	Marketplace(int posX, int posY, int width, int height) {
		this.posX = posX;
		this.posY = posY;
		this.height = height;
		this.width = width;
		menuBar = new MenuBar(posX, posY, width, height);
		ButtonSetub = new boolean[menuBar.getAmoundOfButton()];
		buttonData = new String[2][menuBar.getAmoundOfButton()];
		setButttonData();
		for(int i=0; i<=menuBar.getAmoundOfButton()-1; i++) {
			ButtonSetub[i] = true;
			}
		factor = 1;
		shopping();
	}
	//initialization methods
	private void setButttonData() { 
		buttonData[0][0] = "Oma";
		buttonData[1][0] = "1";
		buttonData[0][1] = "Bäcker";
		buttonData[1][1] = "10";
	}
	//communication methods
	public void render(Graphics2D g2d) {
		menuBar.render(g2d);
	}
	
	public void mousePressed(int mPosX, int mPosY) {
		menuBar.mousePressed(mPosX, mPosY);
		shopping();
	}
	
	public void mouseReleased(int mPosX, int mPosY) {
		menuBar.mouseReleased(mPosX, mPosY);
	}
	
	//help methods
	private void shopping() {
		try {
			menuButton(0);
			menuButton(1);
			}
		catch(Exception e) {
			for(int i=0; i<=menuBar.getAmoundOfButton()-1; i++) {
				buttonData[0][i] = "null";
				buttonData[1][i] = "0";
				}
			for(int i=0; i<=menuBar.getAmoundOfButton()-1; i++) {
				menuButton(i);
				}
			}
	}
	
	private void menuButton(int buttonNumber) {
		int factorOfButton = 1;// is the start number of the button and it isn´t allowt to be bigger then "menuBar.getAmoundOfButton()"  
		if(ButtonSetub[buttonNumber]) { // starts one time
			menuBar.mButton[buttonNumber].setTitle(buttonData[0][buttonNumber]);
			menuBar.mButton[buttonNumber].setCosts(Integer.parseInt(buttonData[1][buttonNumber])); // tells how big is the costs of the button 
			ButtonSetub[buttonNumber] = false;
		}else if(!ButtonSetub[buttonNumber]) {
			if(menuBar.mButton[buttonNumber].isButtonPressed() && monny>=menuBar.mButton[buttonNumber].getCosts() && monny>=0) {
				minuend=menuBar.mButton[buttonNumber].getCosts();
				menuBar.mButton[buttonNumber].setCosts(menuBar.mButton[buttonNumber].getCosts()+ factorOfButton);
				factor = factor + factorOfButton;
				menuBar.mButton[buttonNumber].setStage(menuBar.mButton[buttonNumber].getStage()+1);
			}
		}
	}
	
	//getters and setters
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
