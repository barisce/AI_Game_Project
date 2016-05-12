package c461a.EntityModels;
import Models.*;
public class Town extends Building {
	public Town(){
		this.setName("Town");
		this.setType("Building");
		this.setMaxHp(4000);
		this.setCurrentHp(4000);
		this.setMaintenance(10);
		this.setSightRange(5);
		this.setTypeG(1);
		this.setDefensiveness(1000);
	}
	public Town(int x, int y){
		this.setX(x);
		this.setY(y);
		this.setName("Town");
		this.setType("Building");
		this.setMaxHp(4000);
		this.setCurrentHp(4000);
		this.setMaintenance(10);
		this.setSightRange(5);
		this.setTypeG(1);
		this.setDefensiveness(1000);
	}
	public Town(int x, int y,int owner){
		this.setX(x);
		this.setY(y);
		this.setName("Town");
		this.setType("Building");
		this.setMaxHp(4000);
		this.setCurrentHp(4000);
		this.setMaintenance(10);
		this.setSightRange(5);
		this.setOwner(owner);
		this.setTypeG(1);
		this.setDefensiveness(1000);
		setAim(new AimNode("none"));
	}
	

}
