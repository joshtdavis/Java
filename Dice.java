//Josh Davis
import java.util.Random;
public class Dice
{
	private int roll;//create roll var
	Random randomNumber = new Random();//create random object
	
	public int diceRoll()
	{
		roll = randomNumber.nextInt(6)+1;//assign random number to roll var
		
		switch(roll)//display the roll in form of *s
		{
			case 1:	System.out.print("\n*\n");
			
				break;
				
			case 2:	System.out.println("\n*  ");
							System.out.println("   ");
							System.out.println("  *\n");
				break;
			
			case 3:	System.out.println("\n*  ");
							System.out.println(" * ");
							System.out.println("  *\n");
				break;
				
			case 4:	System.out.println("\n* *");
							System.out.println("   ");
							System.out.println("* *\n");
				break;
			case 5:	System.out.println("\n* *");
							System.out.println(" * ");
							System.out.println("* *\n");
				break;
			case 6:	System.out.println("\n* *");
							System.out.println("* *");
							System.out.println("* *\n");
				break;
				default: System.out.println("\nInvalid");
		}
		return roll; // return the roll as an int
	}
}
	