package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    /**
     * The data as an observable list of Persons.
     */
    private ObservableList<Person> personData = FXCollections.observableArrayList();
    // constrocter
    
    
    public MainApp(){

    	personData.add(new Person("Daniel" , "Chung"));
    	personData.add(new Person("Jake" , "Lim"));
    	personData.add(new Person("Supreme" , "God"));
    }
    
    public ObservableList<Person> getPersonData() {
        return personData;
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        try {
            // Load the root layout from the fxml file
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }

        showPersonOverview();
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Shows the person overview scene.
     */
    public void showPersonOverview() {
        try {
            // Load the fxml file and set into the center of the main layout
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/PersonOverview.fxml"));
            AnchorPane overviewPage = (AnchorPane) loader.load();
            rootLayout.setCenter(overviewPage);
            
            //give controller access into the main app 
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }
    }
    
    public boolean showPersonEditDialog(Person person){
    	try {
    	    FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("view/PersonEditDialog.fxml"));
    	    AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage  = new Stage();
			dialogStage.setTitle("edit");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene  scene = new Scene(page);
			dialogStage.setScene(scene);
			
			// Set the person into the controller
		    PersonEditDialogController controller = loader.getController();
		    controller.setDialogStage(dialogStage);
		    controller.setPerson(person);

		    // Show the dialog and wait until the user closes it
		    dialogStage.showAndWait();
		    
		    return controller.isOkClicked();
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    	
    }

    public static void main(String[] args) {
        launch(args);
    }
}