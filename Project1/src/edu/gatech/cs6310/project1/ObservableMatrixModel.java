package edu.gatech.cs6310.project1;

/**
 * Really for purposes of attaching the GUI later -- but there could be other reasons
 * to attach to an ObservableMatrix and receive updates
 * @author TeamX
 *
 */
public interface ObservableMatrixModel {
	/**
	 * Register for updates - updates are done when the model (data) is changed
	 */
	public void register(MatrixObserver obj);
	/**
	 * Unregister for updates
	 */
	public void unregister(MatrixObserver obj);
	/**
	 * Inform all registered observers that a change in the model has occurred
	 * 
	 */
    public void notifyObservers( boolean modelingComplete );
}
