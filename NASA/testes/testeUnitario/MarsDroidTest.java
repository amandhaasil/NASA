package testeUnitario;
import equipament.Direction;
import equipament.MarsDroid;
import equipament.Position;
import static org.junit.Assert.*;

import org.junit.Test;

import controller.Command;

public class MarsDroidTest {
	
	private MarsDroid r2d2;
	
	@Test
	public void testDefaultInicialization(){
		r2d2 = new MarsDroid();
		assertEquals(new Position(0, 0), r2d2.getPosition());
		assertEquals(Direction.N, r2d2.getDirection());
	}

	@Test
	public void testInicialization() throws Exception{
		r2d2 = new MarsDroid(new Position(2, 3), Direction.S);
		assertEquals(new Position(2, 3), r2d2.getPosition());
		assertEquals(Direction.S, r2d2.getDirection());
	}
	
	
	@Test
	public void testTurnMethod(){
		//initializing with Noth
		r2d2 = new MarsDroid();
		
		r2d2.turn(Command.R);
		assertEquals(Direction.E, r2d2.getDirection());
		
	}
	
	@Test
	public void testMovingMethod(){
		r2d2 = new MarsDroid();
		
		r2d2.move();
		assertEquals(new Position(0, 1), r2d2.getPosition());
		
	}
	

}
