package data;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameAct {
	private static List<Point[]> TYPES;
	private int typeCode;
	
	static {
		TYPES = new ArrayList<Point[]>(7);
		TYPES.add(new Point[] { new Point(4, 0), new Point(3, 0), new Point(4, 0), 
								new Point(5, 0), new Point(6, 0), });
		TYPES.add(new Point[] { new Point(5, 0), new Point(4, 0), new Point(5, 0), 
								new Point(6, 0), new Point(5, 1), });
		TYPES.add(new Point[] { new Point(5, 0), new Point(4, 0), new Point(5, 0), 
								new Point(6, 0), new Point(4, 1), });
		TYPES.add(new Point[] { new Point(5, 1), new Point(5, 0), new Point(6, 0), 
								new Point(4, 1), new Point(5, 1), });
		TYPES.add(new Point[] { new Point(0, 0), new Point(4, 0), new Point(5, 0), 
								new Point(4, 1), new Point(5, 1), });
		TYPES.add(new Point[] { new Point(5, 0), new Point(4, 0), new Point(5, 0), 
								new Point(6, 0), new Point(6, 1), });
		TYPES.add(new Point[] { new Point(5, 1), new Point(4, 0), new Point(5, 0), 
								new Point(5, 1), new Point(6, 1), });
	}
	
	/*
	 * Coordinator of this act
	 */
	private Point[] location;
	
	public GameAct() {
		init(new Random().nextInt(7));
	}
	
	public void init(int code) {
		this.typeCode = code;
		Point[] config = TYPES.get(code);
		location = new Point[config.length];
		for (int i = 0;i < config.length;i++) {
			location[i] = new Point(config[i].x, config[i].y);
		}
	}
	
	public Point[] getLocation() {
		return location;
	}
	
	public int getTypeCode() {
		return typeCode;
	}
	
	// Move the current falling block
	public void move(int x, int y) {
		for (Point p : location) {
			p.x += x;
			p.y += y;
		}
	}
}
