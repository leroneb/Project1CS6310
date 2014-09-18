package Gallhp;

import java.util.logging.Logger;

import edu.gatech.cs6310.project1.HeatingPlateUI;

/**
 * GUI wrapper that enables the user to execute any of the four
 * previous computations and see a visualization of the results.
 * 
 * @author Team 5
 *
 */
public class Demo {
	private final static Logger LOGGER = Logger.getLogger(Demo.class.getName()); 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HeatingPlateUI myGrid = new HeatingPlateUI( );
		myGrid.displayJFrame();
	}

}
