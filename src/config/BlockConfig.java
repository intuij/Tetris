package config;

public class BlockConfig {
	/*
	 * Class name of this block
	 */
	private String className;
	/*
	 * Width of this block
	 */
	private int width;
	/*
	 * Height of this block
	 */
	private int height;
	/*
	 * X position of this block
	 */
	private int posX;
	/*
	 * Y position of this block
	 */
	private int posY;
	
	
	public BlockConfig(String className, int width, int height, int posX, int posY) {
		this.className = className;
		this.width = width;
		this.height = height;
		this.posX = posX;
		this.posY = posY;
	}

	public String getClassName() {
		return className;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
}
