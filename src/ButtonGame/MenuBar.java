package ButtonGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MenuBar {
	private int menuPosX;
	private int menuPosY;
	private int menu_width;
	private int menu_height;
	static final Color MENU_COLOR = Color.WHITE;
	ButtonMenuBar mButton1, mButton2, mButton3, mButton4;
	
	MenuBar(int sreenWidth, int sreenHeight, int menuPosX, int menuPosY) {
		this.menuPosX = menuPosX;
		this.menuPosY = menuPosY;
		this.menu_width = sreenWidth/3;
		this.menu_height = sreenHeight;
		mButton1 = new ButtonMenuBar("Knopf1: ", (int)(menuPosX+menu_width/5), menuPosY+50, (int)(menu_width*3/5), 50);
		mButton2 = new ButtonMenuBar("Knopf2: ", (int)(menuPosX+menu_width/5), menuPosY+150, (int)(menu_width*3/5), 50);
		mButton3 = new ButtonMenuBar("Knopf3: ", (int)(menuPosX+menu_width/5), menuPosY+250, (int)(menu_width*3/5), 50);
		mButton4 = new ButtonMenuBar("Knopf4: ", (int)(menuPosX+menu_width/5), menuPosY+350, (int)(menu_width*3/5), 50);
	}
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		menuBeckround(g2);
		mButton1.render(g2);
		mButton2.render(g2);
		mButton3.render(g2);
		mButton4.render(g2);
	}
	
	private void menuBeckround(Graphics2D g2) {
		g2.setColor(MENU_COLOR);
		g2.fillRect(menuPosX, menuPosY, menu_width, menu_height);
		g2.setColor(Color.gray);
		int strock = 5;
		g2.setStroke(new BasicStroke(strock));
		g2.drawRect(menuPosX+(int)(strock/2), menuPosY+(int)(strock/2), (menu_width)-strock+2, menu_height-strock);
	}
	
	public void mousePressed(int mPosX, int mPosY) {
		mButton1.mousePressed(mPosX, mPosY);
		mButton2.mousePressed(mPosX, mPosY);
		mButton3.mousePressed(mPosX, mPosY);
		mButton4.mousePressed(mPosX, mPosY);
	}
	
}
