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
	
	public void CreateMelee(int x, int y, int owner){
		Melee m = new Melee(x,y,owner);
		entities.add(m);
	}
	
	
}
