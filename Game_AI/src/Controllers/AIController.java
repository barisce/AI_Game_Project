package Controllers;

import c461a.EntityModels.*;
import Models.*;
public class AIController {
	
	
	public AIController(){
		
	}
	
	
	public void MoveToCoor(int x, int y, Entity e, Map m){
		e.setX(x);
		e.setY(y);
	}
	
	public boolean checkMove(int x, int y,Entity e, Map m){
		int ex = e.getX();
		int ey = e.getY();
		if(m.getTile(x, y).getEntity()!=0)
			return false;
		boolean result = false;
		if(x == ex&&ey==y)
			return true;
		int h = Math.abs(ex-x)+Math.abs(ey-y);
		if(Math.abs(ex+1-x)<Math.abs(ex-x)){
			result = result || checkMove(x+1,y,e,m);
			if(result)
				return result;
		}else if(Math.abs(ex-1-x)<Math.abs(ex-x)){
			result = result || checkMove(x-1,y,e,m);
			if(result)
				return result;
		}else if(Math.abs(ey+1-y)<Math.abs(ey-y)){
			result = result || checkMove(x,y+1,e,m);
			if(result)
				return result;
		}else if(Math.abs(ey-1-y)<Math.abs(ey-y)){
			result = result || checkMove(x,y-1,e,m);
		}
		return result;
		
	}
	
}
