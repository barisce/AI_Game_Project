package c461a.EntityModels;

public class Barrack extends Building{
	public Barrack(){
		this.setName("Barrack");
		this.setType("Building");
		this.setMaxHp(3000);
		this.setCurrentHp(3000);
		this.setMaintenance(-5);
		this.setSightRange(5);
	}
	public Barrack(int x, int y){
		this.setX(x);
		this.setY(y);
		this.setName("Barrack");
		this.setType("Building");
		this.setMaxHp(3000);
		this.setCurrentHp(3000);
		this.setMaintenance(-5);
		this.setSightRange(5);
	}
	public Barrack(int x, int y,int owner){
		this.setX(x);
		this.setY(y);
		this.setName("Barrack");
		this.setType("Building");
		this.setMaxHp(3000);
		this.setCurrentHp(3000);
		this.setMaintenance(-5);
		this.setSightRange(5);
		this.setOwner(owner);
	}
}
