/*File: Cylinder.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Create a cylinder class to calculate the
* volume of a cylinder given the radius and height.  
*/
package projectone;

public class Cylinder extends ThreeDimensionalShape {

	//Attribute
	public int radius;
	public int height;
	final double pi = Math.PI;
	
	//Constructor to initialize radius and height attributes
	public Cylinder(int radius, int height) {
		this.radius = radius;
		this.height = height;
	}

	@Override 
	public double calcVolume() {
		//Calculate the volume is PI * radius^2 * height
		return pi * Math.pow(radius, 2) * height;
	}
}
