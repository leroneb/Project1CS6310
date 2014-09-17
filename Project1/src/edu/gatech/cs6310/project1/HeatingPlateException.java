package edu.gatech.cs6310.project1;

import java.util.logging.Logger;

public class HeatingPlateException extends Exception {
	private final static Logger LOGGER = Logger.getLogger(HeatingPlateException.class.getName()); 

	public HeatingPlateException( String errorMessage ) {
		super( errorMessage );
	}
}
