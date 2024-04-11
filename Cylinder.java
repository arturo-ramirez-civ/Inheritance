/*File: Cylinder.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Create a cylinder class to calculate the
* volume of a cylinder given the radius and height.  
*/
package project2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Cylinder extends ThreeDimensionalShape {

	//Attribute
	public int radius;
	public int height;
	final double pi = Math.PI;

	//Constructor to initialize radius and height attributes
	public Cylinder() {
	}

	@Override 
	public double calcVolume() {
		//Calculate the volume is PI * radius^2 * height
		return pi * Math.pow(radius, 2) * height;
	}
	

	@Override
    public String[] getSpecifications() {
        return new String[]{"Radius", "Height"};
    }

    /**
     * Returns a JPanel containing a drawn shape based on the data passed to the object.
     *
     * @return returns a JPanel containing the shape
     */
    @Override
    public JPanel getShapePanel() throws IOException {

    	final BufferedImage image = ImageIO.read(new File("/images/cylinder.png"));
    	//Image reScaledImage = image.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
    	JLabel picLabel = new JLabel(new ImageIcon(image));

    	return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                g.drawImage(image, radius, height, picLabel);

                g.drawString(String.format("Radius: %d, Height: %d", radius, height), 0, 15);
                //int imageX = (this.getWidth() - reScaledImage.getWidth(null))/2;
                //int imageY = (this.getHeight() - reScaledImage.getHeight(null))/2;
               // g.drawImage(reScaledImage, imageX, imageY, null);
               // int stringY = imageY + (reScaledImage.getHeight(null)) + 15;
               // g.drawString(String.format("The Volume of your Cylinder is : %.2f", calcVolume()), imageX ,stringY);
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
        this.height = values.get(1);
    }

}
