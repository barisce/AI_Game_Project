package Controllers;
import Models.*;
import c461a.EntityModels.*;
public class PlayerController {
	private EntityContainer[] ec = new EntityContainer[2];
	private PlayerInfo[] playerInfo = new PlayerInfo[2];
	
	PlayerController(){
		playerInfo[0] = new PlayerInfo();
		playerInfo[1] = new PlayerInfo();
		ec[0] = new EntityContainer();
		ec[1] = new EntityContainer();
	}
	
	public PlayerController(String s){
		playerInfo[0] = new PlayerInfo();
		playerInfo[1] = new PlayerInfo();
		ec[0] = new EntityContainer();
		ec[1] = new EntityContainer();
		if(s=="test"){
			ec[0].CreateMelee(5,5,1);
			ec[0].CreateMelee(6,5,1);
			ec[0].CreateMelee(5,6,1);
			ec[0].CreateMelee(6,6,1);
			
			//or maybe else if test case
			ec[0].CreateMelee(5, 10, 1);
			ec[0].CreateMelee(6, 10, 1);
			ec[0].CreateMelee(7, 10, 1);
			ec[0].CreateMelee(8, 10, 1);
			ec[0].CreateMelee(9, 10, 1);
			
			ec[0].CreateMelee(7, 11, 1);
			ec[0].CreateMelee(8, 11, 1);
			ec[0].CreateMelee(9, 11, 1);
			ec[1].CreateMelee(2, 2, 2);
			ec[0].CreateMelee(5, 12, 1);
			ec[0].CreateMelee(8, 12, 1);
			ec[0].CreateMelee(9, 12, 1);
			
			ec[0].CreateMelee(5, 13, 1);
			ec[1].CreateMelee(5, 13, 1);
			
			ec[0].CreateMelee(5, 14, 1);
			ec[0].CreateMelee(6, 14, 1);
			ec[0].CreateMelee(7, 14, 1);
			ec[0].CreateMelee(8, 14, 1);
			ec[0].CreateMelee(9, 14, 1);
			
			//another case
			ec[0].CreateMelee(15, 10, 1);
			ec[0].CreateMelee(16, 10, 1);
			ec[0].CreateMelee(17, 10, 1);
			ec[0].CreateMelee(18, 10, 1);
			ec[0].CreateMelee(19, 10, 1);
			
			ec[0].CreateMelee(15, 11, 1);
			ec[0].CreateMelee(17, 11, 1);
			ec[0].CreateMelee(18, 11, 1);
			ec[0].CreateMelee(19, 11, 1);
			
			ec[0].CreateMelee(15, 12, 1);
			ec[0].CreateMelee(18, 12, 1);
			ec[0].CreateMelee(19, 12, 1);
			
			ec[0].CreateMelee(15, 13, 1);
			ec[0].CreateMelee(16, 13, 1);
			ec[0].CreateMelee(19, 13, 1);
			
			ec[0].CreateMelee(15, 14, 1);
			ec[0].CreateMelee(16, 14, 1);
			ec[0].CreateMelee(17, 14, 1);
			ec[0].CreateMelee(18, 14, 1);
			ec[0].CreateMelee(19, 14, 1);
			
			//another
			ec[0].CreateMelee(12,1,1);
			ec[0].CreateMelee(12,2,1);
			ec[0].CreateMelee(12,3,1);
			ec[0].CreateMelee(12,4,1);
			ec[0].CreateMelee(12,5,1);
			ec[0].CreateMelee(12,6,1);
			ec[0].CreateMelee(12,7,1);
			
			ec[0].CreateMelee(13,1,1);
			
			ec[0].CreateMelee(14,1,1);
			ec[0].CreateMelee(14,3,1);
			ec[0].CreateMelee(14,4,1);
			ec[0].CreateMelee(14,5,1);
			ec[0].CreateMelee(14,7,1);
			
			ec[0].CreateMelee(15,1,1);
			ec[0].CreateMelee(15,4,1);
			ec[0].CreateMelee(15,5,1);
			ec[0].CreateMelee(15,7,1);
			
			ec[0].CreateMelee(16,1,1);
			ec[0].CreateMelee(16,2,1);
			ec[0].CreateMelee(16,4,1);
			ec[0].CreateMelee(16,5,1);
			ec[0].CreateMelee(16,7,1);
			
			ec[0].CreateMelee(17,1,1);
			ec[0].CreateMelee(17,2,1);
			ec[0].CreateMelee(17,7,1);
			
			ec[0].CreateMelee(18,1,1);
			ec[0].CreateMelee(18,2,1);
			ec[0].CreateMelee(18,3,1);
			ec[0].CreateMelee(18,4,1);
			ec[0].CreateMelee(18,5,1);
			ec[0].CreateMelee(18,6,1);
			ec[0].CreateMelee(18,7,1);
		}
	}
	
	public EntityContainer getEC(int p){
		return ec[p];
	}
	
	public EntityContainer getEntityContainer(int owner){
		return ec[owner-1];
	}
	
	public PlayerInfo getPlayerInfo(int i){
		return playerInfo[i];
	}
	
	public Entity getEntityFromPlayerWithIndex(int owner,int index){
		return ec[owner-1].getEntityFromIndex(index);
	}
	
	public PlayerInfo getPlayer(int owner){
		return playerInfo[owner];
	}
	public boolean buildMine(Worker worker, int workerIndex, Mine mine){
		if( worker.getX() == mine.getX() && worker.getY() == mine.getY() ){
			ec[0].addEntity(mine);
			ec[0].destroyEntity( workerIndex);
			return true;
		}
		else
			return false;
	}
}
