package Models;

public class TurnContainer {
	EntityContainer e;
	public TurnContainer(){
		e = new EntityContainer();
	}
	
	public void FillMoves(EntityContainer ec){
		int size = ec.getSize();
		for(int i = 0;i<size;i++){
			e.addEntity(ec.getEntityFromIndex(i));
		}
	}
	
}
