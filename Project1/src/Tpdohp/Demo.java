package Tpdohp;

import java.util.logging.Level;
import java.util.logging.Logger;

import edu.gatech.cs6310.project1.HeatingPlateApp;
import edu.gatech.cs6310.project1.HeatingPlateException;
import edu.gatech.cs6310.utilities.OptionException;

public class Demo extends HeatingPlateApp {
	private final static Logger LOGGER = Logger.getLogger(Demo.class.getName()); 

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
			
			System.out.println( currentModel.toString() );
		} catch( OptionException oe0 ) {
			LOGGER.log( Level.SEVERE, oe0.getMessage());
		} catch( HeatingPlateException he0 ) {
			LOGGER.log( Level.SEVERE, he0.getMessage());
		}
		
	}

}
