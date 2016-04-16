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
}
