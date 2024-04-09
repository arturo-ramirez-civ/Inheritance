/*File: Torus.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Create a torus class to calculate the
* volume of a torus given the major and minor radius.  
*/
package projectone;

public class Torus extends ThreeDimensionalShape {

	//Attributes
	public int bigRadius;
	public int littleRadius;
	final double pi = Math.PI;
	
	//Constructor to initialize the bigRadius and littleRadius attributes
	public Torus(int bigRadius, int littleRadius) {
		this.bigRadius = bigRadius;
		this.littleRadius = littleRadius;
	}

	@Override 
	public double calcVolume() {
		//Calculate the volume is (PI * r^2)(2 * PI * R)
		return pi* Math.pow(littleRadius, 2)*(2 * pi * bigRadius);
	}
}
