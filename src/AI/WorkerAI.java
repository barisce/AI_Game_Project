package AI;
import Controllers.*;
import Models.*;
import c461a.EntityModels.*;

public class WorkerAI {
	MoveController mc;
	int[] typeList;
	
	public WorkerAI(){
		mc = new MoveController();
		typeList = new int[5];
		typeList[0] = 3;
		typeList[1] = 2;
		typeList[2] = 5;
		typeList[3] = 4;
		typeList[4] = 3;
	}
	
	//ArrayList<Coor> mines
	public void GoAndConstruct(Worker w,Map m, Coor c, EntityContainer ec, int type,InfluenceMap atm){
		mc.MoveToCoor(c.getX(), c.getY(), w, m,atm);
		//if the worker is in the construction site
		if(w.getX()==c.getX()&&w.getY()==c.getY()){
			if(w.getStatu()!=0)
			{
				w.setStatu(w.getStatu()-1);
				if(w.getStatu()%10==0){
					System.out.println("Finished " + type + " Type Building at x: " + w.getX() + " - y: " + w.getY());
					if (type == 2)
					{
						ec.CreateTower(w.getX(), w.getY());
						m.ConstructionBuilding(w.getX(), w.getY(), 2, w.getOwner(), m);
					}
					else if (type == 3)
					{
						ec.CreateMine1(w.getX(), w.getY());
						m.ConstructionBuilding(w.getX(), w.getY(), 3, w.getOwner(), m);
					}
					else if (type == 4)
					{
						ec.CreateMine2(w.getX(), w.getY());
						m.ConstructionBuilding(w.getX(), w.getY(), 4, w.getOwner(), m);
					}
					else if (type == 5)
					{
						ec.CreateBarrack(w.getX(), w.getY());
						m.ConstructionBuilding(w.getX(), w.getY(), 5, w.getOwner(), m);
					}
					else if (type == 6)
					{
						ec.CreateTileImprovement(w.getX(), w.getY());
						m.ConstructionBuilding(w.getX(), w.getY(), 6, w.getOwner(), m);
					}
					w.setCurrentHp(0);
				}
			}else{
				w.setStatu(type*10 + typeList[type-2]);
			}
			
		}
		
	}
}