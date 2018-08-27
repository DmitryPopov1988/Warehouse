package application.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class Users {

	private static PreparedStatement preparedStatment;
	
	private final StringProperty id;
	private final StringProperty fn;
	private final StringProperty ln;
	private final StringProperty lo;
	private final StringProperty pa;
	private final StringProperty em;
	private final StringProperty ro;

	public Users(String id, String fn, String ln, String lo, String pa, String em, String ro) {
		this.id = new SimpleStringProperty(id);
		this.fn = new SimpleStringProperty(fn);
		this.ln = new SimpleStringProperty(ln);
		this.lo = new SimpleStringProperty(lo);
		this.pa = new SimpleStringProperty(pa);
		this.em = new SimpleStringProperty(em);
		this.ro = new SimpleStringProperty(ro);
	}
	
	public String getId() {
		return id.get();
	}


	public void setId(String id) {
		this.id.set(id);
	}

	public String getFn() {
		return fn.get();
	}

	public void setFn(String fn) {
		this.fn.set(fn);
	}

	public String getLn() {
		return ln.get();
	}

	public void setLn(String ln) {
		this.ln.set(ln);
	}

	public String getLo() {
		return lo.get();
	}

	public void setLo(String lo) {
		this.lo.set(lo);
	}

	public String getPa() {
		return pa.get();
	}

	public void setPa(String pa) {
		this.pa.set(pa);
	}

	public String getEm() {
		return em.get();
	}

	public void setEm(String em) {
		this.em.set(em);
	}

	public String getRo() {
		return ro.get();
	}

	public void setRo(String ro) {
		this.ro.set(ro);
	}


	public static String getPassword(String email) {
		Connection connection = null;
		ResultSet resultSet = null;
		String password = "Password not found.";
		connection = ConnectionToSQL.getConnection();
		String query = "SELECT * FROM users WHERE Email = ?";
		try {
			preparedStatment = connection.prepareStatement(query);
			preparedStatment.setString(1, email);
			resultSet = preparedStatment.executeQuery();
			while (resultSet.next()) {
				password = resultSet.getString("Password");
				System.out.println(password);
				return password;
			}
			resultSet.close();
			preparedStatment.close();
			connection.close();
		} catch (SQLException exc) {
			exc.printStackTrace();
		} 
		return password;
	}
}
