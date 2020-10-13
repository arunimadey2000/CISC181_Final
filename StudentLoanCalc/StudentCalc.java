package app;

import java.io.IOException;


import app.controller.LoanCalcViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentCalc extends Application {

	private Stage stage;
	private BorderPane LoanScreen = null;
	private LoanCalcViewController LCVC = null;
	private TableView table = new TableView();

	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		ShowScreen();
	}
	
	public void ShowScreen() {
		// Parent root;
		try {

			FXMLLoader loader = new FXMLLoader();
			loader = new FXMLLoader(getClass()
					.getResource("/app/view/LoanCalcView.fxml"));
			
			LoanScreen = (BorderPane) loader.load();
			Scene scene = new Scene(LoanScreen);
			stage.setScene(scene);
			LCVC = loader.getController();
			LCVC.setMainApp(this);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	


}