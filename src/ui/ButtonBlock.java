package ui;

import java.awt.Graphics;

public class ButtonBlock extends Block{
	public ButtonBlock(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	void paint(Graphics g) {
		super.display(g);
	}
}
