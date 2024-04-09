/*File: TwoDimensionalShape.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Parent to 2D shapes like circle, triangle,
* square,and rectangle.  
*/
package projectone;

public abstract class TwoDimensionalShape extends Shape {
	
	public abstract double calcArea();

	@Override
    public String toString() {
        return String.format("\nThe area of the %s is %.1f.", getClass().getSimpleName(), calcArea());
    }
}