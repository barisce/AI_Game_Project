package AI;
import Controllers.*;
import Models.*;
import c461a.EntityModels.*;
public class ExplorerAI {
	MoveController mc;
	SearchController sc;
	public ExplorerAI(){
		mc =  new MoveController();
		sc = new SearchController();
	}
	
	
	public void MoveToClosestUnknownTile(Entity e, Map m,InfluenceMap found,InfluenceMap atm){
		Coor c;
		if(e.getAim().getGoalType().equalsIgnoreCase("none")){
			c = sc.FindClosestUnknown2(e, found);
			e.setAim(new AimNode("explore",c));
			mc.MoveToCoor(c.x, c.y, e, m,atm);
		}else if(e.getAim().getGoalType().equalsIgnoreCase("explore")){
			c = e.getAim().getGoalCoor();
			mc.MoveToCoor(c.x, c.y, e, m,atm);
		}
		//System.out.println("Coming Unknown "+c.x+" "+c.y);
		
		
		
		
		
	}
	
	
	
}
