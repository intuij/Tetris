package util;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class DrawNumber {
	private static final Image NUM_IMG = new ImageIcon("graphics/string/num.png").getImage();
	private static final int DIGIT_HEIGHT = NUM_IMG.getHeight(null);
	private static final int DIGIT_WIDTH = NUM_IMG.getWidth(null) / 10;
	private static final int PADDLE = 4;
	
	/**
	 * Draw number on the panel
	 * @param x  x offset in the window
	 * @param y  y offset in the window
	 * @param maxBit maxLength of the number
	 * @param val  value of the number
	 * @param g Graphics element
	 */
	public static void drawNum(int x, int y, int maxBit, int val, Graphics g) {
		String num = String.valueOf(val);
		int space = maxBit - num.length();
		for (int i = 0;i < num.length();i++) {
			int digit = num.charAt(i) - '0';
			g.drawImage(NUM_IMG, 
						x + (space + i) * DIGIT_WIDTH + PADDLE * i, y,
						x + (space + i + 1) * DIGIT_WIDTH + PADDLE * i, y + DIGIT_HEIGHT,
						digit * DIGIT_WIDTH + 1, 0,
						(digit + 1) * DIGIT_WIDTH - 1, DIGIT_HEIGHT,
						null);
		}
	}
}
