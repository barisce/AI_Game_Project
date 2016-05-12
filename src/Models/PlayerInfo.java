package Models;
import java.util.ArrayList;

import Models.*;

public class PlayerInfo {
	private int treasure;
	private int income;
	private int isDestroyed;
	private InfluenceMap testM;
	private InfluenceMap fog;
	private InfluenceMap isFound;
	private EntityContainer ec;
	
	public PlayerInfo(){
		ec = new EntityContainer();
		this.isDestroyed = 0;
		testM = new InfluenceMap();
		fog = new InfluenceMap(0);
		isFound =  new InfluenceMap(0);
	}
	public PlayerInfo(int x, int y){
		ec = new EntityContainer();
		this.isDestroyed = 0;
		testM = new InfluenceMap();
		fog = new InfluenceMap(0,x,y);
		isFound = new InfluenceMap(0,x,y);
		
	}
	
	
	public InfluenceMap getFog() {
		return fog;
	}
	public void setFog(InfluenceMap fog) {
		this.fog = fog;
	}
	public InfluenceMap getIsFound() {
		return isFound;
	}
	public void setIsFound(InfluenceMap isFound) {
		this.isFound = isFound;
	}
	public EntityContainer getEntityContainer() {
		return ec;
	}
	public void setEntityContainer(EntityContainer ec) {
		this.ec = ec;
	}
	
	public int getTreasure() {
		return treasure;
	}
	public void setTreasure(int treasure) {
		this.treasure = treasure;
	}
	
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getIsDestroyed() {
		return isDestroyed;
	}
	public void setIsDestroyed(int isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
}
