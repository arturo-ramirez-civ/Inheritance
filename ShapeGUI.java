/*File: CreateShape.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Host the main method for the program and
* provides the menu selection functionality.  
*/

package project2;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.ArrayList;

public class ShapeGUI extends JFrame {

    private final ArrayList<SpecificationPanel> panels = new ArrayList<>();
    private Shape currentShape;

    /**
     * Main constructor of the GUI objects. This GUI uses the default FlowLayout for
     * ease since variable number components are added and taken away. Contains an
     * ActionListener for the JComboBox and one for the submit button.
     */
    public ShapeGUI() {
        super("Project 2");
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        Shape[] shapeList = new Shape[] { new Circle(), new Rectangle(), new Square(), new Triangle(), new Cone(),
                new Cube(), new Cylinder(), new Sphere(), new Torus() };
        JComboBox<Shape> shapeJComboBox = new JComboBox<>(shapeList);
        JPanel introPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        introPanel.add(new JLabel("Please select a shape from the dropdown:"));
        introPanel.add(shapeJComboBox);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(introPanel);
        this.setVisible(true);

        /*
         * JCombobox ActionListener - Set index to -1 so that the ActionListener will
         * fire when the first shape is selected. This JComboBox will dynamically
         * display the required specifications for the chosen shape.
         */
        shapeJComboBox.setSelectedIndex(-1);
        shapeJComboBox.addItemListener((event) -> {
            // first clear panels if there are any
            if (event.getStateChange() == ItemEvent.SELECTED) {
                panels.forEach(introPanel::remove);
                panels.clear();
                introPanel.revalidate();
                this.currentShape = (Shape) event.getItem(); // get that shape
                String[] itemSpecifications = currentShape.getSpecifications();
                // get a panel with JLabels and JTextFields for every required shape input
                panels.add(new SpecificationPanel(itemSpecifications));
                panels.forEach(introPanel::add);
                introPanel.add(submitButton);
            }
        });

        /*
         * Submit Button ActionListener - Takes the values from the dynamically created
         * JTextFields and passes them to the selected shape. Catches any incorrect
         * input passed in the JTextFields.
         */
        submitButton.addActionListener((event) -> {
            DrawFrame drawFrame = new DrawFrame(currentShape);
            try {
                ArrayList<Integer> values = new ArrayList<>();
                panels.forEach( panel -> // for each dynamically created panel
                        panel.getTextFields().forEach(text -> //get values from JTextFields
                                values.add(Integer.parseInt(text.getText()))));
                if (values.stream().allMatch(v -> v > 0)) { //if all values are greater than 0
                    currentShape.passValues(values); //pass the values to be parsed by shape
                    drawFrame.drawShape(); //create shape drawing frame
                } else {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Please use positive, non-zero arguments.",
                            "Warning", JOptionPane.ERROR_MESSAGE);
                }

            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Issue with 3d image pathing",
                        "Warning", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Please enter integer argument(s).",
                        "Warning", JOptionPane.ERROR_MESSAGE);
                panels.forEach( panel -> //clear the text of each JTextField
                        panel.getTextFields().forEach(text -> text.setText("")));
            }
        });

    }

    public static void main(String[] args) {
    	new ShapeGUI();

    }
}
