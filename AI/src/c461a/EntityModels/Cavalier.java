package c461a.EntityModels;

public class Cavalier extends Unit{
	Cavalier(){
		this.setName("Cavalier");
		this.setType("Cavalier");
		this.setMaxHp(500);
		this.setCurrentHp(800);
		this.setKills(0);
		this.setDamage(400);
		this.setMoveMax(7);
		this.setMoveLeft(0);
		this.setMaintenance(5);
		this.setSightRange(10);
		
	}
	Cavalier(int x, int y){
		this.setX(x);
		this.setY(y);
		this.setName("Cavalier");
		this.setType("Cavalier");
		this.setMaxHp(500);
		this.setCurrentHp(800);
		this.setKills(0);
		this.setDamage(400);
		this.setMoveMax(7);
		this.setMoveLeft(0);
		this.setMaintenance(5);
		this.setSightRange(10);
		
	}
}
