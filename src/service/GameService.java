package service;

import java.awt.Point;
import java.util.Random;

import data.Dto;
import data.GameAct;

public class GameService {
	private Dto dataObj;
	
	/*
	 * Size of game map
	 */
	private static final int MAP_WIDTH = 10;
	private static final int MAP_HEIGHT = 18; 
	
	public GameService(Dto dataObj) {
		this.dataObj = dataObj;
	}
	
	private void setAct() {
		GameAct act = new GameAct();
		this.dataObj.setAct(act);
		this.dataObj.setNextType(new Random().nextInt(7));
	}

	public void moveLeft(int x, int y) {
		synchronized (dataObj) {
			if (canMove(x, y)) {
				this.dataObj.getAct().move(x, y);
			}
		}
	}
	
	public void moveRight(int x, int y) {
		synchronized (dataObj) {
			if (canMove(x, y)) {
				this.dataObj.getAct().move(x, y);
			}
		}
	}
	
	public void moveDown() {
		if (dataObj.isStart()) {
			while (canMove(0,1)) {
				moveOneStepDown(0, 1);
			}
		}
		
		boolean[][] map = dataObj.getMap();
		Point[] pos = this.dataObj.getAct().getLocation();
		for (int i = 1;i < pos.length;i++) {
			map[pos[i].x][pos[i].y] = true;
		}
		
		// Refresh a new block
		dataObj.getAct().init(dataObj.getNextType());
		//dataObj.setNextType(new Random().nextInt(7));
		dataObj.setNextType(new Random().nextInt(7));
		
		// Check death. If the new act has overlapping with map, game over
		if (isOver()) {
			dataObj.setStart(false);
			return;
		}
		
		// Remove line and update scores
		for (int i = 0;i < map[0].length;i++) {
			if (canRemove(i, map)) {
				removeLine(i, map);
				updateScores();
			}
		}
	}
	
	public void moveOneStepDown(int x, int y) {
		synchronized (dataObj) {
			if (canMove(x, y)) {
				this.dataObj.getAct().move(x, y);
			} else {
				boolean[][] map = dataObj.getMap();
				Point[] pos = this.dataObj.getAct().getLocation();
				for (int i = 1;i < pos.length;i++) {
					map[pos[i].x][pos[i].y] = true;
				}
				// Refresh a new block
				dataObj.getAct().init(dataObj.getNextType());
				dataObj.setNextType(new Random().nextInt(7));
				
				// Check death. If the new act has overlapping with map, game over
				if (isOver()) {
					dataObj.setStart(false);
					return;
				}
				
				// Remove line and update scores
				for (int i = 0;i < map[0].length;i++) {
					if (canRemove(i, map)) {
						removeLine(i, map);
						updateScores();
					}
				}
			}
		}
	}
	
	private boolean isOver() {
		Point[] currAct = dataObj.getAct().getLocation();
		boolean[][] currMap = dataObj.getMap();
		
		for (Point p : currAct) {
			if (currMap[p.x][p.y])
				return true;
		}
		return false;
	}

	// Check whether can remove line idx 
	private boolean canRemove(int idx, boolean[][] map) {
		for (int i = 0;i < map.length;i++) {
			if (!map[i][idx]) return false;
		}
		return true;
	}
	
	// Remove line
	private void removeLine(int idx, boolean[][] map) {
		for (int i = idx;i > 0;i--) {
			for (int j = 0;j < map.length;j++) {
				map[j][i] = map[j][i - 1];
			}
		}
		
		for (int j = 0;j < map.length;j++) {
			map[j][0] = false;
		}
	}
	
	// Update data after removing line
	private void updateScores() {
		int currScore = dataObj.getCurrScore();
		int currLevel = dataObj.getCurrLevel();
		int currLine = dataObj.getCurrLine();
		
		dataObj.setCurrLine(currLine + 1);
		dataObj.setCurrScore(currScore + 20);
		if (dataObj.getCurrLine() % Dto.LEVEL_UP == 0) {
			dataObj.setCurrLevel(currLevel + 1);
		}
	}
	
	// Rotate the act
	public void rotate() {
		synchronized (dataObj) {
			Point[] pos = dataObj.getAct().getLocation();
			
			if (canRotate()) {
				Point center = pos[0];
				for (Point p : pos) {
					int oldX = p.x;
					int oldY = p.y;
					int newX = center.y + center.x - oldY;
					int newY = center.y - center.x + oldX;
					p.x = newX;
					p.y = newY;
				}
			}
		}
	}
	
	// Check whether can move 
	private boolean canMove(int x, int y) {
		if (dataObj.getAct() == null) return false;
		Point[] pos = dataObj.getAct().getLocation();
		for (int i = 1;i < pos.length;i++) {
			if (pos[i].x + x < 0 || pos[i].x + x >= MAP_WIDTH || 
				pos[i].y + y < 0 || pos[i].y + y >= MAP_HEIGHT ||
				(dataObj.getMap()[pos[i].x + x][pos[i].y + y])) {
				return false;
			}
		}
		return true;
	}
	
	// Check whether can rotate 90 degree
	private boolean canRotate() {
		Point[] pos = dataObj.getAct().getLocation();
		Point center = pos[0];
		for (int i = 1; i < pos.length; i++) {
			int oldX = pos[i].x;
			int oldY = pos[i].y;
			int newX = center.y + center.x - oldY;
			int newY = center.y - center.x + oldX;
			
			if (newX < 0 || newX >= MAP_WIDTH || 
					newY < 0 || newY >= MAP_HEIGHT ||
					(dataObj.getMap()[newX][newY])) {
					return false;
			}
		}
		return true;
	}
	
	public void startGame() {
		dataObj.setStart(true);
		dataObj.initRestart();
		setAct();
	}

	// ========================For test=======================
	public void lineIncrement() {
		int currScore = dataObj.getCurrScore();
		int currLevel = dataObj.getCurrLevel();
		int currLine = dataObj.getCurrLine();
		
		dataObj.setCurrLine(currLine + 1);
		dataObj.setCurrScore(currScore + 20);
		if (dataObj.getCurrLine() % Dto.LEVEL_UP == 0) {
			dataObj.setCurrLevel(currLevel + 1);
		}
	}
}
