package c461a.EntityModels;

public class Building extends Entity {
	public Building(){
		this.setType("Building");
		this.setMoveMax(0);
		int[] temp = new int[]{ 50, 50, 50};
		this.setInfluence(temp);
	}
	
	public int getInfluence( int d){
		if (d < 5){
			return 100;
		}
		else 
			return 0;
	}

	
}
