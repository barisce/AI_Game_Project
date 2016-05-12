package Controllers;
import java.util.ArrayList;

import Models.*;
import c461a.EntityModels.*;
public class PlayerController {
	
	private ArrayList<PlayerInfo>pi;
	
	public PlayerController(){
		pi = new ArrayList<PlayerInfo>();
		PlayerInfo t;
		t = new PlayerInfo();
		pi.add(t);
		t = new PlayerInfo();
		pi.add(t);

	}
	public PlayerController(int numPlayer){
		pi = new ArrayList<PlayerInfo>();
		PlayerInfo t;
		for(int i = 0;i<numPlayer;i++){
			t = new PlayerInfo();
			pi.add(t);
		}
		

	}
	
	
	
	public EntityContainer getEntityContainer(int owner){
		return pi.get(owner-1).getEntityContainer();
	}
	public Entity getEntityFromPlayerWithIndex(int owner,int index){
		return pi.get(owner-1).getEntityContainer().getEntityFromIndex(index);
	}
	public PlayerInfo getPlayer(int owner){
		return pi.get(owner-1);
	}
	
	public void StartPlayer1(){
		pi.get(0).getEntityContainer().CreateTown(5, 5, 1);
		pi.get(0).getEntityContainer().CreateWorker(7, 5,1);
		pi.get(0).getEntityContainer().CreateMelee(5, 7, 1);
	}
	public void StartPlayer2(){
		pi.get(1).getEntityContainer().CreateTown(55, 55,2);
		pi.get(1).getEntityContainer().CreateWorker(53, 55,2);
		pi.get(1).getEntityContainer().CreateMelee(55, 53, 2);
	}
	public void CalculateIncome(PlayerInfo pi){
		EntityContainer ec = pi.getEntityContainer();
		int result  = 0;
		int size = pi.getEntityContainer().getSize();
		for(int i = 0;i<size;i++){
			result+=ec.getEntityFromIndex(i).getMaintenance();
		}
		pi.setIncome(result);
	}
	
	
	
}
