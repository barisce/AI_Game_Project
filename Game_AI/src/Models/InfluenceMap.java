package Models;

import java.io.IOException;
import java.util.ArrayList;

public class InfluenceMap extends Map{
	private ArrayList<ArrayList<InfluenceTile>> grid;

	public InfluenceMap() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InfluenceMap( Map map) throws IOException{
		
	}
	
	public void setInfluence(){
		
		int ownerMod = 0;
		for (int i = 0; i < 60; i++){
			for( int j = 0; i < 60; j++){
				if( grid.get(i).get(j).getOwner() == 0)
					ownerMod = 1;
				else ownerMod = -1;
				
				if( grid.get(i).get(j).getEntity().getType() == "Melee"){
					for( int n = 3; n > 0; n--){
						grid.get(i).get(j).);
					}
				}
				else if( grid.get(i).get(j).getEntity().getType() == "Range"){
					
				}
				else if( grid.get(i).get(j).getEntity().getType() == "Cavalier"){
					
				}
				else if( grid.get(i).get(j).getEntity().getType() == "Worker"){
					
				}
				else if( grid.get(i).get(j).getEntity().getType() == "Tower"){
					
				}
				else if( grid.get(i).get(j).getEntity().getType() == "Building"){
					
				}

			}
		}
	}

}