package Controllers;


import Models.EntityContainer;
import c461a.EntityModels.Entity;

public class TurnController {
	EntityContainer e;
	public TurnController(){
		EntityContainer e = new EntityContainer();
	}
	void turnRestore(Entity entity){
		entity.setCurrentHp(Math.min(entity.getCurrentHp()+entity.getMaxHp()/10,entity.getMaxHp()));
	}
	
	public void FillMoves(EntityContainer ec){
		int size = ec.getSize();
		for(int i = 0;i<size;i++){
			turnRestore(ec.getEntityFromIndex(i));
			e.addEntity(ec.getEntityFromIndex(i));
		}
	}
}
