package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import util.DrawNumber;

public class LevelBlock extends Block{
	private static final Image LEVEL_STR = new ImageIcon("graphics/string/level.png").getImage();
	private static int LEVEL_X_PADDING = 21;
	private static int LEVEL_Y_PADDING = 50;
	
	public LevelBlock(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	void paint(Graphics g) {
		super.display(g);
		// Draw string
		g.drawImage(LEVEL_STR, posX + PADDLE, posY + PADDLE, null);
		// Draw digits
		DrawNumber.drawNum(this.posX + LEVEL_X_PADDING, 
						   this.posY + LEVEL_Y_PADDING, 
						   3, dto.getCurrLevel(), g);	
	}
}
