package ButtonGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MenuBar {
	private int menu_width;
	private int menu_height;
	static final Color MENU_COLOR = Color.WHITE;
	
	MenuBar(int sreenWidth, int sreenHeight) {
		this.menu_width = sreenWidth;
		this.menu_height = sreenHeight;
		
	}
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(MENU_COLOR);
		g2.fillRect(menu_width*2/3, 0, menu_width/3, menu_height);
		g2.setColor(Color.gray);
		int strock = 5;
		g2.setStroke(new BasicStroke(strock));
		g2.drawRect((menu_width*2/3)+(int)(strock/2), (int)(strock/2), (menu_width/3)-strock+2, menu_height-strock);
	}
	
}
