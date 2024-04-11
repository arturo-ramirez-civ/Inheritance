/*File: Shape.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: The lead parent for the hierarchy to work.  
*/
package project2;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Shape {

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
    
    public abstract String[] getSpecifications();

    public abstract JPanel getShapePanel() throws IOException;

    public abstract void passValues(ArrayList<Integer> values);
    
}
