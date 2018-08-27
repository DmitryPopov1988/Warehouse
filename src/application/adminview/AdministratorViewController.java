package application.adminview;

import application.controllers.*;

import java.io.File;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/*import java.sql.PreparedStatement;*/
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
/*import javafx.beans.property.SimpleStringProperty;*/
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
/*import javafx.scene.control.ListView;*/
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.StringConverter;

public class AdministratorViewController implements Initializable {
	
    @FXML
    private Label analysysFirstLabel;
    @FXML
    private Label analysysSecondLabel;
    @FXML
    private Label analysysThirdLabel;
    @FXML
    private Label analysysLabel;
    @FXML
    private Label receiptsLabel;

    @FXML
    private Label stocksLabel;

    @FXML
    private Label disposalsLabel;
    @FXML
    private Label reportsStatusLabel;
    @FXML
    private PieChart reportsPieChart;
    @FXML
    private BarChart<?, ?> reportBarChart;
    @FXML
    private DatePicker reportDatePickerTo;
    @FXML
    private DatePicker reportDatePickerFrom;
    @FXML
    private Button reportShowDataButton;
    @FXML
    private CategoryAxis axisX;
    @FXML
    private NumberAxis axisY;

	@FXML
	private Button departureOfGoodsFromWarehauseButton;
	@FXML
	private Button deleteRecordFromMovementTableView;
	@FXML
	private Button editQuantityInMovmentTableViewButton;
	@FXML
	private TextField quantityTextField;
	@FXML
	private Label sumOfGoodsLabel;
	@FXML
	private TableView<Receipt> movementTableView;
	@FXML
	private TableColumn<Receipt, Integer> idSupplierMovementTableColumn;
	@FXML
	private TableColumn<Receipt, String> receiptDateMovementTableViewColumn;
	@FXML
	private TableColumn<Receipt, String> productNameMovamentTableViewColumn;
	@FXML
	private TableColumn<Receipt, Integer> quantityMovementTableViewColumn;
	@FXML
	private TableColumn<Receipt, Double> priceMovementTableViewColumn;
	@FXML
	private TableColumn<Receipt, Double> amountMovementTableViewColumn;

	@FXML
	private Label dateLabelTwo;
	@FXML
	private DatePicker datePickerFrom;
	@FXML
	private DatePicker datePickerTo;
	@FXML
	private ComboBox<String> supplierComboBoxTwo;
	@FXML
	private Button showGoodsForExportButton;

	@FXML
	private Label summ;
	@FXML
	private Label dateLabel;
	@FXML
	private Button insertToDatabaseReceipt;

	@FXML
	private ComboBox<String> supplierComboBox;

	@FXML
	private TextField productNameTextField;

	@FXML
	private TextField priceOfProductTextField;

	@FXML
	private Button addProductToTableView;

	@FXML
	private Button removeProductFromReceiptTableView;

	@FXML
	private Button updateProductInTableViewButton;

	@FXML
	private TextField quantityOfProductsTexyField;

	@FXML
	private TableView<Receipt> receiptTableView;

	@FXML
	private TableColumn<Receipt, Integer> idsupplierTableColumn;

	@FXML
	private TableColumn<Receipt, String> dateSupplierTableColumn;

	@FXML
	private TableColumn<Receipt, String> nameSupplierTableColumn;

	@FXML
	private TableColumn<Receipt, Integer> quantitySupplierTableColumn;

	@FXML
	private TableColumn<Receipt, Double> priceSupplierTableColumn;

	@FXML
	private TableColumn<Receipt, Double> amountSupplierTableColumn;
	@FXML
	private Button updateSuppliersTableButton;
	@FXML
	private TextField suppliersSearchTextField;
	@FXML
	private TextField supplierNameTextField;
	@FXML
	private TextField supplierAddressTextField;
	@FXML
	private TextField supplierCountryTextField;
	@FXML
	private Button clearSuppliersTableButton;
	@FXML
	private Button deletSupplierButton;
	@FXML
	private Button updateSupplierButton;
	@FXML
	private Button addSupplierButton;
	@FXML
	private TextField supplierPhoneNumberTextField;
	@FXML
	private TextField supplierContractTextField;
	@FXML
	private Button chooseContractFile;
	@FXML
	private TableView<Supplier> supplierTableView;
	@FXML
	private TableColumn<Supplier, String> idColumn;
	@FXML
	private TableColumn<Supplier, String> nameColumn;
	@FXML
	private TableColumn<Supplier, String> countryColumn;
	@FXML
	private TableColumn<Supplier, String> addressColumn;
	@FXML
	private TableColumn<Supplier, String> phoneColumn;
	@FXML
	private TableColumn<Supplier, String> contactColumn;

	@FXML
	private Button goodsReceiptButton;
	@FXML
	private Button goodsMovementButton;
	@FXML
	private Button reportsButton;
	@FXML
	private Button addEmployeeButton;
	@FXML
	private Button updateEmployeeButton;
	@FXML
	private Button deletEmployeeButton;
	@FXML
	private Button settingsButton;
	@FXML
	private Button employeeUpdateButton;
	@FXML
	private TextField employeeSearchField;
	@FXML
	private Pane mainPane;
	@FXML
	private Pane reportsPane;
	@FXML
	private Pane settingsPane;
	@FXML
	private Pane goodsReceiptPane;
	@FXML
	private Pane goodsMovementPane;
	@FXML
	private Pane addEmployeePane;
	@FXML
	private Pane paneLogo;
	@FXML
	private Pane logoMainPane;
	@FXML
	private StackPane stackPane;
	@FXML
	private GridPane goodsReceiptGridPane;
	@FXML
	private GridPane mainGridPane;
	@FXML
	private GridPane goodsMovementGridPane;
	@FXML
	private GridPane reportsGridPane;
	@FXML
	private GridPane settingsGridPane;
	@FXML
	private GridPane employeeGridPane;
	@FXML
	private TableView<Users> employeeTableView;
	@FXML
	private TableColumn<Users, String> id;
	@FXML
	private TableColumn<Users, String> firstName;
	@FXML
	private TableColumn<Users, String> lastName;
	@FXML
	private TableColumn<Users, String> login;
	@FXML
	private TableColumn<Users, String> password;
	@FXML
	private TableColumn<Users, String> email;
	@FXML
	private TableColumn<Users, String> role;
	@FXML
	private TextField employeeFirstNameTextField;
	@FXML
	private TextField employeeLastNameTextField;
	@FXML
	private TextField employeeLoginTextField;
	@FXML
	private TextField employeeEmailAddressTextField;
	@FXML
	private TextField employeePasswordTextField;
	@FXML
	private ToggleGroup Role;
	@FXML
	private TabPane goodsReceiptTabPane;
	/* List<Receipt> justAnotherList = new ArrayList<>(); */
	ObservableList<Receipt> receipt;
	private ObservableList data;
	/* ObservableList list; */
	private ObservableList<PieChart.Data> pieChartList = FXCollections.observableArrayList();
	private ObservableList<String> choise;
	List<Receipt> receiptList = new ArrayList<>();
	private final String pattern = "yyyy-MM-dd";
	private FilteredList<Users> filteredData;
	private FilteredList<Supplier> supplierFilteredData;
	double stocks, receipts, disposals;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
/*		 XYChart.Series series1 = new XYChart.Series();
	        series1.setName("Receipt");
	        series1.getData().add(new XYChart.Data("haha", 35000.65));
	        XYChart.Series series2 = new XYChart.Series();
	        series2.setName("Stocks");
	        series2.getData().add(new XYChart.Data("haha", 23000.65));
	        XYChart.Series series3 = new XYChart.Series();
	        series3.setName("Disposal");
	        series3.getData().add(new XYChart.Data("haha", 15000.65));
	        reportBarChart.getData().addAll(series1, series2, series3);*/
		/* supplierComboBox.getItems().setAll("Supplier"); */
		supplierComboBox.setItems(choise);
		supplierComboBoxTwo.setItems(choise);
		supplierComboBoxTwo.setPromptText("Supplier");
		idColumn.setCellValueFactory(new PropertyValueFactory<>("idsuppliers"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
		addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
		phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
		contactColumn.setCellValueFactory(new PropertyValueFactory<>("contract"));

		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		firstName.setCellValueFactory(new PropertyValueFactory<>("fn"));
		lastName.setCellValueFactory(new PropertyValueFactory<>("ln"));
		login.setCellValueFactory(new PropertyValueFactory<>("lo"));
		password.setCellValueFactory(new PropertyValueFactory<>("pa"));
		email.setCellValueFactory(new PropertyValueFactory<>("em"));
		role.setCellValueFactory(new PropertyValueFactory<>("ro"));
		employeeTableView.setItems(data);
		mainGridPane.toFront();
		mainPane.toFront();

		idSupplierMovementTableColumn.setCellValueFactory(new PropertyValueFactory<>("idsupplier"));
		receiptDateMovementTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		productNameMovamentTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		quantityMovementTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		priceMovementTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		amountMovementTableViewColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

		idsupplierTableColumn.setCellValueFactory(new PropertyValueFactory<>("idsupplier"));
		dateSupplierTableColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
		nameSupplierTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		quantitySupplierTableColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		priceSupplierTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		amountSupplierTableColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		movementTableView.setItems(data);
		/* movementTableView.setItems(list); */
		dateLabel.setText(date());
		dateLabelTwo.setText(date());

		StringConverter converter = new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

			@Override
			public String toString(LocalDate date) {
				if (date != null) {
					return dateFormatter.format(date);
				} else {
					return "";
				}
			}

			@Override
			public LocalDate fromString(String string) {
				if (string != null && !string.isEmpty()) {
					return LocalDate.parse(string, dateFormatter);
				} else {
					return null;
				}
			}
		};

/*		receiptsLabel.setVisible(false);
		stocksLabel.setVisible(false);
		disposalsLabel.setVisible(false);*/



		reportsStatusLabel.setVisible(false);
		datePickerFrom.setConverter(converter);
		datePickerFrom.requestFocus();
		datePickerTo.setConverter(converter);
		datePickerTo.requestFocus();
		reportDatePickerTo.setConverter(converter);
		reportDatePickerTo.requestFocus();
	    reportDatePickerFrom.setConverter(converter);
	    reportDatePickerFrom.requestFocus();
	}

	@FXML
	public void search(KeyEvent event) {
		employeeSearchField.textProperty().addListener((observableValue, oldValue, newValue) -> {
			filteredData.setPredicate((Users users) -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String toLowerCaseFilter = newValue.toLowerCase();
				if (users.getId().contains(newValue)) {
					return true;
				} else if (users.getId().toLowerCase().contains(toLowerCaseFilter)) {
					return true;
				} else if (users.getFn().toLowerCase().contains(toLowerCaseFilter)) {
					return true;
				} else if (users.getLn().toLowerCase().contains(toLowerCaseFilter)) {
					return true;
				} else if (users.getLo().toLowerCase().contains(toLowerCaseFilter)) {
					return true;
				} else if (users.getPa().toLowerCase().contains(toLowerCaseFilter)) {
					return true;
				} else if (users.getEm().toLowerCase().contains(toLowerCaseFilter)) {
					return true;
				} else if (users.getRo().toLowerCase().contains(toLowerCaseFilter)) {
					return true;
				}
				return false;
			});
		});
		SortedList<Users> sort = new SortedList<>(filteredData);
		sort.comparatorProperty().bind(employeeTableView.comparatorProperty());
		employeeTableView.setItems(sort);
	}

	@FXML
	private void handleClicks(ActionEvent event) {

		if (event.getSource() == goodsReceiptButton) {
			setDataIntoChoiseBox();
			/* logoMainPane.setStyle("-fx-background-color: #7FC203;"); */
			goodsReceiptGridPane.toFront();
			goodsReceiptPane.toFront();
			refreshDataInSupplierTableView(event);
		} else if (event.getSource() == goodsMovementButton) {
			/* logoMainPane.setStyle("-fx-background-color: #FF8617;"); */
			setDataIntoComboBox();
			goodsMovementGridPane.toFront();
			goodsMovementPane.toFront();
		} else if (event.getSource() == reportsButton) {
			/* logoMainPane.setStyle("-fx-background-color: #F17C72;"); */
			reportsGridPane.toFront();
			reportsPane.toFront();
		} else if (event.getSource() == addEmployeeButton) {
			/* logoMainPane.setStyle("-fx-background-color: #42CAFC;"); */
			loadDataToEmployeeTableView(event);
			addEmployeePane.toFront();
			employeeGridPane.toFront();
		} else if (event.getSource() == settingsButton) {
			/* logoMainPane.setStyle("-fx-background-color:  #8673C5;"); */
			settingsGridPane.toFront();
			settingsPane.toFront();
		} else {
			/* logoMainPane.setStyle("-fx-background-color:  #008BC1;"); */
			mainGridPane.toFront();
			mainPane.toFront();
		}
	}

	@FXML
	private void loadDataToEmployeeTableView(ActionEvent event) {
		try {
			data = FXCollections.observableArrayList();
			ResultSet rs = ConnectionToSQL.getConnection().createStatement().executeQuery("SELECT * FROM users");
			while (rs.next()) {
				data.add(new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7)));
				filteredData = new FilteredList<>(data, e -> true);
				System.out.println(rs.getString("idusers") + rs.getString("FirstName") + rs.getString("LastName")
						+ rs.getString("Login") + rs.getString("Password") + rs.getString("Email")
						+ rs.getString("Role"));
			}
			employeeTableView.setItems(null);
			employeeTableView.setItems(data);
		} catch (SQLException exc) {
			System.err.println("Error" + exc);
		}
		System.out.println("Done");
	}

	@FXML
	private void addNewEmployeeToDB(ActionEvent event) throws SQLException {
		String firstName = employeeFirstNameTextField.getText();
		String lastName = employeeLastNameTextField.getText();
		String login = employeeLoginTextField.getText();
		String email = employeeEmailAddressTextField.getText();
		String password = employeePasswordTextField.getText();
		String role = getRole();
		String query = "INSERT INTO users (FirstName, LastName, Login, Password, Email, Role) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = ConnectionToSQL.getConnection().prepareStatement(query);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, login);
			preparedStatement.setString(4, password);
			preparedStatement.setString(5, email);
			preparedStatement.setString(6, role);
			if (employeeFirstNameTextField.getText().isEmpty() || !isValidName(firstName)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid first name.");
				alert.showAndWait();
				employeeFirstNameTextField.clear();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			if (employeeLastNameTextField.getText().isEmpty() || !isValidName(lastName)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid last name.");
				alert.showAndWait();
				employeeLastNameTextField.clear();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			if (employeeLoginTextField.getText().isEmpty() || !isValidName(login)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid login.");
				alert.showAndWait();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			if (employeeEmailAddressTextField.getText().isEmpty() || !EmailSender.validateEmailAddres(email)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid email address.");
				alert.showAndWait();
				employeeEmailAddressTextField.clear();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			if (employeePasswordTextField.getText().isEmpty() || !isValidName(login)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid password.");
				alert.showAndWait();
				employeePasswordTextField.clear();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			preparedStatement.executeUpdate();
			clearEmployeeTextFields();
			preparedStatement.close();
			loadDataToEmployeeTableView(event);
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}

	@FXML
	public void deleteUser(ActionEvent event) throws SQLException {
		try {
			Users users = employeeTableView.getSelectionModel().getSelectedItem();
			PreparedStatement preparedStatment = null;
			String query = "DELETE FROM users WHERE idusers = '" + users.getId() + "'";
			preparedStatment = ConnectionToSQL.getConnection().prepareStatement(query);
			Alert alertConfirmation = new Alert(AlertType.CONFIRMATION);
			alertConfirmation.setTitle(null);
			alertConfirmation.setHeaderText(null);
			alertConfirmation.setContentText("User will be deleted.");
			Optional<ButtonType> result = alertConfirmation.showAndWait();
			if (result.get() == ButtonType.OK) {
				preparedStatment.executeUpdate();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setContentText("The user's record was deleted.");
				alert.showAndWait();
				clearEmployeeTextFields();
				preparedStatment.close();
				loadDataToEmployeeTableView(event);
			} else {
				clearEmployeeTextFields();
				preparedStatment.close();
				loadDataToEmployeeTableView(event);
			}
		} catch (SQLException exc) {
			System.out.println(exc);
		}
	}
	


	@FXML
	private void updateEmployeeDataInDB(ActionEvent event) throws SQLException {
		Users users = employeeTableView.getSelectionModel().getSelectedItem();
		String firstName = employeeFirstNameTextField.getText();
		String lastName = employeeLastNameTextField.getText();
		String login = employeeLoginTextField.getText();
		String email = employeeEmailAddressTextField.getText();
		String password = employeePasswordTextField.getText();
		String role = getRole();
		String query = "UPDATE users SET FirstName = ?, LastName = ?, Login = ?, Email = ?, Password = ?, Role = ? WHERE idusers = '"
				+ users.getId() + "'";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = ConnectionToSQL.getConnection().prepareStatement(query);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, login);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, password);
			preparedStatement.setString(6, role);
			if (employeeFirstNameTextField.getText().isEmpty() || !isValidName(firstName)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid name");
				alert.showAndWait();
				employeeFirstNameTextField.clear();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			if (employeeLastNameTextField.getText().isEmpty() || !isValidName(lastName)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid last name");
				alert.showAndWait();
				employeeLastNameTextField.clear();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			if (employeeLoginTextField.getText().isEmpty() || !isValidName(login)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid name");
				alert.showAndWait();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			if (employeeEmailAddressTextField.getText().isEmpty() || !EmailSender.validateEmailAddres(email)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid email address.");
				alert.showAndWait();
				employeeEmailAddressTextField.clear();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			if (employeePasswordTextField.getText().isEmpty() || !isValidName(login)) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid password.");
				alert.showAndWait();
				employeePasswordTextField.clear();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			preparedStatement.executeUpdate();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("The record was changed.");
			alert.showAndWait();
			clearEmployeeTextFields();
			preparedStatement.close();
			loadDataToEmployeeTableView(event);
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}

	private boolean isValidName(String name) {
		boolean b = name.matches("[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$");
		return b;
	}

	private String getRole() {
		RadioButton selectedRadioButton = (RadioButton) Role.getSelectedToggle();
		String toogleGroupValue = selectedRadioButton.getText();
		return toogleGroupValue;
	}

	@FXML
	private void clearEmployeeTextFields(ActionEvent event) {
		employeeFirstNameTextField.clear();
		employeeLastNameTextField.clear();
		employeeLoginTextField.clear();
		employeePasswordTextField.clear();
		employeeEmailAddressTextField.clear();
	}

	private void clearEmployeeTextFields() {
		employeeFirstNameTextField.clear();
		employeeLastNameTextField.clear();
		employeeLoginTextField.clear();
		employeePasswordTextField.clear();
		employeeEmailAddressTextField.clear();
	}

	@FXML
	private void clearSupplierTextFields(ActionEvent event) {
		supplierNameTextField.clear();
		supplierAddressTextField.clear();
		supplierCountryTextField.clear();
		supplierPhoneNumberTextField.clear();
		supplierContractTextField.clear();
	}

	private void clearSupplierTextFields() {
		supplierNameTextField.clear();
		supplierAddressTextField.clear();
		supplierCountryTextField.clear();
		supplierPhoneNumberTextField.clear();
		supplierContractTextField.clear();
	}

	@FXML
	private void displaySelected(MouseEvent event) {
		Users users = employeeTableView.getSelectionModel().getSelectedItem();
		if (users == null) {
			System.out.println("Nothing selected.");
		} else {
			employeeFirstNameTextField.setText(users.getFn());
			employeeLastNameTextField.setText(users.getLn());
			employeeEmailAddressTextField.setText(users.getEm());
			employeeLoginTextField.setText(users.getLo());
			employeePasswordTextField.setText(users.getPa());
		}
	}

	@FXML
	public void chooseContractFile(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File("D:\\"));
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("PDF Files", "*.pdf"));
		File selectFile = fileChooser.showOpenDialog(null);
		if (selectFile != null) {
			supplierContractTextField.setText(selectFile.getAbsolutePath());
		} else {
			System.out.println("File is not valid.");
		}
	}

	@FXML
	public void refreshDataInSupplierTableView(ActionEvent event) {
		try {
			data = FXCollections.observableArrayList();
			ResultSet rs = ConnectionToSQL.getConnection().createStatement().executeQuery("SELECT * FROM suppliers");
			while (rs.next()) {
				data.add(new Supplier(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));
				supplierFilteredData = new FilteredList<>(data, e -> true);
				System.out.println(rs.getString("idsuppliers") + rs.getString("name") + rs.getString("country")
						+ rs.getString("address") + rs.getString("phone") + rs.getString("contract"));
			}
			setDataIntoChoiseBox();
			supplierTableView.setItems(null);
			supplierTableView.setItems(data);
		} catch (SQLException exc) {
			System.err.println("Error" + exc);
		}
		System.out.println("Done");
	}

	@FXML
	private void addNewSupplier(ActionEvent event) throws SQLException {
		String name = supplierNameTextField.getText();
		String country = supplierCountryTextField.getText();
		String address = supplierAddressTextField.getText();
		String phone = supplierPhoneNumberTextField.getText();
		String contract = supplierContractTextField.getText();

		String query = "INSERT INTO suppliers (name, country, address, phone, contract) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = ConnectionToSQL.getConnection().prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, country);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, phone);
			preparedStatement.setString(5, contract);
			if (supplierNameTextField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid first name.");
				alert.showAndWait();
				supplierNameTextField.clear();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			if (supplierCountryTextField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid country name.");
				alert.showAndWait();
				supplierCountryTextField.clear();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			if (supplierAddressTextField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid address.");
				alert.showAndWait();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			if (supplierPhoneNumberTextField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid phone.");
				alert.showAndWait();
				supplierPhoneNumberTextField.clear();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			if (supplierContractTextField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid contract.");
				alert.showAndWait();
				supplierContractTextField.clear();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			preparedStatement.executeUpdate();
			preparedStatement.close();
			refreshDataInSupplierTableView(event);
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}

	@FXML
	public void searchSuppliers(KeyEvent event) {
		suppliersSearchTextField.textProperty().addListener((observableValue, oldValue, newValue) -> {
			supplierFilteredData.setPredicate((Supplier supplier) -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String toLowerCaseFilter = newValue.toLowerCase();
				if (supplier.getName().contains(newValue)) {
					return true;
				} else if (supplier.getIdsuppliers().toLowerCase().contains(toLowerCaseFilter)) {
					return true;
				} else if (supplier.getName().toLowerCase().contains(toLowerCaseFilter)) {
					return true;
				} else if (supplier.getCountry().toLowerCase().contains(toLowerCaseFilter)) {
					return true;
				} else if (supplier.getAddress().toLowerCase().contains(toLowerCaseFilter)) {
					return true;
				} else if (supplier.getPhone().toLowerCase().contains(toLowerCaseFilter)) {
					return true;
				} else if (supplier.getContract().toLowerCase().contains(toLowerCaseFilter)) {
					return true;
				}

				return false;
			});
		});
		SortedList<Supplier> sort = new SortedList<>(supplierFilteredData);
		sort.comparatorProperty().bind(supplierTableView.comparatorProperty());
		supplierTableView.setItems(sort);
	}

	@FXML
	private void displaySelectedSupplier(MouseEvent event) {
		Supplier supplier = supplierTableView.getSelectionModel().getSelectedItem();
		if (supplier == null) {
			System.out.println("Nothing selected.");
		} else {
			supplierNameTextField.setText(supplier.getName());
			supplierCountryTextField.setText(supplier.getCountry());
			supplierAddressTextField.setText(supplier.getAddress());
			supplierPhoneNumberTextField.setText(supplier.getPhone());
			supplierContractTextField.setText(supplier.getContract());
		}
	}

	@FXML
	public void deletSupplier(ActionEvent event) throws SQLException {
		try {
			Supplier supplier = supplierTableView.getSelectionModel().getSelectedItem();
			PreparedStatement preparedStatment = null;
			String query = "DELETE FROM suppliers WHERE idsuppliers = '" + supplier.getIdsuppliers() + "'";
			preparedStatment = ConnectionToSQL.getConnection().prepareStatement(query);
			Alert alertConfirmation = new Alert(AlertType.CONFIRMATION);
			alertConfirmation.setTitle(null);
			alertConfirmation.setHeaderText(null);
			alertConfirmation.setContentText("Supplier will be deleted.");
			Optional<ButtonType> result = alertConfirmation.showAndWait();
			if (result.get() == ButtonType.OK) {
				preparedStatment.executeUpdate();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setContentText("The supplier's record was deleted.");
				alert.showAndWait();
				clearSupplierTextFields();
				preparedStatment.close();
				refreshDataInSupplierTableView(event);
			} else {
				clearSupplierTextFields();
				preparedStatment.close();
				refreshDataInSupplierTableView(event);
			}
		} catch (SQLException exc) {
			System.out.println(exc);
		}
	}

	@FXML
	private void updateSupplierREcordInDB(ActionEvent event) throws SQLException {
		Supplier supplier = supplierTableView.getSelectionModel().getSelectedItem();
		String name = supplierNameTextField.getText();
		String country = supplierCountryTextField.getText();
		String address = supplierAddressTextField.getText();
		String phone = supplierPhoneNumberTextField.getText();
		String contract = supplierContractTextField.getText();
		String query = "UPDATE suppliers SET name = ?, country = ?, address = ?, phone = ?, contract = ? WHERE idsuppliers = '"
				+ supplier.getIdsuppliers() + "'";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = ConnectionToSQL.getConnection().prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, country);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, phone);
			preparedStatement.setString(5, contract);
			if (supplierNameTextField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid first name.");
				alert.showAndWait();
				supplierNameTextField.clear();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			if (supplierCountryTextField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid country name.");
				alert.showAndWait();
				supplierCountryTextField.clear();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			if (supplierAddressTextField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid address.");
				alert.showAndWait();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			if (supplierPhoneNumberTextField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid phone.");
				alert.showAndWait();
				supplierPhoneNumberTextField.clear();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			if (supplierContractTextField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Invalid contract.");
				alert.showAndWait();
				supplierContractTextField.clear();
				ConnectionToSQL.getConnection().close();
				preparedStatement.close();
				return;
			}
			preparedStatement.executeUpdate();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("The record was changed.");
			alert.showAndWait();
			clearSupplierTextFields();
			refreshDataInSupplierTableView(event);
			preparedStatement.close();

		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}

	public void setDataIntoChoiseBox() {
		try {
			choise = FXCollections.observableArrayList();
			ResultSet rs = ConnectionToSQL.getConnection().createStatement().executeQuery("SELECT * FROM suppliers");
			while (rs.next()) {
				choise.add(rs.getString("name"));
				System.out.println(rs.getString("idsuppliers") + rs.getString("name") + rs.getString("country")
						+ rs.getString("address") + rs.getString("phone") + rs.getString("contract"));
			}
			supplierComboBox.setItems(null);
			supplierComboBox.setPromptText("Supplier");
			supplierComboBox.setItems(choise);
			System.out.println("Done");
		} catch (SQLException exc) {
			System.err.println("Error" + exc);
		}
	}

	public int idSupplier(String name) throws SQLException {
		int i = 0;
		ResultSet rs = ConnectionToSQL.getConnection().createStatement()
				.executeQuery("SELECT * FROM suppliers WHERE name = '" + name + "'");
		while (rs.next()) {
			i = rs.getInt("idsuppliers");
			System.out.println(i);
			return i;
		}
		System.out.println(i);
		return i;
	}

	public String date() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedString = date.format(formatter);
		System.out.println(formattedString);
		return formattedString;

	}

	@FXML
	public void addGoodsToTableView(ActionEvent event) throws SQLException {
		String name = productNameTextField.getText();
		int quantity = Integer.parseInt(quantityOfProductsTexyField.getText());
		double price = Double.parseDouble(priceOfProductTextField.getText());
		double amount = quantity * price;
		int idsupplier = idSupplier(supplierComboBox.getSelectionModel().getSelectedItem());
		String date = date();
		if (Receipt.isValidQuantity(quantity) && !supplierComboBox.getSelectionModel().isEmpty()
				&& !priceOfProductTextField.getText().isEmpty() && price > 0) {
			if (productNameTextField.getText().isEmpty() || priceOfProductTextField.getText().isEmpty()
					|| quantityOfProductsTexyField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("Something went wrong.");
				alert.showAndWait();
				return;
			}
			double sum = 0;
			receiptList.add(new Receipt(idsupplier, date, name, quantity, price, amount));
			receipt = FXCollections.observableArrayList(receiptList);
			receiptTableView.setItems(receipt);
			for (Receipt am : receiptList) {
				sum += am.getAmount();
			}
			summ.textProperty().bind(new SimpleDoubleProperty(sum).asString());
			productNameTextField.clear();
			quantityOfProductsTexyField.clear();
			priceOfProductTextField.clear();
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setContentText("Something went wrong.");
			alert.showAndWait();
			return;
		}
	}

	@FXML
	private void displaySelectedGoodsInTableView(MouseEvent event) {
		Receipt receipt = receiptTableView.getSelectionModel().getSelectedItem();
		if (receipt == null) {
			System.out.println("Nothing selected.");
		} else {
			productNameTextField.setText(receipt.getName());
			quantityOfProductsTexyField.setText(Integer.toString(receipt.getQuantity()));
			priceOfProductTextField.setText(Double.toString(receipt.getPrice()));
		}
	}

	@FXML
	private void removeSelectedRecordFromReceiptTableView(ActionEvent event) {
		Receipt receiptObject = receiptTableView.getSelectionModel().getSelectedItem();
		receiptList.remove(receiptObject);
		receipt = FXCollections.observableArrayList(receiptList);
		receiptTableView.setItems(receipt);
		double sum = 0;
		for (Receipt am : receiptList) {
			sum += am.getAmount();
		}
		summ.textProperty().bind(new SimpleDoubleProperty(sum).asString());
		productNameTextField.clear();
		quantityOfProductsTexyField.clear();
		priceOfProductTextField.clear();
	}

	@FXML
	private void updateSelectedRecordFromReceiptTableView(ActionEvent event) throws SQLException {
		Receipt receiptObject = receiptTableView.getSelectionModel().getSelectedItem();
		receiptList.remove(receiptObject);
		addGoodsToTableView(event);
		productNameTextField.clear();
		quantityOfProductsTexyField.clear();
		priceOfProductTextField.clear();
	}

	@FXML
	private void insertIntoDataBaseReceipt(ActionEvent event) {
		try {
			String query = "INSERT INTO receipts (idsupplier, add_data, name, quantity, price) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = null;
			preparedStatement = ConnectionToSQL.getConnection().prepareStatement(query);
			for (Receipt rec : receiptList) {
				if (receiptList != null) {
					preparedStatement.setInt(1, rec.getIdsupplier());
					preparedStatement.setString(2, rec.getDate());
					preparedStatement.setString(3, rec.getName());
					preparedStatement.setInt(4, rec.getQuantity());
					preparedStatement.setDouble(5, rec.getPrice());
					/* preparedStatement.setDouble(6, rec.getAmount()); */
					preparedStatement.executeUpdate();
				}
			}
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Receipt was added to DB.");
			alert.showAndWait();
			preparedStatement.close();
			receiptList.clear();
			receiptTableView.setItems(null);
			double sum = 0;
			for (Receipt am : receiptList) {
				sum += am.getAmount();
			}
			summ.textProperty().bind(new SimpleDoubleProperty(sum).asString());
			productNameTextField.clear();
			quantityOfProductsTexyField.clear();
			priceOfProductTextField.clear();
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}

	public void setDataIntoComboBox() {
		setDataIntoChoiseBox();
		supplierComboBoxTwo.setItems(choise);
	}

	@FXML
	public void getDataAboutGoodsFromDB(ActionEvent event) {
		List<Receipt> newReceiptList = new ArrayList<>();
		receiptList.clear();
		try {
			data = FXCollections.observableArrayList();
			ResultSet rs = ConnectionToSQL.getConnection().createStatement().executeQuery(
					"SELECT idsupplier, add_data, name, SUM(quantity) AS quantity, price, amount FROM receipts WHERE idsupplier = '"
							+ idSupplier(supplierComboBoxTwo.getSelectionModel().getSelectedItem())
							+ "' AND add_data BETWEEN '" + datePickerFrom.getValue() + "' AND '"
							+ datePickerTo.getValue() + "' GROUP BY name; ");
			while (rs.next()) {
				if (rs.getInt(4) <= 0) {
					System.out.println("less than zero;)");
				} else {
					newReceiptList.add(new Receipt(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
							rs.getDouble(5), rs.getDouble(6)));
				}
			}
			for (Receipt rec : newReceiptList) {
				receiptList.add(rec);
			}
			newReceiptList.clear();
			data = FXCollections.observableArrayList(receiptList);
			movementTableView.setItems(null);
			movementTableView.setItems(data);
			double sum = 0;
			for (Receipt am : receiptList) {
				sum += am.getAmount();
			}
			sumOfGoodsLabel.textProperty().bind(new SimpleDoubleProperty(sum).asString());
			data = FXCollections.observableArrayList(receiptList);
			movementTableView.setItems(data);
			/* receiptList.clear(); */
		} catch (SQLException exc) {
			System.err.println("Error" + exc);
		}
		System.out.println("Done");
	}

	@FXML
	private void displaySelectedQuantity(MouseEvent event) {
		Receipt receipt = movementTableView.getSelectionModel().getSelectedItem();
		if (receipt == null) {
			System.out.println("Nothing selected.");
		} else {
			quantityTextField.setText(Integer.toString(receipt.getQuantity()));
		}
	}

	@FXML
	private void editQuantityInTableView(ActionEvent event) throws CloneNotSupportedException {
		Receipt receipt = movementTableView.getSelectionModel().getSelectedItem();
		if (receipt == null) {
			System.out.println("Nothing selected!");
		} else {
			List<Receipt> newReceiptList = new ArrayList<>();
			System.out.println(receiptList.size());
			int oldValue = receipt.getQuantity();
			for (Receipt rec : receiptList) {
				if (receipt.equals(rec)) {
					if (receiptList.size() == 1) {
						if (oldValue > Integer.parseInt(quantityTextField.getText())) {
							int newValue = Integer.parseInt(quantityTextField.getText());
							receipt.setQuantity(Integer.parseInt(quantityTextField.getText()));
							receipt.setAmount(receipt.getPrice() * receipt.getQuantity());
							newReceiptList.add(receipt);
							data.clear();
							receiptList.clear();
							double sum = 0;
							for (Receipt reciept : newReceiptList) {
								receiptList.add(rec);
								sum += rec.getAmount();
							}
							newReceiptList.clear();
							sumOfGoodsLabel.textProperty().bind(new SimpleDoubleProperty(sum).asString());
							data = FXCollections.observableArrayList(receiptList);
							movementTableView.setItems(data);
							quantityTextField.clear();
							System.out.println("Count");
							for(Receipt reci : newReceiptList) {
								System.out.println(reci.getQuantity());
							}
							return;
						}
					}
					System.out.println("Woo hoo");
				} 
				else 
					{
					newReceiptList.add(rec);
				}
			}
			System.out.println(newReceiptList.size());
			if (oldValue > Integer.parseInt(quantityTextField.getText())) {
				int newValue = Integer.parseInt(quantityTextField.getText());
				receipt.setQuantity(Integer.parseInt(quantityTextField.getText()));
				receipt.setAmount(receipt.getPrice() * receipt.getQuantity());
				newReceiptList.add(receipt);
				data = FXCollections.observableArrayList(newReceiptList);
				movementTableView.setItems(data);
				receiptList.clear();
				double sum = 0;
				for (Receipt rec : newReceiptList) {
					receiptList.add(rec);
					sum += rec.getAmount();
				}
				sumOfGoodsLabel.textProperty().bind(new SimpleDoubleProperty(sum).asString());
				/* newReceiptList.clear(); */
				data = FXCollections.observableArrayList(receiptList);
				movementTableView.setItems(data);
				quantityTextField.clear();
			} else {
				System.out.println("Error");
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("You can not put the quantity more than there is in the database.");
				alert.showAndWait();
			}
		}
	}

	@FXML
	private void deleteRecordFromMovementTable(ActionEvent event) {
		for (Receipt rec : receiptList) {
			System.out.println(rec);
		}
		List<Receipt> newReceiptList = new ArrayList<>();
		Receipt receipt = movementTableView.getSelectionModel().getSelectedItem();
		if (receipt == null) {
			System.out.println("Nothing selected!");
		} else {

			for (Receipt rec : receiptList) {
				if (receipt.equals(rec)) {
					System.out.println("Woo hoo");
				} else {
					newReceiptList.add(rec);
				}
				data = FXCollections.observableArrayList(newReceiptList);
				movementTableView.setItems(data);
			}
		}
		receiptList.clear();
		double sum = 0;
		for (Receipt rec : newReceiptList) {
			sum += rec.getAmount();
			receiptList.add(rec);
		}
		sumOfGoodsLabel.textProperty().bind(new SimpleDoubleProperty(sum).asString());
		data = FXCollections.observableArrayList(receiptList);
		movementTableView.setItems(data);
	}

	@FXML
	private void departureGoodsFromWarehause(ActionEvent event) {
		try {
			String query = "INSERT INTO receipts (idsupplier, add_data, name, quantity, price) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = null;
			preparedStatement = ConnectionToSQL.getConnection().prepareStatement(query);
			for (Receipt rec : receiptList) {
				if (receiptList != null) {
					preparedStatement.setInt(1, rec.getIdsupplier());
					preparedStatement.setString(2, rec.getDate());
					preparedStatement.setString(3, rec.getName());
					preparedStatement.setInt(4, -(rec.getQuantity()));
					preparedStatement.setDouble(5, rec.getPrice());
					/* preparedStatement.setDouble(6, rec.getAmount()); */
					preparedStatement.executeUpdate();
				}
			}
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Goods were departures out of stock.");
			alert.showAndWait();
			preparedStatement.close();
			receiptList.clear();
			movementTableView.setItems(null);
			summ.textProperty().bind(new SimpleDoubleProperty(0.0).asString());
			quantityTextField.clear();

		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	private void setDataToReportBarChart(ActionEvent event) {
		reportBarChart.getData().clear();
		reportsPieChart.getData().clear();
		XYChart.Series series1 = new XYChart.Series();
		XYChart.Series series2 = new XYChart.Series();
		XYChart.Series series3 = new XYChart.Series();
		try {
			ResultSet rs = ConnectionToSQL.getConnection().createStatement()
					.executeQuery("SELECT SUM(amount) AS amount FROM receipts;");
			while (rs.next()) {
				stocks = rs.getDouble("amount");
				series2.setName("Stocks");
				series2.getData().add(new XYChart.Data("", stocks));
				System.out.println(stocks);
			}
			ResultSet rs2 = ConnectionToSQL.getConnection().createStatement().executeQuery(
					"SELECT SUM(amount) AS amount FROM receipts WHERE quantity > '0' AND add_data BETWEEN '"+ reportDatePickerFrom.getValue() + "' AND '" + reportDatePickerTo.getValue() + "';");
			while (rs2.next()) {
				receipts = rs2.getDouble("amount");
				series1.setName("Receipts");
				series1.getData().add(new XYChart.Data("", receipts));
				System.out.println(receipts);
			}
			ResultSet rs3 = ConnectionToSQL.getConnection().createStatement().executeQuery(
					"SELECT SUM(amount) AS amount FROM receipts WHERE quantity < '0' AND add_data BETWEEN '"
							+ reportDatePickerFrom.getValue() + "' AND '" + reportDatePickerTo.getValue() + "';");
			while (rs3.next()) {
				disposals = rs3.getDouble("amount") * (-1);
				series3.setName("Disposals");
				series3.getData().add(new XYChart.Data("", disposals));
				
				System.out.println(disposals);
			}
			reportBarChart.setTitle("Statistics from " + reportDatePickerFrom.getValue() + " to " + reportDatePickerTo.getValue() + ".");
			reportBarChart.getData().addAll(series1, series2, series3);
			reportsPieChart.setData(pieChartList);
			pieChartList.add(new PieChart.Data("Receipts", receipts/(stocks + receipts + disposals) * 100));
			pieChartList.add(new PieChart.Data("Stocks", stocks/(stocks + receipts + disposals) * 100));	
			pieChartList.add(new PieChart.Data("Disposals", disposals/(stocks + receipts + disposals) * 100));
			reportsPieChart.setData(pieChartList);
			receiptsLabel.setText(Double.toString(receipts));
			stocksLabel.setText(Double.toString(stocks));
			disposalsLabel.setText(Double.toString(disposals));
			analysysLabel.setText("Analysis of work from " + reportDatePickerFrom.getValue()+ " \nto " + reportDatePickerTo.getValue() + ".");
			analysysFirstLabel.setText("Receipts: " + receipts + " US Dollars, percentage " + String.format("%.2f", receipts/(stocks + receipts + disposals) * 100) + "%.");
			analysysSecondLabel.setText("Stocks: " + stocks + " US Dollars, percentage " + String.format("%.2f", stocks/(stocks + receipts + disposals) * 100) + "%.");
			analysysThirdLabel.setText("Disposals: " + disposals + " US Dollars, percentage " + String.format("%.2f", disposals/(stocks + receipts + disposals) * 100) + "%.");
			rs.close();
			rs2.close();
			rs3.close();
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}
		
	public void showPersentage(MouseEvent event) {
		reportsStatusLabel.setTextFill(Color.DARKORANGE);
		reportsStatusLabel.setStyle("-fx-font: 24 arial;");
		for (final PieChart.Data data : reportsPieChart.getData()) {
			System.out.println(data);
			data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					String a = String.format("%.2f", data.getPieValue());
					reportsStatusLabel.setText(a + "%");
					reportsStatusLabel.setVisible(true);
					System.out.println(reportsStatusLabel.getText());
				}
			});
		}
	}
	

}
