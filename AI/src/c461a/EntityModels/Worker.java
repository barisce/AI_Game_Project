package c461a.EntityModels;

public class Worker extends Unit {
	Worker(){
		this.setName("Worker");
		this.setType("Melee");
		this.setMaxHp(250);
		this.setCurrentHp(250);
		this.setKills(0);
		this.setDamage(50);
		this.setMaintenance(-2);
		this.setMoveMax(3);
		this.setMoveLeft(0);
		this.setSightRange(7);
		
	}
	Worker(int x, int y){
		this.setX(x);
		this.setY(y);
		this.setName("Worker");
		this.setType("Melee");
		this.setMaxHp(250);
		this.setCurrentHp(250);
		this.setKills(0);
		this.setDamage(50);
		this.setMaintenance(-2);
		this.setMoveMax(3);
		this.setMoveLeft(0);
		this.setSightRange(7);
	}

}
