package Tpfahp;

import edu.gatech.cs6310.project1.HeatingPlateApp;
import edu.gatech.cs6310.utilities.OptionException;

// The simple algorithm described above where all computations are performed in double precision using a two-dimensional array of doubles to represent the plate (Tpdahp)

/**
 * Simple simulation of the spread of heat on a two-dimensional, rectangular plate.
 * @author TeamX
 *
 */
public class Demo extends HeatingPlateApp {

	//The same algorithm using floating point computations on an array of floats (Tpfahp)
	
	// Textual
	// primitive
	// floating point
	// arrays	
	public static void main(String[] args) {
		Demo currentDemo = new Demo( args );
	}
	
	//	The following pseudo code illustrates one way the computation might be performed on a square grid of dimension d.
	public Demo( String args[] ) {
		try {
			parseOptions( args );
			HeatingPlatePrimitiveFloatingPoint currentModel = new HeatingPlatePrimitiveFloatingPoint( );
			
			currentModel.runModel( getTopTemperature(), getBottomTemperature(), getLeftTemperature(), getRightTemperature(),
					getLatticeSize());
			
			
			System.out.println( currentModel );
		} catch( OptionException oe0 ) {
			System.err.println( oe0.getMessage());
		}
		
	}
	
}