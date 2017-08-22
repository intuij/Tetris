package ui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import config.BlockConfig;
import config.GameConfig;
import control.GameController;
import control.KeyController;
import data.Dto;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{
	private static final ImageIcon START = new ImageIcon("graphics/string/start.png");
	private static final ImageIcon PAUSE = new ImageIcon("graphics/string/pause.png");
	
	private Dto dto;
	
	private List<Block> blockList;
	
	private List<BlockConfig> configList;
	
	private GameConfig gameConfig;
	
	private JButton startButton;
	private JButton pauseButton;
	private GameController gameController;
	
	public GamePanel(Dto dto) {
		this.dto = dto;
		this.setLayout(null);
		initConfig();
		initButton();
	}
	
	private void initConfig() {
		this.gameConfig = GameConfig.getInstance();
		this.configList = gameConfig.getBlockConfigs();
		this.blockList = new ArrayList<Block>(configList.size());
		for (BlockConfig config : configList) {
			try {
				Class<?> c = Class.forName(config.getClassName());
				Constructor<?> con = c.getConstructor(int.class, int.class, int.class, int.class);
				Block b = (Block)con.newInstance(config.getPosX(), config.getPosY(),
												 config.getWidth(), config.getHeight());
				b.setDto(dto);
				this.blockList.add(b);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void initButton() {
		this.startButton = new JButton(START);
		startButton.setBounds(configList.get(0).getPosX(), 
							  configList.get(0).getPosY() + (configList.get(0).getHeight() - 64 >> 1), 
							  150, 64);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dto.isStart())
					gameController.restart();
				else
					gameController.start();
			}
		});
		add(startButton);
		
		this.pauseButton = new JButton(PAUSE);
		pauseButton.setBounds(configList.get(0).getPosX() + 150,  
				  			  configList.get(0).getPosY() + (configList.get(0).getHeight() - 64 >> 1),
				  			  150, 64);
		
		pauseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dto.isStart())
					gameController.pause();
			}
		});
		add(pauseButton);
	}

	public void initController(KeyController keyController) {
		this.addKeyListener(keyController);		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Block b : blockList) {
			b.paint(g);
		}
		requestFocus();
	}

	public void switchButton(boolean b) {
		startButton.setEnabled(!b);
		pauseButton.setEnabled(b);
	}
	
	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}
}

