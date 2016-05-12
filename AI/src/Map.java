import java.io.IOException;
import java.util.ArrayList; 


public class Map {
	
	// properties
	private ArrayList<ArrayList<Tile>> grid;
	
	// Constructor
	public Map() throws IOException{
		grid = new ArrayList<ArrayList<Tile>>(0);
		ArrayList<Tile> temp;
		
		for( int i = 0; i < 60; i++){
			temp = new ArrayList<Tile>(0);
			for (int j = 0; j <60; j++){
				if (j % 2 == 1 && i % 2 == 1)
				{
					temp.add( new Tile(i, j, 1));
				}
				else
				{
					temp.add( new Tile(i, j, 0));
				}
				
			}
			grid.add(temp);
		}
	}
	public Map(int x) throws IOException{
		grid = new ArrayList<ArrayList<Tile>>(0);
		ArrayList<Tile> temp;
		
		for( int i = 0; i < 60; i++){
			temp = new ArrayList<Tile>(0);
			for (int j = 0; j <60; j++){
				temp.add(new Tile(i,j,x));
			}
			grid.add(temp);
		}
	}
	
	// Methods
	
	public Tile getTile( int x, int y){
		ArrayList<Tile> temp = grid.get(x);
		return temp.get(y);
	}
	public void setTileType(int x, int y, int type) throws IOException{
		grid.get(x).get(y).setType(type);
		System.out.println(""+x+" "+y+"has been set to"+type);
	}
	
}