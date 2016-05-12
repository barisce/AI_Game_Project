package Controllers;

import java.util.ArrayList;
import java.util.Random;

import Models.*;
import c461a.EntityModels.Entity;

public class MoveController {
	Random ran;
	InfluenceMapController imc;
	FightController fc;
	public MoveController(){
		ran = new Random();
		imc = new InfluenceMapController();
	}
	
	
	
	
	
	public boolean MoveToCoor(int x, int y, Entity e, Map m, InfluenceMap atm){
		imc.ResetMap(m, atm);
		imc.UpdateATM(m, atm);
		if(checkMove(x,y,e,m,atm)){
			int distance = calculateDistance(e, x,y);
			Coor temp;
			if(distance<e.getMoveMax()){
				temp = CoorCanMove(x, y, e,m,distance,atm);
			}else{
				temp = CoorCanMove(x, y, e,m,e.getMoveMax(),atm);
			}
			
			MoveDone(temp.x,temp.y,e,m);
			
			return true;
		}
		return false;
	}
	
	public void MoveDone(int x, int y, Entity e, Map m){
		System.out.println(e.getType()+"has moved from x-y "+e.getX() +" "+e.getY()+" to "+x+" "+y+" Goal is x-y: "+e.getAim().getGoalCoor().getX()+" "+ e.getAim().getGoalCoor().getY());
		int firstx = e.getX();
		int firsty = e.getY();
		m.getTile(e.getX(), e.getY()).setEntity(0);
		m.getTile(e.getX(), e.getY()).setOwner(0);
		e.setX(x);
		e.setY(y);
		m.getTile(x, y).setEntity(e.getTypeG());
		m.getTile(x, y).setOwner(e.getOwner());
		if(e.getAim().getGoalCoor().getX()==e.getX()&&e.getAim().getGoalCoor().getY()==e.getY()){
			e.setAim(new AimNode("none"));
		}
		if(firstx == e.getX()&&firsty==e.getY()){
			e.setAim(new AimNode("none"));
		}
		
		
	}
public Coor CoorCanMove(int x, int y, Entity e, Map m, int mo,InfluenceMap atm){
		ArrayList<Coor> temp = new ArrayList<Coor>();
		int t = mo;
		int tempx = e.getX();
		int tempy = e.getY();
		for(int i = 0;i<=t;i++){
			if(tempx+i<m.getSizex()&&tempy+t-i<m.getSizey()){
				if(checkMoveFix(x,y,tempx+i,tempy+t-i,m,atm)&&atm.getIndex(tempx+i, tempy+t-i)==1){
					temp.add(new Coor(tempx+i,tempy+t-i));
				}
			}
			if(tempx+i<m.getSizex()&&tempy-t+i>=0){
				if(checkMoveFix(x,y,tempx+i,tempy-t+i,m,atm)&&atm.getIndex(tempx+i, tempy-t+i)==1){
					temp.add(new Coor(tempx+i,tempy-t+i));
				}
			}
			if(tempx-i>=0&&tempy+t-i<m.getSizey()){
				if(checkMoveFix(x,y,tempx-i,tempy+t-i,m,atm)&&atm.getIndex(tempx-i, tempy+t-i)==1){
					temp.add(new Coor(tempx-i,tempy+t-i));
				}
			}
			if(tempx-i>=0&&tempy-t+i>=0){
				if(checkMoveFix(x,y,tempx-i,tempy-t+i,m,atm)&&atm.getIndex(tempx-i, tempy-t+i)==1){
					temp.add(new Coor(tempx-i,tempy-t+i));
				}
				
			}
		}
		if(temp.size()==0)
			return CoorCanMove(x,y,e,m,mo-1,atm);
		if(temp.size()>0){
			temp = ReConstructList(x, y, temp);
		}
		return temp.get(ran.nextInt(temp.size()));
	}

	public ArrayList<Coor> ReConstructList(int x, int y,ArrayList<Coor> list){
		ArrayList<Coor> temp = new ArrayList<Coor>();
		int size = list.size();
		int mind = calculateDistance(list.get(0).getX(), list.get(0).getY(), x, y);
		temp.add(list.get(0));
		int t;
		for(int i = 1;i<size;i++){
			t = calculateDistance(list.get(i).getX(), list.get(i).getY(), x, y);
			if(t<mind){
				temp.clear();
				mind = t;
				temp.add(list.get(i));
			}else if(t==mind){
				temp.add(list.get(i));
			}
		}
		return temp;
	}
	
	public boolean checkMove(int x, int y,Entity e, Map m,InfluenceMap atm){
		boolean result = false;
		int ex = e.getX();
		int ey = e.getY();
		
		if(Math.abs(ex+1-x)<Math.abs(ex-x)){
			result = result || checkMoveFix(x,y,ex+1,ey,m,atm);
			if(result)
				return result;
		}else if(Math.abs(ex-1-x)<Math.abs(ex-x)){
			result = result || checkMoveFix(x,y,ex-1,ey,m,atm);
			if(result)
				return result;
		}else if(Math.abs(ey+1-y)<Math.abs(ey-y)){
			result = result || checkMoveFix(x,y,ex,ey+1,m,atm);
			if(result)
				return result;
		}else if(Math.abs(ey-1-y)<Math.abs(ey-y)){
			result = result || checkMoveFix(x,y,ex,ey-1,m,atm);
		}
		return result;
	
	}
	
	public int calculateDistance(Entity first, Entity second){
		return (Math.abs(first.getX()-second.getX())+Math.abs(first.getY()-second.getY()));
	}
	
	public int calculateDistance(Entity first, int x, int y){
		return (Math.abs(first.getX()-x)+Math.abs(first.getY()-y));
	}
	public int calculateDistance(int ex, int ey, int x, int y){
		return (Math.abs(ex-x)+Math.abs(ey-y));
	}
	
	public boolean checkMoveFix(int x, int y, int ex, int ey, Map m,InfluenceMap atm){
		if(m.getTile(ex, ey).getEntity()!=0){
			return false;
		}
		if(atm.getIndex(ex, ey)==0)
			return false;
		if(ex == x && ey == y){
			return true;
		}
		boolean result = false;
		if(Math.abs(ex+1-x)<Math.abs(ex-x)){
			result = result || checkMoveFix(x,y,ex+1,ey,m,atm);
			if(result)
				return result;
		}else if(Math.abs(ex-1-x)<Math.abs(ex-x)){
			result = result || checkMoveFix(x,y,ex-1,ey,m,atm);
			if(result)
				return result;
		}else if(Math.abs(ey+1-y)<Math.abs(ey-y)){
			result = result || checkMoveFix(x,y,ex,ey+1,m,atm);
			if(result)
				return result;
		}else if(Math.abs(ey-1-y)<Math.abs(ey-y)){
			result = result || checkMoveFix(x,y,ex,ey-1,m,atm);
		}
		return result;
	}

	
	
}
