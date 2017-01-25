package testeUnitario;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.Command;
import equipament.Direction;
import equipament.Position;

public class DirectionTest {

	@Test
	public void fullTurnRight() {
		Direction direction = Direction.N;
		Command command = Command.R;
		
		direction = direction.turn(command);		
		assertEquals(Direction.E, direction);
		
		direction = direction.turn(command);		
		assertEquals(Direction.S, direction);
		
		direction = direction.turn(command);		
		assertEquals(Direction.W, direction);
		
		direction = direction.turn(command);		
		assertEquals(Direction.N, direction);
	}
	
	@Test
	public void fullTurnLeft(){
		Direction direction = Direction.N;
		Command command = Command.L;

		direction = direction.turn(command);		
		assertEquals(Direction.W, direction);
		
		direction = direction.turn(command);		
		assertEquals(Direction.S, direction);
		
		direction = direction.turn(command);		
		assertEquals(Direction.E, direction);
		
		direction = direction.turn(command);		
		assertEquals(Direction.N, direction);
	}
	
	@Test
	public void notATurnCommand(){
		Direction direction = Direction.N;
		Command command = Command.M;
		
		//still same Direction (no turn)
		direction = direction.turn(command);		
		assertEquals(Direction.N, direction);
	}

	@Test
	public void moveNorth(){
		Direction direction = Direction.N;
		Position position = new Position(0, 0);
		
		position = direction.move(position);
		System.out.println(position.getX() + " " + position.getY());
		assertEquals(true, position.equals(new Position(0, 1)));
	}
	
	@Test
	public void moveEast(){
		Direction direction = Direction.E;
		Position position = new Position(0, 0);
		
		position = direction.move(position);
		assertEquals(new Position(1, 0), position);
	}
	
	@Test
	public void moveSouth(){
		Direction direction = Direction.S;
		Position position = new Position(0, 1);
		
		position = direction.move(position);
		assertEquals(new Position(0, 0), position);
	}
	
	@Test
	public void moveWest(){
		Direction direction = Direction.W;
		Position position = new Position(1, 0);
		
		position = direction.move(position);
		assertEquals(new Position(0, 0), position);
	}
	
}