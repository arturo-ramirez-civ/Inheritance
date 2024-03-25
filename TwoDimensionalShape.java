package projectone;

public class TwoDimensionalShape extends Shape {

	//Create Has-A relationship
	Area myArea = new Area();
	
	//Constructor
	public TwoDimensionalShape() {
		myArea.calcArea();
	}
}
