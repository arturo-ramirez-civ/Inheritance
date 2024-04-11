/*File: Cube.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Create a cube class to calculate the
* volume of a cube given the edge.  
*/
package project2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Cube extends ThreeDimensionalShape {

	//Attribute
	public int edge;
	
	//Constructor to initialize the edge attribute
		public Cube() {
		}

	@Override 
	public double calcVolume() {
		//Calculate the volume is edge^3
		return Math.pow(edge, 3);
	}
	

	@Override
    public String[] getSpecifications() {
        return new String[]{"Edge"};
    }

    /**
     * Returns a JPanel containing a drawn shape based on the data passed to the object.
     *
     * @return returns a JPanel containing the shape
     */
    @Override
    public JPanel getShapePanel() throws IOException {
        final BufferedImage image = ImageIO.read(getClass().getResource("/images/cube.jpg"));
        Image reScaledImage = image.getScaledInstance(300, 300, image.getType());

        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString(String.format("Edge: %d", edge), 0, 15);

                int imageX = (this.getWidth() - reScaledImage.getWidth(null)  )/2;
                int imageY = (this.getHeight() - reScaledImage.getHeight(null))/2;
                g.drawImage(reScaledImage, imageX, imageY, null);
                int stringY = imageY + (reScaledImage.getHeight(null)) + 15;
                g.drawString(String.format("The Volume of your Cube is : %.2f", calcVolume()), imageX ,stringY);
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
        this.edge = values.get(0);
    }
	

}
