package c461a.EntityModels;

public class TileImprovement extends Building {
	public TileImprovement(){
		this.setName("Mine1");
		this.setType("Building");
		this.setMaxHp(2000);
		this.setCurrentHp(2000);
		this.setMaintenance(20);
		this.setSightRange(5);
	}
	public TileImprovement(int x, int y){
		this.setX(x);
		this.setY(y);
		this.setName("Mine1");
		this.setType("Building");
		this.setMaxHp(2000);
		this.setCurrentHp(2000);
		this.setMaintenance(20);
		this.setSightRange(5);
	}
	public TileImprovement(int x, int y, int owner){
		this.setX(x);
		this.setY(y);
		this.setName("Mine1");
		this.setType("Building");
		this.setMaxHp(2000);
		this.setCurrentHp(2000);
		this.setMaintenance(20);
		this.setSightRange(5);
		this.setOwner(owner);
	}
}
