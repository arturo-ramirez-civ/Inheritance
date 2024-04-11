/*File: Torus.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Create a torus class to calculate the
* volume of a torus given the major and minor radius.  
*/
package project2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Torus extends ThreeDimensionalShape {

	//Attributes
	public int outerRadius;
	public int innerRadius;
	final double pi = Math.PI;
	
	//Constructor to initialize the bigRadius and littleRadius attributes
		public Torus() {
		}

	@Override 
	public double calcVolume() {
		//Calculate the volume is (PI * r^2)(2 * PI * R)
		return pi* Math.pow(innerRadius, 2)*(2 * pi * outerRadius);
	}


	@Override
    public String[] getSpecifications() {
        return new String[]{"Inner Radius", "Outer Radius"};
    }

    /**
     * Returns a JPanel containing a drawn shape based on the data passed to the object.
     *
     * @return returns a JPanel containing the shape
     */
    @Override
    public JPanel getShapePanel() throws IOException {
        final BufferedImage image = ImageIO.read(getClass().getResource("/images/torus.jpg"));
        Image reScaledImage = image.getScaledInstance(300, 300, Image.SCALE_DEFAULT);

        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString(String.format("Inner Radius: %d, Outer Radius: %d", innerRadius, outerRadius), 0, 15);
                int imageX = (this.getWidth() - reScaledImage.getWidth(null))/2;
                int imageY = (this.getHeight() - reScaledImage.getHeight(null))/2;
                g.drawImage(reScaledImage, imageX, imageY, null);
                int stringY = imageY + (reScaledImage.getHeight(null)) + 15;
                g.drawString(String.format("The Volume of your shape is : %.2f", calcVolume()), imageX ,stringY);
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
        this.innerRadius = values.get(0);
        this.outerRadius = values.get(1);
    }

}
