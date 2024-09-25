package edu.westga.cs1302.FoodPantry.view;

import java.util.ArrayList;

import edu.westga.cs1302.FoodPantry.model.Food;
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
	 private Integer[] quantity = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 50, 100};
	 private ArrayList<Food> pantry = new ArrayList<Food>(); 
	 private ArrayList<String> visualRepresentation = new ArrayList<String>();
    @FXML
    private ListView<String> foodListView;

    @FXML
    private TextField foodName;

    @FXML
    private ChoiceBox<String> foodType;
    
    @FXML
    private ChoiceBox<Integer> foodQuantity;

    @FXML
    private Button submitFoodItem;
    
    /**this handles when the submitFoodItem button is pressed. 
     * 
     * @author Mason Richardson
     * @version Fall 2024
     * 
     * @param event this is the even that is fired by the button "submitFoodItem".
     */
    public void submitFoodItem(ActionEvent event) {
    	try {
    		Food newFood = new Food(this.foodName.getText(), this.foodType.getValue());
    		System.out.println("this food's name is: " + this.foodName.getText());
    		System.out.print(this.foodName.getText().getClass());
    		newFood.changeFoodQuantity(this.foodQuantity.getValue());
    		this.pantry.add(newFood);
        	this.visualRepresentation.add(newFood.getFoodName() + " " + newFood.getfoodType() + " " + newFood.getFoodQuantity());
        	this.foodListView.getItems().clear();
        	this.foodListView.getItems().addAll(this.visualRepresentation);
    	} catch (Exception error) {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText(error.getMessage());
    		alert.showAndWait();
    	}
    }
    
    @FXML
	void initialize() {
		this.foodType.getItems().addAll(this.types);
		this.foodQuantity.getItems().addAll(this.quantity);
	}

}
