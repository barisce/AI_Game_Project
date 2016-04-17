package c461a.EntityModels;

public class Mine2 extends Mine {
	public Mine2(){
		this.setName("Mine1");
		this.setType("Building");
		this.setMaxHp(4000);
		this.setCurrentHp(4000);
		this.setMaintenance(50);
		this.setSightRange(5);
	}
	public Mine2(int x, int y){
		this.setX(x);
		this.setY(y);
		this.setName("Mine1");
		this.setType("Building");
		this.setMaxHp(4000);
		this.setCurrentHp(4000);
		this.setMaintenance(50);
		this.setSightRange(5);
	}
	public Mine2(int x, int y,int owner){
		this.setX(x);
		this.setY(y);
		this.setName("Mine1");
		this.setType("Building");
		this.setMaxHp(4000);
		this.setCurrentHp(4000);
		this.setMaintenance(50);
		this.setSightRange(5);
		this.setOwner(owner);
	}
}
