/*File: CreateShape.java
* Creator: Arturo Ramirez
* Date: March 23, 2024
* Purpose: Host the main method for the program and
* provides the menu selection functionality.  
*/

package projectone;

import java.util.Scanner;

public class CreateShape {
	
	//Attribute
	Shape generateShape = new Shape(0, 0);
	
    // Method to display menu
    public void displayMenu() {
        
        System.out.println("\n********** Welcome to the Java OO Shapes Program **********");
        System.out.println("\nSelect from the menu below: ");
        System.out.println("1. Construct a Circle");
        System.out.println("2. Construct a Rectangle");
        System.out.println("3. Construct a Square");
        System.out.println("4. Construct a Triangle");
        System.out.println("5. Construct a Sphere");
        System.out.println("6. Construct a Cube");
        System.out.println("7. Construct a Cone");
        System.out.println("8. Construct a Cylinder");
        System.out.println("9. Construct a Torus");
        System.out.println("10. Exit the program");
    }//End of method
    
    // Method to handle user's selection
    public void processChoice( int c){
    /*
        switch(c) {
            
            /case 1: inv.addBook();
                break;
            case 2: inv.removeBook();
                break;
            case 3: inv.findBook();
                break;
            case 4: inv.displayBook();
                break;
            case 10: System.out.println("\nThanks for using the program. Today is");
                break;
            default: System.out.println("\nError. Please select from menu.");
     
        }//End of switch 
    */    
    }//End of method 
    
    // Main method
    public static void main(String[] args){
    	  
    	//new instance of current class
    	CreateShape run = new CreateShape();
    	
        Scanner scan = new Scanner(System.in);
        int selection = 0;
        
        do {
            run.displayMenu();
            
            System.out.println("\nEnter your selection : ");
            selection = scan.nextInt();
            
            run.processChoice(selection);
        } while (selection != 10);
        
        scan.close();
        
    }// End of Main method

}
