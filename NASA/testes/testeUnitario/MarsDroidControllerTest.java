package testeUnitario;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import controller.MarsDroidController;
import controller.MarsDroidControllerException;
import equipament.MarsDroid;
import equipament.MarsDroid.MapDirection;

public class MarsDroidControllerTest {
	
	private MarsDroidController controller = new MarsDroidController(3, 3);
	final private String nonExistentMessage = "This droid does not exist!";
	final private String addingOutOfBoundsMessage = "You can't create Droids out of the Bounds."
			+ "\nMust have 0 <= x <= 3" 
			+ " and 0 <= y <= 3";
	final private String tryingToLeaveBorderMessage = "Droid attempted to leave the border.";
	
	
	@Test
	public void nonExistentDroidTest()throws Exception{
		controller.addNewDroid(1, 2, MapDirection.N, "");
		
		try{
			controller.moveDroidN(1, "");
			assertEquals(1, 0);//forcing to fail if does not throw an exception
		}catch(MarsDroidControllerException nonExistent){
			assertEquals(nonExistentMessage, nonExistent.getMessage());
		}
	}
	
	@Test
	public void addingNewDroidTest()throws Exception{
		controller.addNewDroid(1, 2, MapDirection.N, "");
		List<MarsDroid> check = controller.getDroids();
		MarsDroid aux = check.get(0);
		
		assertEquals(1, aux.getX());
		assertEquals(2, aux.getY());
		assertEquals(MapDirection.N, aux.getDirection());
	}
	
	@Test
	public void addingOutOfBoundsTest1()throws Exception{
		
		//X is Negative 
		try{
			controller.addNewDroid(-1, 0, MapDirection.N, "");
			assertEquals(1, 0);//forcing to fail if does not throw an exception
		}catch(MarsDroidControllerException xnegative){
			assertEquals(addingOutOfBoundsMessage, xnegative.getMessage());
		}
		
		//Y is Negative
		try{
			controller.addNewDroid(0, -1, MapDirection.N, "");
			assertEquals(1, 0);//forcing to fail if does not throw an exception
		}catch(MarsDroidControllerException ynegative){
			assertEquals(addingOutOfBoundsMessage, ynegative.getMessage());
		}
		
		//X out of bound 3
		try{
			controller.addNewDroid(4, 0, MapDirection.N, "");
			assertEquals(1, 0);//forcing to fail if does not throw an exception
		}catch(MarsDroidControllerException xOut){
			assertEquals(addingOutOfBoundsMessage, xOut.getMessage());
		}
		
		//Y out of Bound 3
		try{
			controller.addNewDroid(0, 4, MapDirection.N, "");
			assertEquals(1, 0);//forcing to fail if does not throw an exception
		}catch(MarsDroidControllerException yOut){
			assertEquals(addingOutOfBoundsMessage, yOut.getMessage());
		}
	}
	
	@Test
	public void movingDroidTest()throws Exception{
		//Add droid to the list (not moving)
		controller.addNewDroid(1, 2, MapDirection.N, "");
		
		//Move it
		controller.moveDroidN(0, "MRMMRMMRMMLLM");
		
		//Check final position
		List<MarsDroid> check = controller.getDroids();
		MarsDroid aux = check.get(0);
		
		assertEquals(2, aux.getX());
		assertEquals(1, aux.getY());
		assertEquals(MapDirection.E, aux.getDirection());
	}
	
	@Test 
	public void movingOutNorthTest()throws Exception{
		//Droid can't move
		MarsDroidController limited = new MarsDroidController(0, 0);

		try{
			limited.addNewDroid(0, 0, MapDirection.N, "M");
			assertEquals(1, 0);//forcing to fail if does not throw an exception
		}catch(MarsDroidControllerException goingOut){
			assertEquals(tryingToLeaveBorderMessage, goingOut.getMessage());
		}
	}
	
	@Test 
	public void movingOutEastTest()throws Exception{
		//Droid can't move
		MarsDroidController limited = new MarsDroidController(0, 0);

		try{
			limited.addNewDroid(0, 0, MapDirection.E, "M");
			assertEquals(1, 0);//forcing to fail if does not throw an exception
		}catch(MarsDroidControllerException goingOut){
			assertEquals(tryingToLeaveBorderMessage, goingOut.getMessage());
		}
	}
	
	@Test 
	public void movingOutSouthTest()throws Exception{
		//Droid can't move
		MarsDroidController limited = new MarsDroidController(0, 0);

		try{
			limited.addNewDroid(0, 0, MapDirection.S, "M");
			assertEquals(1, 0);//forcing to fail if does not throw an exception
		}catch(MarsDroidControllerException goingOut){
			assertEquals(tryingToLeaveBorderMessage, goingOut.getMessage());
		}
	}

	@Test 
	public void movingOutWestTest()throws Exception{
		//Droid can't move
		MarsDroidController limited = new MarsDroidController(0, 0);

		try{
			limited.addNewDroid(0, 0, MapDirection.W, "M");
			assertEquals(1, 0);//forcing to fail if does not throw an exception
		}catch(MarsDroidControllerException goingOut){
			assertEquals(tryingToLeaveBorderMessage, goingOut.getMessage());
		}
	}
}
