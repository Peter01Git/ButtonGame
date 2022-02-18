package MenuBar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MenuBar {
	private int menuPosX;
	private int menuPosY;
	private int menu_width;
	private int menu_height;
	private final int amoundOfButton = 5;
	static final Color MENU_COLOR = Color.WHITE;
	public ButtonMenuBar[] mButton = new ButtonMenuBar[amoundOfButton];
	
	public MenuBar(int sreenWidth, int sreenHeight, int menuPosX, int menuPosY) {
		this.menuPosX = menuPosX;
		this.menuPosY = menuPosY;
		this.menu_width = sreenWidth/3;
		this.menu_height = sreenHeight; 
		for (int i=0; i<=amoundOfButton-1; i++) {
			mButton[i] = new ButtonMenuBar();
			mButton[i].setLocation((int)(menuPosX+menu_width/5), menuPosY+50+(100*i));
			mButton[i].setSize((int)(menu_width*3/5), 50);
		}
	}
	
	public void render(Graphics2D g2) {
		setMenuBeckround(g2);
		drawButtonMenuBar(g2);
	}
	
	public void mousePressed(int mPosX, int mPosY) {
		for(int i=0; i<=amoundOfButton-1; i++) {
			mButton[i].mousePressed(mPosX, mPosY);
		}
	}
	
	public void mouseReleased(int mPosX, int mPosY) {
		for(int i=0; i<=amoundOfButton-1; i++) {
			mButton[i].mouseReleased(mPosX, mPosY);
		}
	}
	
	private void drawButtonMenuBar(Graphics2D g2) {
		for(int i=0; i<=amoundOfButton-1; i++) {
			mButton[i].render(g2);
		}
	}
	
	private void setMenuBeckround(Graphics2D g2) {
		g2.setColor(MENU_COLOR);
		g2.fillRect(menuPosX, menuPosY, menu_width, menu_height);
		g2.setColor(Color.gray);
		int strock = 5;
		g2.setStroke(new BasicStroke(strock));
		g2.drawRect(menuPosX+(int)(strock/2), menuPosY+(int)(strock/2), (menu_width)-strock+2, menu_height-strock);
	}
}
