package c461a.EntityModels;
import Models.*;
public class Unit extends Entity {
	private int damage;
	private int kills;
	private int moveMax;
	private int moveLeft;
	private int range;
	
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getKills() {
		return kills;
	}
	public void setKills(int kills) {
		this.kills = kills;
	}
	public int getMoveMax() {
		return moveMax;
	}
	public void setMoveMax(int moveMax) {
		this.moveMax = moveMax;
	}
	public int getMoveLeft() {
		return moveLeft;
	}
	public void setMoveLeft(int moveLeft) {
		this.moveLeft = moveLeft;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	
	
}
