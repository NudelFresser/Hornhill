package application;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PasswortVergessenController {

    @FXML
    private Button buttonDatenUeberpruefen;

    @FXML
    private Button buttonZurueckZuLogin;

    @FXML
    private DatePicker datepickerGeburtstagseingabe;

    @FXML
    private Label labelGeburtstagseingabe;

    @FXML
    private Label labelNutzername;

    @FXML
    private TextField textfieldNutzername;


    @FXML
	void initialize()
	{
    	datepickerGeburtstagseingabe.setEditable(false);
	}

    //Methode um wieder zurück zum Loginfenster zu wechseln
	public void switchBack(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Login.fxml"));
		loader.setResources(ResourceBundle.getBundle("bundles.language", Array.locale));

		Parent root = loader.load();
		Scene tableViewscene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		tableViewscene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		window.setScene(tableViewscene);
		window.show();
	}

	public void checkPassword(ActionEvent event) throws IOException {
		ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", Array.locale);
		UserConfig uc = new UserConfig();

		if(datepickerGeburtstagseingabe.getValue() != null) {

			LocalDate localDate = datepickerGeburtstagseingabe.getValue();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			String birthdate = localDate.format(formatter);

			if(birthdate.equals(uc.getBirthday())) {
				
				JOptionPane.showMessageDialog(null, bundle.getString("joption.getPassword") +"\""+ uc.getPassword()+"\".");
				
			}
			else {
				JOptionPane.showMessageDialog(null, bundle.getString("joption.wrongEntry"));
				
			}

		}
	}

}
