/*File: Square.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Create a Square class to calculate the
* area of a square give the side length.  
*/
package project2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Square extends TwoDimensionalShape {

	//Attribute
	public int sideLength;
	
	//Constructor to initialize side attribute
	public Square() {
	}

	@Override 
	public double calcArea() {
		//Calculate the area of square sideLength x sideLength
		return sideLength*sideLength;
	}	

    public String[] getSpecifications() {
        return new String[] {"Sides"};
    }

    /**
     * Returns a JPanel containing a drawn shape based on the data passed to the object.
     *
     * @return returns a JPanel containing the shape
     */
    @Override
    public JPanel getShapePanel(){
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.drawString(String.format("Side: %d", sideLength), 0, 15);
                String stats = String.format("The Area of your Square is : %.2f", calcArea());
                FontMetrics metrics = g.getFontMetrics();

                int rectX = (this.getWidth()-sideLength)/2;
                int rectY = (this.getHeight()-sideLength )/2;
                int stringX = (this.getWidth()-metrics.stringWidth(stats))/2;
                int stringY = rectY+sideLength+30;

                g.drawRect(rectX, rectY , sideLength, sideLength);
                g.drawString(stats, stringX ,stringY);
            }
        };
    }

    /**
     * Passes values to the objects in a way that shapes with varying parameter counts can implement.
     *
     * @param values an arraylist of integers. First index is the first initialized data member and so on.
     */
    @Override
    public void passValues(ArrayList<Integer> values) {
        this.sideLength = values.get(0);
    }

}
