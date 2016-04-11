
public class Tower extends Building{
	private int damage;
	private int range;
	Tower(){
		this.setName("Tower");
		this.setType("Building");
		this.setMaxHp(4000);
		this.setCurrentHp(4000);
		this.setMaintenance(-5);
		this.setSightRange(15);
		this.setRange(5);
		this.setDamage(300);
	}
	Tower(int x, int y){
		this.setX(x);
		this.setY(y);
		this.setName("Tower");
		this.setType("Building");
		this.setMaxHp(4000);
		this.setCurrentHp(4000);
		this.setMaintenance(-5);
		this.setSightRange(15);
		this.setRange(5);
		this.setDamage(300);
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
