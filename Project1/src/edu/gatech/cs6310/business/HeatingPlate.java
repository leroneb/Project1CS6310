package edu.gatech.cs6310.business;

import java.awt.Point;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * A heating plate is composed of LatticePoints -- it is an MxM matrix
 * 
 * A heating plate has a consistent set of outside temperatures -- if the
 * matrix is 3x3, the plate would actually be a 5x5 matrix where the outside
 * edges maintain a consistent set of temperatures (no change allowed in the
 * LatticePoint)
 * 
 * This data structure really is a specific type of a graph.  Rather than 
 * come up with a graph class complete with operations, I'm going to go with
 * a lesser route -- one that is much more specific to the problem.  A
 * HashMap where the location is the key of the HashMap and the node is 
 * the value.
 * 
 * This is all internal to this class and can be swapped out later if a more
 * robust data structure is needed.
 * 
 * The way it's been implemented is so heinous from a object references standpoint
 * 
 * @author eserzo
 *
 */
public class HeatingPlate {
	/**
	 * Truth is I kinda hate putting a point location down in here as it reduces the
	 * flexibility of the implementation.  Given a more robust set of requirements though,
	 * this can be changed to be a true Graph. 
	 * 
	 * For purposes of this implementation, LatticePoints once created cannot be changed
	 * (location)
	 */
	private HashMap<Point,LatticePoint> allPoints = new HashMap<Point,LatticePoint>();

	/**
	 * Center point of the graph for determining convergence of final temperature
	 */
	private Point centerPoint = new Point(1,1);

	private int latticeSize;
	private int modelingCounter=0;
	
	public HeatingPlate( ) { }
	
	/**
	 * As opposed to the other classes which were more functional in nature - there is no
	 * initialize( )... method -- the constructor contains the initializing code.
	 */
	public HeatingPlate( double topTemperature, double bottomTemperature, 
			double leftTemperature, double rightTemperature, int internalLatticeSize ) {
		
		this.latticeSize=internalLatticeSize+2;

		if( internalLatticeSize % 2 == 1 ) {
			centerPoint = new Point((latticeSize+1)/2, (latticeSize+1)/2 );
		} else {
			// Determine max differential for inner square -- skipping for now I don't 
			// think it's going to make a significant difference for our purpose.  The
			// final temperature to two significant digits will still be the same given
			// the temperature constraints provided.  Simple to change if needed though
			centerPoint = new Point((latticeSize)/2, (latticeSize)/2 );
		}
		
		// Create an X x Y matrix and put references to the adjoining LatticePoints
		// during creation of a LatticePoint
		// Starting point is  at 1,1
		for( int xCounter=1; xCounter <= latticeSize; xCounter++ ) {
			for( int yCounter=1; yCounter <= latticeSize; yCounter++ ) {
				LatticePoint myPoint=null;
				// Initializing the top/bottom of the plate -- temperatures on the edges cannot
				// change
				if( xCounter==1 ) {
					myPoint = new LatticePoint( topTemperature, true, xCounter + "," + yCounter );
				} else if( xCounter==latticeSize ) {
					myPoint = new LatticePoint( bottomTemperature, true, xCounter + "," + yCounter );
				} // now initialize the left and right
				else if( yCounter == 1 ) {
					myPoint = new LatticePoint( leftTemperature, true, xCounter + "," + yCounter );
				} else if( yCounter == latticeSize ) {
					myPoint = new LatticePoint( rightTemperature, true, xCounter + "," + yCounter );
				} else {
					// Internal point - we initialize to 0 and the temperature is not
					// fixed
					myPoint = new LatticePoint( 0, false, xCounter + "," + yCounter );
				}
				allPoints.put( new Point( xCounter, yCounter ), myPoint );
			}
		}

		
		// Now assign the neighbors - granted not the most economical of methods, but we only
		// init once
		for( int xCounter=1; xCounter <= latticeSize; xCounter++ ) {
			for( int yCounter=1; yCounter <= latticeSize; yCounter++ ) {
				LatticePoint myPoint=allPoints.get( new Point( xCounter, yCounter ));
				
				// We have a north north neighbor
				if( xCounter > 1 )
					myPoint.setNorthNeighbor( allPoints.get( new Point( xCounter-1, yCounter )));
				// We have a south neighbor
				if( xCounter < latticeSize )
					myPoint.setSouthNeighbor( allPoints.get( new Point( xCounter+1, yCounter )));
				// We have an east neighbor
				if( yCounter > 1 ) {
					myPoint.setEastNeighbor( allPoints.get( new Point( xCounter, yCounter-1 )));
				}
				// We have a west neighbor
				if( yCounter < latticeSize ) {
					myPoint.setWestNeighbor( allPoints.get( new Point( xCounter, yCounter+1 )));
				}
				
				allPoints.put( new Point( xCounter, yCounter ), myPoint );
			}
		}
	}
	
	public LatticePoint getHeadLatticePoint( ) {
		if( allPoints.size() < 0 ) {
			return null;
		}
		return (LatticePoint)allPoints.values().toArray()[0];
	}

	/**
	 * Given the temperatures in the incoming plate, place them in the
	 * current plate.
	 * 
	 * @param heatingPlate
	 */
	public void swap(HeatingPlate incomingPlate ) {
		for( int xCounter=0; xCounter < latticeSize; xCounter++ ) {
			for( int yCounter=0; yCounter < latticeSize; yCounter++ ) {
				LatticePoint myPoint=allPoints.get( new Point( xCounter+1, yCounter+1 ));

				// blech - but at some point you just have to get 'er done and move on
				double[][] incomingTemps = incomingPlate.getTemperatures();
				myPoint.setTemperature(incomingTemps[xCounter][yCounter]);
			}
		}
		
	}
	
	/**
	 * Get all of the temperatures in the form an MxM array of doubles
	 * for this heating plate.  The outside temperatures of the plate
	 * will be included
	 * 
	 * @return
	 */
	public double[][] getTemperatures( ) {
		double[][] allTemperatures = new double[latticeSize][latticeSize];
		
		for( int xCounter=1; xCounter <= latticeSize; xCounter++ ) {
			for( int yCounter=1; yCounter <= latticeSize; yCounter++ ) {
				allTemperatures[xCounter-1][yCounter-1] = allPoints.get( new Point( xCounter, yCounter)).getTemperature();
			}
		}
		
		return allTemperatures;
	}
	
	public LatticePoint getNextPoint( LatticePoint current ) {
		Collection<LatticePoint> pointKeys = allPoints.values();
		
		// Whether to return the next point in the collection
		boolean nextPoint=false;
		
		Iterator myIt = pointKeys.iterator();
		while( myIt.hasNext()) {
			LatticePoint checkPoint = (LatticePoint)myIt.next();
			if( nextPoint ) {
				return checkPoint;
			} else if( checkPoint == current ) {
				nextPoint=true;
			} 
		}
		
		// Couldn't find a next LatticePoint in the set
		return null;
	}
	
	public Point getCenterPoint() {
		return centerPoint;
	}

	public void setCenterPoint(Point centerPoint) {
		this.centerPoint = centerPoint;
	}
	
	public int getLatticeSize() {
		return latticeSize;
	}

	public void setLatticeSize(int latticeSize) {
		this.latticeSize = latticeSize;
	}

	/**
	 * Go through the heating plate starting at the first LatticePoint, unil
	 * the last lattice point and write out the position and temperature
	 */
	public String toString( ) {
		DecimalFormat formatter = new DecimalFormat();
		formatter.setMaximumFractionDigits(2);
		
		StringBuffer myOutput = new StringBuffer( );
		for( int x=1; x <= latticeSize; x++ ) {
			for( int y=1; y <= latticeSize; y++ ) {
				//myOutput.append( "[x,y:" + (x+1) + "," + (y+1) + "] - " + heatingPlate[x][y] + "\r\n" );
				myOutput.append( formatter.format( allPoints.get( new Point( x, y )).getTemperature()) + "\t" );
			}
			
			myOutput.append( "\r\n" );
		}
		
		return myOutput.toString();		
	}

}
