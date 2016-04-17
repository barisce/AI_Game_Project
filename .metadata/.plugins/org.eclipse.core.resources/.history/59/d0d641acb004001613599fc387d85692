package Controllers;

import Models.Map;
import c461a.EntityModels.Entity;

public class MoveController {
	public MoveController(){
		
	}
	public boolean MoveToCoor(int x, int y, Entity e, Map m){
		if(checkMove(x,y,e,m)){
			MoveDone(x,y,e,m);
			return true;
		}
		return false;
	}
	
	public void MoveDone(int x, int y, Entity e, Map m){
		m.getTile(e.getX(), e.getY()).setEntity(0);
		m.getTile(e.getX(), e.getY()).setOwner(0);
		e.setX(x);
		e.setY(y);
		m.getTile(x, y).setEntity(e.getEntityType());
		m.getTile(x, y).setOwner(e.getOwner());
		
	}
	
	
	public boolean checkMove(int x, int y,Entity e, Map m){
		boolean result = false;
		int ex = e.getX();
		int ey = e.getY();
		
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
