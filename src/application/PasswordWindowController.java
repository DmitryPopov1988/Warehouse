package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import application.controllers.ConnectionToSQL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PasswordWindowController implements Initializable {

	private static Connection connection;
	private static PreparedStatement preparedStatment;

	@FXML
	private Hyperlink link = new Hyperlink("Forgotten your password?");
	@FXML
	private TextField userField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Button login;
	@FXML
	private Label informationLabel;

	@FXML
	private void login(ActionEvent event) throws SQLException {
		try {
			if (retriveData(userField.getText(), passwordField.getText())) {
				if (isAdmin(userField.getText(), passwordField.getText())) {
					openAdministratorView(event);
				}
				informationLabel.setText("Has entered.");
				informationLabel.setTextFill(Color.RED);
				informationLabel.setVisible(true);
			} else if (!retriveData(userField.getText(), passwordField.getText())) {
				informationLabel.setText("Incorrect username or password.");
				informationLabel.setTextFill(Color.RED);
				informationLabel.setVisible(true);
			}
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}

	@FXML
	private void linkToForgetPasswordDialog(ActionEvent event) throws IOException {
		AnchorPane anchorPane;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/ForgetPasswordDialog.fxml"));
			anchorPane = loader.load();
			Scene tableViewScene = new Scene(anchorPane);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(tableViewScene);
			window.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean retriveData(String userName, String password) throws SQLException {
		ResultSet resultSet = null;
		connection = ConnectionToSQL.getConnection();
		String query = "SELECT * FROM users WHERE Login = ? and Password = ?";
		try {
			preparedStatment = connection.prepareStatement(query);
			preparedStatment.setString(1, userName);
			preparedStatment.setString(2, password);
			resultSet = preparedStatment.executeQuery();
			if (resultSet.next()) {
				return true;
			}
			return false;
		} catch (SQLException exc) {
			exc.printStackTrace();
			return false;
		} finally {
			resultSet.close();
			preparedStatment.close();
			connection.close();
		}
	}

	private void openAdministratorView(ActionEvent event) {
		AnchorPane anchorPane;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("adminview/AdministratorView.fxml"));
			anchorPane = loader.load();
			Scene tableViewScene = new Scene(anchorPane);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(tableViewScene);
			window.setResizable(false);
			window.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Get from database user role.
	private boolean isAdmin(String userName, String password) throws SQLException {
		ResultSet resultSet = null;
		connection = ConnectionToSQL.getConnection();
		String role;
		String query = "SELECT * FROM users WHERE Login = ? and Password = ?";
		try {
			preparedStatment = connection.prepareStatement(query);
			preparedStatment.setString(1, userName);
			preparedStatment.setString(2, password);
			resultSet = preparedStatment.executeQuery();
			while (resultSet.next()) {
				role = resultSet.getString("Role");
				if (role.equals("Admin"))
					return true;
			}
			return false;
		} catch (SQLException exc) {
			exc.printStackTrace();
			return false;
		} finally {
			resultSet.close();
			preparedStatment.close();
			connection.close();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		informationLabel.setVisible(false);
	}
}
