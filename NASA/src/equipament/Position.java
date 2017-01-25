package equipament;

public class Position {
	private int x, y;
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj == null) 
	        return false;
	    
	    if (!Position.class.isAssignableFrom(obj.getClass())) 
	        return false;
	        
	    final Position other = (Position) obj;
		if(other.getX() == x && other.getY() == y)
			return true;
		
		return false;
	}
	
}
