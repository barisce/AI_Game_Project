package Controllers;


import java.util.Random;

import c461a.EntityModels.Entity;
import c461a.EntityModels.Unit;

public class FightController {
	Random ran = new Random();
	
	
	public FightController(){
		
	}
	
	public int FightMelee(Unit Attacker, Entity Defender){
		int atDa = Attacker.getDamage();
		int cal = ran.nextInt(100)+50;
		return (atDa*cal)/100;
		
	}
}
