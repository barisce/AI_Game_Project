package Controllers;

import Models.*;
import c461a.EntityModels.*;

public class InfluenceMapController {
	
	public InfluenceMapController() {
		
	}
	
	public void AllMapUpdate(Map m, PlayerController pc){
		IsFoundCalculation(m,pc.getPlayer(1));
		IsFoundCalculation(m,pc.getPlayer(2));
		FogCalculation(m,pc.getPlayer(1));
		FogCalculation(m, pc.getPlayer(2));
	}
	
	public void UpdateATM(Map m, InfluenceMap atm){
		ResetMap(m, atm);
		int sizex = m.getSizex();
		int sizey = m.getSizey();
		for(int x = 0;x<sizex;x++){
			for(int y = 0;y<sizey;y++){
				if(m.getTile(x, y).getEntity()==0){
					atm.setIndex(x, y, 1);
				}else{
					atm.setIndex(x, y, 0);
				}
					
			}
		}
	}
	
	
	public void IsFoundCalculation(Map m, PlayerController pc){
		IsFoundCalculation(m,pc.getPlayer(1));
		IsFoundCalculation(m,pc.getPlayer(2));
	}
	public void IsFoundCalculation(Map m, PlayerInfo pi){
		IsFoundCalculation(m,pi.getEntityContainer(),pi.getIsFound());
	}
	public void ResetMap(Map m,InfluenceMap im){
		int sizex = m.getSizex();
		int sizey = m.getSizey();
		
			
		for(int x=0;x<sizex;x++){
			for(int y = 0;y<sizey;y++){
				im.setIndex(x, y, 0);
			}
		}
		
	}
	public void FogCalculation(Map m, PlayerInfo pi){
		FogCalculation(m,pi.getEntityContainer(),pi.getFog());
	}
	
	public void FogCalculation(Map m, EntityContainer ec, InfluenceMap im){
		ResetMap(m,im);
		IsFoundCalculation(m,ec,im);
	}
	
	
	public void IsFoundCalculation(Map m, EntityContainer ec, InfluenceMap im){
		int esize = ec.getSize();
		int sizex = m.getSizex();
		int sizey = m.getSizey();
		int s;
		Entity temp;
		for(int i = 0;i<esize;i++){
			temp = ec.getEntityFromIndex(i);
			s = temp.getSightRange();
			for(int x=temp.getX()-s;x<=temp.getX()+s;x++){
				for(int y = temp.getY()-s;y<=temp.getY()+s;y++){
					if(Math.abs(x-temp.getX())+Math.abs(y-temp.getY())<=s&&x>=0&&x<sizex&&y>=0&&y<sizey){
						im.setIndex(x, y, 1);
					}
				}
			}
		}
	}
	public void BattleInfluenceMapCalculation(Map m,PlayerInfo pi,EntityContainer enemyBuilding, EntityContainer enemyUnit,InfluenceMap bim){
		ResetMap(m, bim);
		CalculateBattleInfluence(m, pi.getEntityContainer(), bim, 1);
		CalculateBattleInfluence(m, enemyUnit, bim, -1);
		CalculateBattleInfluence(m, enemyBuilding, bim, -1);
		
	}
	public void CalculateBattleInfluence(Map m,EntityContainer ec, InfluenceMap bim,int mu){
		int sizex = m.getSizex();
		int sizey = m.getSizey();
		int size = ec.getSize();
		int temp1, temp2;
		Melee me;
		Siege s;
		Range r;
		Cavalier c;
		Tower t;
		
		for(int i = 0;i<size;i++){
			if(ec.getEntityFromIndex(i).getName().equalsIgnoreCase("Tower")){
				t =(Tower) ec.getEntityFromIndex(i);
				temp1 = t.getRange();
				for(int x=t.getX()-temp1;x<=t.getX()+temp1;x++){
					for(int y = t.getY()-temp1;y<=t.getY()+temp1;y++){
						if(Math.abs(x-t.getX())+Math.abs(y-t.getY())<=temp1&&x>=0&&x<sizex&&y>=0&&y<sizey){
							bim.setIndex(x, y, bim.getIndex(x, y)+t.getDamage()*mu);
						}
					}
				}
			}else
			if(ec.getEntityFromIndex(i).getName().equalsIgnoreCase("Melee")){
				me =(Melee) ec.getEntityFromIndex(i);
				temp1 = me.getMoveMax()+1;
				for(int x=me.getX()-temp1;x<=me.getX()+temp1;x++){
					for(int y = me.getY()-temp1;y<=me.getY()+temp1;y++){
						if(Math.abs(x-me.getX())+Math.abs(y-me.getY())<=temp1&&x>=0&&x<sizex&&y>=0&&y<sizey){
							bim.setIndex(x, y, bim.getIndex(x, y)+me.getDamage()*mu);
						}
					}
				}
			}else
			if(ec.getEntityFromIndex(i).getName().equalsIgnoreCase("Range")){
				r =(Range) ec.getEntityFromIndex(i);
				temp1 = r.getRange()+r.getMoveMax();
				for(int x=r.getX()-temp1;x<=r.getX()+temp1;x++){
					for(int y = r.getY()-temp1;y<=r.getY()+temp1;y++){
						if(Math.abs(x-r.getX())+Math.abs(y-r.getY())<=temp1&&x>=0&&x<sizex&&y>=0&&y<sizey){
							bim.setIndex(x, y, bim.getIndex(x, y)+r.getDamage()*mu);
						}
					}
				}
			}else
			if(ec.getEntityFromIndex(i).getName().equalsIgnoreCase("Siege")){
				s =(Siege) ec.getEntityFromIndex(i);
				temp1 = s.getRange()+s.getMoveMax();
				for(int x=s.getX()-temp1;x<=s.getX()+temp1;x++){
					for(int y = s.getY()-temp1;y<=s.getY()+temp1;y++){
						if(Math.abs(x-s.getX())+Math.abs(y-s.getY())<=temp1&&x>=0&&x<sizex&&y>=0&&y<sizey){
							bim.setIndex(x, y, bim.getIndex(x, y)+s.getDamage()*mu);
						}
					}
				}
			}else
				if(ec.getEntityFromIndex(i).getName().equalsIgnoreCase("Cavalier")){
					c =(Cavalier) ec.getEntityFromIndex(i);
					temp1 = c.getMoveMax()+1;
					for(int x=c.getX()-temp1;x<=c.getX()+temp1;x++){
						for(int y = c.getY()-temp1;y<=c.getY()+temp1;y++){
							if(Math.abs(x-c.getX())+Math.abs(y-c.getY())<=temp1&&x>=0&&x<sizex&&y>=0&&y<sizey){
								bim.setIndex(x, y, bim.getIndex(x, y)+c.getDamage()*mu);
							}
						}
					}
				}
			
		}
	}
	
	public void DefenceInfluenceMapCalculation(Map m,PlayerInfo pi,EntityContainer enemyBuilding, EntityContainer enemyUnit,InfluenceMap bim){
		ResetMap(m, bim);
		CalculateDefenceInfluence(m, pi.getEntityContainer(), bim, 1);
		CalculateDefenceInfluence(m, enemyUnit, bim, -1);
		CalculateDefenceInfluence(m, enemyBuilding, bim, -1);
		
	}

	public void CalculateDefenceInfluence(Map m, EntityContainer ec, InfluenceMap bim, int mu) {
		int sizex = m.getSizex();
		int sizey = m.getSizey();
		int size = ec.getSize();
		int temp1;
		Town t;
		Tower t1;
		Mine1 m1;
		Mine2 m2;
		Barrack b;
		TileImprovement ti;
		
		for(int i = 0;i<size;i++){
			if(ec.getEntityFromIndex(i).getName().equalsIgnoreCase("Town")){
				t =(Town) ec.getEntityFromIndex(i);
				int x_coor = t.getX();
				int y_coor = t.getY();
				temp1 = t.getSightRange();
				for(int x=t.getX()-temp1;x<=t.getX()+temp1;x++){
					for(int y = t.getY()-temp1;y<=t.getY()+temp1;y++){
						if(Math.abs(x-t.getX())+Math.abs(y-t.getY())<=temp1&&x>=0&&x<sizex&&y>=0&&y<sizey){
							bim.setIndex(x, y, bim.getIndex(x, y)+( t.getDefensiveness() - ( Math.min(t.getDefensiveness(), Math.abs(x_coor-x)*(int)(t.getDefensiveness()*1/10)  +  Math.abs(y_coor-y)*(int)(t.getDefensiveness() * 1/10) ) ) )*mu);
						}
					}
				}
			}
		}
		
		for(int i = 0;i<size;i++){
			if(ec.getEntityFromIndex(i).getName().equalsIgnoreCase("Tower")){
				t1 =(Tower) ec.getEntityFromIndex(i);
				int x_coor = t1.getX();
				int y_coor = t1.getY();
				temp1 = t1.getSightRange();
				for(int x=t1.getX()-temp1;x<=t1.getX()+temp1;x++){
					for(int y = t1.getY()-temp1;y<=t1.getY()+temp1;y++){
						if(Math.abs(x-t1.getX())+Math.abs(y-t1.getY())<=temp1&&x>=0&&x<sizex&&y>=0&&y<sizey){
							bim.setIndex(x, y, bim.getIndex(x, y)+(t1.getDefensiveness() - ( Math.abs(x_coor-x)*(int)(t1.getDefensiveness()*1/10)  +  Math.abs(y_coor-y)*(int)(t1.getDefensiveness() * 1/10) ) )*mu);
						}
					}
				}
			}
		}
		
		for(int i = 0;i<size;i++){
			if(ec.getEntityFromIndex(i).getName().equalsIgnoreCase("Mine1")){
				m1 =(Mine1) ec.getEntityFromIndex(i);
				int x_coor = m1.getX();
				int y_coor = m1.getY();
				temp1 = m1.getSightRange();
				for(int x=m1.getX()-temp1;x<=m1.getX()+temp1;x++){
					for(int y = m1.getY()-temp1;y<=m1.getY()+temp1;y++){
						if(Math.abs(x-m1.getX())+Math.abs(y-m1.getY())<=temp1&&x>=0&&x<sizex&&y>=0&&y<sizey){
							bim.setIndex(x, y, bim.getIndex(x, y)+( m1.getDefensiveness() - ( Math.min(m1.getDefensiveness(), Math.abs(x_coor-x)*(int)(m1.getDefensiveness()*1/10)  +  Math.abs(y_coor-y)*(int)(m1.getDefensiveness() * 1/10) ) ) )*mu);
						}
					}
				}
			}
		}
		
		for(int i = 0;i<size;i++){
			if(ec.getEntityFromIndex(i).getName().equalsIgnoreCase("Mine2")){
				m2 =(Mine2) ec.getEntityFromIndex(i);
				int x_coor = m2.getX();
				int y_coor = m2.getY();
				temp1 = m2.getSightRange();
				for(int x=m2.getX()-temp1;x<=m2.getX()+temp1;x++){
					for(int y = m2.getY()-temp1;y<=m2.getY()+temp1;y++){
						if(Math.abs(x-m2.getX())+Math.abs(y-m2.getY())<=temp1&&x>=0&&x<sizex&&y>=0&&y<sizey){
							bim.setIndex(x, y, bim.getIndex(x, y)+( m2.getDefensiveness() - ( Math.min(m2.getDefensiveness(), Math.abs(x_coor-x)*(int)(m2.getDefensiveness()*1/10)  +  Math.abs(y_coor-y)*(int)(m2.getDefensiveness() * 1/10) ) ) )*mu);
						}
					}
				}
			}
		}
		
		for(int i = 0;i<size;i++){
			if(ec.getEntityFromIndex(i).getName().equalsIgnoreCase("Barrack")){
				b =(Barrack) ec.getEntityFromIndex(i);
				int x_coor = b.getX();
				int y_coor = b.getY();
				temp1 = b.getSightRange();
				for(int x=b.getX()-temp1;x<=b.getX()+temp1;x++){
					for(int y = b.getY()-temp1;y<=b.getY()+temp1;y++){
						if(Math.abs(x-b.getX())+Math.abs(y-b.getY())<=temp1&&x>=0&&x<sizex&&y>=0&&y<sizey){
							bim.setIndex(x, y, bim.getIndex(x, y)+( b.getDefensiveness() - ( Math.min(b.getDefensiveness(), Math.abs(x_coor-x)*(int)(b.getDefensiveness()*1/10)  +  Math.abs(y_coor-y)*(int)(b.getDefensiveness() * 1/10) ) ) )*mu);
						}
					}
				}
			}
		}
		
		for(int i = 0;i<size;i++){
			if(ec.getEntityFromIndex(i).getName().equalsIgnoreCase("TileImprovement")){
				ti =(TileImprovement) ec.getEntityFromIndex(i);
				int x_coor = ti.getX();
				int y_coor = ti.getY();
				temp1 = ti.getSightRange();
				for(int x=ti.getX()-temp1;x<=ti.getX()+temp1;x++){
					for(int y = ti.getY()-temp1;y<=ti.getY()+temp1;y++){
						if(Math.abs(x-ti.getX())+Math.abs(y-ti.getY())<=temp1&&x>=0&&x<sizex&&y>=0&&y<sizey){
							bim.setIndex(x, y, bim.getIndex(x, y)+( ti.getDefensiveness() - ( Math.min(ti.getDefensiveness(), Math.abs(x_coor-x)*(int)(ti.getDefensiveness()*1/10)  +  Math.abs(y_coor-y)*(int)(ti.getDefensiveness() * 1/10) ) ) )*mu);
						}
					}
				}
			}
		}
	}
	public void BuildableInfluenceMapCalculation(Map m,PlayerController pc,InfluenceMap bim){
		ResetMap(m, bim);
		CalculateBuildInfluence(m, pc, bim, 1);
	}
	//if the tile is 1 it is not possible to build
	public void CalculateBuildInfluence(Map m, PlayerController pc, InfluenceMap bim, int mu) {
		int sizex = m.getSizex();
		int sizey = m.getSizey();
		int size1 = pc.getEntityContainer(1).getSize();
		int size2 = pc.getEntityContainer(2).getSize();
		Entity e;
		
		for(int i = 0;i<size1;i++){
			e = pc.getEntityContainer(1).getEntityFromIndex(i);
			int x = e.getX();
			int y = e.getY();
			bim.setIndex(x, y, bim.getIndex(x, y) + 1*mu);
		}
		for(int i = 0;i<size2;i++){
			e = pc.getEntityContainer(2).getEntityFromIndex(i);
			int x = e.getX();
			int y = e.getY();
			bim.setIndex(x, y, bim.getIndex(x, y) + 1*mu);
		}
		
		for(int x = 0;x<sizex;x++){
			for(int y = 0; y<sizey;y++){
				if(m.getTile(x, y).getType() == 3){
					bim.setIndex(x, y, bim.getIndex(x, y) + 1*mu);
				}
			}
		}
	}
	
	

	
}
