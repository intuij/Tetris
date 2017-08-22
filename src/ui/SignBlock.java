package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class SignBlock extends Block{ 
	private static final Image SIGNATURE = new ImageIcon("graphics/string/sig.png").getImage();
	
	public SignBlock(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	void paint(Graphics g) {
		super.display(g);
		g.drawImage(SIGNATURE, this.getPosX() + (this.getWidth() - SIGNATURE.getWidth(null) >> 1), 
							   this.getPosY() + (this.getHeight() - SIGNATURE.getHeight(null) >> 1), 
							   null);
	}
}
