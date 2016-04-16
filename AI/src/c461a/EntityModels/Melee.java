package c461a.EntityModels;

public class Melee extends Unit {
	
	public Melee(){
		this.setName("Melee");
		this.setType("Melee");
		this.setMaxHp(500);
		this.setCurrentHp(500);
		this.setKills(0);
		this.setDamage(300);
		this.setMaintenance(-5);
		this.setMoveMax(3);
		this.setMoveLeft(0);
		this.setSightRange(7);
		
	}
	public Melee(int x, int y){
		this.setX(x);
		this.setY(y);
		this.setName("Melee");
		this.setType("Melee");
		this.setMaxHp(500);
		this.setCurrentHp(500);
		this.setKills(0);
		this.setDamage(300);
		this.setMaintenance(-5);
		this.setMoveMax(3);
		this.setMoveLeft(0);
		this.setSightRange(7);
	}
	
}
