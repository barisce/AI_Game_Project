package Controllers;

import ai.*;
import c461a.EntityModels.*;
import java.util.ArrayList;
import Models.*;
import c461a.EntityModels.*;

public class AIController {
	ProductionAI productionAI;
	EntityContainer enemyBuild;
	EntityContainer enemyUnit;
	private int turnNumber;
	PlayerController player;
	Map				m;
	ArrayList<Move> movesList;
		
	public AIController(){
		turnNumber = 0;
		productionAI = new ProductionAI();
	}
	public void CalculateSituation(Map m, int owner, EntityContainer em){
		for(int x = 0;x<60;x++){
			for(int y = 0;y<60;y++){
				if(m.getTile(x, y).getOwner()!=owner&&m.getTile(x, y).getOwner()!=0){
					if(m.getTile(x, y).getEntity()<=6){
						enemyBuild.Create(x, y, m.getTile(x, y).getEntity());
					}else if(m.getTile(x, y).getEntity()<=11){
						enemyUnit.Create(x, y, m.getTile(x, y).getEntity());
					}
				}
			}
		}
		CalculateInfluence(enemyBuild, enemyUnit, em, m);
		
		
		
	}
	
	public void CalculateInfluence(EntityContainer eb, EntityContainer eu, EntityContainer em, Map m){ // eb is enemy building, eu, enemy unit em is ours 
		// reset map influence or pass new map empty map everytime
		for( int i = 0; i < em.getSize(); i++){
			eb.getEntityFromIndex(i).enforceInfluence(m, 0); // if 0 positve, if 1 negative
		}
		for( int i = 0; i < eb.getSize(); i++){
			eb.getEntityFromIndex(i).enforceInfluence(m, 1); // if 0 positve, if 1 negative
		}
		for( int i = 0; i < eu.getSize(); i++){
			eb.getEntityFromIndex(i).enforceInfluence(m, 1); // if 0 positve, if 1 negative
		}
	}
	
	public EntityContainer findUnitsAtRisk(EntityContainer em, Map m){
		EntityContainer unitsAtRisk = new EntityContainer();
		for( int i = 0; i < em.getSize(); i++){
			if( m.getTile(em.getEntityFromIndex(i).getX(), em.getEntityFromIndex(i).getY()).getInfluence() < 0){
				unitsAtRisk.addEntity(em.getEntityFromIndex(i));
			}
		}
		return unitsAtRisk;
	}
	public EntityContainer destroyableEnemyUnits(EntityContainer eU, Map m){
		EntityContainer destroyableEnemyUnits = new EntityContainer();
		for( int i = 0; i < eU.getSize(); i++){
			if( m.getTile(eU.getEntityFromIndex(i).getX(), eU.getEntityFromIndex(i).getY()).getInfluence() > 0){
				destroyableEnemyUnits.addEntity(eU.getEntityFromIndex(i));
			}
		}
		return destroyableEnemyUnits;
	}
	public EntityContainer destroyableEnemyBuildings(EntityContainer eB, Map m){
		EntityContainer destroyableEnemyBuildings = new EntityContainer();
		for( int i = 0; i < eB.getSize(); i++){
			if( m.getTile(eB.getEntityFromIndex(i).getX(), eB.getEntityFromIndex(i).getY()).getInfluence() > 0){
				destroyableEnemyBuildings.addEntity(eB.getEntityFromIndex(i));
			}
		}
		return destroyableEnemyBuildings;
	}
	
	
	public void DirectAI(EntityContainer ec, Map m){
		if(ec.getSize()==0){
			return;
		}
		if(ec.getEntityFromIndex(0).getClass()==Building.class){
			if(ec.getEntityFromIndex(0).getCounter()==0){
				ec.BackToEndOfQueue();
			}else{
				productionAI.ProductiveMove(ec.getEntityFromIndex(0), m);
			}
		}else if(ec.getEntityFromIndex(0).getClass()==Worker.class){
			productionAI.ProductiveMove(ec.getEntityFromIndex(0), m);
		}else{
			
		}
	}
	
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
