/**
 * 
 */
package controller;
import java.util.List;
import java.util.LinkedList;

import equipament.Direction;
import equipament.MarsDroid;
import equipament.Position;

/**
 *	Controlador de Sondas em Marte. Possivel criar novas sondas
 *	e movimenta-las na malha definida com extremidades de (0,0)
 *  ate (xMax, yMax)
 *  
 *  @author Amandha
 */
public class MarsDroidController {
	final private String nonExistentMessage = "This droid does not exist!";
	final private String creatingOutOfBorderMessage = "You can't create Droids out of the Bounds.";
	
	int xMax, yMax;
	private List<MarsDroid> droids = new LinkedList<MarsDroid>();
	
	public MarsDroidController(int xMax, int yMax){
		this.xMax = xMax; 
		this.yMax = yMax;
	}
	
	
	public void moveDroidN(int n, List<Command> commands) throws Exception{
		//check if droid exists
		if(n>=droids.size() || n<0){
			throw new MarsDroidControllerException(nonExistentMessage);
		}
		
		if(commands != null){			
			MarsDroid moving = droids.get(n);
			
			for(Command command: commands){
				if(command==Command.M)
					moving.move();
				else
					moving.turn(command);
			}
		}
	}
	
	public void addNewDroid(Position p, Direction d, List<Command> commands)throws Exception{
		//check if the position is valid
		if(p.getX()<0||p.getX()>xMax||p.getY()<0||p.getY()>yMax){
			throw new MarsDroidControllerException(creatingOutOfBorderMessage);
		}
		
		MarsDroid newDroid = new MarsDroid(p, d);
		droids.add(newDroid);
		moveDroidN(droids.size() - 1, commands);		
	}
	
	public List<MarsDroid> getDroids(){
		return droids;
	}
}
