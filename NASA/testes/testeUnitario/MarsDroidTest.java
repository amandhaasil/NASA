package testeUnitario;
import equipament.MarsDroid;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarsDroidTest {
	
	private MarsDroid r2d2;
	
	@Test
	public void testDefaultInicialization(){
		r2d2 = new MarsDroid();
		assertEquals(0, r2d2.getX());
		assertEquals(0, r2d2.getY());
		assertEquals('N', r2d2.getDirection());
	}

	@Test
	public void testInicialization() throws Exception{
		r2d2 = new MarsDroid(2, 3, 'S');
		assertEquals(2, r2d2.getX());
		assertEquals(3, r2d2.getY());
		assertEquals('S', r2d2.getDirection());
	}
	
	@Test
	public void testFullTurns(){
		r2d2 = new MarsDroid();
		assertEquals('N', r2d2.getDirection());
		
		r2d2.turnRight();
		assertEquals('E', r2d2.getDirection());
		
		r2d2.turnRight();
		assertEquals('S', r2d2.getDirection());
		
		r2d2.turnRight();
		assertEquals('W', r2d2.getDirection());
		
		r2d2.turnRight();
		assertEquals('N', r2d2.getDirection());
		
		r2d2.turnLeft();
		assertEquals('W', r2d2.getDirection());
		
		r2d2.turnLeft();
		assertEquals('S', r2d2.getDirection());
		
		r2d2.turnLeft();
		assertEquals('E', r2d2.getDirection());
		
		r2d2.turnLeft();
		assertEquals('N', r2d2.getDirection());
	}
	
	@Test
	public void testMovingAround(){
		r2d2 = new MarsDroid();
		
		r2d2.move();
		assertEquals(0, r2d2.getX());
		assertEquals(1, r2d2.getY());
		assertEquals('N', r2d2.getDirection());
		
		r2d2.turnRight();
		r2d2.move();
		assertEquals(1, r2d2.getX());
		assertEquals(1, r2d2.getY());
		assertEquals('E', r2d2.getDirection());
		
		r2d2.turnLeft();
		r2d2.move();
		assertEquals(1, r2d2.getX());
		assertEquals(2, r2d2.getY());
		assertEquals('N', r2d2.getDirection());
		
		r2d2.turnLeft();
		r2d2.move();
		assertEquals(0, r2d2.getX());
		assertEquals(2, r2d2.getY());
		assertEquals('W', r2d2.getDirection());
		
		r2d2.turnLeft();
		r2d2.move();
		assertEquals(0, r2d2.getX());
		assertEquals(1, r2d2.getY());
		assertEquals('S', r2d2.getDirection());
		
	}
	

}
