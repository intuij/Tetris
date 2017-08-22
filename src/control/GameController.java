package control;

import data.Dto;
import service.GameService;
import ui.GameFrame;
import ui.GamePanel;

public class GameController {
	/*
	 * Connect to UI layer
	 */
	private GamePanel gamePanel;
	
	/*
	 * Connect to game logic
	 */
	private GameService gameService;
	
	/*
	 * Game data object
	 */
	private Dto gameDto;

	/*
	 * The event listener of game
	 */
	private KeyController keyController;
	
	/*
	 * The control thread of game
	 */
	private Thread gameThread;
	
	public GameController() {
		initComponents();
		// Create player controller
		keyController = new KeyController(this);
		// Install the keyController on game panel
		gamePanel.initController(keyController);
		gamePanel.setGameController(this);
		// Create frame
		new GameFrame(gamePanel);
	}
	
	private void initComponents() {
		// Global data object
		gameDto = new Dto();
		// Create game logic
		gameService = new GameService(gameDto);
		// Create content panel
		gamePanel = new GamePanel(gameDto);
	}
	
	// Move logic
	public void moveLeft(int x, int y) {
		gameService.moveLeft(x, y);
		gamePanel.repaint();
	}
	
	public void moveRight(int x, int y) {
		gameService.moveRight(x, y);
		gamePanel.repaint();
	}
	
	public void moveDown() {
		gameService.moveDown();
		gamePanel.repaint();
	}
	
	// Rotate logic
	public void rotateAct() {
		gameService.rotate();
		gamePanel.repaint();
	}
	
	// Start the game
	public void start() {
		//initComponents();
		gamePanel.switchButton(true);
		gameService.startGame();
		
		gameThread = new Thread() {
			@Override
			public void run() {
				gamePanel.repaint();
				while (gameDto.isStart()) {
					try {
						Thread.sleep(800);
						if (gameDto.isPause())	{
							continue;
						}
						gameService.moveOneStepDown(0, 1);
						gamePanel.repaint();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				afterDead();
			}
		};
		gameThread.start();
		gamePanel.repaint();
	}
	
	// Restart the game after pausing
	public void restart() {
		gameDto.setPause(false);
		gamePanel.switchButton(true);
	}
	
	// Pause the game
	public void pause() {
		gameDto.setPause(true);
		gamePanel.switchButton(false);
	}
	
	public Dto getGameDto() {
		return gameDto;
	}
	
	public void afterDead() {
		gamePanel.switchButton(false);
	}
	
	//===============test======================
	public void lineIncrement() {
		gameService.lineIncrement();
		gamePanel.repaint();
	}
}
