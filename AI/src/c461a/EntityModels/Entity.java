package c461a.EntityModels;

public class Entity {
	String name;
	private int currentHp;
	private int maxHp;
	private int sightRange;
	private int x;
	private int y;
	private String type;
	private int maintenance;
	private int owner;
	
	
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	public int getSightRange() {
		return sightRange;
	}
	public void setSightRange(int sightRange) {
		this.sightRange = sightRange;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public int getCurrentHp() {
		return currentHp;
	}
	public void setCurrentHp(int currentHp) {
		this.currentHp = currentHp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public int getMaintenance() {
		return maintenance;
	}
	public void setMaintenance(int maintenance) {
		this.maintenance = maintenance;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
