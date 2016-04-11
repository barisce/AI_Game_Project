import java.io.IOException;
import java.util.ArrayList; 

public class Tile implements TileEntity{
	// Properties
	public enum Neighbour{NORTH, EAST, SOUTH, WEST};
	private Terrain terrain;
	private Unit unit; 
	private Building building; //TODO: hold one entity and one unit to walk
	private boolean hasBuilding; 
	private boolean isFull;
	private float[] modifiers; //no need for this
	private ArrayList<Tile> neighbours; 
	// Constructors
	
	public Tile() throws IOException{
		neighbours = new ArrayList<Tile>(4);
		terrain = new Terrain();
	}
	
	public Tile(Terrain terrain){
		neighbours = new ArrayList<Tile>(4);
		this.terrain= terrain;
	}
	// Methods
	// Getter
	public Unit getUnit(){
		return this.unit;
	}
	
	public Building getBuilding(){
		return building;
	}
	
	public boolean hasBuilding(){
		return hasBuilding;
	}
	
	public Terrain getTerrain(){
		return terrain;
	}
	
	// modifiers
	public boolean build(Building newBuilding) {
		if (this.hasBuilding){ // there is a building
			return false;
		}
		else{
			this.building = newBuilding;
			hasBuilding = true;
			isFull = true;
			return true;
		}
		
	}
	
	public void moveUnit(Tile tile){
		this.unit.moveUnit(tile);
		this.unit = null;

	}
	
	public void attack(Tile tile){
		//unit.attack( tile);
	}

	@Override
	public void attack(Unit unit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void defend(Unit unit) {
		// TODO Auto-generated method stub
		
	}
		
}
