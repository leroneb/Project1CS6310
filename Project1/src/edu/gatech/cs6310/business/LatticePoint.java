package edu.gatech.cs6310.business;

import java.awt.Point;
import java.util.logging.Logger;

/**
 * A type of node -- each node has a double representing a temperature.  Now we could
 * get more fancy with the design, but I'm more a fan of the KISS rule, keeping
 * future requirements in mind of course..
 * 
 * Given that the codebase is maintained by a small set of developers we have 
 * the flexibility to change when needed
 * 
 * Per requirements, the LatticePoint must know about each of it's neighbors.  I'd 
 * probably request more flexibility in this though -- as I would prefer that the
 * knowledge of external conditions be maintained in a class which contains the
 * LatticePoints (ie > a matrix).  Associations would then be maintianed by the 
 * Matrix
 * 
 * @author eserzo
 *
 */
public class LatticePoint {
	private final static Logger LOGGER = Logger.getLogger(LatticePoint.class.getName()); 

	private double temperature;
	
	private LatticePoint northNeighbor;
	private LatticePoint southNeighbor;
	private LatticePoint eastNeighbor;
	private LatticePoint westNeighbor;

	/**
	 * Whether or not the temperature can change for this LatticePoint
	 */
	private boolean fixedTemperature;
	/**
	 * Implies that a LatticePoint knows it's position... I'm not a huge fan 
	 * of this as the HeatingPlate keeps the locations of the points and 
	 * we have a bit of a circular reference here (potential for errors).
	 * Given that the points are static right now this is not an issue, may
	 * need to change
	 */
	private Point location;
	
	public Point getLocation() {
		return location;
	}


	public void setLocation(Point location) {
		this.location = location;
	}


	public LatticePoint( double temperature, boolean fixedTemperature, Point location ) {
		this.temperature=temperature;
		this.fixedTemperature=fixedTemperature;
		this.location=location;
	}
	

	public boolean isFixedTemperature() {
		return fixedTemperature;
	}

	public void setFixedTemperature(boolean fixedTemperature) {
		this.fixedTemperature = fixedTemperature;
	}

	public LatticePoint getNorthNeighbor() {
		return northNeighbor;
	}

	public void setNorthNeighbor(LatticePoint northNeighbor) {
		this.northNeighbor = northNeighbor;
	}

	public LatticePoint getSouthNeighbor() {
		return southNeighbor;
	}

	public void setSouthNeighbor(LatticePoint southNeighbor) {
		this.southNeighbor = southNeighbor;
	}

	public LatticePoint getEastNeighbor() {
		return eastNeighbor;
	}

	public void setEastNeighbor(LatticePoint eastNeighbor) {
		this.eastNeighbor = eastNeighbor;
	}

	public LatticePoint getWestNeighbor() {
		return westNeighbor;
	}

	public void setWestNeighbor(LatticePoint westNeighbor) {
		this.westNeighbor = westNeighbor;
	}
	
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	public String toString( ) {
		return "Temp:" + fixedTemperature + "Loc:" + location;
	}

	@Override
	public boolean equals(Object incoming) {
		if( ((LatticePoint)incoming).getLocation().x == this.getLocation().x &&
				((LatticePoint)incoming).getLocation().y == this.getLocation().y) {
			return true;
		}
		
		return false;
	}


}
