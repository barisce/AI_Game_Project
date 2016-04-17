package Models;

import java.io.IOException;

public class InfluenceTile extends Tile{
	private int influence;
	public InfluenceTile() throws IOException {
		super();
		influence = 0;
		// TODO Auto-generated constructor stub
	}
	
	public int getInfluence(){
		return influence;
	}
	
	public void setInfluence(int influence){
		this.influence = influence;
	}
	
	public void addInfluence( int i){
		influence = influence + i;
	}

}
