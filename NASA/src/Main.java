import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import controller.Border;
import controller.Command;
import controller.MarsDroidController;
import equipament.Direction;
import equipament.MarsDroid;
import equipament.Position;


public class Main {

	private static int x, y;
	private static Direction direction;
	
	private static List<Command> processMovements(String m) throws Exception{
		List<Command> commandsList = new LinkedList<Command>();
		
		for(int i = 0; i < m.length(); i++){
			switch(m.charAt(i)){
			case 'M':
				commandsList.add(Command.M);
				break;
			case 'R':
				commandsList.add(Command.R);
				break;
			case 'L':
				commandsList.add(Command.L);
				break;
			default:
				throw new Exception("This Command doesn't exist");
			}
		}
		return commandsList;
	}
	
	private static boolean processDroidPosition(String p)throws Exception{
		if(p.charAt(0)=='q') return false;
		
		String[] position = p.split(" ");

		x = Integer.parseInt(position[0]);
		y = Integer.parseInt(position[1]);
		
		switch(position[2].charAt(0)){
			case 'N':
				direction = Direction.N;
				break;
			case 'E':
				direction = Direction.E;
				break;
			case 'S':
				direction = Direction.S;
				break;
			case 'W':
				direction = Direction.W;
				break;
			default:
				throw new Exception("This direction is no valid!");
		}
		
		return true;
	}
	
	public static void main(String args[]){
		
		Scanner scan = new Scanner(System.in);
		
		MarsDroidController controller;
		List<MarsDroid> droids;
		
		System.out.println("Welcome to NASA's program of Droids in Mars!");
		
		try{
			System.out.println("Please enter integers X and Y that will mark"
				+ " borders of the Cartesian Plane: ");
			String[] borders = (scan.nextLine()).split(" ");
		 
			x = Integer.parseInt(borders[0]);
			y = Integer.parseInt(borders[1]);
			
			controller = new MarsDroidController(new Border(x, y));
			
			String movements;
			String newPosition = scan.nextLine();
			while(processDroidPosition(newPosition)){
				movements = scan.nextLine();
				controller.addNewDroid(new Position(x, y), direction, processMovements(movements));
				
				newPosition = scan.nextLine();
			}
			
			System.out.println("\nDroids final positions:");
			droids = controller.getDroids();
			MarsDroid aux;
			for (int i = 0; i < droids.size(); i++){
				aux = droids.get(i);
				System.out.println(aux.getPosition().getX() + " " + aux.getPosition().getY() + " " + aux.getDirection());
			}
			
			System.out.print("\n Thank you!");
			
		}catch(Exception e){
			System.err.println(e.getMessage());
			System.err.println(e.getCause());
			
		}finally{
			scan.close();
		}
		
		scan.close();
	}
}
