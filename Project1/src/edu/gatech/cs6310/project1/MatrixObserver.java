package edu.gatech.cs6310.project1;
/**
 * An observer of a matrix which contains doubles.  
 * @author TeamX
 *
 */
public interface MatrixObserver {
	public void receiveUpdate( double[][] myData );
}
