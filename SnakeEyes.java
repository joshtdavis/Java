//********************************************************************
// SnakeEyes.java       
//
// This program rolls a pair of dice 1000 times and counts the number of 
// snake eyes (both dies roll a one) rolled. The Dice class must be used
// to simulate the roll of a die.
//********************************************************************

import java.util.Scanner;

public class SnakeEyes
{
     public static void main (String[] args)
     {
      int rolls, roll1, roll2, noRolls, noSnakeEyes = 0;
      Scanner input = new Scanner(System.in);
			
	   // Create two separate dice objects to create a pair of dice
      Dice die1 = new Dice();
      Dice die2 = new Dice();
		
		// get from the user the number of dice rolls
		System.out.print ("Enter the number of dice rolls: ");
		noRolls = input.nextInt();
		
		// loop for the number of rolls requested by the user
		for (rolls = 1; rolls <= noRolls; rolls++)
  		  {
          System.out.println("_______________Roll #: " + rolls + " _________________");
		    roll1 = die1.diceRoll();
  		    roll2 = die2.diceRoll();
			 
          if (roll1 == 1 && roll2 == 1)
		  	    noSnakeEyes++;
		   }	
				 
         // Display the dice roll results 
         System.out.println ("Number of Dice Rolls: " + noRolls);
         System.out.println ("Number of Snake Eyes Rolled: " + noSnakeEyes);
         System.out.println ("\nGame Ended");            
		
   }
}