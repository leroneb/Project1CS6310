package edu.gatech.cs6310.factories;

import java.util.logging.Logger;

import Tpdahp.HeatingPlatePrimitiveDouble;
import Tpdohp.HeatingPlateMatrixNodes;
import Tpfahp.HeatingPlatePrimitiveFloatingPoint;
import Twfahp.HeatingPlateWrappedFloat;
import edu.gatech.cs6310.project1.HeatingPlateModel;

/**
 * Singleton to enable creation of particular types of heating plate.  Ask 
 * the factory to do the work, don't instantiate directly
 * 
 * @author eserzo
 *
 */
public class HeatingPlateFactory {
	private final static Logger LOGGER = Logger.getLogger(HeatingPlateFactory.class.getName()); 

	private static HeatingPlateFactory me=null;
	
	public enum PROGRAM_TYPES {
	    PRIMITIVE_FLOAT, PRIMITIVE_DOUBLE, WRAPPED_FLOAT, OBJECT 
	}
	/**
	 * Not very interesting... for now anyways, a do nothing constructor
	 */
	private HeatingPlateFactory( ) { }
		
	public static HeatingPlateFactory getInstance( ) {
		// Now technically want to synchronize so we don't have more than one object created but
		// we have a do nothing constructor, fine for now.. and no attributes are initialized
		if( me == null ) {
			me = new HeatingPlateFactory( );
		}

		return me;
	}
	
	public HeatingPlateModel getHeatingPlate( PROGRAM_TYPES heatingPlateType ) {
		HeatingPlateModel myModel = null;
		
		switch( heatingPlateType ) {
			case PRIMITIVE_FLOAT :
				myModel = new HeatingPlatePrimitiveFloatingPoint();
				break;
			case PRIMITIVE_DOUBLE :
				myModel = new HeatingPlatePrimitiveDouble();
				break;
			case WRAPPED_FLOAT :
				myModel = new HeatingPlateWrappedFloat();
				break;
			case OBJECT :
				myModel = new HeatingPlateMatrixNodes();
		}
		
		return myModel;
	}
	
}
