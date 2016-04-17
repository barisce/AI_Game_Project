package c461a.EntityModels;

public class Siege extends Range {
	public Siege(){
		this.setName("Siege");
		this.setType("Siege");
		this.setMaxHp(500);
		this.setCurrentHp(500);
		this.setKills(0);
		this.setDamage(300);
		this.setRange(4);
		this.setMoveMax(5);
		this.setMoveLeft(0);
		this.setSightRange(10);
	}
	
	public Siege(int x, int y){
		this.setX(x);
		this.setY(y);
		this.setName("Siege");
		this.setType("Siege");
		this.setMaxHp(500);
		this.setCurrentHp(500);
		this.setKills(0);
		this.setDamage(300);
		this.setRange(4);
		this.setMoveMax(5);
		this.setMoveLeft(0);
		this.setSightRange(10);
	}
	public Siege(int x, int y, int owner){
		this.setX(x);
		this.setY(y);
		this.setName("Siege");
		this.setType("Siege");
		this.setMaxHp(500);
		this.setCurrentHp(500);
		this.setKills(0);
		this.setDamage(300);
		this.setRange(4);
		this.setMoveMax(5);
		this.setMoveLeft(0);
		this.setSightRange(10);
		this.setOwner(owner);
	}
}
