package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyController extends KeyAdapter {
	private GameController gameController;
	
	public KeyController(GameController gameController) {
		this.gameController = gameController;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (gameController.getGameDto().isPause() || !gameController.getGameDto().isStart())
			return;
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			// Rotate
			gameController.rotateAct();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			// Move down
			gameController.moveDown();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// Move left
			gameController.moveLeft(-1, 0);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// Move right
			gameController.moveRight(1, 0);
		} else if (e.getKeyCode() == KeyEvent.VK_Q) {
			gameController.lineIncrement();
		}
	}

	public GameController getGameController() {
		return gameController;
	}
}
