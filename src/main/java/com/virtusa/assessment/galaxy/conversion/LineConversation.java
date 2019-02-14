package com.virtusa.assessment.galaxy.conversion;

import com.virtusa.assessment.galaxy.constants.Constants;
import com.virtusa.assessment.galaxy.constants.Type;

/**
 * @author Bhaskar.N
 * 
 *         <p>
 *         This class contains the type of line in an input<br>
 *         And regular expression to check whether that input belongs to our
 *         assumption or not.<br>
 *         Use method getLineType() to determine the type of line.
 *
 */
public class LineConversation {

	public class LineFilter {
		private Type type;
		private String pattern;

		public LineFilter(Type type, String pattern) {
			this.type = type;
			this.pattern = pattern;
		}

		public String getPattern() {
			return this.pattern;

		}

		public Type getType() {
			return this.type;
		}
	}

	private LineFilter[] linefilter;

	/**
	 * <p>
	 * Initializes the line filters, i.e the four type of lines to be checked.<br>
	 * If more filters are to be added then create as per shown
	 * </p>
	 */
	public LineConversation() {
		// Since we have have four type of lines
		this.linefilter = new LineFilter[4];
		this.linefilter[0] = new LineFilter(Type.ASSIGNED, Constants.PATTERN_ASSIGNED);
		this.linefilter[1] = new LineFilter(Type.CREDITS, Constants.PATTERN_CREDITS);
		this.linefilter[2] = new LineFilter(Type.QUESTION_HOW_MUCH, Constants.PATTERN_HOWMUCH);
		this.linefilter[3] = new LineFilter(Type.QUESTION_HOW_MANY, Constants.PATTERN_HOWMANY);
	}

	/**
	 * <p>
	 * This method returns the line type for the a particular line
	 * </p>
	 * 
	 * @param line String
	 * @return lineType ConversationLine.Type
	 */
	public Type getLineType(String line) {
		line = line.trim();
		Type result = Type.NOMATCH;
		boolean matched = false;
		for (int i = 0; i < linefilter.length && !matched; i++) {
			if (line.matches(linefilter[i].getPattern())) {
				matched = true;
				result = linefilter[i].getType();
			}
		}
		return result;
	}
}
