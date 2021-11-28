package controller;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.FCarsRentalSystem;
import model.FileProcessing;
import model.rental.customer.Customer;
import model.rental.customer.Resident;
import model.rental.customer.Visitor;

/**
 * Controller class for the update customer window.
 * 
 * @author Ahmed Abdelhamid
 * @version 1.0
 * @since 2020-11-15
 */

public class UpdateCustomerController {

	@FXML
	private TextField customerTf;

	@FXML
	private TextField nameTf;

	@FXML
	private TextField phoneTf;

	@FXML
	private TextField addressTf;

	@FXML
	private TextField nationalityTf;

	@FXML
	private TextField drivingTf;

	@FXML
	private TextField passportTf;

	@FXML
	private DatePicker entryDateTf;

	@FXML
	private DatePicker expiryDateTf;

	@FXML
	private TextField qatarIdTf;

	@FXML
	private Button updateBtn;

	@FXML
	private Button cancelBtn;

	@FXML
	private RadioButton isResident;

	@FXML
	private ToggleGroup custType;

	@FXML
	private RadioButton isVisitor;

	@FXML
	void handleCancel(ActionEvent event) {

		Stage UpdateCustomerStage = (Stage) cancelBtn.getScene().getWindow();
		UpdateCustomerStage.close();
	}

	@FXML
	void handleUpdate(ActionEvent event) {
		boolean flag = false;
		int customerid = Integer.parseInt(customerTf.getText());
		String name = nameTf.getText();
		String phone = phoneTf.getText();
		String address = addressTf.getText();
		String nationality = nationalityTf.getText();
		String drivingLicense = drivingTf.getText();

		if (isResident.isSelected()) {

			if (MainCustomerController.isInteger(qatarIdTf.getText()) == false) {
				Alert message = new Alert(Alert.AlertType.ERROR,
						"Cannot accept non-numerical values for Qatar ID. Please make sure to enter digits.");
				message.getDialogPane().setMinSize(200, 200);
				message.setTitle("Unexpected Error");
				message.show();
				return;
			}
			// Checking if fields are empty or not
			if (nameTf.getText().isBlank() || phoneTf.getText().isBlank() || addressTf.getText().isBlank()
					|| nationalityTf.getText().isBlank() || drivingTf.getText().isBlank()) {
				Alert message = new Alert(Alert.AlertType.ERROR,
						"Incomplete customer details. Please make sure to fill every detail.");
				message.getDialogPane().setMinSize(200, 200);
				message.setTitle("Update Customer");
				message.show();
				return;
			}

			String errorHandler = null;
			int qatarId = Integer.parseInt(qatarIdTf.getText());

			// Validation Check - Making sure the current selection is
			// not applied for validation of duplicate values!
			for (Customer cust : FCarsRentalSystem.getCustomers()) {
				if ((cust.getCustomerId() != customerid)) {
					if (phone.equals(cust.getPhone())) {
						flag = true;
						errorHandler = "Phone ID";
					}
					if (cust instanceof Resident)
						if (qatarId == ((Resident) cust).getQatarId()) {
							flag = true;
							errorHandler = "Qatar ID";
						}
				}
			}

			if (flag == true) {
				Alert message = new Alert(Alert.AlertType.ERROR,
						"Data already exists for: " + errorHandler + ". Please enter unique data.");
				message.getDialogPane().setMinSize(200, 200);
				message.setTitle("Unexpected Error");
				message.show();
				return;
			}

			Customer residentUpdated = new Resident(customerid, name, phone, address, nationality, drivingLicense,
					qatarId);
			FCarsRentalSystem.getCustomers().set(MainCustomerController.selectedTableindex, residentUpdated);
			FileProcessing.writeCustomerDB(FCarsRentalSystem.getCustomers());
			Alert message = new Alert(Alert.AlertType.INFORMATION, "Resident updated succesfully.");
			message.setTitle("Update Customer");
			message.show();

		} else if (isVisitor.isSelected()) {

			if (MainCustomerController.isInteger(passportTf.getText()) == false) {
				Alert message = new Alert(Alert.AlertType.ERROR,
						"Cannot accept a non-numerical value for Passport. Please make sure to enter digits.");
				message.getDialogPane().setMinSize(200, 200);
				message.setTitle("Unexpected Error");
				message.show();
				return;
			}
			// Checking if fields are empty or not
			if (nameTf.getText().isBlank() || phoneTf.getText().isBlank() || addressTf.getText().isBlank()
					|| nationalityTf.getText().isBlank() || drivingTf.getText().isBlank()
					|| entryDateTf.getValue() == null || expiryDateTf.getValue() == null) {
				Alert message = new Alert(Alert.AlertType.ERROR,
						"Incomplete customer details. Please make sure to fill every detail.");
				message.getDialogPane().setMinSize(200, 200);
				message.setTitle("Update Customer");
				message.show();
				return;
			}
			// checks if the expiry date is set before the entry date
			if (expiryDateTf.getValue().compareTo(entryDateTf.getValue()) < 0) {
				Alert message = new Alert(Alert.AlertType.ERROR,
						"Visa expiry date cannot be before entry date. Please try again.");
				message.setTitle("Date Error");
				message.show();
				return;
			}

			String errorHandler = null;
			int passport = Integer.parseInt(passportTf.getText());
			LocalDate entryDate = entryDateTf.getValue();
			LocalDate expiryDate = expiryDateTf.getValue();

			// Checks if the data entered already exists in the system.
			for (Customer cust : FCarsRentalSystem.getCustomers()) {
				if ((cust.getCustomerId() != customerid)) {
					if (phone.equals(cust.getPhone())) {
						flag = true;
						errorHandler = "Phone ID";
					}
					if (cust instanceof Visitor)
						if (passport == ((Visitor) cust).getPassportNo()) {
							flag = true;
							errorHandler = "Passport ID";
						}
				}
			}

			if (flag == true) {
				Alert message = new Alert(Alert.AlertType.ERROR,
						"Data already exists for: " + errorHandler + ". Please enter unique data.");
				message.getDialogPane().setMinSize(200, 200);
				message.setTitle("Unexpected Error");
				message.show();
				return;
			}

			Customer visitorUpdated = new Visitor(customerid, name, phone, address, nationality, drivingLicense,
					passport, entryDate, expiryDate);
			FCarsRentalSystem.getCustomers().set(MainCustomerController.selectedTableindex, visitorUpdated);
			FileProcessing.writeCustomerDB(FCarsRentalSystem.getCustomers());
			Alert message = new Alert(Alert.AlertType.INFORMATION, "Visitor updated succesfully.");
			message.setTitle("Update Customer");
			message.show();
		}

		Stage updateCustomerStage = (Stage) updateBtn.getScene().getWindow();
		updateCustomerStage.close();
	}

	public void initialize(int customerId, String name, String phone, String address, String nationality,
			String drivingLicence, int passportNo, LocalDate entryDate, LocalDate visaExpiryDate) {

		isVisitor.selectedProperty().set(true);
		String custId = Integer.toString(customerId);
		String passportId = Integer.toString(passportNo);
		customerTf.setText(custId);
		nameTf.setText(name);
		phoneTf.setText(phone);
		addressTf.setText(address);
		nationalityTf.setText(nationality);
		drivingTf.setText(drivingLicence);
		passportTf.setText(passportId);
		entryDateTf.setValue(entryDate);
		expiryDateTf.setValue(visaExpiryDate);

		customerTf.editableProperty().set(false);
		customerTf.disableProperty().bind(isVisitor.selectedProperty());
		qatarIdTf.disableProperty().bind(isVisitor.selectedProperty());
		passportTf.disableProperty().bind(isResident.selectedProperty());
		entryDateTf.disableProperty().bind(isResident.selectedProperty());
		expiryDateTf.disableProperty().bind(isResident.selectedProperty());

	}

	public void initialize(int customerId, String name, String phone, String address, String nationality,
			String drivingLicence, int qatarId) {

		isResident.selectedProperty().set(true);
		String custId = Integer.toString(customerId);
		String qtrId = Integer.toString(qatarId);
		customerTf.setText(custId);
		nameTf.setText(name);
		phoneTf.setText(phone);
		addressTf.setText(address);
		nationalityTf.setText(nationality);
		drivingTf.setText(drivingLicence);
		qatarIdTf.setText(qtrId);

		customerTf.editableProperty().set(false);
		customerTf.disableProperty().bind(isResident.selectedProperty());
		passportTf.disableProperty().bind(isResident.selectedProperty());
		entryDateTf.disableProperty().bind(isResident.selectedProperty());
		expiryDateTf.disableProperty().bind(isResident.selectedProperty());
		qatarIdTf.disableProperty().bind(isVisitor.selectedProperty());

	}
}
