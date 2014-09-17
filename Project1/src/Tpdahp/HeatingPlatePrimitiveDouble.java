package Tpdahp;

import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Logger;

import edu.gatech.cs6310.business.HeatingPlate;
import edu.gatech.cs6310.project1.HeatingPlateModel;
import edu.gatech.cs6310.project1.MatrixObserver;

public class HeatingPlatePrimitiveDouble extends HeatingPlateModel {
	private final static Logger LOGGER = Logger.getLogger(HeatingPlatePrimitiveDouble.class.getName()); 
	
	// Initializing the heating plate to an empty array to prevent errors
	private double[][] heatingPlate = new double[0][0];
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
	public HeatingPlatePrimitiveDouble( ) { }
	
	public void runModel(int topTemperature, int bottomTemperature,
			int leftTemperature, int rightTemperature, int latticeSize ) {
		System.out
				.println("Running the model using primitives : double calculation");
		
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
		double[][] oldPlate = new double[latticeSize + 2][latticeSize + 2];
		heatingPlate = new double[latticeSize + 2][latticeSize + 2];

		// Initialize the temperatures of the edge values and the plate itself
		initialize(oldPlate, topTemperature, bottomTemperature,
				leftTemperature, rightTemperature);
		initialize(heatingPlate, topTemperature, bottomTemperature,
				leftTemperature, rightTemperature);

		// Loop until exit criteria are met, updating each newPlate cell from
		// the
		// average temperatures of the corresponding neighbors in oldPlate
		while (!isModelingComplete( )) {
			for (int i = 1; i <= latticeSize; i++) {
				for (int j = 1; j <= latticeSize; j++) {
					heatingPlate[i][j] = (oldPlate[i + 1][j] + oldPlate[i - 1][j]
							+ oldPlate[i][j + 1] + oldPlate[i][j - 1]) / 4.0;
				}
			}

			swap(oldPlate, heatingPlate);
			
			notifyObservers();
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
		
		//System.out.println( "modeling counter is " + modelingCounter );
	
		setPreviousTemperatureConvergencePoint(heatingPlate[convergencePointX][convergencePointY]);
		
		return false;
	}
	
	private void swap( double oldPlate[][], double newPlate[][] ) {
		for( int x=0; x < oldPlate.length; x++ ) {
			for( int y=0; y < oldPlate[x].length; y++ ) {
				oldPlate[x][y] = newPlate[x][y];
			}
		}
	}
	
	// Edge temperatures are passed in
	// the rest of the temperatures are initialized to 0 per the problem specification
	private double[][] initialize( double[][] plate, int topTemperature, int bottomTemperature, int leftTemperature, int rightTemperature ) {

		for( int x=0; x < plate.length; x++ ) {
			for( int y=0; y < plate[x].length; y++ ) {
				// Top
				if( x == 0 ) {
					plate[x][y] = topTemperature;					
				}
				// Bottom
				else if( x == plate.length-1 ) {
					plate[x][y] = bottomTemperature;
				} 
				// Note this implies all left but not the top and bottom
				else if( y == 0 ) {
					plate[x][y] = leftTemperature;					
				}
				else if( y == plate[x].length-1 ) {
					plate[x][y] = rightTemperature;					
				}
				else {
					// It's already initialized to 0 but doing for emphasis
					plate[x][y] = 0;
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
		for( int x=0; x < heatingPlate.length; x++ ) {
			for( int y=0; y < heatingPlate[x].length; y++ ) {
				//myOutput.append( "[x,y:" + (x+1) + "," + (y+1) + "] - " + heatingPlate[x][y] + "\r\n" );
				myOutput.append( formatter.format(heatingPlate[x][y]) + "\t" );
			}
			
			myOutput.append( "\r\n" );
		}
		
		return "\r\n" + myOutput.toString();
	}

	@Override
	public void notifyObservers( ) {
		// May want to consider a flag for checking whether or not to send out updates to the observers - slight
		// reduction in ops
		List<MatrixObserver> observers = getObservers();
		for (MatrixObserver currentObserver : observers) {
			currentObserver.receiveUpdate( heatingPlate );
		}
	}
}
