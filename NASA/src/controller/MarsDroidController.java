/**
 * 
 */
package controller;
import java.util.List;
import java.util.LinkedList;

import equipament.MarsDroid;
import equipament.MarsDroid.MapDirection;

/**
 * @author Amandha
 *	Controlador de Sondas em Marte. Possivel criar novas sondas
 *	e movimenta-las na malha definida com extremidades de (0,0)
 *  ate (xMax, yMax)
 */
public class MarsDroidController {
	final private String nonExistentMessage = "This droid does not exist!";
	final private String tryingToLeaveBorderMessage = "Droid attempted to leave the border.";
	 
	
	int xMax, yMax;
	private List<MarsDroid> droids = new LinkedList<MarsDroid>();
	
	public MarsDroidController(int xMax, int yMax){
		this.xMax = xMax; 
		this.yMax = yMax;
	}
	
	
	public void moveDroidN(int n, String m) throws Exception{
		MarsDroid moving;
		char aux;
		
		//check if droid exists
		if(n>=droids.size()){
			throw new MarsDroidControllerException(nonExistentMessage);
		}
		moving = droids.get(n);
		for(int i = 0; i < m.length(); i++){
			aux = m.charAt(i);
			
			if(aux == 'R')
				moving.turnRight();
			else if(aux == 'L')
				moving.turnLeft();
			else if(aux == 'M'){
				//se o droid nao estiver indo para fora dos limites pode se mover
				if((moving.getDirection() == MapDirection.N && moving.getY() != yMax)
						|| (moving.getDirection() == MapDirection.E && moving.getX() != xMax)
						|| (moving.getDirection() == MapDirection.S && moving.getY() != 0)
						|| (moving.getDirection() == MapDirection.W && moving.getX() != 0))
					moving.move();
				else throw new MarsDroidControllerException(tryingToLeaveBorderMessage); 
			}
			else{
				throw new MarsDroidControllerException("Invalid command /'" + aux + "'/."
						+ "\nPlease only use L, R or M with no space between.");
			}
		}
	}
	
	public void addNewDroid(int x, int y, MapDirection d, String m)throws Exception{
		//check if the position is valid
		if(x<0||x>xMax||y<0||y>yMax){
			throw new MarsDroidControllerException("You can't create Droids out of the Bounds."
					+ "\nMust have 0 <= x <= " + xMax
					+ " and 0 <= y <= " + yMax);
			
		}
		
		MarsDroid newDroid = new MarsDroid(x, y, d);
		droids.add(newDroid);
		moveDroidN(droids.size() - 1, m);		
	}
	
	public List<MarsDroid> getDroids(){
		return droids;
	}
}
