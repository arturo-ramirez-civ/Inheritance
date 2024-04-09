/*File: Cube.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Create a cube class to calculate the
* volume of a cube given the edge.  
*/
package projectone;

public class Cube extends ThreeDimensionalShape {

	//Attribute
	public int edge;
	
	//Constructor to initialize the edge attribute
	public Cube(int edge) {
		this.edge = edge;
	}

	@Override 
	public double calcVolume() {
		//Calculate the volume is edge^3
		return Math.pow(edge, 3);
	}
}
