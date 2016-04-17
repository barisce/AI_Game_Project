package ai;

import Controllers.PlayerController;
import Models.Map;
import c461a.EntityModels.*;

public class EconomyAI {
	class WorkerMine{
		Entity worker;
		Mine	mine;
		public WorkerMine(Worker worker, Mine mine){
			this.worker = worker;
			this.mine = mine;
		}
		public WorkerMine() {
		}
	}
	
	PlayerController player;
	Map				m;
	
	// Constructors
	
	// Methods
	
	public void moveWorkerToMine(){
		// move worker to mine
	}
	
	public WorkerMine findClosestWorkerToMine(){ // finds closest worker to mine, regardless of path
		// get all mines
		int shortestDistance = 1000;
		int tempDistance;
		WorkerMine wM = new WorkerMine();
		for( int i = 0; i < m.getNumberOfMines(); i++){
			for( int j = 0; j < player.getEntityContainer(0).getSize(); j++){// for each worker in player entity collection
				if( player.getEntityContainer(0).getEntityFromIndex(j).getType() == "Worker" ){
					// find closest distance to a mine
					tempDistance = Math.abs(player.getEntityContainer(0).getEntityFromIndex(j).getX() - m.getMine(i).getX());
					tempDistance = tempDistance + Math.abs(player.getEntityContainer(0).getEntityFromIndex(j).getX() - m.getMine(i).getY());
					if(tempDistance < shortestDistance){
						shortestDistance = tempDistance;
						wM.mine = m.getMine(i);
						wM.worker = player.getEntityContainer(0).getEntityFromIndex(j);
					}//endif
				}//endif
			}//end for entity colelction, searching workers
		}// end for seaching mines
		return wM; // not nullproof, may return null in the future
	}
	
	public boolean buildMine(Worker worker, int workerIndex, Mine mine){
		if( worker.getX() == mine.getX() && worker.getY() == mine.getY() ){
			return true;
		}
		else
			return false;
	}
}
