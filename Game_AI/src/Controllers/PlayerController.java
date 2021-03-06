package Controllers;
import Models.*;
import c461a.EntityModels.*;
public class PlayerController {
	private EntityContainer[] ec = new EntityContainer[2];
	private PlayerInfo[] playerInfo = new PlayerInfo[2];
	
	public PlayerController(){
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
		}
	}
	
	public EntityContainer getEntityContainer(int owner){
		return ec[owner-1];
	}
	public Entity getEntityFromPlayerWithIndex(int owner,int index){
		return ec[owner-1].getEntityFromIndex(index);
	}
	
}
