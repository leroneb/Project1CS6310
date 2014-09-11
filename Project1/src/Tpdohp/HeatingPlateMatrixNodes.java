package Tpdohp;

import java.util.List;

import edu.gatech.cs6310.business.HeatingPlate;
import edu.gatech.cs6310.business.LatticePoint;
import edu.gatech.cs6310.project1.HeatingPlateModel;
import edu.gatech.cs6310.project1.MatrixObserver;

/**
 * Not complete - 9/11/2014.  I decided to rewrite as I was unhappy with
 * the original model produced.  Stubbed out and just need to populate
 * the stubs
 * 
 * @author eserzo
 *
 */
public class HeatingPlateMatrixNodes extends HeatingPlateModel {
	private HeatingPlate heatingPlate = new HeatingPlate( );
	private HeatingPlate oldHeatingPlate = new HeatingPlate( );

	
	// How many times we've recalculated the temperatures in our model
	private int modelingCounter=0;
	
	/**
	 * One could argue for the initialization of the plate to be here
	 */
	public HeatingPlateMatrixNodes( ) { }
	
	public void runModel(int topTemperature, int bottomTemperature,
			int leftTemperature, int rightTemperature, int latticeSize ) {
		System.out
				.println("Running the model using primitives : double calculation");
		
		HeatingPlate oldHeatingPlate = new HeatingPlate( topTemperature, bottomTemperature,
				leftTemperature, rightTemperature, latticeSize );
		HeatingPlate heatingPlate = new HeatingPlate( topTemperature, bottomTemperature,
				leftTemperature, rightTemperature, latticeSize );
		
		LatticePoint headPoint = heatingPlate.getHeadLatticePoint();
		
		// Loop until exit criteria are met, updating each newPlate cell from
		// the
		// average temperatures of the corresponding neighbors in oldPlate
		while (!isModelingComplete( )) {
			//.getNextLatticePoint( )
			
			for (int i = 1; i <= latticeSize; i++) {
				for (int j = 1; j <= latticeSize; j++) {
				//	heatingPlate[i][j] = (oldPlate[i + 1][j] + oldPlate[i - 1][j]
					//		+ oldPlate[i][j + 1] + oldPlate[i][j - 1]) / 4.0;
				}
			}

			oldHeatingPlate.swap( heatingPlate );
			notifyObservers();
		}		
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

		//
		heatingPlate.isConverged(oldHeatingPlate);
		
		return false;
	}
	
	
	/**
	 * Textual representation of a HeatingPlate -- in here primarily for debugging purposes, but
	 * it's always nice to have a textual representation of an object when needed
	 */
	public String toString( ) {
		return heatingPlate.toString();
	}

	@Override
	public void notifyObservers( ) {
		// May want to consider a flag for checking whether or not to send out updates to the observers - slight
		// reduction in ops
		List<MatrixObserver> observers = getObservers();
		for (MatrixObserver currentObserver : observers) {
			currentObserver.receiveUpdate( heatingPlate.getTemperatures() );
		}
	}
}
