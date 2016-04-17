package Models;
import java.util.ArrayList;

import c461a.EntityModels.*;

public class EntityContainer {
	ArrayList <Entity> entities;
	public EntityContainer(){
		entities =  new ArrayList<Entity>();
	}
	public Entity getEntityFromIndex(int i){
		return entities.get(i);
	}
	
	public void addEntity(Entity entity){
		entities.add(entity);
	}
	
	public Entity findFromCoor(int x, int y){
		for(int i = 0;i<entities.size();i++){
			if(entities.get(i).getX()==x&&entities.get(i).getY()==y){
				return entities.get(i);
			}	
		}
		return entities.get(0);
	}
	
	public int getSize(){
		return entities.size();
	}
	public void Create(int x, int y, int entity){
		if(entity==1){
			CreateTown(x,y);
		}else if(entity==2){
			CreateTower(x,y);
		}else if(entity==3){
			CreateMine1(x,y);
		}else if(entity == 4){
			CreateMine2(x,y);
		}else if(entity == 5){
			CreateBarrack(x,y);
		}else if(entity == 6){
			CreateTileImprovement(x,y);
		}else if(entity == 7){
			CreateMelee(x,y);
		}else if(entity == 8){
			CreateRange(x,y);
		}else if(entity == 9){
			CreateCavalier(x,y);
		}else if(entity == 10){
			CreateSiege(x,y);
		}else if(entity == 11){
			CreateWorker(x,y);
		}
	}
	public void CreateWorker(int x, int y){
		Worker m = new Worker(x,y);
		entities.add(m);
	}
	public void CreateWorker(int x, int y,int owner){
		Worker m = new Worker(x,y,owner);
		entities.add(m);
	}
	public void CreateSiege(int x, int y){
		Siege m = new Siege(x,y);
		entities.add(m);
	}
	public void CreateSiege(int x, int y,int owner){
		Siege m = new Siege(x,y,owner);
		entities.add(m);
	}
	public void CreateCavalier(int x, int y){
		Cavalier m = new Cavalier(x,y);
		entities.add(m);
	}
	public void CreateCavalier(int x, int y,int owner){
		Range m = new Range(x,y,owner);
		entities.add(m);
	}
	public void CreateRange(int x, int y){
		Range m = new Range(x,y);
		entities.add(m);
	}
	public void CreateRange(int x, int y,int owner){
		Range m = new Range(x,y,owner);
		entities.add(m);
	}
	
	public void CreateTileImprovement(int x, int y){
		TileImprovement m = new TileImprovement(x,y);
		entities.add(m);
	}
	public void CreateTileImprovement(int x, int y,int owner){
		TileImprovement m = new TileImprovement(x,y,owner);
		entities.add(m);
	}
	public void CreateBarrack(int x, int y){
		Barrack m = new Barrack(x,y);
		entities.add(m);
	}
	public void CreateBarrack(int x, int y,int owner){
		Barrack m = new Barrack(x,y,owner);
		entities.add(m);
	}
	public void CreateMine2(int x, int y){
		Mine2 m = new Mine2(x,y);
		entities.add(m);
	}
	public void CreateMine2(int x, int y,int owner){
		Mine2 m = new Mine2(x,y,owner);
		entities.add(m);
	}
	public void CreateMine1(int x, int y){
		Mine1 m = new Mine1(x,y);
		entities.add(m);
	}
	public void CreateMine1(int x, int y,int owner){
		Mine1 m = new Mine1(x,y,owner);
		entities.add(m);
	}
	public void CreateTower(int x, int y){
		Tower m = new Tower(x,y);
		entities.add(m);
	}
	public void CreateTower(int x, int y, int owner){
		Tower m = new Tower(x,y,owner);
		entities.add(m);
	}
	public void CreateMelee(int x, int y){
		Melee m = new Melee(x,y);
		entities.add(m);
	}
	public void CreateMelee(int x, int y, int owner){
		Melee m = new Melee(x,y,owner);
		entities.add(m);
	}
	public void CreateTown(int x, int y, int owner){
		Town m = new Town(x,y,owner);
		entities.add(m);
	}
	public void CreateTown(int x, int y){
		Town m = new Town(x,y);
		entities.add(m);
	}
	public void BackToEndOfQueue(){
		if(getSize()==0)
			return;
		entities.get(0).setCounter(entities.get(0).getCounter()+1);
		Entity temp = entities.get(0);
		entities.remove(0);
		entities.add(temp);
	}
	public void destroyEntity(int i) {
		// TODO Auto-generated method stub
		entities.remove(i);
	}
	
}
