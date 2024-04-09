/*File: CreateShape.java
* Creator: Arturo Ramirez
* Course: CMSC 335
* Date: March 25, 2024
* Purpose: Host the main method for the program and
* provides the menu selection functionality.  
*/

package projectone;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateShape {
	
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
    public void processChoice(Scanner scan){
   
        switch(getResponse(scan)) {
            
            case 1: makeCircle();
                break;
            case 2: makeRectangle();
                break;
            case 3: makeSquare();
                break;
            case 4: makeTriangle();
                break;
            case 5: makeSphere();
            	break;
            case 6: makeCube();
            	break;
            case 7:	makeCone();
            	break;
            case 8:	makeCylinder();
            	break;
            case 9: makeTorus();
        		break;
            case 10:terminateMessage();
            		scan.close();
            		System.exit(0);	
                break;
            default: System.out.println("\nError. Please select from menu.");
     
        }//End of switch     
    }//End of method 
    
    //Review scanned input
    public static int getResponse(Scanner scan) {
        int response;
        try {
        	response = scan.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Error, please enter an integer.");
            scan.next(); 
            return getResponse(scan);
        }
        if (response > 0 && response <11) { 
            return response;
        } else {
            System.out.println("Error, please enter a positive integer between 1 to 10.");
            return getResponse(scan);
        }
    }
    
    public static boolean seeMore(Scanner scan) {
    	//Ask question
        System.out.println("\nWould you like to continue? (Y or N)");
        //convert input to lower case
        char res = Character.toLowerCase(scan.next().charAt(0));

        //check for y and n responses or give error
        if (res == 'n') {
            return false;//true
        } else if (res == 'y') {
            return true;
        } else {
        System.out.println("Sorry I do not understand. Enter Y or N");
        return seeMore(scan);
        }
    }
    
    //Function created to time stamp when you exit the program.
    public static void terminateMessage() { 
        DateFormat timestamp = new SimpleDateFormat("MMM d 'at' h:mm a");
        Date date = new Date();
        System.out.println("\nThank you for using the program. Today is "+ timestamp.format(date));
    }
    
    //create circle
    public void makeCircle() { 
        Scanner scan = new Scanner(System.in);
    	System.out.println("You have selected a Circle\n\nWhat is the radius?");
		System.out.println(new Circle(getResponse(scan)));
    }
    
    //create rectangle
    public void makeRectangle() { 
        Scanner scan = new Scanner(System.in);
        System.out.println("You have selected a Rectangle\n\nWhat is the width?");          		
		int rectangleWidth = getResponse(scan);
		System.out.println("What is the height?");
		System.out.println(new Rectangle(rectangleWidth, getResponse(scan)));
    }
    
    //create Square 
    public void makeSquare() { 
        Scanner scan = new Scanner(System.in);
        System.out.println("You have selected a Square\n\nWhat length are the sides?");
    	System.out.println(new Square(getResponse(scan)));
    }
    
    //create Triangle
    public void makeTriangle() { 
        Scanner scan = new Scanner(System.in);
        System.out.println("You have selected a Triangle\n\nWhat is the base?");                
    	int triangleBase = getResponse(scan);
    	System.out.println("What is the height?");
    	System.out.println(new Triangle(triangleBase, getResponse(scan)));
    }
    
    //create Sphere
    public void makeSphere() { 
        Scanner scan = new Scanner(System.in);
        System.out.println("You have selected a Sphere\n\nWhat is the radius?");
		System.out.println(new Sphere(getResponse(scan)));
    }
    
    //create cube
    public void makeCube() { 
        Scanner scan = new Scanner(System.in);
        System.out.println("You have selected a Cube\n\nWhat is the length of the side?");
		System.out.println(new Cube(getResponse(scan)));
    }
    
    //create Cone
    public void makeCone() { 
        Scanner scan = new Scanner(System.in);
        System.out.println("You have selected a Cone\n\nWhat is the radius?");
		int coneBaseRadius = getResponse(scan);
		System.out.println("What is the height?");
		System.out.println(new Cone(coneBaseRadius, getResponse(scan)));
    }
    
    //create Cylinder
    public void makeCylinder() { 
        Scanner scan = new Scanner(System.in);
        System.out.println("You have selected a Cylinder\n\nWhat is the radius?");
		int cylinderRadius = getResponse(scan);
		System.out.println("What is the height?");
		System.out.println(new Cylinder(cylinderRadius, getResponse(scan)));
    }
    
    //create Torus
    public void makeTorus() { 
        Scanner scan = new Scanner(System.in);
        System.out.println("You have selected a Torus\n\nWhat is the inner radius?");
		int littleRadius =getResponse(scan);
		System.out.println("and what is the outer radius?");
		System.out.println(new Torus(littleRadius, getResponse(scan)));
    }  
    
    // Main method
    public static void main(String[] args){
    	  
    	//new instance of current class
    	CreateShape run = new CreateShape();
        Scanner scan = new Scanner(System.in);
      
        do {
        	//Display menu and run switch statements
            run.displayMenu();                       
            run.processChoice(scan);
            
        } while (seeMore(scan));
        terminateMessage();
        scan.close();
        
    }// End of Main method
}
