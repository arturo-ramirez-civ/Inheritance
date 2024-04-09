/*File: Rectangle.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Create a rectangle class to calculate the
* area of a rectangle give the height and width.  
*/
package projectone;

public class Rectangle extends TwoDimensionalShape {

	//Attributes
	public int height;
	public int width;
	
	//Constructor to initialize height and width attributes
	public Rectangle(int height, int width) {
		this.height = height;
		this.width = width;
	}

	@Override 
	public double calcArea() {
		//Calculate the area of rectangle height x width
		return height*width;
	}	
}
