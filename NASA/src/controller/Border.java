package controller;

import equipament.Position;

public class Border {
	//min x, min y
	private int maxX, maxY;
	public Border(int x, int y){
		maxX = x;
		maxY = y;
	}
	
	public int getMaxX() {
		return maxX;
	}
	
	public int getMaxY() {
		return maxY;
	}
	
	public boolean isInsideBorders(Position p){
		if(p.getX() >= 0
				 && p.getX() <= maxX
				 && p.getY() >= 0
				 && p.getY() <= maxY)
			return true;
		return false;
	}
}
