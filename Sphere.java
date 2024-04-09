/*File: Sphere.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Create a sphere class to calculate the
* volume of a sphere given the radius.  
*/
package projectone;

public class Sphere extends ThreeDimensionalShape {

	//Attributes
	public int radius;
	final double pi = Math.PI;
	
	//Constructor to initialize the radius attribute
	public Sphere(int radius) {
		this.radius = radius;
	}

	@Override 
	public double calcVolume() {
		//Calculate the volume is (4/3) * PI * radius^3
		return (4.0/3.0) * pi * Math.pow(radius, 3.0);
	}
}
