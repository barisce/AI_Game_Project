package ai;

import Controllers.*;
import Models.EntityContainer;
import Models.Map;

public class ProductionAI {
	// Properties
	private Map map;
	private PlayerController player;
	private int[] p1Units;
	private int[] p2Units;
	public enum Types {
	    MELEE, CAVALIER, RANGE, SIEGE;  
	}
	// Constructors
	public ProductionAI( Map map, PlayerController player){
		this.map = map;
		this.player = player;
		p1Units = new int[4]; // follows enum indexies
		p2Units = new int[4]; // follows enum indexies
	}
	// Methods
	public int evaluate(){
		EntityContainer temp1 = player.getEC(0);
		EntityContainer temp2 = player.getEC(1);
		p1Units = new int[4];
		p2Units = new int[4];
		int[] diff = new int[4];
		int[] battleDiff = new int[4];
		int[] netDiff = new int[4];
		for( int i = 0; i < temp1.getSize(); i++){
//			p1Units[Types.valueOf((temp1.getEntityFromIndex(i).getType()))]++;// fix later with enum in other classes or sth else
		}
		for( int i = 0; i < temp2.getSize(); i++){
//			p1Units[(temp2.getEntityFromIndex(i).getType())]++;
		}
		
		for( int i = 0; i < 4; i++){
			diff[i] = p1Units[i] - p2Units[i];
			battleDiff[i] = evaluateBattleDiff(p1Units, p2Units, i);
			netDiff[i] = diff[i] - battleDiff[i];
		}
		
		int d = 0;
		// return total diff = sum of net diff
		for( int i = 0; i < 4; i++){
			d = d + netDiff[i];
		}
		
		return d;
		
	}
	
	public int evaluateBattleDiff( int[] u1, int[] u2, int t){
		if( t == 0){
			return u1[1]-u2[2] - (u2[1]-u1[2]);
		}
		else if( t == 1){
			return u1[2]-u2[1] - (u2[3]-u1[1]);
		}
		else if( t == 2){
			return u1[2]-u2[1] - (u2[3]-u1[1]);
		}
		else if( t == 3){
			return u1[2]-u2[1] - (u2[3]-u1[1]);
		}
		return 0;
	}
	public void prune(int n, int p){
		if( n == 0){
			return; // local total difference value
		}
		else{
			if( player.getPlayerInfo(0).getTreasure() > costOfMelee){// revenue - maintainance
				// prune for player 2 use p++ % 2 in each cycle
			}
			// do for each other unit type
			
			// return type with best difference
		}
	}
}
