package c461a.EntityModels;

public class Mine1 extends Building{
	Mine1(){
		this.setName("Mine1");
		this.setType("Building");
		this.setMaxHp(2000);
		this.setCurrentHp(2000);
		this.setMaintenance(20);
		this.setSightRange(5);
	}
	Mine1(int x, int y){
		this.setX(x);
		this.setY(y);
		this.setName("Mine1");
		this.setType("Building");
		this.setMaxHp(2000);
		this.setCurrentHp(2000);
		this.setMaintenance(20);
		this.setSightRange(5);
	}
}
