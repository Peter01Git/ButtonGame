package MenuBar;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class ScrollMenuBar {
	private int menuPosX;
	private int menuPosY;
	private int menu_width;
	private int menu_height;
	private boolean menuBarPressed;
	private boolean menuBarReleased;
	private int mouseMove;
	private boolean isSetubMouseMove = true;

	public ScrollMenuBar() {
		super();
		
	}
	
	public void render(Graphics2D g2) {
		
	}
	
	public void mouseDragged(int mPosX, int mPosY) {
		if(menuBarPressed) {
			if(isSetubMouseMove) {
				mouseMove = mPosY;
				menuPosY = menuPosY + mPosY- mouseMove;
				mouseMove = mPosY;
				isSetubMouseMove = false;
			} else { 
				menuPosY = menuPosY + mPosY- mouseMove;
				mouseMove = mPosY;
			}
		}
	}
	
	public void mousePressed(int mPosX, int mPosY) {
		if(isPressedMenuBar(mPosX, mPosY)) {
			menuBarPressed = true;
		}
	}
	
	public void mouseReleased(int mPosX, int mPosY) {
		menuBarPressed = false;
		isSetubMouseMove = true;
	}
	
	private boolean isPressedMenuBar(int mPosX, int mPosY) {
		return mPosX>=menuPosX && mPosX<=menuPosX+menu_width && mPosY>=menuPosY && mPosY<=menuPosY+menu_height;
	}
	
	public void setMenuArea(int menuPosX, int menuPosY, int menu_width, int menu_height) {
		this.menuPosX = menuPosX;
		this.menuPosY = menuPosY;
		this.menu_width = menu_width;
		this.menu_height = menu_height;
	}

	public int getMenuPosX() {
		return menuPosX;
	}

	public void setMenuPosX(int menuPosX) {
		this.menuPosX = menuPosX;
	}

	public int getMenuPosY() {
		return menuPosY;
	}

	public void setMenuPosY(int menuPosY) {
		this.menuPosY = menuPosY;
	}

	public int getMenu_width() {
		return menu_width;
	}

	public void setMenu_width(int menu_width) {
		this.menu_width = menu_width;
	}

	public int getMenu_height() {
		return menu_height;
	}

	public void setMenu_height(int menu_height) {
		this.menu_height = menu_height;
	}

}
