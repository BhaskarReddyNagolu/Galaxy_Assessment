package com.virtusa.assessment.galaxy.constants;
/**
 * @author Bhaskar.N
 * 
 *         <p>
 *         This Enumeration holds the different type of possible line types
 *         notation<br>
 *         Used by other classes to check the type of particular line and
 *         perform certain action
 *         </p>
 */

public enum Type {

		/**
		 * This represents that line is of Assignment type. Ex: glob is V
		 */
		ASSIGNED,

		/**
		 * This represents that line is of Credits type. Ex : glob glob Silver is 34
		 * Credits
		 */
		CREDITS,

		/**
		 * This represents that line is question asking how much. Ex : how much is pish
		 * tegj glob glob ?
		 */
		QUESTION_HOW_MUCH,

		/**
		 * This represents that line is question asking how many. Ex: how many Credits
		 * is glob prok Iron ?
		 */
		QUESTION_HOW_MANY,

		/**
		 * This represents that line does not matched any of the line type mentioned
		 * above
		 */
		NOMATCH

	}