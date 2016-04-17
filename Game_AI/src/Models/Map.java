package Models;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList; 


public class Map {
	// properties
	private ArrayList<ArrayList<Tile>> grid;
	
	// Constructor
	
	public Map(String mapURL, int a) throws IOException{
		grid = new ArrayList<ArrayList<Tile>>(0);
		ArrayList<Tile> temp;
		String map = "";
		
		BufferedReader br = new BufferedReader(new FileReader(mapURL));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    map = sb.toString();
		} finally {
		    br.close();
		}
		map = map.replace("\n", "").replace("\r", "");
		System.out.println(map);
		
		for( int i = 0; i < 60; i++){
			temp = new ArrayList<Tile>(0);
			for (int j = 0; j <60; j++){
				//temp.add(new Tile(i,j,map.charAt((i*60)+j)));
				
				if(map.charAt((i*60)+j)=='g'){
					temp.add(new Tile(i,j,1));
				}
				else if(map.charAt((i*60)+j)=='f'){
					temp.add(new Tile(i,j,3));
				}
				else if(map.charAt((i*60)+j)=='F'){
					temp.add(new Tile(i,j,4));
				}
				else if(map.charAt((i*60)+j)=='r'){
					temp.add(new Tile(i,j,5));
				}
				else if(map.charAt((i*60)+j)=='R'){
					temp.add(new Tile(i,j,6));
				}
				else if(map.charAt((i*60)+j)=='i'){
					temp.add(new Tile(i,j,4));
				}
				else
				{
					temp.add(new Tile(i,j,0));
				}
			}
			grid.add(temp);
		}
	}
	
	
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
	public Map(String s) throws IOException{
		grid = new ArrayList<ArrayList<Tile>>(0);
		ArrayList<Tile> temp;
		for( int i = 0; i < 60; i++){
			temp = new ArrayList<Tile>(0);
			for (int j = 0; j <60; j++){
				temp.add(new Tile(i,j,0));
			}
			grid.add(temp);
		}
		if (s=="test"){
			System.out.println("TestMap1");
			grid.get(5).get(5).setEntity(7);
			grid.get(5).get(5).setOwner(1);
			grid.get(6).get(5).setEntity(7);
			grid.get(6).get(5).setOwner(1);
			grid.get(5).get(6).setEntity(7);
			grid.get(5).get(6).setOwner(1);
			grid.get(6).get(6).setEntity(7);
			grid.get(6).get(6).setOwner(1);
		}
	}
	
	// Methods
	
	public Tile getTile( int x, int y){
		
		return grid.get(x).get(y);
		
	}
	public void setTileType(int x, int y, int type) throws IOException{
		
		grid.get(x).get(y).setType(type);
		System.out.println(""+x+" "+y+"has been set to"+type);
	}
	
}
