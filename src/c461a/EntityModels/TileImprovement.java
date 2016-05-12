package c461a.EntityModels;
import Models.*;
public class TileImprovement extends Building {
	public TileImprovement(){
		this.setName("TileImprovement");
		this.setType("Building");
		this.setMaxHp(2000);
		this.setCurrentHp(2000);
		this.setMaintenance(20);
		this.setSightRange(5);
		this.setTypeG(6);
		this.setDefensiveness(600);
	}
	public TileImprovement(int x, int y){
		this.setX(x);
		this.setY(y);
		this.setName("TileImprovement");
		this.setType("Building");
		this.setMaxHp(2000);
		this.setCurrentHp(2000);
		this.setMaintenance(20);
		this.setSightRange(5);
		this.setTypeG(6);
		this.setDefensiveness(600);
	}
	public TileImprovement(int x, int y, int owner){
		this.setX(x);
		this.setY(y);
		this.setName("TileImprovement");
		this.setType("Building");
		this.setMaxHp(2000);
		this.setCurrentHp(2000);
		this.setMaintenance(20);
		this.setSightRange(5);
		this.setOwner(owner);
		this.setTypeG(6);
		this.setDefensiveness(600);
	}
}
