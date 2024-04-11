/*File: Circle.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Create a circle class to calculate the
* area of a circle give the radius.  
*/
package project2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Circle extends TwoDimensionalShape {

	//Attribute
	public int radius;
	final double pi = Math.PI; 

	//Constructor to initialize radius attribute
	public Circle() {
	}

	@Override 
	public double calcArea() {
		//Calculate the area of circle PI*Radius^2
		return pi * Math.pow(radius, 2);
	}

	//public ImageIcon getImg() {
	//	return img;
	//}
		
    public String[] getSpecifications() {
        return new String[]{"Radius"};
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
                g.drawString(String.format("Radius: %d", radius), 0, 15);
                String stats = String.format("The Area of your Circle is : %.2f", calcArea());
                FontMetrics metrics = g.getFontMetrics();

                int diameter = radius * 2;
                int circleX = (this.getWidth()-diameter)/2;
                int circleY = (this.getHeight()-diameter)/2;
                int stringX = (this.getWidth()-metrics.stringWidth(stats))/2;
                int stringY = circleY+diameter+30;

                g.drawOval(circleX, circleY, diameter, diameter);
                g.drawString(stats, stringX, stringY);

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
        this.radius = values.get(0);
    }
}
