package game;

public class Space {
	private char space;
	private int x;
	private int y;
	
	public Space(){
		space='E';
	}
	
	public Space(int x, int y){
		this.x=x;
		this.y=y;
		space='E';
	}
	
	public void setSpace(char s){
		space = s;
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

	public char getSpace(){
		return space;
	}

	public boolean isNextTo(Space space2) {
		if( Math.abs( space2.getX()-x )< 2 || Math.abs( space2.getY()-y )<2 ){
			return true;
		}
		return false;
	}
}
