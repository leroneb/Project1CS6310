package edu.gatech.cs6310.business;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * A heating plate is composed of LatticePoints -- it is an MxM matrix
 * 
 * A heating plate has a consistent set of outside temperatures -- if the
 * matrix is 3x3, the plate would actually be a 5x5 matrix where the outside
 * edges maintain a consistent set of temperatures (no change allowed in the
 * LatticePoint)
 * 
 * @author eserzo
 *
 */
public class HeatingPlate {
	public ArrayList<LatticePoint> allPoints = new ArrayList<LatticePoint>();

	// The position on the plate, x and y that is either the center of the plate,
	// or in the case where we are working with an even grid - 4x4, the 
	// x and y in the center square that has the maximum differential to the 
	// sides.  In that case, it will take the longest to converge.
	private int centerPointX=0;
	private int centerPointY=0;
	
	public HeatingPlate( ) { }
	
	public HeatingPlate( double topTemperature, double bottomTemperature, 
			double leftTemperature, double rightTemperature, int internalLatticeSize ) {

		if( internalLatticeSize % 2 == 1 ) {
			centerPointX=(internalLatticeSize+1)/2;
			centerPointY=(internalLatticeSize+1)/2;
		} else {
			// Determine max differential for inner square -- skipping for now I don't 
			// think it's going to make a significant difference for our purpose.  The
			// final temperature to two significant digits will still be the same given
			// the temperature constraints provided.  Simple to change if needed though
			centerPointX=(internalLatticeSize)/2;
			centerPointY=(internalLatticeSize)/2;
		}

	}
	
	public LatticePoint getHeadLatticePoint( ) {
		if( allPoints.size() < 0 ) {
			return null;
		}
		return allPoints.get(0);
	}

	/**
	 * Given the temperatures in the incoming plate, place them in the
	 * current plate.
	 * 
	 * @param heatingPlate
	 */
	public void swap(HeatingPlate incomingPlate ) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Are all of the temperatures in the incoming plate < X difference 
	 * of the current plate?  If so then we will consider the two as 
	 * converged
	 * 
	 * mmm... maybe not want here but leaving for now
	 * 
	 * @param incomingPlate
	 * @return
	 */
	public boolean isConverged( HeatingPlate incomingPlate ) {
		return false;
	}
	
	/**
	 * Get all of the temperatures in the form an MxM array of doubles
	 * for this heating plate.  The outside temperatures of the plate
	 * will be included
	 * 
	 * @return
	 */
	public double[][] getTemperatures( ) {
		return null;
	}

	/**
	 * Go through the heating plate starting at the first LatticePoint, unil
	 * the last lattice point and write out the position and temperature
	 */
	public String toString( ) {
		DecimalFormat formatter = new DecimalFormat();
		formatter.setMaximumFractionDigits(2);
		
		StringBuffer myOutput = new StringBuffer( );
	/*	for( int x=0; x < heatingPlate.length; x++ ) {
			for( int y=0; y < heatingPlate[x].length; y++ ) {
				//myOutput.append( "[x,y:" + (x+1) + "," + (y+1) + "] - " + heatingPlate[x][y] + "\r\n" );
				myOutput.append( formatter.format(heatingPlate[x][y]) + "\t" );
			}
			
			myOutput.append( "\r\n" );
		}
		
		myOutput.append( "\r\n\r\nModel took " + modelingCounter + " steps to converge on a temperature" );
	*/	
		return myOutput.toString();		
	}
}
