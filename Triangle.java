/*File: Triangle.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Create a triangle class to calculate the
* area of a triangle give the base and height.  
*/
package projectone;

public class Triangle extends TwoDimensionalShape {

	//Attributes
	public int base;
	public int height; 
	
	//Constructor to initialize base and height attributes
	public Triangle(int base,int height) {
		this.base = base;
		this.height = height;
	}

	@Override 
	public double calcArea() {
		//Calculate the area of triangle (base x height)/ 2
		return (base*height)/ 2;
	}	
}
