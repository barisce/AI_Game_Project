package Controllers;


import Models.EntityContainer;
import c461a.EntityModels.Entity;
import c461a.EntityModels.Unit;

public class TurnController {
	
	public EntityContainer e;
	
	
	public TurnController(){
		EntityContainer e = new EntityContainer();
	}
	public void turnRestore(Entity entity){
		entity.setCurrentHp(Math.min(entity.getCurrentHp()+entity.getMaxHp()/10,entity.getMaxHp()));
	}
	
	public void FillMoves(EntityContainer ec){
		e = new EntityContainer();
		int size = ec.getSize();
		Entity temp;
		for(int i = 0;i<size;i++){
			/*turnRestore(ec.getEntityFromIndex(i));
			if(ec.getEntityFromIndex(i).getClass()==Unit.class){
				temp =(Unit) ec.getEntityFromIndex(i);
				temp.setMoveLeft(temp.getMoveMax());
			}*/
			temp = ec.getEntityFromIndex(i);
			e.addEntity(temp);
		}
		
		
	}
	
	public EntityContainer getContainer(){
		return e;
	}
	
	
}
