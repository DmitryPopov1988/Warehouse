package application.controllers;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Receipt implements Cloneable {

	private IntegerProperty idsupplier;
	private StringProperty date;
	private StringProperty name;
	private IntegerProperty quantity;
	private DoubleProperty price;
	private DoubleProperty amount;

	public Receipt(int idsupplier, String date, String name, int quantity, double price, double amount) {
		this.idsupplier = new SimpleIntegerProperty(idsupplier);
		this.date = new SimpleStringProperty(date);
		this.name = new SimpleStringProperty(name);
		this.quantity = new SimpleIntegerProperty(quantity);
		this.price = new SimpleDoubleProperty(price);
		this.amount = new SimpleDoubleProperty(quantity * price);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public Integer getIdsupplier() {
		return idsupplier.get();
	}

	public void setIdsupplier(int idsupplier) {
		this.idsupplier.get();
	}

	public String getDate() {
		return date.get();
	}

	public void setDate(String date) {
		this.date.set(date);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
		;
	}

	public Integer getQuantity() {
		return quantity.get();
	}

	public void setQuantity(int quantity) {
		this.quantity.set(quantity);
	}

	public Double getPrice() {
		return price.get();
	}

	public void setPrice(double price) {
		this.price.set(price);
	}

	public Double getAmount() {
		return amount.get();
	}

	public void setAmount(double amount) {
		this.amount.set(amount);
	}

	public static boolean isValidQuantity(int i) {
		if (i > 0 && i % 1 == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setContentText("Invalid quantity.");
			alert.showAndWait();
			return false;
		}
	}
}
