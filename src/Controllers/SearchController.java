package Controllers;
import java.util.ArrayList;
import java.util.Random;

import Controllers.*;
import Models.*;
import c461a.EntityModels.*;
public class SearchController {
	boolean[][] flag;
	ArrayList<Coor> que;
	Random random;
	
	public SearchController(){
		flag = new boolean[60][60];
		que = new ArrayList<Coor>();
		random = new Random();
	}
	public SearchController(Map m){
		int sizex = m.getSizex();
		int sizey = m.getSizey();
		flag = new boolean[sizex][sizey];
		que = new ArrayList<Coor>();
		random = new Random();
	}
	
	void resetFlag(){
		for(int i = 0;i<60;i++){
			for(int j = 0;j<60;j++){
				flag[i][j] = false;
			}
		}
	}
	void FlagEqualize(Map m){
		for(int x = 0;x<60;x++){
			for(int y = 0;y<60;y++){
				if(m.getTile(x, y).getEntity()!=0){
					flag[x][y]=true;
				}
			}
		}
	}
	
	public int cal(Entity e, int x, int y){
		return Math.abs(e.getX()-x)+Math.abs(e.getY()-y);
	}
	
	public Coor FindClosestUnknown2(Entity e, InfluenceMap found){
		ArrayList<Coor> tq = new ArrayList<Coor>();
		Coor t;
		int temp = 3600;
		for(int x = 0;x<60;x++){
			for(int y = 0;y<60;y++){
				if(found.getIndex(x, y)==0){
					if(temp>cal(e,x,y)){
						temp = cal(e,x,y);
						tq.clear();
						t = new Coor(x,y);
						tq.add(t);
					}else if(temp==cal(e,x,y)){
						t = new Coor(x,y);
						tq.add(t);
					}
				}
			}
		}
		return tq.get(random.nextInt(tq.size()));
	}
	
	
	public Coor FindClosestUnknown(Entity e,InfluenceMap found){
		System.out.println("burasý FindClosest");
		Coor t;
		flag = new boolean[60][60];
		resetFlag();
		que.clear();
		//FlagEqualize(m);
		int ex = e.getX();
		int ey = e.getY();
		flag[ex][ey]= true;
		
		if(ex+1<60){
			if(found.getIndex(ex+1, ey)==0){
				return new Coor(ex+1,ey,true);
			}else if(!flag[ex+1][ey]){
				que.add(new Coor(ex+1,ey));
			}
		}
		if(ex-1>=0){
			if(found.getIndex(ex-1, ey)==0){
				return new Coor(ex-1,ey,true);
			}else if(!flag[ex-1][ey]){
				que.add(new Coor(ex-1,ey));
			}
		}
		if(ey+1<60){
			if(found.getIndex(ex, ey+1)==0){
				return new Coor(ex,ey+1,true);
			}else if(!flag[ex][ey+1]){
				que.add(new Coor(ex,ey+1));
			}
		}
		if(ey-1>=0){
			if(found.getIndex(ex, ey-1)==0){
				return new Coor(ex,ey-1,true);
			}else if(!flag[ex][ey-1]){
				que.add(new Coor(ex,ey-1));
			}
		}
		t = BFS(e.getX(),e.getY(),found);
		
		
		
		return t;
	}
	
	
	public Coor BFS(int x, int y, InfluenceMap found){
		//System.out.println("Burasý BFS x-y :"+x+" "+y);
		flag[x][y]=true;
		int ex,ey;
		int asd = 0;
		while(que.size()!=0){
			asd++;
			//System.out.println("Burada parti var"+asd);
			ex = que.get(0).x;
			ey = que.get(0).y;
			//System.out.println("ex----ey---"+ex+"---"+ey);
			flag[ex][ey] = true;
			que.remove(0);
			if(ex+1<60){
				if(found.getIndex(ex+1, ey)==0){
					return new Coor(ex+1,ey,true);
				}else if(!flag[ex+1][ey]){
					flag[ex+1][ey] = true;
					que.add(new Coor(ex+1,ey));
				}
			}
			if(ex-1>=0){
				if(found.getIndex(ex-1, ey)==0){
					return new Coor(ex-1,ey,true);
				}else if(!flag[ex-1][ey]){
					que.add(new Coor(ex-1,ey));
					flag[ex-1][ey] = true;
				}
			}
			if(ey+1<60){
				if(found.getIndex(ex, ey+1)==0){
					return new Coor(ex,ey+1,true);
				}else if(!flag[ex][ey+1]){
					flag[ex][ey+1] = true;
					que.add(new Coor(ex,ey+1));
				}
			}
			if(ey-1>=0){
				if(found.getIndex(ex, ey-1)==0){
					return new Coor(ex,ey-1,true);
				}else if(!flag[ex][ey-1]){
					flag[ex][ey-1] = true;
					que.add(new Coor(ex,ey-1));
				}
			}
			
		}
		
		return new Coor(-1,-1);
		
		
	}

}
