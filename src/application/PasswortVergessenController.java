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
import javafx.stage.Stage;

public class PasswortVergessenController {

	@FXML
	private Button buttonDatenUeberpruefen;

	@FXML
	private Button buttonZurueckZuLogin;

    @FXML
    private DatePicker datepickerGeburtstagseingabe;

    @FXML
    private Label labeleburtstagseingabe;


    @FXML
	void initialize()
	{
    	datepickerGeburtstagseingabe.setEditable(false);
	}

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

		UserConfig uc = new UserConfig();

		if(datepickerGeburtstagseingabe.getValue() != null) {

			LocalDate localDate = datepickerGeburtstagseingabe.getValue();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			String birthdate = localDate.format(formatter);

			if(birthdate.equals(uc.getBirthday())) {
				JOptionPane.showMessageDialog(null, "Das Passwort Ihres Benutzers lautet \""+uc.getPassword()+"\".");
			}
			else {
				JOptionPane.showMessageDialog(null, "Der angegebene Geburtstag stimmt nicht mit dem gespeicherten überein.");
			}

		}
	}

}
