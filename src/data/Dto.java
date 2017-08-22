package data;

import java.util.List;

/**
 * The data transmission object that carries all data in the game
 * @author weiyijiang
 */

public class Dto {
	/*
	 * Required removing line number to next level
	 */
	public static final int LEVEL_UP = 20;
	
	/*
	 * Record list of local
	 */
	private List<PlayerRecord> localList;
	/*
	 * Record list in DB
	 */
	private List<PlayerRecord> dbList;
	/*
	 * The main window map of game
	 */
	private boolean[][] map;
	/*
	 * The block which is falling currently
	 */
	private GameAct act;
	/*
	 * The next block
	 */
	private int nextType;
	/*
	 * Current level
	 */
	private int currLevel;
	/*
	 * Current score
	 */
	private int currScore;
	/*
	 * Current exp
	 */
	private int currExp;
	/*
	 * Current remove line numebr
	 */
	private int currLine;
	/*
	 * Status of the game
	 */
	private boolean start;
	private boolean pause;
	
	public int getCurrLine() {
		return currLine;
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public void setCurrLine(int currLine) {
		this.currLine = currLine;
	}

	public Dto() {
		initDto();
	}
	
	private void initDto() {
		this.map = new boolean[10][18];
		this.currExp = 0;
		this.currLevel = 1;
		this.currScore = 0;
		this.currLine = 0;
		this.nextType = 0;
		this.start = false;
		this.pause = false;
	}
	
	public void initRestart() {
		this.map = new boolean[10][18];
		this.currExp = 0;
		this.currLevel = 1;
		this.currScore = 0;
		this.currLine = 0;
		this.nextType = 0;
		this.pause = false;
	}
	
	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public List<PlayerRecord> getLocalList() {
		return localList;
	}
	public GameAct getAct() {
		return act;
	}
	public void setAct(GameAct act) {
		this.act = act;
	}
	public void setLocalList(List<PlayerRecord> localList) {
		this.localList = localList;
	}
	public List<PlayerRecord> getDbList() {
		return dbList;
	}
	public void setDbList(List<PlayerRecord> dbList) {
		this.dbList = dbList;
	}
	public boolean[][] getMap() {
		return map;
	}
	public void setMap(boolean[][] map) {
		this.map = map;
	}
	public int getNextType() {
		return nextType;
	}
	public void setNextType(int nextType) {
		this.nextType = nextType;
	}
	public int getCurrLevel() {
		return currLevel;
	}
	public void setCurrLevel(int currLevel) {
		this.currLevel = currLevel;
	}
	public int getCurrScore() {
		return currScore;
	}
	public void setCurrScore(int currScore) {
		this.currScore = currScore;
	}
	public int getCurrExp() {
		return currExp;
	}
	public void setCurrExp(int currExp) {
		this.currExp = currExp;
	}
}
