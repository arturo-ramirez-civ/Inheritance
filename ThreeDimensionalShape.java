/*File: ThreeDimensionalShape.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Parent to 3D shapes like torus, cylinder,
* cone, sphere, and cube.  
*/
package project2;

public abstract class ThreeDimensionalShape extends Shape {

	
	public abstract double calcVolume();

	@Override
    public String toString() {
        return String.format("\nThe volume of the %s is %.1f.", getClass().getSimpleName(), calcVolume());
    }
}