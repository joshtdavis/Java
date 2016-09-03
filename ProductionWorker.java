//Josh Davis
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.*;
public class ProductionWorker extends Employee
{

	//create arrays
	private String[] shift = new String[9];
	private String[] payRate = new String[9];
	
	//constructor
	public ProductionWorker() throws IOException
	{
		super();
	}
	
	//tokenize methos
	public void token()
	{
		for(int j=0;j<9;j++)
		{
			//create token object
			
			StringTokenizer tk = new StringTokenizer(info[j]);
			
			//assign tokens
			while(tk.hasMoreTokens())
			{
				firstName[j]=tk.nextToken();
				lastName[j]=tk.nextToken();
				emNum[j]=tk.nextToken();
				hireDate[j]=tk.nextToken();
				shift[j]=tk.nextToken();
				payRate[j]=tk.nextToken(); 
			}
		}
	}
	
	public String shiftHours(int j)
	{
		count=j;
		int t;
		t=Integer.parseInt(shift[j]);  //parse char to int
			switch(t)
			{
				case 1:	return "Morning shift";
				case 2:	return "Swing shift"; 
				case 3:	return "Night shift";
				default:		return "This guy works all day and night";
			}
	}
	public String getPayRate(int j)
	{
		count=j;
		return payRate[count];
	}
}

