package com.virtusa.assessment.galaxy.main;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.virtusa.assessment.galaxy.reader.ParagraphReader;

/**
 * @author Bhaskar.N
 * 
 *         <p>
 *         This class is the starting point of the application.<br>
 * 
 *         Kindly see the <b>package-info.java</b> for assumptions made in the
 *         application
 *         </p>
 *
 */
@SpringBootApplication
public class VirtusaApplication {
	public static void main(String[] args) {
		// Read the input from console, validate and process
		System.out.println("Welcome to GalaxyMerchant !\nPlease provide input below and a blank new line to finish input\n");
		new ParagraphReader().read().forEach(System.out::println);
	}
}
