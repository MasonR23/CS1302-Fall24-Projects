package edu.westga.cs1302.FoodPantry.model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.FoodPantry.model.Food;

class testChangeFoodQuantity {

	@Test
	public void testWhenQuantityGoesBelowZero() {
		Food Mango = new Food ("Mango" , "fruit");
		
		Mango.setFoodQuantity(20);
		
		assertThrows(IllegalArgumentException.class,
	            ()->{
	            Mango.changeFoodQuantity(-21);
	            });
	}
	
	@Test
	public void testWhenQuantityIsBeingAdded() {
		Food Mango = new Food ("Mango" , "fruit");
		
		Mango.setFoodQuantity(20);	
		
		Mango.changeFoodQuantity(12);
		
		assertTrue(Mango.getFoodQuantity() == 32);
	}
	
	@Test
	public void testwhenQuantityIsBeingSubtracted() {
		Food Mango = new Food ("Mango" , "fruit");
		
		Mango.setFoodQuantity(20);	
		
		Mango.changeFoodQuantity(-12);
		
		assertTrue(Mango.getFoodQuantity() == 8);
	}
	
	@Test
	public void testWhenQuantityGoesToZero() {
		Food Mango = new Food ("Mango" , "fruit");
		
		Mango.setFoodQuantity(20);
		
		Mango.changeFoodQuantity(-20);
		
		assertTrue(0 == Mango.getFoodQuantity());
	}

}
