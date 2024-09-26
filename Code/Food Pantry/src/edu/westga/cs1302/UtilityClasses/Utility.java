package edu.westga.cs1302.UtilityClasses;

import java.util.ArrayList;

import edu.westga.cs1302.FoodPantry.model.Food;

/**This is a class that houses static methods to be used across the entire system.
 * 
 * @author Mason Richardson
 * @version Fall 2024
 */
public class Utility {

	/** This Method takes an input of ArrayList over type food, and will total all of the Quantities of food inside the 
	 * given list.
	 * 
	 * @param pantry ArrayList over food that contains all of the objects that need to be tallied. 
	 * @return the total quantity of all items in the given list. 
	 */
	public static int findTotalAmmountOfItems(ArrayList<Food> pantry) throws IllegalArgumentException {
		if (pantry == null) {
			throw new IllegalArgumentException("The List that was passed in was null");
		}
		int totalNum = 0;
		
		for (Food currFood: pantry) {
			totalNum = totalNum + currFood.getFoodQuantity(); 
		}
		
		return totalNum;
	}
}
