package c461a.EntityModels;

import Models.AimNode;
import Models.Map;

public class Entity {
	String name;
	private int currentHp;
	private int maxHp;
	private int sightRange;
	private int x;
	private int y;
	private String type;
	private int typeG;
	private int maintenance;
	private int owner;
	private int entityType;
	private int counter;
	private int moveMax;
	private int influence[];
	private int statu;
	private AimNode aim;
	
	
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public int getEntityType() {
		return entityType;
	}
	public void setEntityType(int entityType) {
		this.entityType = entityType;
	}
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
	
	public int getMoveMax() {
		return moveMax;
	}
	public void setMoveMax(int moveMax) {
		this.moveMax = moveMax;
	}
	public void setInfluence(int[] influence){
		this.influence = influence;
	}
	
	public int getInfluence(int i){// enter distance gives distance modifier
		return influence[i];
	}
	
	public int getInfluenceRange() {
		// TODO Auto-generated method stub
		return this.influence.length;
	}
	/*public void enforceInfluence(Map m, int player){
		for( int i = 0; i < this.getInfluenceRange(); i++){
			m.addInfluence(  this.getX() + i,  this.getY() + i, this.getInfluence(i), player);
			m.addInfluence(  this.getX() + i,  this.getY(), this.getInfluence(i), player);
			m.addInfluence(  this.getX(),  this.getY() + i, this.getInfluence(i), player);
			m.addInfluence(  this.getX() - i,  this.getY() - i, this.getInfluence(i), player);
		}
	}*/
	
	public int getTypeG() {
		return typeG;
	}
	
	public void setTypeG(int typeG) {
		this.typeG = typeG;
	}
	public AimNode getAim() {
		return aim;
	}
	public void setAim(AimNode aim) {
		this.aim = aim;
	}
	
}
