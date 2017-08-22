package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class DBBlock extends Block {
	private static final Image DB_STR = new ImageIcon("graphics/string/db.png").getImage();
	private static final int PADDLE = 7; 
	
	private static final int RECORD_NUM = 5;
	private static final int BLOCK_PADDLE = 12;
	private static final int BLOCK_WIDTH = 216;
	private static final int BLOCK_HEIGHT = 32;
	private static final int SPACING = 11;
	
	public DBBlock(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	void paint(Graphics g) {
		super.display(g);
		g.drawImage(DB_STR, posX + PADDLE, posY + PADDLE, null);
		for (int i = 1;i <= RECORD_NUM; i++) {
			drawRect(this.posX + BLOCK_PADDLE, 
					 this.posY + PADDLE + (32 + SPACING) * i, 
					 BLOCK_WIDTH, 
					 BLOCK_HEIGHT, g);
		}
	}
	
	private void drawRect(int x, int y, int w, int h, Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, w, h);
		g.setColor(Color.WHITE);
		g.fillRect(x + 1, y + 1, w - 2, h - 2);
		g.setColor(Color.BLACK);
		g.fillRect(x + 2, y + 2, w - 4, h - 4);
	}
}
