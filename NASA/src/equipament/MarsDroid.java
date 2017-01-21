/**
 * 
 */
package equipament;

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
	public enum MapDirection{
		N, E, S, W
	}
	private MapDirection direction;
	
	/**
	 * X e Y sao coordenadas 
	 * onde a Sonda se encontra no plano carteziano
 	 * que mapeia marte. 
 	 */
	private int x, y;

	
	
	public MarsDroid(){
		direction = MapDirection.N;
	}
	public MarsDroid(int x,int y,MapDirection direction){
		this.x = x;
		this.y = y;
		this.direction = direction;
		
	}
	
	public void turnRight(){
		switch(direction){
			case N: 
				direction = MapDirection.E;
				break;
				
			case E:
				direction = MapDirection.S;
				break;
				
			case S:
				direction = MapDirection.W;
				break;
				
			default:
				direction = MapDirection.N;
				break;
			
		}
	}
	public void turnLeft(){
		switch(direction){
			case N: 
				direction = MapDirection.W;
				break;
				
			case W:
				direction = MapDirection.S;
				break;
				
			case S:
				direction = MapDirection.E;
				break;
				
			default:
				direction = MapDirection.N;
				break;
		}
	}
	
	public MapDirection getDirection(){
		return direction;
	}
	
	public void move(){
		switch( direction ){
			case N: 
				y++;
				break;
			case E:
				x++;
				break;
			case S:
				y--;
				break;
			default:
				x--;
				break;
		}
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	
}
