

public class Town extends Building {
	Town(){
		this.setName("Town");
		this.setType("Building");
		this.setMaxHp(4000);
		this.setCurrentHp(4000);
		this.setMaintenance(10);
		this.setSightRange(15);
	}
	Town(int x, int y){
		this.setX(x);
		this.setY(y);
		this.setName("Town");
		this.setType("Building");
		this.setMaxHp(4000);
		this.setCurrentHp(4000);
		this.setMaintenance(10);
		this.setSightRange(15);
	}

}
