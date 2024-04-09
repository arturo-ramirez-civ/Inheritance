/*File: Square.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Create a Square class to calculate the
* area of a square give the side length.  
*/
package projectone;

public class Square extends TwoDimensionalShape {

	//Attribute
	public int sideLength;
	
	//Constructor to initialize side attribute
	public Square(int sideLength) {
		this.sideLength = sideLength;
	}

	@Override 
	public double calcArea() {
		//Calculate the area of square sideLength x sideLength
		return sideLength*sideLength;
	}	
}
