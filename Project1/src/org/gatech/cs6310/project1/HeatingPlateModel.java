package org.gatech.cs6310.project1;

import java.util.ArrayList;
import java.util.List;

public abstract class HeatingPlateModel implements ObservableMatrixModel {
	public static final int MAX_TEMPERATURE = 100;

	// The previous temperature at the convergence point. This will ensure we
	// run
	// at least one iteration
	private double previousTemperatureConvergencePoint = -100.0;

	// This value is used for temperature convergence. When the difference in
	// temperatures (between runs)
	// over the maximum temperature is < this number we can consider the model
	// complete.
	//
	// The number was derived backwards by comparing the test data provided
	// against what our expected data
	// should be
	public static final double MAX_DIFF_RATIO = .000001;
	private final Object MUTEX= new Object();

    private List<MatrixObserver> observers = new ArrayList<MatrixObserver>();
    
	/**
	 * Decides whether or not, based on the current and past iteration the
	 * modeling of heat transfer has been completed
	 * 
	 */
	public abstract void runModel(int topTemperature, int bottomTemperature,
			int leftTemperature, int rightTemperature, int latticeSize);

	/**
	 * While performing the function runModel, whether or not the model can be
	 * considered complete. If in a threaded application (ie > a UI where we
	 * have a separate thread for display), could also be called to determine
	 * whether or not the model has completed
	 */
	public abstract boolean isModelingComplete();

	/**
	 * String representation of the model at any given point in time - for
	 * debugging purposes
	 * 
	 * @return
	 */
	public abstract String toString();

	public double getPreviousTemperatureConvergencePoint() {
		return previousTemperatureConvergencePoint;
	}

	public void setPreviousTemperatureConvergencePoint(
			double previousTemperatureConvergencePoint) {
		this.previousTemperatureConvergencePoint = previousTemperatureConvergencePoint;
	}

	public void register(MatrixObserver obj) {
		if (obj == null)
			throw new NullPointerException("Observers must not be null");
		synchronized (MUTEX) {
			if (!observers.contains(obj))
				observers.add(obj);
		}
	}

	public void unregister(MatrixObserver obj) {
		synchronized (MUTEX) {
			observers.remove(obj);
		}
	}
	
	public abstract void notifyObservers( );
	
	public List<MatrixObserver> getObservers( ) {
		return observers;
	}
}
