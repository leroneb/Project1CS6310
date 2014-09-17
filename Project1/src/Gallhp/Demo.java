package Gallhp;

import java.util.logging.Logger;

import Tpdahp.HeatingPlatePrimitiveDouble;
import edu.gatech.cs6310.project1.HeatingPlateUI;

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
