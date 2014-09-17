package Tpdohp;

import Tpdohp.Demo;
import Tpdahp.HeatingPlatePrimitiveDouble;
import edu.gatech.cs6310.project1.HeatingPlateApp;
import edu.gatech.cs6310.utilities.OptionException;

public class Demo extends HeatingPlateApp {

	public static void main(String[] args) {
		Demo currentDemo = new Demo( args );
	}
	
	//	The following pseudo code illustrates one way the computation might be performed on a square grid of dimension d.
	public Demo( String args[] ) {
		try {
			parseOptions( args );
			HeatingPlateMatrixNodes currentModel = new HeatingPlateMatrixNodes( );
			
			currentModel.runModel( getTopTemperature(), getBottomTemperature(), getLeftTemperature(), getRightTemperature(),
					getLatticeSize());
			
			
			System.out.println( currentModel );
		} catch( OptionException oe0 ) {
			System.err.println( oe0.getMessage());
		}
		
	}

}
