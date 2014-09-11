package org.gatech.cs6310.project1;

import org.gatech.cs6310.utilities.OptionException;
import org.gatech.cs6310.utilities.OptionsParser;

import Tpfahp.Demo;

public abstract class HeatingPlateApp {
	private int topTemperature;
	private int bottomTemperature;
	private int leftTemperature;
	private int rightTemperature;

	private int latticeSize;

	/**
	 * The options will be applicable across any HeatingPlateDemo -- so
	 * extracting and placing in this abstract class so that our expected
	 * options are consistent across Demo apps
	 * 
	 * @param args
	 * @return
	 * @throws OptionException
	 */
	public OptionsParser parseOptions(String args[]) throws OptionException {
		OptionsParser myParser = new OptionsParser(args);

		try {
			// Must have a top, bottom, left and right options (t,b,l,r)
			topTemperature = Integer.parseInt(myParser
					.getValueForOption("t"));
			bottomTemperature = Integer.parseInt(myParser
					.getValueForOption("b"));
			leftTemperature = Integer.parseInt(myParser
					.getValueForOption("l"));
			rightTemperature = Integer.parseInt(myParser
					.getValueForOption("r"));

			if (topTemperature < 0
					|| bottomTemperature < 0
					|| leftTemperature < 0
					|| rightTemperature < 0
					|| (topTemperature > 100 || bottomTemperature > 100
							|| leftTemperature > 100 || rightTemperature > 100)) {

					// Yes, we are throwing and subsequently catching the option -- here's the thing though,
					// it's very clear that this is invalid.  It does have a cost associated with it but the
					// cost is ultra minimal as this only occurs once during startup.
				
					// Some might disagree about the use of an Exception for flow control versus.  
					// For me, consistency and clarity are very high on any design -- I believe that the use
					// of exceptions for flow control, condition handling makes it explicitly clear how the
					// program is going to react and possible conditions (ie > the method parseOptions says
					// Hey!  I may throw an OptionException -- you better handle it)
				throw new OptionException( "Invalid value" );
			}
			// Catch all -- it either didn't have the option or the option
			// wasn't a valid value
		} catch (Exception noe0) {
			throw new OptionException(
					"Please provide arguments for the top (-t #), bottom (-b #), left (-l #) and right (-r #)temperatures.  Must be an integer between 0 and 100.");
		}

		try {
			// Must have a size of the lattice... note that the problem didn't provide a constraint other than it be an 
			// integer > 0
			latticeSize = Integer.parseInt(myParser.getValueForOption("d"));
			if( latticeSize < 1 ) {
				throw new OptionException( "Invalid value, lattice size < 1" );
			}
		} catch (OptionException noe0) {
			throw new OptionException(
					"An argument (-d #) containing the integer representing the size of the dimension lattice must be provided.  It must be > 0.");
		}

		return myParser;
	}

	public int getTopTemperature() {
		return topTemperature;
	}

	public int getBottomTemperature() {
		return bottomTemperature;
	}

	public int getLeftTemperature() {
		return leftTemperature;
	}

	public int getRightTemperature() {
		return rightTemperature;
	}

	public int getLatticeSize() {
		return latticeSize;
	}
	
}
