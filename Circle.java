public class Circle
{
	private double radius;
	private final double pi = 3.14159;
	
	public Circle(double rad)
	{
		radius = rad;
	}
	
	public void setRadius (double rad)
	{
		radius = rad;
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	public double getArea()
	{
		double area;
		area = pi * radius * radius;
		return area;
	}
	
	public double getCircumference()
	{
		double circumf;
		
		circumf = pi * 2 * radius;
		return circumf;
	}
	
	public double getDiameter()
	{
		double diam;
		diam = radius * 2;
		return diam;
	}
}