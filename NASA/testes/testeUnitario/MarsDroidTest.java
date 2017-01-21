package testeUnitario;
import equipament.MarsDroid;
import equipament.MarsDroid.MapDirection;
import static org.junit.Assert.*;

import org.junit.Test;

public class MarsDroidTest {
	
	private MarsDroid r2d2;
	
	@Test
	public void testDefaultInicialization(){
		r2d2 = new MarsDroid();
		assertEquals(0, r2d2.getX());
		assertEquals(0, r2d2.getY());
		assertEquals(MapDirection.N, r2d2.getDirection());
	}

	@Test
	public void testInicialization() throws Exception{
		r2d2 = new MarsDroid(2, 3, MapDirection.S);
		assertEquals(2, r2d2.getX());
		assertEquals(3, r2d2.getY());
		assertEquals(MapDirection.S, r2d2.getDirection());
	}
	
	
	@Test
	public void testFullTurns(){
		r2d2 = new MarsDroid();
		assertEquals(MapDirection.N, r2d2.getDirection());
		
		r2d2.turnRight();
		assertEquals(MapDirection.E, r2d2.getDirection());
		
		r2d2.turnRight();
		assertEquals(MapDirection.S, r2d2.getDirection());
		
		r2d2.turnRight();
		assertEquals(MapDirection.W, r2d2.getDirection());
		
		r2d2.turnRight();
		assertEquals(MapDirection.N, r2d2.getDirection());
		
		r2d2.turnLeft();
		assertEquals(MapDirection.W, r2d2.getDirection());
		
		r2d2.turnLeft();
		assertEquals(MapDirection.S, r2d2.getDirection());
		
		r2d2.turnLeft();
		assertEquals(MapDirection.E, r2d2.getDirection());
		
		r2d2.turnLeft();
		assertEquals(MapDirection.N, r2d2.getDirection());
	}
	
	@Test
	public void testMovingAround(){
		r2d2 = new MarsDroid();
		
		r2d2.move();
		assertEquals(0, r2d2.getX());
		assertEquals(1, r2d2.getY());
		assertEquals(MapDirection.N, r2d2.getDirection());
		
		r2d2.turnRight();
		r2d2.move();
		assertEquals(1, r2d2.getX());
		assertEquals(1, r2d2.getY());
		assertEquals(MapDirection.E, r2d2.getDirection());
		
		r2d2.turnLeft();
		r2d2.move();
		assertEquals(1, r2d2.getX());
		assertEquals(2, r2d2.getY());
		assertEquals(MapDirection.N, r2d2.getDirection());
		
		r2d2.turnLeft();
		r2d2.move();
		assertEquals(0, r2d2.getX());
		assertEquals(2, r2d2.getY());
		assertEquals(MapDirection.W, r2d2.getDirection());
		
		r2d2.turnLeft();
		r2d2.move();
		assertEquals(0, r2d2.getX());
		assertEquals(1, r2d2.getY());
		assertEquals(MapDirection.S, r2d2.getDirection());
		
	}
	

}
