package application.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class Supplier {

	private StringProperty idsuppliers;
	private StringProperty name;
	private StringProperty country;
	private StringProperty address;
	private StringProperty phone;
	private StringProperty contract;

	public Supplier(String idsuppliers, String name, String country, String address, String phone, String contract) {
		this.idsuppliers = new SimpleStringProperty(idsuppliers);
		this.name = new SimpleStringProperty(name);
		this.country = new SimpleStringProperty(country);
		this.address = new SimpleStringProperty(address);
		this.phone = new SimpleStringProperty(phone);
		this.contract = new SimpleStringProperty(contract);
	}

	public String getIdsuppliers() {
		return idsuppliers.get();
	}
	public void setIdsuppliers(String idsuppliers) {
		this.idsuppliers.set(idsuppliers);
	}
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);;
	}
	public String getCountry() {
		return country.get();
	}
	public void setCountry(String country) {
		this.country.set(country);;
	}
	public String getAddress() {
		return address.get();
	}
	public void setAddress(String address) {
		this.address.set(address);
	}
	public String getPhone() {
		return phone.get();
	}
	public void setPhone(String phone) {
		this.phone.set(phone);
	}
	public String getContract() {
		return contract.get();	
	}
	public void setContract(String contract) {
		this.contract.set(contract);
	}
	
}
	
