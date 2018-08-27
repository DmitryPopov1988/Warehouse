package application.view;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Main;
import application.controllers.ConnectionToSQL;
import application.controllers.EmailSender;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ForgetPasswordController implements Initializable {
	
	private static Connection connection;
	private static PreparedStatement preparedStatment;
	
	@FXML
	private Label invisibleLabel;
	@FXML
	private TextField emailAddressField;
	@FXML
	private Button backToMainMenuButton;
	@FXML
	Button enterEmailButton;
	
	public String findUserPassword(String emailAddress) throws SQLException {
		Connection connection = null;
		ResultSet resultSet = null;
		String str = "--------";
		connection = ConnectionToSQL.getConnection();
		String query = "SELECT * FROM users WHERE Email = ?";
		try {
			preparedStatment = connection.prepareStatement(query);
			preparedStatment.setString(1, emailAddress);

			resultSet = preparedStatment.executeQuery();
			while (resultSet.next()) {
				str = resultSet.getString("Email");
				System.out.println(str);
				return str;
			}
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setContentText("No account found with that email address.");
			alert.showAndWait();
			resultSet.close();
			preparedStatment.close();
			connection.close();
		} catch (SQLException exc) {
			exc.printStackTrace();
		} 
		return str;

	}
	
	@FXML
	public void sendEmailToUser(ActionEvent event) throws SQLException {
		if(findUserPassword(emailAddressField.getText()) != "--------") {
		EmailSender emailSender = new EmailSender(findUserPassword(emailAddressField.getText()));
		invisibleLabel.setText("Password has been sent to your email address.");
		invisibleLabel.setTextFill(Color.RED);
		invisibleLabel.setVisible(true);
		}
	}

	@FXML
	public void backToLoginScree(ActionEvent event) {
		AnchorPane anchorPane;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("PasswordWindow.fxml"));
			anchorPane = loader.load();
			Scene tableViewScene = new Scene(anchorPane);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(tableViewScene);
			window.show();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	} 

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		invisibleLabel.setVisible(false);

	}

}
