package c461a.EntityModels;
import Models.*;
public class Range extends Unit {
	
	public Range(){
		this.setName("Range");
		this.setType("Range");
		this.setMaxHp(500);
		this.setCurrentHp(500);
		this.setKills(0);
		this.setDamage(200);
		this.setRange(3);
		this.setMoveMax(5);
		this.setMoveLeft(0);
		this.setSightRange(10);
		this.setTypeG(8);
	}
	
	public Range(int x, int y){
		this.setX(x);
		this.setY(y);
		this.setName("Range");
		this.setType("Range");
		this.setMaxHp(500);
		this.setCurrentHp(500);
		this.setKills(0);
		this.setDamage(200);
		this.setRange(3);
		this.setMoveMax(5);
		this.setMoveLeft(0);
		this.setSightRange(10);
		this.setTypeG(8);
	}
	public Range(int x, int y, int owner){
		this.setX(x);
		this.setY(y);
		this.setName("Range");
		this.setType("Range");
		this.setMaxHp(500);
		this.setCurrentHp(500);
		this.setKills(0);
		this.setDamage(200);
		this.setRange(3);
		this.setMoveMax(5);
		this.setMoveLeft(0);
		this.setSightRange(10);
		this.setOwner(owner);
		this.setTypeG(8);
		setAim(new AimNode("none"));
	}
	
	
	
	
	
	

}
