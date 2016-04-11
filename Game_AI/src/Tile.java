import java.io.IOException;

public class Tile {
	// Properties
	public int x;
	public int y;
	public int type;
	
	private Terrain terrain;
	// Constructors
	
	public Tile() throws IOException{
		terrain = new Terrain();
	}
	
	public Tile(int x, int y) throws IOException{
		terrain = new Terrain();
		this.x = x;
		this.y = y;
	}
	
	public Tile(int x, int y, int type) throws IOException{
		terrain = new Terrain(type);
		this.x = x;
		this.y = y;
	}
	
	public Tile(int type) throws IOException{
		terrain = new Terrain(type);
	}

	public Tile(Terrain terrain){
		this.terrain= terrain;
	}
	// Methods
	// Getter
	
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

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	
	public Terrain getTerrain(){
		return terrain;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	// modifiers
	
}
