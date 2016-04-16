package Controllers;


import c461a.EntityModels.Entity;

public class TurnController {
	TurnController(){
		
	}
	void turnPass(Entity entity){
		entity.setCurrentHp(Math.min(entity.getCurrentHp()+entity.getMaxHp()/10,entity.getMaxHp()));
	}
}
