package edu.westga.cs1302.FoodPantry.model;

/**This is the food class 
 * 
 * @author Mason Richardson
 * @version Fall 2024
 * 
 */
public class Food {
	
	private String foodName;
	private String foodType;
	private int foodQuantity;

	/**Simple constructor that creates a food object consisting of a foodName, foodType, and foodQuantity. 
	 * foodName is set to the passed in foodName, foodType is set to the passed in foodType, and foodQuantity is set to 0.
	 * 
	 * @param foodName = this is the name of the food that you want to store
	 * @param foodType = this is the type of food that you want to store.
	 * 
	 * @precondiditons throws an illegalArgumentException if either foodName or
	 *                 foodType are null, or if either has a blank value entered in.
	 */
	public Food(String foodName, String foodType) throws IllegalArgumentException {
		if (foodName == null) {
			throw new IllegalArgumentException("foodName can not be null.");
		}
		
		if (foodName.equals("") || foodName.equals(" ")) {
			throw new IllegalArgumentException("Foood Name can not be Empty");
		}

		if (foodType == null) {
			throw new IllegalArgumentException("foodType can not be null");
		}
		
		if (foodType.equals("") || foodType.equals(" ")) {
			throw new IllegalArgumentException("Foood Name can not be Empty");
		}

		this.foodName = foodName;
		this.foodType = foodType;
		this.foodQuantity = 0;
	}
	
	/**simple getter
	 * 
	 * @return this.foodName
	 */
	public String getFoodName() {
		return this.foodName;
	}

	/**simple getter
	 * 
	 * @return this.foodType
	 */
	public String getfoodType() {
		return this.foodType;
	}

	/**simple getter
	 * 
	 * @return this.foodQuantity
	 */
	public int getFoodQuantity() {
		return this.foodQuantity;
	}
	
	/** this is a method that changes the quantity of the food object in a pantry. 
	 * 
	 * @param newQuantity this is the desired new quantity of the food repented as an int. 
	 */
	public void changeFoodQuantity(int newQuantity) {
		this.foodQuantity = newQuantity;
	}
}
