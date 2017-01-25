/**
 * 
 */
package equipament;

import controller.Command;

/**
 * @author Amandha
 *
 * Equipamento utilizado para exploracao da
 * superficie de marte. Esta sonda eh capaz de se movimentar em apenas 4
 * direcoes: Norte(N), Sul(S), Leste(E) e Oeste(W)
 *  
 */
public class MarsDroid{
	
	/**
	 * Direcao eh representada dentro da classe como um inteiro, 
	 * para que seja mais facil mudar sua direcao, portanto o zero
	 * representa Norte(N), 1 representa leste(E), 2 sul(S) e
	 * 3 oeste(W).
	 */

	private Direction direction;
	
	/**
	 * X e Y sao coordenadas 
	 * onde a Sonda se encontra no plano carteziano
 	 * que mapeia marte. 
 	 */
	private Position position;

	
	
	public MarsDroid(){
		position = new Position(0, 0);
		direction = Direction.N;
	}
	public MarsDroid(Position p,Direction d){
		position = p;
		direction = d;	
	}
	
	public void turn(Command c){
		direction = direction.turn(c);
	}
	
	public Direction getDirection(){
		return direction;
	}
	
	public void move(){
		position = direction.move(position);
	}
	
	public Position getPosition(){
		return position;
	}
	
	
}
