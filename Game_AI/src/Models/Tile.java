package Models;
import java.io.IOException;

public class Tile {
	// Properties
	public int x;
	public int y;
	public int type;
	public int owner;
	public int entity;
	public int index;
	private int hitpoint;
	private int influence;
	private boolean found;
	//private Terrain terrain;
	
	// Constructors
	public Tile() throws IOException{
		//terrain = new Terrain();
		this.x = -1;
		this.y = -1;
		this.type = 0;
		this.owner = 0;
		this.entity = 0;
		this.index = -1;
		this.hitpoint = -100;
		this.found = true;
		this.influence = 0;
	}
	
	public Tile(int x, int y) throws IOException{
		//terrain = new Terrain();
		this.x = x;
		this.y = y;
		this.type = 0;
		this.entity = 0;
		this.owner = 0;
		this.hitpoint = 100;
		this.found = true;
		this.influence = 0;
	}
	
	public Tile(int x, int y, int type) throws IOException{
		//terrain = new Terrain(type);
		this.x = x;
		this.y = y;
		this.type = type;
		this.entity = 0;
		this.owner = 0;
		this.hitpoint = 100;
		this.found = true;
		this.influence = 0;
	}
	public Tile(int x, int y, int type,int entity, int owner) throws IOException{
		//terrain = new Terrain(type);
		this.x = x;
		this.y = y;
		this.type = type;
		this.entity = entity;
		this.owner = owner;
		this.hitpoint = 100;
		this.found = true;
		this.influence = 0;
	}
	
	
	
	public Tile(int type) throws IOException{
		//terrain = new Terrain(type);
		this.type = type;
		this.hitpoint = 100;
		this.found = true;
		this.influence = 0;
	}

	
	// Methods
	// Getter
	
	public boolean isFound(){
		return found;
	}
	
	public void setFound(boolean found) {
		this.found = found;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getHitpoint() {
		return hitpoint;
	}

	public void setHitpoint(int hitpoint) {
		this.hitpoint = hitpoint;
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
/*
	public void setTerrain(Terrain terrain) {
		//this.terrain = terrain;
	}
	
	public Terrain getTerrain(){
		//return terrain;
	}
*/	
	public int getType() {
		return type;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public int getEntity() {
		return entity;
	}

	public void setEntity(int entity) {
		this.entity = entity;
	}

	public void setType(int type) throws IOException {
		this.type = type;
		//this.terrain = new Terrain(type);
	}

	public void addInfluence(int i, int player) {
		if( player == 0)
			influence = influence + i;
		else
			influence = influence - i;
	}

	public int getInfluence() {
		// TODO Auto-generated method stub
		return this.influence;
	}
	
	// modifiers
	
}
