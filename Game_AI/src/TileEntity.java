
public interface TileEntity {
	void moveUnit(Tile tile);
	
	void attack(Tile tile);
	void attack(Unit unit);
	void defend(Unit unit); 
}
