package Models;

public class Coor {
	public int x;
	public int y;
	public boolean done;
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public Coor(){
		this.x = -1;
		this.y = -1;
		this.done = false;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Coor(int x, int y){
		this.x = x;
		this.y = y;
		this.done = false;
	}
	public Coor(int x, int y, boolean done){
		this.x = x;
		this.y = y;
		this.done = done;
	}
}
