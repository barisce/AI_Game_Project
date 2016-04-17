package Controllers;

import c461a.EntityModels.*;

public class Move {
	private int x;
	private int y;
	private Entity e;
	
	public Move(int x, int y, Entity e){
		this.x = x;
		this.y = y;
		this.e = e;
	}

	public Move() {
		// TODO Auto-generated constructor stub
	}

	public int getX() {
		// TODO Auto-generated method stub
		return this.x;
	}
	
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

}
