package c461a.EntityModels;
import Models.*;
public class Mine1 extends Mine{
	public Mine1(){
		this.setName("Mine1");
		this.setType("Building");
		this.setMaxHp(2000);
		this.setCurrentHp(2000);
		this.setMaintenance(20);
		this.setSightRange(5);
		this.setTypeG(3);
		this.setDefensiveness(600);
	}
	public Mine1(int x, int y){
		this.setX(x);
		this.setY(y);
		this.setName("Mine1");
		this.setType("Building");
		this.setMaxHp(2000);
		this.setCurrentHp(2000);
		this.setMaintenance(20);
		this.setSightRange(5);
		this.setTypeG(3);
		this.setDefensiveness(600);
	}
	public Mine1(int x, int y, int owner){
		this.setX(x);
		this.setY(y);
		this.setName("Mine1");
		this.setType("Building");
		this.setMaxHp(2000);
		this.setCurrentHp(2000);
		this.setMaintenance(20);
		this.setSightRange(5);
		this.setOwner(owner);
		this.setTypeG(3);
		this.setDefensiveness(600);
		setAim(new AimNode("none"));
	}
}
