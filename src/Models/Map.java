package Models;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import c461a.EntityModels.Entity; 
import Controllers.PlayerController;
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
		//System.out.println(map);
		
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
				}else{
					temp.add(new Tile(i,j,1));
				}
			}
			grid.add(temp);
		}
	}
	
	
	public int getSizex(){
		return grid.size();
	}
	public int getSizey(){
		return grid.get(0).size();
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
	public Map(Map m) throws IOException{
		grid = new ArrayList<ArrayList<Tile>>(0);
		ArrayList<Tile> temp;
		for( int i = 0; i < 60; i++){
			temp = new ArrayList<Tile>(0);
			for (int j = 0; j <60; j++){
				Tile t = new Tile(i,j);
				t.setType(m.getTile(i, j).getType());
				t.setEntity(m.getTile(i, j).getEntity());
				t.setOwner(m.getTile(i, j).getOwner());
				temp.add(t);
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
	
	public void ConstructionBuilding(int x, int y, int entity, int owner,Map m){
		m.getTile(x, y).setEntity(entity);
		m.getTile(x, y).setOwner(owner);
	}
	
	
	// Methods
	
	public Tile getTile( int x, int y){
		return grid.get(x).get(y);
		
	}
	public void setTileType(int x, int y, int type) throws IOException{
		
		grid.get(x).get(y).setType(type);
		System.out.println(""+x+" "+y+"has been set to"+type);
	}
	
	public void MapUpdate(PlayerController pc){
		MapUpdate(pc.getEntityContainer(1));
		MapUpdate(pc.getEntityContainer(2));
	}
	
	public void MapUpdate(EntityContainer e){
		int size = e.getSize();
		for(int i = 0;i<size;i++){
			getTile(e.getEntityFromIndex(i).getX(), e.getEntityFromIndex(i).getY()).setOwner(e.getEntityFromIndex(i).getOwner());
			getTile(e.getEntityFromIndex(i).getX(), e.getEntityFromIndex(i).getY()).setEntity(e.getEntityFromIndex(i).getTypeG());
		}
	}
	public void MapUpdate(Entity e){
		getTile(e.getX(), e.getY()).setOwner(e.getOwner());
		getTile(e.getX(), e.getY()).setEntity(e.getTypeG());
		
	}
	
	public void PrintMap(){
		int sizex = grid.size();
		int sizey = grid.get(0).size();
		for(int x = 0;x<sizex;x++){
			for(int y = 0;y<sizey;y++){
				System.out.print(getTile(x, y).getEntity()+" ");
			}
			System.out.print("\n");
		}
	}
	

	
}
