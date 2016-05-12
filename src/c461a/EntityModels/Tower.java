package c461a.EntityModels;
import Models.*;
public class Tower extends Building{
	private int damage;
	private int range;
	public Tower(){
		this.setName("Tower");
		this.setType("Building");
		this.setMaxHp(4000);
		this.setCurrentHp(4000);
		this.setMaintenance(-5);
		this.setSightRange(8);
		this.setRange(5);
		this.setDamage(300);
		this.setTypeG(2);
		this.setDefensiveness(-600);
	}
	public Tower(int x, int y){
		this.setX(x);
		this.setY(y);
		this.setName("Tower");
		this.setType("Building");
		this.setMaxHp(4000);
		this.setCurrentHp(4000);
		this.setMaintenance(-5);
		this.setSightRange(8);
		this.setRange(5);
		this.setDamage(300);
		this.setTypeG(2);
		this.setDefensiveness(-600);
	}
	public Tower(int x, int y, int owner){
		this.setX(x);
		this.setY(y);
		this.setName("Tower");
		this.setType("Building");
		this.setMaxHp(4000);
		this.setCurrentHp(4000);
		this.setMaintenance(-5);
		this.setSightRange(8);
		this.setRange(5);
		this.setDamage(300);
		this.setOwner(owner);
		this.setTypeG(2);
		this.setDefensiveness(-600);
		setAim(new AimNode("none"));
	}
	
	
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}

}
