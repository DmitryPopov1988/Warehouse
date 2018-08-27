package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage stage;

	@Override
	public void start(Stage primaryStage) throws IOException {
		stage = primaryStage;
		stage.setTitle("Warehause");
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("PasswordWindow.fxml"));
		AnchorPane panel = new AnchorPane();
		panel = loader.load();
		Scene scene = new Scene(panel);
		Image icon = new Image(getClass().getResourceAsStream("images/icons8_Fork_Lift_96px_6.png"));
		stage.getIcons().add(icon); 
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);	
	}
}
