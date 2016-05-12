package Controllers;


import java.util.Random;

import c461a.EntityModels.Entity;
import c461a.EntityModels.Unit;

public class FightController {
	Random ran;
	MoveController mc;
	public FightController(){
		mc = new MoveController();
		ran = new Random();
	}
	
	public boolean MoveAttack(Unit attacker, Entity defender){
		int distance = mc.calculateDistance(attacker, defender);
		if(attacker.getMoveLeft()+attacker.getRange()>=distance){
			return true;
		}
		return false;
	}
	
	public int CalculateDamage(Unit Attacker, Entity Defender){
		int atDa = Attacker.getDamage();
		int cal = ran.nextInt(100)+50;
		return (atDa*cal)/100;
	}
	public int FightMelee(Unit Attacker, Entity Defender){
		int atDa = Attacker.getDamage();
		int cal = ran.nextInt(100)+50;
		return (atDa*cal)/100;
		
	}
}
