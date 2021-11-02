package application;


import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private Label labelNutzername;

	@FXML
	private TextField textfieldNutzername;

	@FXML
	private Label labelPasswort;

	@FXML
	private PasswordField textfieldPasswort;


	@FXML
	void initialize() {
		assert labelNutzername != null : "fx:id=\"labelNutzername\" was not injected: check your FXML file 'Login.fxml'.";
		assert textfieldNutzername != null : "fx:id=\"textfieldNutzername\" was not injected: check your FXML file 'Login.fxml'.";
		assert labelPasswort != null : "fx:id=\"labelPasswort\" was not injected: check your FXML file 'Login.fxml'.";
		assert textfieldPasswort != null : "fx:id=\"textfieldPasswort\" was not injected: check your FXML file 'Login.fxml'.";
	}

	public void switchToZeiterfassung(ActionEvent event) throws IOException {

		UserConfig uc = new UserConfig();

		if(uc.login(textfieldNutzername.getText(), textfieldPasswort.getText())) {
			if(uc.getLanguage() == 1)
			{
				Locale.setDefault(Locale.ENGLISH);
			}
			if(uc.getLanguage() == 0)
			{
				Locale.setDefault(Locale.GERMAN);
			}

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("Sample.fxml"));
			loader.setResources(ResourceBundle.getBundle("bundles.language", Array.locale));

			Parent root = loader.load();

			Scene tableViewscene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(tableViewscene);
			window.show();
		}
		else {
			textfieldNutzername.setText("");
			textfieldPasswort.setText("");

			ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", Array.locale);

			JOptionPane.showMessageDialog(null,bundle.getString("joption.login"));

		}

	}

	public void switchToRegistration(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Registrierung.fxml"));
		loader.setResources(ResourceBundle.getBundle("bundles.language", Array.locale));

		Parent root = loader.load();

		Scene tableViewscene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tableViewscene);
		window.show();
	}
}