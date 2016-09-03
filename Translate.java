import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Translate 
{
	//declare vars
	
	private String input;
	private String space = "   ";
	private int i=0;
	private char in;
	private int a;
	private String temp;
	
	//create arrays
	private String[] transl = new String[36];
	private String[] trans = new String[36];
	
	//constructor to recieve string
	
	public Translate(String input) throws IOException
	{
		this.input = input;
			//read in file data to array
			File of = new File("Morse.txt");
			Scanner inf = new Scanner(of);
			while( inf.hasNext())
		{
			
			transl[i]=inf.nextLine();
			i++;
		}
		inf.close();
		
		for(int j=0;j<36; j++)
		{
		StringTokenizer st = new StringTokenizer(transl[j]," ");
			while(st.hasMoreTokens())
			{	
				st.nextToken();
				if(i==0)
				{
					trans[j]=st.nextToken();
				}
				i++;
			}
		}
		i=0;
	}
	// I used this method to tokenize and some debuging
	public void token()
	{
		for(int j=0; j<36; j++)
		{
		//System.out.println(transl[j]);
		StringTokenizer st = new StringTokenizer(transl[j]," ");
		while(st.hasMoreTokens())
		{
			//System.out.print("yes");
			st.nextToken();
				if(i==0){
					trans[j]=st.nextToken();}
		}
		//System.out.println(trans[j]);
	   }
	}
	
	//the method to translate the characters into morse code
	public String toMorse(char in)
	{	
		this.in=in;
		switch(in)
		{
			case 'a':
			case 'A': return trans[10]+" ";
			case 'b':
			case 'B': return trans[11]+" ";
			case 'c':
			case 'C': return trans[12]+" ";
			case 'd':
			case 'D': return trans[13]+" ";
			case 'e':
			case 'E': return trans[14]+" ";
			case 'f':
			case 'F': return trans[15]+" ";
			case 'g':
			case 'G': return trans[16]+" ";
			case 'h':
			case 'H': return trans[17]+" ";
			case 'i':
			case 'I': return trans[18]+" ";
			case 'j':
			case 'J': return trans[19]+" ";
			case 'k':
			case 'K': return trans[20]+" ";
			case 'l':
			case 'L': return trans[21]+" ";
			case 'm':
			case 'M': return trans[22]+" ";
			case 'n':
			case 'N': return trans[23]+" ";
			case 'o':
			case 'O': return trans[24]+" ";
			case 'p':
			case 'P': return trans[25]+" ";
			case 'q':
			case 'Q': return trans[26]+" ";
			case 'r':
			case 'R': return trans[27]+" ";
			case 's':
			case 'S': return trans[28]+" ";
			case 't':
			case 'T': return trans[29]+" ";
			case 'u':
			case 'U': return trans[30]+" ";
			case 'v':
			case 'V': return trans[31]+" ";
			case 'w':
			case 'W': return trans[32]+" ";
			case 'x':
			case 'X': return trans[33]+" ";
			case 'y':
			case 'Y': return trans[34]+" ";
			case 'z':
			case 'Z': return trans[35]+" ";
			default: return space;
		}
	}
	//this method translates morse for integers
	public String toMorseTwo(int a)
	{
		this.a=a;
		switch(a)
		{
			case 1:	return trans[0]+" ";
			case 2:	return trans[1]+" ";
			case 3:	return trans[2]+" ";
			case 4:	return trans[3]+" ";
			case 5:	return trans[4]+" ";
			case 6:	return trans[5]+" ";
			case 7:	return trans[6]+" ";
			case 8:	return trans[7]+" ";
			case 9:	return trans[8]+" ";
			case 0:	return trans[9]+" ";
			default: return space;
		}
	}
	//this method returns 3 spaces to seperate words
	public String toMorseThree()
	{
		return space;
	}
}
