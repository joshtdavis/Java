//   Joshua Davis

import java.util.Scanner;
import java.io.*;
public class Morse
{
	public static void main(String [ ] args) throws IOException
	{
		//declare vars
		
		String input;
		String temp;
		boolean again=false;
		String ans;
		String test;
		int tempy;
		
		//create object
		
		Scanner kb = new Scanner(System.in);
		
		// ask user if they want to convert a sentence into morse code
		
		System.out.println("Do you want to code a sentence in morse code? if so press y");
		ans=kb.nextLine();
		
		//check user response
		
		if(ans.charAt(0)=='y' || ans.charAt(0)=='Y')
		{
			again = true;
		}
		
		while(again)
		{
			System.out.println("Write a sentence that you want to code in morse code");
			input=kb.nextLine();
			Translate tr = new Translate(input);
			tr.token();
			System.out.println("Your sentence is "+input+" and the morse equalivant is ");
			for(int i=0; i<input.length();i++)
			{
				if(Character.isLetter(input.charAt(i)))
				{
				temp=tr.toMorse(input.charAt(i));
				System.out.print(temp);
				}
				else{if(Character.isDigit(input.charAt(i)))
				{
				temp=String.valueOf(input.charAt(i));
				tempy=Integer.parseInt(temp);
				temp=tr.toMorseTwo(tempy);
				System.out.print(temp);
				}else{if(Character.isSpaceChar(input.charAt(i)))
						{ temp=tr.toMorseThree();
							System.out.print(temp);
						}else{System.out.print("This is an invalid character");}
					}
				}
			}
			System.out.println("Do you want to go again? if so press y");
			ans=kb.nextLine();
			
				if(ans.charAt(0)=='y' || ans.charAt(0)=='Y')
				{
					again = true;
				}
				else{ again=false;}
		}
		
	}
}

	