
package manage;
// Josh Davis
public class proman {

	/**
	 * @param args
	 */
	public static int count=0;
	public static int time=0;
	public static Job[] jobs= new Job[10];
	public static final int quantum = 4;
	public static int w=0;
	public static void main(String[] args) {
		initialize();
		runSim();
	}
public static void initialize()
{
	jobs[0] = new Job(0,6);
	jobs[1] = new Job(3,2);
	jobs[2] = new Job(5,1);
	jobs[3] = new Job(9,7);
	jobs[4] = new Job(10,5);
	jobs[5] = new Job(12,3);
	jobs[6] = new Job(14,4);
	jobs[7] = new Job(16,5);
	jobs[8] = new Job(17,7);
	jobs[9] = new Job(19,2);
}

public static void runSim()
{
	//System.out.println("Working?");  debug use
	while(!chkDone())
	{
		//System.out.println(count%10);   debug use
		if(time < jobs[count % 10].getArrivTime())
		{
			count++;
		}
		else{
			if(jobs[count % 10].isDone())
			{
				count++;
			}
			else{
				if(jobs[count % 10].getCycles()>quantum)
				{
					fullprintTimeCycle(count%10);
					jobs[count % 10].setCycles(jobs[count % 10].getCycles()-quantum);
					//System.out.println("Job "+ ((count%10)+1)+" has "+jobs[count%10].getCycles() + " cycles left");  debug use
					count++;
				}
				else{
					printTimeCycle(count%10);
					jobs[count%10].setCycles(0);
					jobs[count%10].setDone(true);
					System.out.println("Job "+ ((count%10)+1) +" is done");
					count++;
				}
			}
		}
	}
	System.out.println("All done");
}
public static void printProcessQueue()
{
	for(int i=0; i<10;i++)
	{
		if(!jobs[i].isDone() && time >= jobs[i].getArrivTime() && !jobs[i].isPro())
		{
			System.out.println("Job "+ (i+1)+" is waiting to be processed");
		}
	}
}
public static void fullprintTimeCycle(int x)
{
	jobs[x].setPro(true);
	for(int i=0; i<4;i++)
	{
		System.out.println("Job " + (x+1) + " is processing at time "+ time);
		printProcessQueue();
		time++;
	}
	jobs[x].setPro(false);
}
public static void printTimeCycle(int x)
{
	jobs[x].setPro(true);
	for(int i=0;i<(jobs[x].getCycles());i++)
	{
		System.out.println("Job " + (x+1) + " is processing at time "+time);
		printProcessQueue();
		time++;
	}
	jobs[x].setPro(false);
}
public static boolean chkDone()
{
	for(int i=0;i<10;i++)
	{
		if(!jobs[i].isDone())
		{
			return false;
		}
	}
	return true;
}

}
