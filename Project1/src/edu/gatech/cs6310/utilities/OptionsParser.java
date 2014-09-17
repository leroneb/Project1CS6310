package edu.gatech.cs6310.utilities;

import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Takes in an array of options, generally passed via the command line and
 * parses it into the corresponding name/values
 * 
 * Just a helper class so I don't have to write parsing of options more than
 * once
 */
public class OptionsParser {
	private final static Logger LOGGER = Logger.getLogger(OptionsParser.class.getName()); 

	public HashMap<String, String> allOptions = new HashMap<String, String>();

	public OptionsParser(String[] args) {
		boolean useNextValue = false;
		String currentOption = "";

		for (int counter = 0; counter < args.length; counter++) {
			if (useNextValue) {
				allOptions.put(currentOption, args[counter]);
				useNextValue = false;
			} else {
				// Option has to start with a - otherwise we are going to ignore
				if (args[counter].startsWith("-")) {
					currentOption = args[counter].replaceAll("-", "");
					if (currentOption.length() > 0) {
						useNextValue = true;
					}
				}
			}
		}
	}

	/**
	 * Option character or name, for example -u would coorelate to an option
	 * "name" of u. The resulting value would be whatever is provided in the
	 * next character string following the -u{space}<br/>
	 * 
	 * For example<br/>
	 * <br/>
	 * 
	 * -u eserzo<br/>
	 * <br/>
	 * 
	 * Would be an option name of u and and option value of eserzo
	 * 
	 * 
	 * @param optionName
	 * @return Corresponding option value
	 * @throws NoOptionException
	 *             if there is no corresponding option found
	 */
	public String getValueForOption(String optionName)
			throws OptionException {
		String retValue = allOptions.get(optionName);
		if (retValue != null) {
			return retValue;
		} else {
			throw new OptionException("No option by the name of "
					+ optionName + " found");
		}
	}
}