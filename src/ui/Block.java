package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import config.GameConfig;
import data.Dto;

public abstract class Block {
	/*
	 * Image of block window
	 */
	private static final Image BOARDER = new ImageIcon("graphics/window/Window.png").getImage();
	protected static final int SIZE = GameConfig.getInstance().getSize();
	private static final int B_WIDTH = BOARDER.getWidth(null);
	private static final int B_HEIGHT = BOARDER.getHeight(null);
	
	protected static int PADDLE = GameConfig.getInstance().getPaddle();
	
	/*
	 * Position of this block
	 */
	protected int posX;
	protected int posY;
	/*
	 * Size of this block
	 */
	protected int width;
	protected int height;
	/*
	 * Dto object of block
	 */
	protected Dto dto;
	
	public Block(int x, int y, int width, int height) {
		this.posX = x;
		this.posY = y;
		this.width = width;
		this.height = height;
	}
	
	// Draw this block
	public void display(Graphics g) {
		g.drawImage(BOARDER, posX, posY, posX + SIZE, posY + SIZE, 0, 0, SIZE, SIZE, null);
		g.drawImage(BOARDER, posX + SIZE, posY, posX + width - SIZE, posY + SIZE,SIZE, 0, B_WIDTH - SIZE, SIZE, null);
		g.drawImage(BOARDER, posX + width - SIZE, posY, posX + width, posY + SIZE, B_WIDTH - SIZE, 0, B_WIDTH, SIZE, null);
		g.drawImage(BOARDER, posX, posY + SIZE, posX + SIZE, posY + height - SIZE, 0, SIZE, SIZE, B_HEIGHT - SIZE, null);
		g.drawImage(BOARDER, posX + SIZE, posY + SIZE, posX + width - SIZE, posY + height - SIZE, 
							 SIZE, SIZE, B_WIDTH - SIZE, B_HEIGHT - SIZE,  null);
		g.drawImage(BOARDER, posX + width - SIZE, posY + SIZE, posX + width, posY + height - SIZE, 
							 B_WIDTH - SIZE, SIZE, B_WIDTH, B_HEIGHT - SIZE, null);
		g.drawImage(BOARDER, posX, posY + height - SIZE, posX + SIZE, posY + height, 0, B_HEIGHT - SIZE, SIZE, B_HEIGHT, null);
		g.drawImage(BOARDER, posX + SIZE, posY + height - SIZE, posX + width - SIZE, 
				 			 posY + height,SIZE, B_HEIGHT - SIZE, B_WIDTH - SIZE, B_HEIGHT,  null);
		g.drawImage(BOARDER, posX + width - SIZE, posY + height - SIZE,  posX + width, 
							 posY + height,B_WIDTH - SIZE, B_HEIGHT - SIZE, B_WIDTH, B_HEIGHT,  null);
	}
	
	// Paint method
	abstract void paint(Graphics g);
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setDto(Dto dto) {
		this.dto = dto;
	}
}
