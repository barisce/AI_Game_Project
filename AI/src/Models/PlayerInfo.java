package Models;

public class PlayerInfo {
	private int treasure;
	private int revenue;
	private int isDestroyed;
	public PlayerInfo(){
		this.isDestroyed = 0;
	}
	public int getTreasure() {
		return treasure;
	}
	public void setTreasure(int treasure) {
		this.treasure = treasure;
	}
	public int getRevenue() {
		return revenue;
	}
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	public int getIsDestroyed() {
		return isDestroyed;
	}
	public void setIsDestroyed(int isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
}
