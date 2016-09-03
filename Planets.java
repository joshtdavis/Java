//  Joshua Davis
import java.util.Scanner;

public class Planets
{
	public static void main(String [ ] args)
	{
		//declare vars
		
		char planet;
		String input;
		double weightOnEarth;
		double newWeight=0;
		Scanner keyboard = new Scanner(System.in);
		
		//input
		
		System.out.println("Which Planet are you on?");
		System.out.println("M for Mercury S for saturn");
		System.out.println("V for venus and J for Jupiter");
		do
		{	
			input = keyboard.nextLine();
			planet = input.charAt(0);

		}while(planet!='M' && planet!='m' && planet!='S' && planet!='s'
				 && planet!='V' && planet!='v' && planet!='J' && planet!='j');
		System.out.println("What is your weight on Earth");
		weightOnEarth = keyboard.nextDouble();
		
		//processing
		
		 switch(planet)
		 {
		 	case 'M':
			case 'm':
				newWeight = weightOnEarth * .4;
				break;
			case 'S':
			case 's':
				newWeight = weightOnEarth * 1.1;
				break;
			case 'V':
			case 'v':
				newWeight = weightOnEarth * .9;
				break;
			case 'J':
			case 'j':
				newWeight = weightOnEarth * 2.5;
		}
		
		//output
		
		System.out.print("Your new weight is" + newWeight);
		}
	}
	
	