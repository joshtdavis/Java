//Josh Davis
import java.io.*;
public class Employees
{
	public static void main(String [ ] args) throws IOException
	{
		//create object
		ProductionWorker p = new ProductionWorker();
		p.token(); //call method to tokenize
		
		//display output
		for(int j=0;j<9;j++)
		{
		System.out.println( "The Employee's name is " + p.getName(j) + 
									" they were hired on " + p.getHireDate(j) +
									" their Employee number is " + p.getEmployeeNum(j) +
									" they work in " + p.Department(j) + 
									" they are on the " +p.shiftHours(j) +
									" they make " + p.getPayRate(j) + " dollars an hour " );
		}
		//create text document filled with the ouput
		PrintWriter pr = new PrintWriter("Department.txt");
		for(int j=0;j<9;j++){
		pr.println( "The Employee's name is " + p.getName(j) + 
									" they were hired on " + p.getHireDate(j) +
									" their Employee number is " + p.getEmployeeNum(j) +
									" they work in " + p.Department(j) + 
									" they are on the " +p.shiftHours(j) +
									" they make " + p.getPayRate(j) + " dollars an hour " );}
		pr.close(); // close file
	}
}
