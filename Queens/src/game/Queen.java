package game;

public class Queen {
	int x;
	int y;
	boolean danger;
	
	public Queen(int x, int y){
		this.x = x;
		this.y = y;
		danger = false;
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

	public boolean isInDanger() {
		return danger;
	}

	public void setDanger(boolean danger) {
		this.danger = danger;
	}

	public int getX() {
		return x;
	}

	@Override
	public String toString() {
		return "Queen [x=" + x + ", y=" + y + ", danger=" + danger + "]";
	}
	
}
