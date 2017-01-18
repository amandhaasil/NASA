/**
 * 
 */
package controller;
import java.util.List;
import java.util.LinkedList;

import equipament.MarsDroid;

/**
 * @author Amandha
 *	Controlador de Sondas em Marte. Possivel criar novas sondas
 *	e movimenta-las na malha definida com extremidades de (0,0)
 *  ate (xMax, yMax)
 */
public class MarsDroidController {
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
			throw new Exception("This droid does not exist!");
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
				if((moving.getDirection() == 'N' && moving.getY() != yMax)
						|| (moving.getDirection() == 'E' && moving.getX() != xMax)
						|| (moving.getDirection() == 'S' && moving.getY() != 0)
						|| (moving.getDirection() == 'W' && moving.getX() != 0))
					moving.move();
				else throw new Exception("Droid attempted to leave the border."); 
			}
			else{
				throw new Exception("Invalid command /'" + aux + "'/."
						+ "/nPlease only use L, R or M with no space between.");
			}
		}
	}
	
	public void addNewDroid(int x, int y, char d, String m)throws Exception{
		//check if the position is valid
		if(x<0||x>xMax||y<0||y>yMax){
			throw new Exception("You can't create Droids out of the Borders."
					+ "/nMust have 0 <= x <= " + xMax
					+ " and 0 <= y <= " + yMax);
			
		}
		MarsDroid newDroid = new MarsDroid(x, y, d);
		droids.add(newDroid);
		moveDroidN(droids.size() -1, m);		
	}
	
	public List<MarsDroid> getDroids(){
		return droids;
	}
}
