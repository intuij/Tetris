package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class GameBlock extends Block{
	private static final Image RECT = new ImageIcon("graphics/game/rect.png").getImage();
	private static final int BLK_SIZE = 32;
	
	public GameBlock(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	void paint(Graphics g) {
		super.display(g);
		if (this.dto.getAct() != null) {
			Point[] pos = this.dto.getAct().getLocation();
			boolean isStart = dto.isStart();
			int typeCode = isStart ? this.dto.getAct().getTypeCode() : 7;
			for (int i = 1;i < pos.length;i++) {
				g.drawImage(RECT, this.posX + BLK_SIZE * pos[i].x + SIZE, 
								  this.posY + BLK_SIZE * pos[i].y + SIZE, 
								  this.posX + BLK_SIZE * pos[i].x + BLK_SIZE + SIZE, 
								  this.posY + BLK_SIZE * pos[i].y + BLK_SIZE + SIZE, 
								  BLK_SIZE * (typeCode + 1), 0, 
								  BLK_SIZE * (typeCode + 2), BLK_SIZE, null);	
			}
		}
		drawMap(this.dto.getMap(), g);
	}
	
	private void drawMap(boolean[][] map, Graphics g) {
		for (int i = 0;i < map.length;i++) {
			for (int j = 0;j < map[0].length;j++) {
				if (map[i][j]) {
					if (dto.isStart()) {
						g.drawImage(RECT, this.posX + BLK_SIZE * i + SIZE, 
										  this.posY + BLK_SIZE * j + SIZE,
										  this.posX + BLK_SIZE * i + SIZE + BLK_SIZE, 
										  this.posY + BLK_SIZE * j + SIZE + BLK_SIZE,
										  0, 0, BLK_SIZE, BLK_SIZE, null);
					} else {
						g.drawImage(RECT, this.posX + BLK_SIZE * i + SIZE, 
								  this.posY + BLK_SIZE * j + SIZE,
								  this.posX + BLK_SIZE * i + SIZE + BLK_SIZE, 
								  this.posY + BLK_SIZE * j + SIZE + BLK_SIZE,
								  BLK_SIZE << 3, 0, (BLK_SIZE << 3) + BLK_SIZE, BLK_SIZE, null);
					}
				}
			}
		}
	}
}
