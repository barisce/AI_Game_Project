import java.io.IOException;

public class MapControl {
	// properties
	private GameMap gameMap;
	// constructors
	
	public MapControl() throws IOException{
		gameMap = new GameMap();
	}
	
	// methods
	
	public boolean build(Building newBuilding, Tile tile){
		return tile.build(newBuilding);
	}
	
	public boolean build(Building building, int x, int y){
		return true;
	}
	
	public boolean train( Building building, String unit){
		return building.train(unit);
		/* 
		 * yeni unit binada kalsin, oyuncu oradan cagirir
		 * her binaninin unitleri olur
		 * unitler orda dormant kalir
		 */
	}
	
	public void move(Tile tileStart, Tile tileDest){
		tileStart.moveUnit(tileDest);
	}
	
	public void attack(Unit attacker, Unit defender){
		// call respective attacker/defender methods
		// call a FightController method who handles this shit
		//attacker.attack(defender);
		//defender.defend();
	}
}
