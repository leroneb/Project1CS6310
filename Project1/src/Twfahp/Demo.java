package Twfahp;

import java.util.logging.Level;
import java.util.logging.Logger;

import Tpdahp.HeatingPlatePrimitiveDouble;
import edu.gatech.cs6310.project1.HeatingPlateApp;
import edu.gatech.cs6310.utilities.OptionException;

// The simple algorithm described above where all computations are performed in double precision using a two-dimensional array of doubles to represent the plate (Tpdahp)

/**
 * Simple simulation of the spread of heat on a two-dimensional, rectangular plate.
 * @author TeamX
 *
 */
public class Demo extends HeatingPlateApp {
	private final static Logger LOGGER = Logger.getLogger(Demo.class.getName()); 

	//The same algorithm using floating point computations on an array of floats (Tpfahp)
	
	// Textual
	// wrapped
	// Float
	// arrays	
	public static void main(String[] args) {
		Demo currentDemo = new Demo( args );
	}
	
	//	The following pseudo code illustrates one way the computation might be performed on a square grid of dimension d.
	public Demo( String args[] ) {
		try {
			parseOptions( args );
			HeatingPlateWrappedFloat currentModel = new HeatingPlateWrappedFloat( );
			
			currentModel.runModel( getTopTemperature(), getBottomTemperature(), getLeftTemperature(), getRightTemperature(),
					getLatticeSize());
			
			
			System.out.println( currentModel );
		} catch( OptionException oe0 ) {
			LOGGER.log( Level.SEVERE, oe0.getMessage());
		}
		
	}
	
}
