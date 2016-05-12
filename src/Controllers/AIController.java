package Controllers;

import java.util.ArrayList;

import AI.*;
import c461a.EntityModels.*;
import Models.*;
import c461a.EntityModels.*;
public class AIController {
	ProductionAI productionAI;
	ExplorerAI explorerAI;
	EntityContainer enemyBuild;
	EntityContainer enemyUnit;
	ArrayList <Coor> mines;
	WorkerAI wai;
	InfluenceMap battleInfluenceMap;
	InfluenceMap defensivenessInfluenceMap;
	InfluenceMap atm;
	InfluenceMapController imc;
	MoveController mc;
	private int turnNumber;
	public AIController(){
		turnNumber = 0;
		productionAI = new ProductionAI();
		explorerAI = new ExplorerAI();
		enemyBuild = new EntityContainer();
		enemyUnit = new EntityContainer();
		mines = new ArrayList<Coor>();
		wai = new WorkerAI();
		imc = new InfluenceMapController();
		battleInfluenceMap = new InfluenceMap(0);
		battleInfluenceMap.setType("Battle");
		defensivenessInfluenceMap = new InfluenceMap(0);
		defensivenessInfluenceMap.setType("Defensive");
		atm = new InfluenceMap(0);
		atm.setType("AvailableToMoveMap");
		mc = new MoveController();
	}
	
	public void CalculateSituation(Map m, int owner,InfluenceMap found,InfluenceMap fog,PlayerInfo pi){
		enemyBuild.clear();
		enemyUnit.clear();
		mines.clear();
		Coor temp;
		
		for(int x = 0;x<60;x++){
			for(int y = 0;y<60;y++){
				if(m.getTile(x, y).getOwner()!=owner&&m.getTile(x, y).getOwner()!=0&&found.getIndex(x, y)==1){
					if(m.getTile(x, y).getEntity()<=6){
						enemyBuild.Create(x, y, m.getTile(x, y).getEntity());
					}else if(m.getTile(x, y).getEntity()<=11){
						enemyUnit.Create(x, y, m.getTile(x, y).getEntity());
					}
				}
				if(m.getTile(x, y).getType()>=5&&found.getIndex(x, y)==1&&m.getTile(x, y).getOwner()!=owner){
					temp = new Coor(x,y);
					mines.add(temp);
				}
			}
		}
		
		
		
		imc.BattleInfluenceMapCalculation(m,pi, enemyBuild, enemyUnit,battleInfluenceMap);
		imc.DefenceInfluenceMapCalculation(m, pi, enemyBuild, enemyUnit, defensivenessInfluenceMap);
		//CalculateInfluence(enemyBuild, enemyUnit, m);
		
	}
	
	
	
	public void DirectAI(EntityContainer ec, Map m,int turn,EntityContainer pec,InfluenceMap found,PlayerInfo pi){
		//System.out.println("Gelen ec size "+ec.getSize());
		Coor c = new Coor(10, 10);	//TODO fill&fix this. Take coordinates from influence maps
		int type = 3;				//TODO fill&fix this. Take the types from influence maps also
		
		if(ec.getSize()==0){
			return;
		}
		CalculateSituation(m, ec.getEntityFromIndex(0).getOwner(), pi.getIsFound(),pi.getFog(),pi);
		if(ec.getEntityFromIndex(0).getType().equals("Building")){
			Building b =(Building) ec.getEntityFromIndex(0);
			if(ec.getEntityFromIndex(0).getCounter()==0){
				ec.RemoveFirst();
				//ec.BackToEndOfQueue();
			}else{
				productionAI.ProductiveMove(ec.getEntityFromIndex(0), m);
			}
		}else if(ec.getEntityFromIndex(0).getName().equals("Worker")){
			Worker temp = (Worker) ec.getEntityFromIndex(0);
			wai.GoAndConstruct(temp, m, c, pec, type,atm);
			
			//productionAI.ProductiveMove(ec.getEntityFromIndex(0), m);
			ec.RemoveFirst();
		}else{
			Unit t = (Unit)ec.getEntityFromIndex(0);
			explorerAI.MoveToClosestUnknownTile(t, m,found,atm);
			ec.RemoveFirst();
		}
	}
	public InfluenceMap getBattleInfluenceMap() {
		return battleInfluenceMap;
	}
	public void setBattleInfluenceMap(InfluenceMap battleInfluenceMap) {
		this.battleInfluenceMap = battleInfluenceMap;
	}
	public MoveController getMoveController(){
		return mc;
	}
	public InfluenceMap getDefensivenessInfluenceMap() {
		return defensivenessInfluenceMap;
	}
	public void setDefensivenessInfluenceMap(InfluenceMap defensivenessInfluenceMap) {
		this.defensivenessInfluenceMap = defensivenessInfluenceMap;
	}

	public InfluenceMap getAtm() {
		return atm;
	}

	public void setAtm(InfluenceMap atm) {
		this.atm = atm;
	}
	
}
