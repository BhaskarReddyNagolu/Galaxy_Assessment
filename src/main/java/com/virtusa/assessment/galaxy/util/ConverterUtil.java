package com.virtusa.assessment.galaxy.util;

import com.virtusa.assessment.galaxy.constants.Roman;
import com.virtusa.assessment.galaxy.error.ErrorCodes;
import com.virtusa.assessment.galaxy.error.ErrorMessage;

/**
 * @author Bhaskar.N
 * 
 *         <p>
 *         This class provides set of methods to convert and validate roman
 *         numbers to Arabic numerals
 *         </p>
 */
public class ConverterUtil {

	/**
	 * This regex string will validate whether roman number entered is valid or not
	 */
	public static String romanNumberValidator = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

	private static int getValueByRoman(char romanChar) {
		int value = -1;
		switch (romanChar) {
		case 'I':
			value = Roman.I.getValue();
			break;
		case 'V':
			value = Roman.V.getValue();
			break;
		case 'X':
			value = Roman.X.getValue();
			break;
		case 'L':
			value = Roman.L.getValue();
			break;

		case 'C':
			value = Roman.C.getValue();
			break;

		case 'D':
			value = Roman.D.getValue();
			break;

		case 'M':
			value = Roman.M.getValue();
			break;
		}
		return value;
	}

	public static String romanToArabic(String roman) {
		String result = "";
		switch (validateRomanNumber(roman)) {
		case 1:
			result = convert(roman);
			break;
		default:
			result = new ErrorMessage().getMessage(ErrorCodes.INVALID_ROMAN_STRING);
		}
		return result;
	}

	/**
	 * <p>
	 * This method validates a given roman number<br>
	 * Return 1 when roman number is in correct format or 0 otherwise
	 * </p>
	 * 
	 * @param roman String
	 * @return boolean
	 */
	private static int validateRomanNumber(String roman) {
		int result = 0;
		if (roman.matches(romanNumberValidator)) {
			result = 1;
		}
		return result;
	}

	/**
	 * Converts the valid roman number to arabic number
	 * 
	 * @param roman
	 * @return String
	 */
	private static String convert(String roman) {
		int decimal = 0;
		int lastNumber = 0;
		for (int i = roman.length() - 1; i >= 0; i--) {
			char ch = roman.charAt(i);
			decimal = checkRoman(getValueByRoman(ch), lastNumber, decimal);
			lastNumber = getValueByRoman(ch);
		}
		return decimal + "";
	}

	private static int checkRoman(int totalDecimal, int lastRoman, int lastDecimal) {
		return (lastRoman > totalDecimal)? (lastDecimal - totalDecimal) : (lastDecimal + totalDecimal);
	}
}
