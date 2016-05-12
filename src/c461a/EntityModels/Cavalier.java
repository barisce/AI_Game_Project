package c461a.EntityModels;
import Models.*;
public class Cavalier extends Unit{
	public Cavalier(){
		this.setName("Cavalier");
		this.setType("Cavalier");
		this.setMaxHp(800);
		this.setCurrentHp(800);
		this.setKills(0);
		this.setDamage(400);
		this.setMoveMax(7);
		this.setMoveLeft(0);
		this.setMaintenance(5);
		this.setSightRange(10);
		this.setTypeG(9);
		
	}
	public Cavalier(int x, int y){
		this.setX(x);
		this.setY(y);
		this.setName("Cavalier");
		this.setType("Cavalier");
		this.setMaxHp(800);
		this.setCurrentHp(800);
		this.setKills(0);
		this.setDamage(400);
		this.setMoveMax(7);
		this.setMoveLeft(0);
		this.setMaintenance(5);
		this.setSightRange(10);
		this.setTypeG(9);
		
	}
	public Cavalier(int x, int y, int owner){
		this.setX(x);
		this.setY(y);
		this.setName("Cavalier");
		this.setType("Cavalier");
		this.setMaxHp(800);
		this.setCurrentHp(800);
		this.setKills(0);
		this.setDamage(400);
		this.setMoveMax(7);
		this.setMoveLeft(0);
		this.setMaintenance(5);
		this.setSightRange(10);
		this.setOwner(owner);
		this.setTypeG(9);
		setAim(new AimNode("none"));
	}
}
