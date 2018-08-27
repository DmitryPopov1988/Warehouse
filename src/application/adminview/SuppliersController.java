package application.adminview;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.controllers.ConnectionToSQL;
import application.controllers.EmailSender;
import application.controllers.Supplier;
import application.controllers.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class SuppliersController implements Initializable {
	
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
	ObservableList data;
	FilteredList<Users> filteredData;
	

    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
