package edu.westga.cs1302.FoodPantry.view;

import java.util.ArrayList;

import edu.westga.cs1302.FoodPantry.model.Food;
import edu.westga.cs1302.UtilityClasses.Utility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**This is the codebehind class for the MainWindow GUI.
 * 
 * @author Mason Richardson
 * @version Fall 2024
 * 
 */
public class MainWindow {

	 private String[] types = {"Vegetable", "Meat", "Bread", "Fruit", "Dessert", "Ingredient"};
	 private ArrayList<Food> pantry = new ArrayList<Food>(); 
	 private ArrayList<String> visualRepresentation = new ArrayList<String>();
		@FXML
		private Button submitQuantity;

		@FXML
		private ListView<String> foodListView;

		@FXML
		private TextField foodName;

		@FXML
		private TextField foodQuantity;

		@FXML
		private ChoiceBox<String> foodType;

		@FXML
		private Button oneDown;

		@FXML
		private Button oneUp;

		@FXML
		private Button submitFoodItem;
		
		@FXML
		private Button removeItem;
		
		@FXML
	    private Button showTotoal;
		
		/**This is method shows the total ammount of items inside the pantry.
		 * 
		 * @param event when the showTotal button is pressed. 
		 */
		public void showTotal(ActionEvent event) {
			try {
			int total = Utility.findTotalAmmountOfItems(this.pantry);
			
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setContentText("Total Ammount of Items In Pantry: " + total);
			alert.showAndWait();
			} catch (IllegalArgumentException error) {
				this.makeAlert(error);
			}
		}
		
		/**This allows for the removal of items from the list using the "RemoveItem" button
		 * 
		 * @param event when button to remove the selected option is pressed.
		 * 
		 */
		public void removeItem(ActionEvent event) {
			String currItem;
			try {
				currItem = this.foodListView.getSelectionModel().getSelectedItem();
				int tempIndex = this.findIndex(currItem);
				this.pantry.remove(tempIndex);
				this.visualRepresentation.remove(tempIndex);
				this.foodListView.getItems().clear();
				this.foodListView.getItems().addAll(this.visualRepresentation);
			} catch (Exception error) {
				this.makeAlert(error);
			}
		}
		
		/**This allows for the button that says "click to add one" to actually add one to the quantity
		 * of the selected item in the listView. 
		 * 
		 * @param event when the button to add one is pressed. 
		 */
		public void oneDown(ActionEvent event) {
			String currItem;
			try {
				currItem = this.foodListView.getSelectionModel().getSelectedItem();
				int tempIndex = this.findIndex(currItem);
				this.pantry.get(tempIndex).changeFoodQuantity(-1);
				this.visualRepresentation.set(tempIndex,
						this.pantry.get(tempIndex).getFoodName() + " " + this.pantry.get(tempIndex).getfoodType() + " "
								+ this.pantry.get(tempIndex).getFoodQuantity());
				this.foodListView.getItems().clear();
				this.foodListView.getItems().addAll(this.visualRepresentation);
			} catch (Exception error) {
				this.makeAlert(error);
			}
		}
		
		/**This allows for the button that says "click to add one" to actually add one to the quantity
		 * of the selected item in the listView. 
		 * 
		 * @param event when the button to add one is pressed. 
		 */
		public void oneUp(ActionEvent event) {
			String currItem;
			try {
				currItem = this.foodListView.getSelectionModel().getSelectedItem();
				int tempIndex = this.findIndex(currItem);
				this.pantry.get(tempIndex).changeFoodQuantity(1);
				this.visualRepresentation.set(tempIndex,
						this.pantry.get(tempIndex).getFoodName() + " " + this.pantry.get(tempIndex).getfoodType() + " "
								+ this.pantry.get(tempIndex).getFoodQuantity());
				this.foodListView.getItems().clear();
				this.foodListView.getItems().addAll(this.visualRepresentation);
			} catch (Exception error) {
				this.makeAlert(error);
			}
		}
		
		/**
		 * This uses the foodQuantity text field to update a selected food item in the
		 * pantry's quantity.
		 * 
		 * @param event the submitQuantity button being pressed
		 */
		public void submitQuantity(ActionEvent event) {
			String currItem;
			try {
				int tempQuantity = Integer.parseInt(this.foodQuantity.getText());
				currItem = this.foodListView.getSelectionModel().getSelectedItem();
				int tempIndex = this.findIndex(currItem);
				this.pantry.get(tempIndex).setFoodQuantity(tempQuantity);
				this.visualRepresentation.set(tempIndex,
						this.pantry.get(tempIndex).getFoodName() + " " + this.pantry.get(tempIndex).getfoodType() + " "
								+ this.pantry.get(tempIndex).getFoodQuantity());
				this.foodListView.getItems().clear();
				this.foodListView.getItems().addAll(this.visualRepresentation);
			} catch (Exception error) {
				this.makeAlert(error);
			}
		}

		/**
		 * this handles when the submitFoodItem button is pressed.
		 * 
		 * @author Mason Richardson
		 * @version Fall 2024
		 * 
		 * @param event this is the even that is fired by the button "submitFoodItem".
		 */
		public void submitFoodItem(ActionEvent event) {
			try {
				Food newFood = new Food(this.foodName.getText(), this.foodType.getValue());
				this.pantry.add(newFood);
				this.visualRepresentation
						.add(newFood.getFoodName() + " " + newFood.getfoodType() + " " + newFood.getFoodQuantity());
				this.foodListView.getItems().clear();
				this.foodListView.getItems().addAll(this.visualRepresentation);
			} catch (Exception error) {
				this.makeAlert(error);
			}
		}
    
    @FXML
	void initialize() {
		this.foodType.getItems().addAll(this.types);
	}
    
    private int findIndex(String foodName) {
    	for (int temp = 0; temp < this.visualRepresentation.size(); temp++) {
    		if (this.visualRepresentation.get(temp).equals(foodName)) {
    			return temp;
    		}
    	}
    	return Integer.MIN_VALUE;
    }
    
    private void makeAlert(Exception error) {
    	Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setContentText(error.getMessage());
		alert.showAndWait();
    }

}
