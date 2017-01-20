import java.util.List;
import java.util.Scanner;

import controller.MarsDroidController;
import equipament.MarsDroid;


public class Main {

	private static int x, y;
	private static char d;
	
	private static boolean processDroidPosition(String p){
		if(p.charAt(0)=='q') return false;
		
		String[] position = p.split(" ");

		x = Integer.parseInt(position[0]);
		y = Integer.parseInt(position[1]);
		d = position[2].charAt(0);
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
			
			controller = new MarsDroidController(x, y);
			
			String movements;
			String newPosition = scan.nextLine();
			while(processDroidPosition(newPosition)){
				movements = scan.nextLine();
				controller.addNewDroid(x, y, d, movements);
				
				newPosition = scan.nextLine();
			}
			
			System.out.println("\nDroids final positions:");
			droids = controller.getDroids();
			MarsDroid aux;
			for (int i = 0; i < droids.size(); i++){
				aux = droids.get(i);
				System.out.println(aux.getX() + " " + aux.getY() + " " + aux.getDirection());
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
