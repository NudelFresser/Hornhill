package application;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class RegistrierungController
{
	@FXML
	private Label labelRegistrierungNutzername;

	@FXML
	private Label labelRegistrierungPasswort;

	@FXML
	private Label labelRegistrierungPasswortwiederholen;

	@FXML
	private Label labelRegistrierungGeburtsdatum;

	@FXML
	private Label labelRegistrierungSprache;

	@FXML
	private Label labelRegistrierungWochenarbeitszeit;

	@FXML
	private TextField textfieldRegistrierungNutzername;

	@FXML
	private PasswordField passwortfeldRegistrierungPasswort;

	@FXML
	private PasswordField passwortfeldRegistrierungPasswortwiederholen;

	@FXML
	private DatePicker datepickerRegistrierungGeburtsdatum;

	@FXML
	private RadioButton radiobuttonRegistrierungDeutsch;

	@FXML
	private RadioButton radiobuttonRegistrierungEnglisch;

	@FXML
	private ChoiceBox<String> comboboxRegistrierungWochenarbeitszeit;

    @FXML
	void initialize()
	{
		assert labelRegistrierungNutzername != null : "fx:id=\"labelRegistrierungNutzername\" was not injected: check your FXML file 'Registrierung.fxml'.";
		assert labelRegistrierungPasswort != null : "fx:id=\"labelRegistrierungPasswort\" was not injected: check your FXML file 'Registrierung.fxml'.";
		assert labelRegistrierungPasswortwiederholen != null : "fx:id=\"labelRegistrierungPasswortwiederholen\" was not injected: check your FXML file 'Registrierung.fxml'.";
		assert labelRegistrierungGeburtsdatum != null : "fx:id=\"labelRegistrierungGeburtsdatum\" was not injected: check your FXML file 'Registrierung.fxml'.";
		assert labelRegistrierungSprache != null : "fx:id=\"labelRegistrierungSprache\" was not injected: check your FXML file 'Registrierung.fxml'.";
		assert labelRegistrierungWochenarbeitszeit != null : "fx:id=\"labelRegistrierungWochenarbeitszeit\" was not injected: check your FXML file 'Registrierung.fxml'.";
		assert textfieldRegistrierungNutzername != null : "fx:id=\"textfieldRegistrierungNutzername\" was not injected: check your FXML file 'Registrierung.fxml'.";
		assert passwortfeldRegistrierungPasswort != null : "fx:id=\"passwortfeldRegistrierungPasswort\" was not injected: check your FXML file 'Registrierung.fxml'.";
		assert passwortfeldRegistrierungPasswortwiederholen != null : "fx:id=\"passwortfeldRegistrierungPasswortwiederholen\" was not injected: check your FXML file 'Registrierung.fxml'.";
		assert datepickerRegistrierungGeburtsdatum != null : "fx:id=\"datepickerRegistrierungGeburtsdatum\" was not injected: check your FXML file 'Registrierung.fxml'.";
		assert radiobuttonRegistrierungDeutsch != null : "fx:id=\"radiobuttonRegistrierungDeutsch\" was not injected: check your FXML file 'Registrierung.fxml'.";
		assert radiobuttonRegistrierungEnglisch != null : "fx:id=\"radiobuttonRegistrierungEnglisch\" was not injected: check your FXML file 'Registrierung.fxml'.";
		assert comboboxRegistrierungWochenarbeitszeit != null : "fx:id=\"comboboxRegistrierungWochenarbeitszeit\" was not injected: check your FXML file 'Registrierung.fxml'.";

		comboboxRegistrierungWochenarbeitszeit.getItems().addAll(Array.stunden);
		datepickerRegistrierungGeburtsdatum.setEditable(false);
		//Locale.setDefault(Locale.GERMAN);
	}

    public void alterBerechnen() throws ParseException {
		methoden m1 = new methoden();

		try {

			int alter = m1.unter18check(datepickerRegistrierungGeburtsdatum.getValue());

			if (alter == 1) {
				comboboxRegistrierungWochenarbeitszeit.getItems().removeAll(Array.stunden);
				comboboxRegistrierungWochenarbeitszeit.getItems().addAll(Array.unter18);
			} else if (alter == 2) {
				comboboxRegistrierungWochenarbeitszeit.getItems().removeAll(Array.stunden);
				comboboxRegistrierungWochenarbeitszeit.getItems().addAll(Array.stunden);
			} else {
				comboboxRegistrierungWochenarbeitszeit.getItems().removeAll(Array.stunden);
			}
		}
		catch (ParseException  | IllegalArgumentException e) {
			// TODO Auto-generated catch block
			comboboxRegistrierungWochenarbeitszeit.getItems().removeAll(Array.stunden);
			e.printStackTrace();
		}


	}
   //Methode um nach einer erfolgreichen Registration wieder zurück zum Loginfenster zu wechseln
    public void switchToLogin(ActionEvent event) throws IOException
	{
    	UserConfig uc = new UserConfig();

    	if (datepickerRegistrierungGeburtsdatum.getValue() != null
    					&& !textfieldRegistrierungNutzername.getText().equals("")
    					&& !passwortfeldRegistrierungPasswort.getText().equals("")
    					&& !passwortfeldRegistrierungPasswort.getText()
    						.equals(passwortfeldRegistrierungPasswortwiederholen.getText())
    					&& comboboxRegistrierungWochenarbeitszeit.getSelectionModel().getSelectedItem() != null)
    				{

    					ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", Array.locale);
    					JOptionPane.showMessageDialog(null, bundle.getString("joption.passpass"));
    				}
    	else if(textfieldRegistrierungNutzername.getText().equals(uc.getUsername())) {
    		ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", Array.locale);
    		JOptionPane.showMessageDialog(null, bundle.getString("joption.register"));
    	}
    	else if (datepickerRegistrierungGeburtsdatum.getValue() != null
			&& !textfieldRegistrierungNutzername.getText().equals("")
			&& !passwortfeldRegistrierungPasswort.getText().equals("")
			&& passwortfeldRegistrierungPasswort.getText()
				.equals(passwortfeldRegistrierungPasswortwiederholen.getText())
			&& comboboxRegistrierungWochenarbeitszeit.getSelectionModel().getSelectedItem() != null)
		{


			char language = 'd';
			String s = comboboxRegistrierungWochenarbeitszeit.getSelectionModel().getSelectedItem().toString();

			LocalDate localDate = datepickerRegistrierungGeburtsdatum.getValue();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			String birthdate = localDate.format(formatter);

			if (radiobuttonRegistrierungDeutsch.isSelected())
			{
				language = 'd';
			}
			if (radiobuttonRegistrierungEnglisch.isSelected())
			{
				language = 'e';
			}
			ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", Array.locale);
			int reply = JOptionPane.showConfirmDialog(null, bundle.getString("joption.options"), null, JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {

				if (uc.registerUser(textfieldRegistrierungNutzername.getText(), passwortfeldRegistrierungPasswort.getText(),
					birthdate, language, s))
				{
					if (language == 'd')
					{
						Array.locale = new Locale("de");
					}
					if (language == 'e')
					{
						Array.locale = new Locale("en");
					}

					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("Login.fxml"));
					loader.setResources(ResourceBundle.getBundle("bundles.language", Array.locale));

					Parent root = loader.load();

					Scene tableViewscene = new Scene(root);
					Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
					window.setScene(tableViewscene);
					window.show();
				}
			}
		}
		else {
			ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", Array.locale);

			JOptionPane.showMessageDialog(null,bundle.getString("joption.fill"));
		}
	}

   //Methode um wieder zurück zum Loginfenster zu wechseln
	public void switchBack(ActionEvent event) throws IOException
	{

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

}