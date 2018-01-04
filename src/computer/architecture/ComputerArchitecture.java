/**
 * @author: Armand Moussaouyi
 * @date: January 03, 2018
 * @description: this is launcher for the interface object (Driver class)
 */
package computer.architecture;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ComputerArchitecture extends Application{
    
    BorderPane root = new BorderPane();     // Creates and initialize a BorderPane variable
    Scene scene = new Scene(root);          // Creates a Scene variable
    Interface iface = new Interface();      // Instant of Interface object
    
    @Override
    public void start(Stage stage){
        
        root.setTop(iface.getTop());        // Add getTop at the top
        root.setRight(iface.getRight());    // Add getRight to the right
        root.setCenter(iface.getCenter());  // Add getCenter to the center
        
        stage.setTitle("Computer Architecture");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}