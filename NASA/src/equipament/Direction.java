package equipament;

import controller.Command;


public enum Direction {
	N(0, 1), E(1, 0), S(0, -1), W(-1, 0);
	
	private int xIncrement, yIncrement;
	
	private Direction(int x,int  y){
		xIncrement = x;
		yIncrement = y;
	}
	
	public Position move(Position p){
		return new Position(p.getX() + xIncrement, p.getY() + yIncrement);
	}
	
	public Direction turn(Command c){
		Direction[] directions = Direction.values();
		
		return directions[ (this.ordinal() + c.getRotationalIncrement()) % 4 ];
	}

}
