package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig {
	/*
	 * Width of the game frame
	 */
	private int frameWidth;
	/*
	 * Height of the game frame
	 */
	private int frameHeight;
	/*
	 * Size of the block corner
	 */
	private int size;
	/*
	 * Padding of words in each block
	 */
	private int paddle;
	/*
	 * List of each block's config
	 */
	private List<BlockConfig> blockConfigs;
	
	/*
	 * singleton object
	 */
	private static GameConfig gameConfig;
	
	public static GameConfig getInstance() {
		if (gameConfig == null) {
			gameConfig = new GameConfig();
		}
		return gameConfig;
	}
	
	private GameConfig() {
		SAXReader reader = new SAXReader();
		try {
			Document cfg = reader.read("config/gameCfg.xml");
			Element root = cfg.getRootElement();
			Element frame = root.element("frame");
			init(frame);
			@SuppressWarnings("unchecked")
			List<Element> blocks = frame.elements("block");
			loadBlockConfig(blocks);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Initialize the fields of frame
	 */
	private void init(Element frame) {
		this.frameWidth  = Integer.parseInt(frame.attributeValue("width"));
		this.frameHeight = Integer.parseInt(frame.attributeValue("height"));
		this.paddle      = Integer.parseInt(frame.attributeValue("paddle"));
		this.size        = Integer.parseInt(frame.attributeValue("size"));
	}
	
	/*
	 * Load config of blocks
	 */
	private void loadBlockConfig(List<Element> blocks) {
		this.blockConfigs = new ArrayList<BlockConfig>();
		for (Element e : blocks) {
			String className = e.attributeValue("className");
			int w = Integer.parseInt(e.attributeValue("w"));
			int h = Integer.parseInt(e.attributeValue("h"));
			int x = Integer.parseInt(e.attributeValue("x"));
			int y = Integer.parseInt(e.attributeValue("y"));
			blockConfigs.add(new BlockConfig(className, w, h, x, y));
		}
	}

	public int getFrameWidth() {
		return frameWidth;
	}

	public int getFrameHeight() {
		return frameHeight;
	}

	public int getSize() {
		return size;
	}

	public int getPaddle() {
		return paddle;
	}

	public List<BlockConfig> getBlockConfigs() {
		return blockConfigs;
	}
}
