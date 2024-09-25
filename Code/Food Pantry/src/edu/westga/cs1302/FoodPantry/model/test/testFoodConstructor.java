package edu.westga.cs1302.FoodPantry.model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.FoodPantry.model.Food;

class testFoodConstructor {

	@Test
	public void testWhenNameIsNull() {
		 assertThrows(IllegalArgumentException.class,
		            ()->{
		            Food Mango = new Food (null , "fruit");
		            });
	}
	
	@Test
	public void testWhenTypeIsNull() {
		 assertThrows(IllegalArgumentException.class,
		            ()->{
		            Food Mango = new Food ("mango" , null);
		            });
	}
	
	@Test
	public void testWhenConstructorShouldCreateObject() {
		 Food Mango = new Food ("Mango" , "fruit");
		 
		 assertTrue(Mango.getFoodName().equals("Mango")); 
		 assertTrue(Mango.getfoodType().equals("fruit"));
		 assertTrue(Mango.getFoodQuantity() == 0);
	}

}
