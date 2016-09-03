
public class job {

	private int size;
	private int cycle;
	private boolean done = false;
	private boolean skipped = false;
	private boolean loaded = false;
	
	public job(int time, int size, int cycle, boolean done, boolean skipped) {
		this.size = size;
		this.cycle = cycle;
		this.done = done;
		this.skipped = skipped;
	}
	public job(){
	}
	
	public boolean isLoaded() {
		return loaded;
	}
	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCycle() {
		return cycle;
	}
	public void setCycle(int cycle) {
		this.cycle = cycle;
	}
	public void runCycle()
	{
		cycle--;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public boolean isSkipped() {
		return skipped;
	}
	public void setSkipped(boolean skipped) {
		this.skipped = skipped;
	}
	
	
	
}
