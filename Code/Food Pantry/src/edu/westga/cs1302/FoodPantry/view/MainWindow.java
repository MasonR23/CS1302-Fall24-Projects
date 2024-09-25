package edu.westga.cs1302.FoodPantry.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**This is the codebehind class for the MainWindow GUI.
 * 
 * @author Mason Richardson
 * @version Fall 2024
 * 
 */
public class MainWindow {

    @FXML
    private ListView<?> foodListView;

    @FXML
    private TextField foodName;

    @FXML
    private TextField foodType;

    @FXML
    private Button submitFoodItem;

}
