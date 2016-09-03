package manage;

public class Job {
	private int arrivTime;
	private int cycles;
	private boolean done = false;
	private boolean isPro = false;
	
public Job(int x,int y)
{
	this.arrivTime = x;
	this.cycles = y;
}

public boolean isPro() {
	return isPro;
}

public void setPro(boolean isPro) {
	this.isPro = isPro;
}

public int getArrivTime() {
	return arrivTime;
}
public void setArrivTime(int arrivTime) {
	this.arrivTime = arrivTime;
}
public int getCycles() {
	return cycles;
}
public void setCycles(int cycles) {
	this.cycles = cycles;
}
public boolean isDone() {
	return done;
}
public void setDone(boolean done) {
	this.done = done;
}

}
