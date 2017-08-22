package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import data.Dto;
import util.DrawNumber;

public class ExpBlock extends Block{
	//private static final Image EXP_STR = new ImageIcon("graphics/string/exp.png").getImage();
	private static final Image RM_STR = new ImageIcon("graphics/string/rmline.png").getImage();
	private static final Image SC_STR = new ImageIcon("graphics/string/score.png").getImage();
	private static final Image RECT = new ImageIcon("graphics/window/rect.png").getImage();
	
	private static final int SPACING = 48;
	
	// Size of rect
	private static final int RECT_WIDTH = RECT.getWidth(null);
	private static final int RECT_HEIGHT = RECT.getHeight(null);
	
	// Size of exp slot
	private final int SLOT_WIDTH = this.width - PADDLE * 4 - 4; 
	private final int SLOT_HEIGHT = 26;
	
	public ExpBlock(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	void paint(Graphics g) {
		super.display(g);
		// Draw string
		g.drawImage(RM_STR, posX + PADDLE * 2, posY + PADDLE * 2, null);
		g.drawImage(SC_STR, posX + PADDLE * 2, posY + PADDLE * 2 + SPACING, null);
		//g.drawImage(EXP_STR, posX + PADDLE * 2, posY + PADDLE * 2 + SPACING * 2, null);
		// Draw digits
		DrawNumber.drawNum(this.posX + 150, posY + PADDLE * 2, 5, dto.getCurrLine(), g);
		DrawNumber.drawNum(this.posX + 150, posY + PADDLE * 2 + SPACING, 5, dto.getCurrScore(), g);
		
		// Draw exp slot
		g.setColor(Color.BLACK);
		g.fillRect(posX + PADDLE * 2, posY + PADDLE * 2 + SPACING * 2, 
				   width - PADDLE * 4, 30);
		g.setColor(Color.WHITE);
		g.fillRect(posX + PADDLE * 2 + 1, posY + PADDLE * 2 + SPACING * 2 + 1, 
				   width - PADDLE * 4 - 2, 28);
		g.setColor(Color.BLACK);
		g.fillRect(posX + PADDLE * 2 + 2, posY + PADDLE * 2 + SPACING * 2 + 2, 
				   width - PADDLE * 4 - 4, 26);
		fillSlot(g);
	}
	
	private void fillSlot(Graphics g) {
		double ratio = (double)(dto.getCurrLine() % Dto.LEVEL_UP) / Dto.LEVEL_UP;
		int len = (int)(ratio * SLOT_WIDTH);
		int pos = (int)(ratio * RECT_WIDTH);
		
		g.drawImage(RECT, posX + PADDLE * 2 + 2, 
						  posY + PADDLE * 2 + SPACING * 2 + 2,
						  posX + PADDLE * 2 + 2 + len, 
						  posY + PADDLE * 2 + SPACING * 2 + 2 + SLOT_HEIGHT,
						  pos, 0,
						  pos + 1, RECT_HEIGHT,
						  null);
	}
}
