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
	private List<MarsDroid> sondas = new LinkedList<MarsDroid>();
	
	public MarsDroidController(int xMax, int yMax){
		this.xMax = xMax; 
		this.yMax = yMax;
	}
	
	public void addNewDroid(){
		
	}
}
