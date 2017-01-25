package controller;

public enum Command {
	R(1), L(3), M(0);
	
	private int rotationalIncrement;
	
	private Command(int r){
		rotationalIncrement = r;
	}
	
	public int getRotationalIncrement(){
		return rotationalIncrement;
	}
}
