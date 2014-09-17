package Tpdohp;

import java.util.List;
import java.util.logging.Logger;

import Tpdahp.HeatingPlatePrimitiveDouble;
import edu.gatech.cs6310.business.HeatingPlate;
import edu.gatech.cs6310.business.LatticePoint;
import edu.gatech.cs6310.project1.HeatingPlateException;
import edu.gatech.cs6310.project1.HeatingPlateModel;
import edu.gatech.cs6310.project1.MatrixObserver;

/**
 * Not complete - 9/11/2014. I decided to rewrite as I was unhappy with the
 * original model produced. Stubbed out and just need to populate the stubs
 * 
 * @author eserzo
 * 
 */
public class HeatingPlateMatrixNodes extends HeatingPlateModel {
	private final static Logger LOGGER = Logger.getLogger(HeatingPlateMatrixNodes.class.getName()); 

	private HeatingPlate heatingPlate = new HeatingPlate();

	// How many times we've recalculated the temperatures in our model
	private int modelingCounter = 0;

	/**
	 * One could argue for the initialization of the plate to be here
	 */
	public HeatingPlateMatrixNodes() {
	}

	public void runModel(int topTemperature, int bottomTemperature,
			int leftTemperature, int rightTemperature, int latticeSize) throws HeatingPlateException {
		System.out.println("Running the model using LatticePoint Objects : double calculation");

		HeatingPlate oldHeatingPlate = new HeatingPlate(topTemperature,
				bottomTemperature, leftTemperature, rightTemperature,
				latticeSize);
		heatingPlate = new HeatingPlate(topTemperature,
				bottomTemperature, leftTemperature, rightTemperature,
				latticeSize);
		
		// Loop until exit criteria are met, updating each newPlate cell from
		// the
		// average temperatures of the corresponding neighbors in oldPlate
		while (!isModelingComplete(oldHeatingPlate, heatingPlate)) {
			HeatingPlate.swap(oldHeatingPlate, heatingPlate);

			LatticePoint currentLatticePoint = heatingPlate.getHeadLatticePoint();

			while (currentLatticePoint != null) {
				// Implication that all fixed points on a heating plate are on
				// the outside of the plate
				// and that all inside points will have a n/s/w/e neighbor
				if (!currentLatticePoint.isFixedTemperature()) {
					heatingPlate.setTemperature( currentLatticePoint.getLocation(),
							(currentLatticePoint.getEastNeighbor()
									.getTemperature()
									+ currentLatticePoint.getWestNeighbor()
											.getTemperature()
									+ currentLatticePoint.getNorthNeighbor()
											.getTemperature() + currentLatticePoint
									.getSouthNeighbor().getTemperature()) / 4);
					currentLatticePoint = oldHeatingPlate.getNextPoint(currentLatticePoint);
				} else {
					currentLatticePoint = oldHeatingPlate.getNextPoint(currentLatticePoint);
				}
			}
			
			notifyObservers();
		}

		LOGGER.finest( "Model took " + modelingCounter + " steps to converge on a temperature" );
		
	}

	/**
	 * We will based whether or not the algorithm for diffusion has finished on
	 * the convergence of an inner point (center, or in the case where the
	 * center is has multiple points -- a grid that is even :: 4x4 grid -- one
	 * of these points
	 * 
	 * x x x x x x x x x x x x x x x x
	 * 
	 * The convergence will be considered complete when the change is < .01% of
	 * the maximum initial temperature of 100. value.
	 * 
	 * ie >> 33.325 (run 1), 33.320 (run 2) where the difference is < .01% of
	 * the maximum initial temperature -- problem has been solved, done will be
	 * considered true
	 * 
	 * 
	 * Thoughts.. this is a potential
	 * 
	 * @param counter
	 * @return
	 */
	public boolean isModelingComplete(HeatingPlate oldPlate,
			HeatingPlate currentPlate) {
		modelingCounter++;
		
		// Also note the comparison here to the size of the plate. The inner
		// temperature will remain 0
		// until the model has progressed (plate.length) steps. Granted, could
		// also check and see if
		// the temperatures were all initialized 0 -- in which case you save
		// (plate.length) steps but
		// realistically this is a virtual nothing in computing time
		if (((currentPlate.getTemperatures()[currentPlate.getCenterPoint().x][currentPlate
				.getCenterPoint().y] - oldPlate.getTemperatures()[oldPlate
				.getCenterPoint().x][oldPlate.getCenterPoint().y]) / MAX_TEMPERATURE) < MAX_DIFF_RATIO
				&& modelingCounter > oldPlate.getLatticeSize()) {
			return true;
		}

		return false;
	}

	/**
	 * Textual representation of a HeatingPlate -- in here primarily for
	 * debugging purposes, but it's always nice to have a textual representation
	 * of an object when needed
	 */
	public String toString() {
		return "\r\n" + heatingPlate.toString();
	}

	@Override
	public void notifyObservers() {
		// May want to consider a flag for checking whether or not to send out
		// updates to the observers - slight
		// reduction in ops
		List<MatrixObserver> observers = getObservers();
		for (MatrixObserver currentObserver : observers) {
			currentObserver.receiveUpdate(heatingPlate.getTemperatures());
		}
	}
}
