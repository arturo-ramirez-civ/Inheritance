/*File: Circle.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Create a circle class to calculate the
* area of a circle give the radius.  
*/
package projectone;

public class Circle extends TwoDimensionalShape {

	//Attribute
	public int radius;
	final double pi = Math.PI; 
	
	//Constructor to initialize radius attribute
	public Circle(int radius) {
		this.radius = radius;
	}

	@Override 
	public double calcArea() {
		//Calculate the area of circle PI*Radius^2
		return pi * Math.pow(radius, 2);
	}
}
