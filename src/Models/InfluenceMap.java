package Models;

import java.util.ArrayList;

public class InfluenceMap {
	String type;
	ArrayList<ArrayList<Integer>> influenceMap;
	public InfluenceMap(){
		influenceMap = new ArrayList<ArrayList<Integer>>(0);
		ArrayList<Integer> t = new ArrayList<Integer>();
		int temp;
		for(int i = 0;i<60;i++){
			t = new ArrayList<Integer>();
			for(int j = 0;j<60;j++){
				temp =(int) (Math.random()*100);
				//System.out.println(temp);
				//System.out.print(temp+" ");
				t.add(temp);
			}
			//System.out.print("\n");
			influenceMap.add(t);
		}
		//System.out.println(this.influenceMap.size());
		
//		printList();
	}
	public InfluenceMap(int fill){
		influenceMap = new ArrayList<ArrayList<Integer>>(0);
		ArrayList<Integer> t = new ArrayList<Integer>();
		int temp;
		for(int i = 0;i<60;i++){
			t = new ArrayList<Integer>();
			for(int j = 0;j<60;j++){
				temp =fill;
				//System.out.println(temp);
				//System.out.print(temp+" ");
				t.add(temp);
			}
			//System.out.print("\n");
			influenceMap.add(t);
		}
	}
	public InfluenceMap(int fill, int x, int y){
		influenceMap = new ArrayList<ArrayList<Integer>>(0);
		ArrayList<Integer> t = new ArrayList<Integer>();
		int temp;
		for(int i = 0;i<x;i++){
			t = new ArrayList<Integer>();
			for(int j = 0;j<y;j++){
				temp =fill;
				//System.out.println(temp);
				//System.out.print(temp+" ");
				t.add(temp);
			}
			//System.out.print("\n");
			influenceMap.add(t);
		}
	}
	
	
	public InfluenceMap(int fill,int x,int y, String type){
		this.type = type;
		influenceMap = new ArrayList<ArrayList<Integer>>(0);
		ArrayList<Integer> t = new ArrayList<Integer>();
		int temp;
		for(int i = 0;i<x;i++){
			t = new ArrayList<Integer>();
			for(int j = 0;j<y;j++){
				temp =fill;
				//System.out.println(temp);
				//System.out.print(temp+" ");
				t.add(temp);
			}
			//System.out.print("\n");
			influenceMap.add(t);
		}
	}
	
	
	public void printList(){
		int size1 = influenceMap.size();
		int size2 = influenceMap.get(0).size();
		for(int i = 0;i <size1 ;i++){
			for (int j = 0; j<size2 ; j++){
				System.out.print(influenceMap.get(i).get(j)+" ");
			}
			System.out.print("\n");
		}
	}
	public int getIndex(int x,int y){
		return influenceMap.get(x).get(y);
	}
	
	public void setIndex(int x, int y, int input){
		influenceMap.get(x).set(y, input);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
