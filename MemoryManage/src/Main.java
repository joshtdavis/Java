
import java.util.*;

public class Main {
	
	//  field variables
	public static job[] jobs = new job[25];
	public static Stack[] stacks = new Stack[10];
	public static int[] memPart = new int [10];
	public static boolean simDone=false;
	public static int interFrag=0;
	public static int totalFrag=0;
	public static int totalFragSys=0;
	public static int countJob=0;
	public static int counter=0;
	public static int max=0;
	public static int timeCounter=0;
	public static int totalTime=0;
	
	
	public static void main(String[] args) {
		initialize();
		runSim();
	}
	
	// initialize the simulation
	public static void initialize(){
		memoryPartitions();
		intiJoobs();
		memMax();
		for(int y=0;y<10;y++)
		{
			stacks[y]=new Stack<job>();	
		}
	}
	// method to initialize memory partitions
	private static void memoryPartitions() {
		memPart[0]=9500;
		memPart[1]=7000;
		memPart[2]=4500;
		memPart[3]=8500;
		memPart[4]=3000;
		memPart[5]=9000;
		memPart[6]=1000;
		memPart[7]=5500;
		memPart[8]=1500;
		memPart[9]=900;
	}
	
	// initializing all jobs
	private static void intiJoobs() {
		for(int i=0;i<25;i++)
		{
			jobs[i] = new job();
		}
		setJobbs(0,5,5760);
		setJobbs(1,4,4190);
		setJobbs(2,8,3290);
		setJobbs(3,2,2030);
		setJobbs(4,2,2550);
		setJobbs(5,6,6990);
		setJobbs(6,8,8940);
		setJobbs(7,10,740);
		setJobbs(8,7,3930);
		setJobbs(9,6,6890);
		setJobbs(10,5,6580);
		setJobbs(11,8,3820);
		setJobbs(12,9,9140);
		setJobbs(13,10,420);
		setJobbs(14,10,220);
		setJobbs(15,7,7540);
		setJobbs(16,3,3210);
		setJobbs(17,1,1380);
		setJobbs(18,9,9850);
		setJobbs(19,3,3610);
		setJobbs(20,7,7540);
		setJobbs(21,2,2710);
		setJobbs(22,8,8390);
		setJobbs(23,5,5950);
		setJobbs(24,10,760);	
	}
	
	// method to assist with initializing jobs
	public static void setJobbs(int x, int cycles, int size){
		jobs[x].setCycle(cycles);
		jobs[x].setSize(size);
	}
	
	// runs the simulation
	public static void runSim(){
		//System.out.println("Running the simulation");  used for debug
		while(simDone==false){
		loadSim();
		interFrag=0;
		totalFrag=0;
		for(int i=0;i<10;i++){
			if(!stacks[i].empty())
			{
				for(int j=0;j<25;j++)
				{
					if(jobs[j]==stacks[i].peek())
					{
						interFrag=memPart[i]-jobs[j].getSize();
						totalFrag+=interFrag;
						totalFragSys+=totalFrag;
					}
				}
			}
		}
		System.out.println("The amount of internal fragmentation for time "+timeCounter+" is "+totalFrag);
		runCycle();
		unload();
		
			for(int i=0;i<25;i++)
			{
				if(jobs[i].isDone() || jobs[i].isSkipped()){
					counter++;
				}
				if(counter==25){
					simDone=true;
				}
			}
			counter=0;
		}
		for(int i=0;i<25;i++)
		{
			if(jobs[i].isDone() || jobs[i].isSkipped()){
				countJob++;
			}
			if(jobs[i].isSkipped())
			{
				System.out.println("Job "+(i+1)+" was skipped because it was to large for any of the partitions");
			}
		}
		System.out.println("The average amont of internal fragmentation is "+totalFragSys/timeCounter);
		System.out.println("The average amount of time it took to leave the system is "+totalTime/countJob);
	}
	
	// loads jobs into memory partitions
	public static void loadSim(){
		//System.out.println("Beginning loading phase"); used for debug
		for(int i=0; i<10;i++){
			//System.out.println("Checking the stacks");  used for debug
			if(stacks[i].empty())
				{
					//System.out.println("Checking for available jobs");  used for debug
					//System.out.println("Stack "+(i+1)+" is empty");  used for debug
					
						for(int j=0; j<25;j++){
						if(jobs[j].isDone() || jobs[j].isSkipped() || jobs[j].isLoaded() || !stacks[i].empty()){
						// System.out.println("Job "+ (j+1) + " is done");
						}
						else{
							//System.out.println("Checking if job fits partition"); used for debug
							if(jobs[j].getSize()<=memPart[i]){
								stacks[i].push(jobs[j]);
								//System.out.println("Placing job "+(j+1) + " in partition " + (i+1) ); used for debug
								jobs[j].setLoaded(true);
							}
						}
						
						if(jobs[j].getSize()>max){
							jobs[j].setSkipped(true);
						}
					}
				}
		}
	}
	
	// find largest memory partition
	public static int memMax()
	{
		for(int w=0; w<10;w++)
		{
			if(memPart[w]>max){
				max=memPart[w];
			}
		}
		return max;
	}
	
	// process to simulate the passage of a cycle
	public static void runCycle(){
		//System.out.println("Running Cycle");  used for debug
		for(int i=0;i<25;i++)
		{
			//System.out.println("Checking if job is loaded");  used for debug
			if(jobs[i].isLoaded())
			{
				//System.out.println("Cycle running"); used for debug
				jobs[i].runCycle();
			}
		}
		timeCounter++;
	}
	
	//  unloads jobs when they finish 
	public static void unload(){
		//System.out.println("Beginning unloading phase"); used for debug
		for(int i=0;i<25;i++){
			//System.out.println("Checking if job has finished");  used for debug
			if(jobs[i].getCycle()==0)
			{
				for(int j=0;j<10;j++){
					//System.out.println("Locating the finished job in stacks"); used for debug
					if(stacks[j].empty()){
						
					}
					else{
						if(jobs[i]==stacks[j].peek()) {
							//System.out.println("Job found deallocating memory");  used for debug
							stacks[j].pop();
							jobs[i].setDone(true);
							jobs[i].setLoaded(false);
							System.out.println("The amount of time job " +(i+1)+ " took to leave the system is " + timeCounter);
							totalTime+=timeCounter;
						}
					}
				}
			}
		}
	}
}
