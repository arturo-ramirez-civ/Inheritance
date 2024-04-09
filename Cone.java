/*File: Cone.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Create a cone class to calculate the
* volume of a cone give the radius and height.  
*/
package projectone;

public class Cone extends ThreeDimensionalShape {

	//Attributes
	public int radius;
	public int height;
	final double pi = Math.PI;
	
	//Constructor to initialize radius and height attributes
	public Cone(int radius, int height) {
		this.radius = radius;
		this.height = height;
	}

	@Override 
	public double calcVolume() {
		//Calculate the volume is PI * Radius^2 * (height / 3)
		return pi * Math.pow(radius, 2)*(height / 3.0);
	}
}
