package testeUnitario;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import controller.Border;
import controller.Command;
import controller.MarsDroidController;
import controller.MarsDroidControllerException;
import equipament.Direction;
import equipament.MarsDroid;
import equipament.Position;

public class MarsDroidControllerTest {
	
	private MarsDroidController controller;
	private LinkedList<Command> commandsList;
	
	MarsDroidController limited;
	private LinkedList<Command> commandMove;
	private LinkedList<Command> turnRightAndMove;
	
	final private String nonExistentMessage = "This droid does not exist!";
	final private String addingOutOfBoundsMessage = "You can't create Droids out of the Bounds.";
//	final private String tryingToLeaveBorderMessage = "Droid attempted to leave the border.";
	
	
	@Before
	public void inicialize() throws Exception{
		controller = new MarsDroidController(new Border(3, 3));
		controller.addNewDroid(new Position(1, 2), Direction.N, null);
		
		//"MRMMRMMRMMLLM"
		Command[] array = {Command.M, Command.R,
				Command.M, Command.M, Command.R,
				Command.M, Command.M, Command.R,
				Command.M, Command.M, Command.L,
				Command.L, Command.M};
		commandsList = new LinkedList<Command>(Arrays.asList(array));
		
		limited = new MarsDroidController(new Border(0,0));
		limited.addNewDroid(new Position(0,0), Direction.N, null);
		
		commandMove = new LinkedList<Command>();
		commandMove.add(Command.M);
		
		turnRightAndMove = new LinkedList<Command>();
		turnRightAndMove.add(Command.R);
		turnRightAndMove.add(Command.M);
	}
	
	
	@Test
	public void nonExistentDroidTest() throws Exception{
		try{
			controller.moveDroidN(1, null);
			assertEquals(1, 0);//forcing to fail if does not throw an exception
		}catch(MarsDroidControllerException nonExistent){
			assertEquals(nonExistentMessage, nonExistent.getMessage());
		}
	}
	
	@Test
	public void addingNewDroidTest()throws Exception{
		controller.addNewDroid(new Position(3, 3), Direction.N, null);
		List<MarsDroid> check = controller.getDroids();
		MarsDroid aux = check.get(check.size() -1 );
		
		assertEquals(new Position(3, 3), aux.getPosition());
		assertEquals(Direction.N, aux.getDirection());
	}
	
	@Test
	public void addingOutOfBoundsTest()throws Exception{

		//X is Negative 
		try{	
			controller.addNewDroid(new Position(-1, 0), Direction.N, null);
			assertEquals(1, 0);//forcing to fail if does not throw an exception
		}catch(MarsDroidControllerException xnegative){
			assertEquals(addingOutOfBoundsMessage, xnegative.getMessage());
		}
		
		//Y is Negative
		try{
			controller.addNewDroid(new Position(0, -1), Direction.N, null);
			assertEquals(1, 0);//forcing to fail if does not throw an exception
		}catch(MarsDroidControllerException ynegative){
			assertEquals(addingOutOfBoundsMessage, ynegative.getMessage());
		}
		
		//X out of bound 3
		try{
			controller.addNewDroid(new Position(4, 0), Direction.N, null);
			assertEquals(1, 0);//forcing to fail if does not throw an exception
		}catch(MarsDroidControllerException xOut){
			assertEquals(addingOutOfBoundsMessage, xOut.getMessage());
		}
		
		//Y out of Bound 3
		try{
			controller.addNewDroid(new Position(0, 4), Direction.N, null);
			assertEquals(1, 0);//forcing to fail if does not throw an exception
		}catch(MarsDroidControllerException yOut){
			assertEquals(addingOutOfBoundsMessage, yOut.getMessage());
		}
	}
	
	@Test
	public void movingDroidTest()throws Exception{
		controller.moveDroidN(0, commandsList);
		
		List<MarsDroid> check = controller.getDroids();
		MarsDroid aux = check.get(0);
		
		assertEquals( new Position(2, 1), aux.getPosition());
		assertEquals(Direction.E, aux.getDirection());
	}
	
	@Test 
	public void noPlaceToMoveTest()throws Exception{
		limited.moveDroidN(0, commandMove);
		limited.moveDroidN(0, turnRightAndMove);
		limited.moveDroidN(0, turnRightAndMove);
		limited.moveDroidN(0, turnRightAndMove);
		
		List<MarsDroid> check = limited.getDroids();
		MarsDroid aux = check.get(0);
		
		assertEquals( new Position(0, 0), aux.getPosition());
		assertEquals(Direction.W, aux.getDirection());
	}
}
		
		
