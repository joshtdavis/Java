//Josh Davis
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;
public class Employee
{
	protected int count;
	protected int i=0;

	//create arrays
	protected String[] firstName = new String[9];
	protected String[] lastName = new String[9];
	protected String[] emNum = new String[9];
	protected String[] hireDate = new String[9];
	protected String[] info = new String[9];
	
	//constructor
	public Employee()throws IOException
	{
		// open file
		File of = new File("Information.txt");
		Scanner inf = new Scanner(of);
		
		//read file in to array
		
		while(inf.hasNext())
		{
			info[i]=inf.nextLine();
			i++;
		}
		inf.close();//close file
	}
	
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
			}
		}
	}
	
	public String getHireDate(int p)
	{
		count=p;
		return hireDate[count];
	}
	
	public String getName(int p)
	{
		count=p;
		return firstName[count]+ " " + lastName[count];
	}
	
	public String getEmployeeNum(int p)
	{
		count=p;
		return emNum[count];
	}
	
	public String Department(int j)
	{
		count=j;
			switch(emNum[count].charAt(4))
			{
				case 'a':
				case 'A':	return "Accounting";
				case 'h':
				case 'H':	return "Human Resources";
				case 'p':
				case 'P':	return "Production";
				case 's':
				case 'S':	return "Shipping";
				default:	return "This person does not do shit";
			}
		
	}
}


 