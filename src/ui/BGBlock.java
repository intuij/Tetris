package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class BGBlock extends Block {
	private static List<Image> BACKGROUND_IMG = new ArrayList<>();
	
	static {
		
		File dir = new File("graphics/background");
		for (File f : dir.listFiles()) {
			if (f.isDirectory() || f.isHidden()) continue;
			BACKGROUND_IMG.add(new ImageIcon(f.getPath()).getImage());
		}
	}
	
	public BGBlock(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	@Override
	void paint(Graphics g) {
		int currLevel = this.dto.getCurrLevel();
		int bgSize = BACKGROUND_IMG.size();
		g.drawImage(BACKGROUND_IMG.get((currLevel - 1) % bgSize), posX, posY, width, height, null);
	}
}
