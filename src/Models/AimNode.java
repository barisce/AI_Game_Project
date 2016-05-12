package Models;

public class AimNode {
	String goalType;
	Coor goalCoor;
	public AimNode(String goalType){
		this.goalType = goalType;
		goalCoor = new Coor(0,0);
	}
	public AimNode(String goalType, Coor goal){
		this.goalType = goalType;
		this.goalCoor = goal;
	}
	public AimNode(String goalType, int x, int y){
		this.goalType = goalType;
		this.goalCoor = new Coor(x,y);
	}

	public String getGoalType() {
		return goalType;
	}

	public void setGoalType(String goalType) {
		this.goalType = goalType;
	}

	public Coor getGoalCoor() {
		return goalCoor;
	}

	public void setGoalCoor(Coor goal) {
		this.goalCoor = goal;
	}
	public void setGoalCoor(int x, int y){
		this.goalCoor = new Coor(x,y);
	}
	
}
