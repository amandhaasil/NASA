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
	 * X e Y sao coordenadas 
	 * onde a Sonda se encontra no plano carteziano
 	 * que mapeia marte. 
 	 */
	private int x, y;
	/**
	 * Direcao eh representada dentro da classe como um inteiro, 
	 * para que seja mais facil mudar sua direcao, portanto o zero
	 * representa Norte(N), 1 representa leste(E), 2 sul(S) e
	 * 3 oeste(W).
	 */
	private int direction;
	
	public MarsDroid(){}
	public MarsDroid(int x,int y,char d)throws Exception{
		this.x = x;
		this.y = y;
		
		if (d == 'N') direction = 0;
		else if(d == 'E') direction = 1;
		else if(d == 'S') direction = 2;
		else if(d == 'W') direction = 3;
		else throw new MarsDroidException("Not a valid Direction!");
		
	}
	
	public void turnRight(){
		direction = (direction+1)%4;
	}
	public void turnLeft(){
		direction = (direction+3)%4;
	}
	
	public char getDirection(){
		if(direction == 0)return 'N';
		else if(direction == 1) return 'E';
		else if(direction == 2) return 'S';
		else return 'W';
	}
	
	public void move(){
		switch( direction ){
			case 0: 
				y++;
				break;
			case 1:
				x++;
				break;
			case 2:
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
