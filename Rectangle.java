/*File: Rectangle.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Create a rectangle class to calculate the
* area of a rectangle give the height and width.  
*/
package project2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Rectangle extends TwoDimensionalShape {

	//Attributes
	public int length;
	public int width;
	
	//Constructor to initialize height and width attributes
	public Rectangle() {;
	}

	@Override 
	public double calcArea() {
		//Calculate the area of rectangle height x width
		return length*width;
	}	

 
	public String[] getSpecifications() {
        return new String[]{"Width", "Length"};
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
                super.paintComponent(g);
                g.drawString(String.format("Width: %d, Length: %d", width, length), 0, 50);
                String stats = String.format("The Area of your Rectangle is : %.2f", calcArea());
                FontMetrics metrics = g.getFontMetrics();

                int rectX = (this.getWidth()- width)/2;
                int rectY = (this.getHeight()- length)/2;
                int stringX = (this.getWidth()-metrics.stringWidth(stats))/2;
                int stringY = rectY + length + 30;

                g.drawRect(rectX, rectY , width, length);
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
        this.width = values.get(0);
        this.length = values.get(1);
    }

}
