package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class NextBlock extends Block{
	public NextBlock(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	private static List<Image> IMAGE_LIST = new ArrayList<Image>();
	
	static {
		IMAGE_LIST.add(new ImageIcon("graphics/game/0.png").getImage());
		IMAGE_LIST.add(new ImageIcon("graphics/game/1.png").getImage());
		IMAGE_LIST.add(new ImageIcon("graphics/game/2.png").getImage());
		IMAGE_LIST.add(new ImageIcon("graphics/game/3.png").getImage());
		IMAGE_LIST.add(new ImageIcon("graphics/game/4.png").getImage());
		IMAGE_LIST.add(new ImageIcon("graphics/game/5.png").getImage());
		IMAGE_LIST.add(new ImageIcon("graphics/game/6.png").getImage());
	}

	@Override
	void paint(Graphics g) {
		super.display(g);
		if (!dto.isStart())	return;
		int nextType = this.dto.getNextType();
		Image img = IMAGE_LIST.get(nextType);
		int xPaddle = this.width - img.getWidth(null) >> 1;
		int yPaddle = this.height - img.getHeight(null) >> 1;
		g.drawImage(IMAGE_LIST.get(nextType), this.posX + xPaddle, this.posY + yPaddle, null);
	}
	
}
