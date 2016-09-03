import java.util.Scanner;
public class CircleDemo
{
	public static void main(String [ ] args)
	{
		//declare vars	
		double rad;
		Circle newCircle;
		Scanner kb;
		
		//input
		
		kb = new Scanner(System.in);
		
		System.out.println("What is the radius?");
		rad = kb.nextDouble();
		
		//declare object
	
		newCircle= new Circle(rad);
		
		//output
		
		System.out.println("Your circle has an area of " + newCircle.getArea());
		System.out.println("Your circle has a circumference of " + newCircle.getCircumference());
		System.out.println("Your circle has a diameter of " + newCircle.getDiameter());
	}
}

		
		
		