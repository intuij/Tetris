package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.GameConfig;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	private GameConfig gameConfig;
	
	public GameFrame(GamePanel panel) {
		init(panel);
	}
	
	private void init(GamePanel panel) {
		setTitle("Java Tetris");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.gameConfig = GameConfig.getInstance();
		setSize(gameConfig.getFrameWidth(), gameConfig.getFrameHeight());
		setResizable(false);
		setLocation(calMid(getWidth(), getHeight())[0], 
					calMid(getWidth(), getHeight())[1]);
		setContentPane(panel);
		setVisible(true);
	}
	
	private int[] calMid(int width, int height) {
		int[] ret = new int[2];
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension ds = tk.getScreenSize();
		ret[0] = ds.width - width >> 1;
		ret[1] = ds.height - height >> 1;
		return ret;
	}
}
