package ai;

import java.util.ArrayList;
import Controllers.Move;
import Controllers.PlayerController;
import Models.Map;
import c461a.EntityModels.Entity;

public class ExplorerAI {
	PlayerController player;
	Map				m;
	ArrayList<Move> movesList;
		
	// Constructor
		
		
	// Methods
		
	// prune
	public Move prune(){
		int moveMax = 0;
		int moveX = 0;
		int moveY = 0;
		int eX = 0;
		int eY = 0;
		int closestToCenter = 0;
		Move	bestMove = new Move();
		int temp = 0;
		// if moveable
		for( int i = 0; i < player.getEC(0).getSize(); i++){ // for each enity player has
			if( player.getEC(0).getEntityFromIndex(i).getType() !="Building"){
				moveMax = player.getEC(0).getEntityFromIndex(i).getMoveMax();
				moveX = player.getEC(0).getEntityFromIndex(i).getX() + moveMax; // place will move to
				moveY = player.getEC(0).getEntityFromIndex(i).getY(); // place will move to
				eX = player.getEC(0).getEntityFromIndex(i).getX();
				eY = player.getEC(0).getEntityFromIndex(i).getY();
				//can add max moves modifier
				for(int j = 0; j <= moveMax; j++){
					if(checkMoveFix( moveX,  moveY, eX, eY, m) && !m.getTile(moveX, moveY).isFound()){// if possible move is legit +x, + y
						movesList.add(new Move(moveX, moveY, player.getEC(0).getEntityFromIndex(i)));
					}
					if(checkMoveFix( moveX,  -moveY, eX, eY, m) && !m.getTile(moveX, moveY).isFound()){// if possible move is legit, +x, -y
						movesList.add(new Move(moveX, moveY, player.getEC(0).getEntityFromIndex(i)));
					}
					if(checkMoveFix( -moveX,  moveY, eX, eY, m) && !m.getTile(moveX, moveY).isFound()){// if possible move is legit, -x, +y
						movesList.add(new Move(moveX, moveY, player.getEC(0).getEntityFromIndex(i)));
					}
					if(checkMoveFix( -moveX,  -moveY, eX, eY, m) && !m.getTile(moveX, moveY).isFound()){// if possible move is legit, -x -y
						movesList.add(new Move(moveX, moveY, player.getEC(0).getEntityFromIndex(i)));
					}
					moveX--;
					moveY++;
				}
			}
		}
		
		for(int i = 0; i < movesList.size(); i++){
			temp = Math.abs(30 - movesList.get(i).getX()) + Math.abs(30 - movesList.get(i).getY());
			if( temp > closestToCenter){
				closestToCenter = temp;	
				bestMove = movesList.get(i);
			}
		}
		return bestMove;
	}

	public boolean checkMoveFix(int x, int y, int ex, int ey, Map m){
		if(m.getTile(ex, ey).getEntity()!=0){
			return false;
		}
		if(ex == x && ey == y){
			return true;
		}
		boolean result = false;
		if(Math.abs(ex+1-x)<Math.abs(ex-x)){
			result = result || checkMoveFix(x,y,ex+1,ey,m);
			if(result)
				return result;
		}else if(Math.abs(ex-1-x)<Math.abs(ex-x)){
			result = result || checkMoveFix(x,y,ex-1,ey,m);
			if(result)
				return result;
		}else if(Math.abs(ey+1-y)<Math.abs(ey-y)){
			result = result || checkMoveFix(x,y,ex,ey+1,m);
			if(result)
				return result;
		}else if(Math.abs(ey-1-y)<Math.abs(ey-y)){
			result = result || checkMoveFix(x,y,ex,ey-1,m);
		}
		return result;
	}
	
}


