/*File: Triangle.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Create a triangle class to calculate the
* area of a triangle give the base and height.  
*/
package project2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Triangle extends TwoDimensionalShape {

	//Attributes
	public int base;
	public int height; 
	
	//Constructor to initialize base and height attributes
	public Triangle() {
	}

	@Override 
	public double calcArea() {
		//Calculate the area of triangle (base x height)/ 2
		return (base*height)/ 2;
	}	
	

    public String[] getSpecifications() {
        return new String[]{"Base", "Height"};
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
                g.drawString(String.format("Base: %d, Height: %d", base, height), 0, 15);
                String stats = String.format("The Area of your Triangle is : %.2f", calcArea());
                FontMetrics metrics = g.getFontMetrics();

                // https://i.redd.it/7inz78of1ch51.jpg
                int triX1 = (this.getWidth()/2)-base;
                int triX2 = this.getWidth()/2;
                int triX3 = (this.getWidth()/2)+base;
                int triY1 = (this.getHeight()-height)/2;
                int triY2 = (this.getHeight()+height)/2;
                int stringX = (this.getWidth()-metrics.stringWidth(stats))/2;
                int stringY = triY1+height+30;

                //All triangle corner x coordinate
                int[]x={triX1,triX2,triX3};
                //All triangle corner y coordinate
                int[]y={triY2,triY1,triY2};

                g.drawString(stats, stringX ,stringY);
                g.drawPolygon( x, y, 3);
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
        this.base = values.get(0);
        this.height = values.get(1);
    }

}
