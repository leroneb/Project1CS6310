package Twfahp;

import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Logger;

import edu.gatech.cs6310.project1.HeatingPlateModel;
import edu.gatech.cs6310.project1.MatrixObserver;

/**
 * Simple algorithm described above where all computations are performed in 
 * Float precision using a two-dimensional array of wrapped Floats to represent the plate 
 * @author Team5
 *
 */
public class HeatingPlateWrappedFloat extends HeatingPlateModel {
	private final static Logger LOGGER = Logger.getLogger(HeatingPlateWrappedFloat.class.getName()); 

	// Initializing the heating plate to an empty array to prevent errors
	private Float[][] heatingPlate = new Float[0][0];
	// The position on the plate, x and y that is either the center of the plate,
	// or in the case where we are working with an even grid - 4x4, the 
	// x and y in the center square that has the maximum differential to the 
	// sides.  In that case, it will take the longest to converge.
	private int convergencePointX;
	private int convergencePointY;
	
	// How many times we've recalculated the temperatures in our model
	private int modelingCounter=0;
	
	/**
	 * One could argue for the initialization of the plate to be here
	 */
	public HeatingPlateWrappedFloat( ) { }
	
	public void runModel(int topTemperature, int bottomTemperature,
			int leftTemperature, int rightTemperature, int latticeSize ) {
		System.out
				.println("Running the model using wrapped Float array");
		
		if( latticeSize % 2 == 1 ) {
			convergencePointX=(latticeSize+1)/2;
			convergencePointY=(latticeSize+1)/2;
		} else {
			// Determine max differential for inner square -- skipping for now I don't 
			// think it's going to make a significant difference for our purpose.  The
			// final temperature to two significant digits will still be the same given
			// the temperature constraints provided.  Simple to change if needed though
			convergencePointX=(latticeSize)/2;
			convergencePointY=(latticeSize)/2;
		}

		// Create arrays oldPlate and newPlate with linear dimension d
		// plus two extra rows and columns to hold edge temperatures
		Float[][] oldPlate = new Float[latticeSize + 2][latticeSize + 2];
		heatingPlate = new Float[latticeSize + 2][latticeSize + 2];

		// Initialize the temperatures of the edge values and the plate itself
		initialize(oldPlate, topTemperature, bottomTemperature,
				leftTemperature, rightTemperature);
		initialize(heatingPlate, topTemperature, bottomTemperature,
				leftTemperature, rightTemperature);

		boolean isModelingComplete=false;
		
		// Loop until exit criteria are met, updating each newPlate cell from
		// the
		// average temperatures of the corresponding neighbors in oldPlate
		while (!isModelingComplete) {
			for (int i = 1; i <= latticeSize; i++) {
				for (int j = 1; j <= latticeSize; j++) {
					heatingPlate[i][j] = (float) ((oldPlate[i + 1][j] + oldPlate[i - 1][j]
							+ oldPlate[i][j + 1] + oldPlate[i][j - 1]) / 4.0);
				}
			}

			swap(oldPlate, heatingPlate);
			isModelingComplete = isModelingComplete();
			notifyObservers( isModelingComplete );
		}
		
		LOGGER.finest( "Model took " + modelingCounter + " steps to converge on a temperature" );
	}
	
	/**
	 * We will based whether or not the algorithm for diffusion has finished on the convergence of an inner
	 * point (center, or in the case where the center is has multiple points -- a grid that is even ::
	 * 4x4 grid -- one of these points
	 * 
	 *  x x x x
	 *  x x x x
	 *  x x x x
	 *  x x x x
	 *  
	 *  The convergence will be considered complete when the change is < .01% of the maximum initial temperature of
	 *  100. value. 
	 *  
	 *  ie >> 33.325 (run 1), 33.320 (run 2) where the difference is < .01% of the maximum initial temperature
	 *    -- problem has been solved, done will be considered true
	 *    
	 *    
	 *    Thoughts.. this is a potential 
	 *  
	 * @param counter
	 * @return
	 */
	public boolean isModelingComplete( ) {
		modelingCounter++;

		// Also note the comparison here to the size of the plate.  The inner temperature will remain 0 
		// until the model has progressed (plate.length) steps.  Granted, could also check and see if 
		// the temperatures were all initialized 0 -- in which case you save (plate.length) steps but
		// realistically this is a virtual nothing in computing time
		if( ((heatingPlate[convergencePointX][convergencePointY]-getPreviousTemperatureConvergencePoint())/
				MAX_TEMPERATURE) < MAX_DIFF_RATIO && modelingCounter > heatingPlate.length ) {
			return true;
		}
	
		setPreviousTemperatureConvergencePoint(heatingPlate[convergencePointX][convergencePointY]);
		
		return false;
	}
	
	private void swap( Float oldPlate[][], Float newPlate[][] ) {
		for( int x=0; x < oldPlate.length; x++ ) {
			for( int y=0; y < oldPlate[x].length; y++ ) {
				oldPlate[x][y] = newPlate[x][y];
			}
		}
	}
	
	// Edge temperatures are passed in
	// the rest of the temperatures are initialized to 0 per the problem specification
	private Float[][] initialize( Float[][] plate, int topTemperature, int bottomTemperature, int leftTemperature, int rightTemperature ) {

		for( int x=0; x < plate.length; x++ ) {
			for( int y=0; y < plate[x].length; y++ ) {
				// Top
				if( x == 0 ) {
					plate[x][y] = new Float(topTemperature);					
				}
				// Bottom
				else if( x == plate.length-1 ) {
					plate[x][y] = new Float( bottomTemperature );
				} 
				// Note this implies all left but not the top and bottom
				else if( y == 0 ) {
					plate[x][y] = new Float( leftTemperature );					
				}
				else if( y == plate[x].length-1 ) {
					plate[x][y] = new Float( rightTemperature );					
				}
				else {
					// It's already initialized to 0 but doing for emphasis
					plate[x][y] = new Float( 0 );
				}
			}
		}

		return plate;
	}
	
	/**
	 * Textual representation of a HeatingPlate -- in here primarily for debugging purposes, but
	 * it's always nice to have a textual representation of an object when needed
	 */
	public String toString( ) {
		DecimalFormat formatter = new DecimalFormat();
		formatter.setMaximumFractionDigits(2);
		
		StringBuffer myOutput = new StringBuffer( );
		for( int x=1; x < heatingPlate.length-1; x++ ) {
			for( int y=1; y < heatingPlate[x].length-1; y++ ) {
				//myOutput.append( "[x,y:" + (x+1) + "," + (y+1) + "] - " + heatingPlate[x][y] + "\r\n" );
				myOutput.append( formatter.format(heatingPlate[x][y]) + "\t" );
			}
			
			myOutput.append( "\r\n" );
		}
		
		return "\r\n" + myOutput.toString();
	}

	@Override
	public void notifyObservers( boolean isModelingComplete ) {
		// Make sure we have something in our matrix
		if( heatingPlate.length > 0 ) {
			double[][] myPlate = new double[heatingPlate.length][heatingPlate[0].length];

			for( int counter=0; counter < heatingPlate.length; counter++ ) {
				for( int internalCounter=0; internalCounter < heatingPlate.length; internalCounter++ ) {
					myPlate[counter][internalCounter] = heatingPlate[counter][internalCounter];
				}
			}
			// May want to consider a flag for checking whether or not to send out updates to the observers - slight
			// reduction in ops
			List<MatrixObserver> observers = getObservers();
			for (MatrixObserver currentObserver : observers) {
				currentObserver.receiveUpdate( myPlate, modelingCounter, isModelingComplete );
			}
		}
	}
}
