package c461a.EntityModels;
import Models.*;
public class Worker extends Unit {

	
	public Worker(){
		this.setName("Worker");
		this.setType("Melee");
		this.setMaxHp(250);
		this.setCurrentHp(250);
		this.setKills(0);
		this.setDamage(50);
		this.setMaintenance(-2);
		this.setMoveMax(3);
		this.setMoveLeft(0);
		this.setSightRange(5);
		this.setTypeG(11);
		
	}
	public Worker(int x, int y){
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
		this.setSightRange(5);
		this.setTypeG(11);
	}
	
	public Worker(int x, int y, int owner){
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
		this.setSightRange(5);
		this.setOwner(owner);
		this.setTypeG(11);
		setAim(new AimNode("none"));
	}
	


}
