package application;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

//import com.sun.javafx.scene.control.skin.TableViewSkin;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SampleController {

	private Locale locale;

	public static LocalDate myDate;
	@FXML
	private Label labelZeiterfassungTag;

	@FXML
	private Label labelZeiterfassungArbeitsbeginn;

	@FXML
	private Label labelZeiterfassungGesetzlichesmaximum;

	@FXML
	private Label labelZeiterfassungArbeitsende;

	@FXML
	private CheckBox checkboxZeiterfassungZusatzpause;

	@FXML
	private Label labelZeiterfassungZusatzpause;

	@FXML
	private TextField textfieldZeiterfassungArbeitsbeginn;

	@FXML
	private TextField textfieldZeiterfassungGesetzlichesmaximum;

	@FXML
	private TextField textfieldZeiterfassungArbeitsende;

	@FXML
	private TextField textfieldZeiterfassungZusatzpause;

	@FXML
	private DatePicker birthdayDatePicker;

	@FXML
	private Button buttonZeiterfassungDatenÜbernehmen;

	@FXML
	private Label labelEinstellungenAltesPasswort;

	@FXML
	private Label labelEinstellungenSprache;

	@FXML
	private Label labelEinstellungenWochenarbeitszeit;

	@FXML
	private Label labelEinstellungenErsteWarnstufe;

	@FXML
	private Label labelEinstellungenZweiteWarnstufe;

	@FXML
	private PasswordField passwortfiedEinstellungenAltesPasswort;

	@FXML
	private RadioButton radioButtonEinstellungDeutsch;

	@FXML
	private ToggleGroup Sprache;

	@FXML
	private RadioButton radioButtonEinstellungenEnglisch;

	@FXML
	private TextField textfieldEinstellungenErsteWarnstufe;

	@FXML
	private TextField textfieldEinstellungenZweiteWarnstufe;

	@FXML
	private Button buttonEinstellungenEinstellungenÜbernehmen;

	@FXML
	private Label labelEinstellungenNeuesPasswort1;

	@FXML
	private Label labelKalenderMonat;

	@FXML
	private Label labelKalenderAmpelansicht;

	@FXML
	private Label labelKalenderQuartal;

	@FXML
	private Label labelKalenderJahr;

	@FXML
	private TextField textfieldKalenderQuartalsStunden;

	@FXML
	private TextField textfieldKalenderJahresStunden;

	@FXML
	private TextField textfieldKalenderMonatsStunden;

	@FXML
	private Circle circleAmpelansichtColorGreen;

	@FXML
	private Circle circleAmpelansichtColorYellow;

	@FXML
	private Circle circleAmpelansichtColorRed;

	@FXML
	private PasswordField passwortfiedEinstellungenNeuesPasswort1;

	@FXML
	private PasswordField passwortfiedEinstellungenNeuesPasswort2;

	@FXML
	private Label labelEinstellungenNeuesPasswort2;

	@FXML
	private ChoiceBox<String> choiceBoxEinstellungenWochenarbeitszeit;

	@FXML
	private ComboBox<String> comboBoxBeginnStunden;

	@FXML
	private ComboBox<String> comboBoxBeginnMinuten;

	@FXML
	private ComboBox<String> comboBoxEndeStunden;

	@FXML
	private ComboBox<String> comboBoxEndeMinuten;

	@FXML
	private Label labelWochenarbeitszeit;

	@FXML
	private TableView<person> tableViewKalenderKalenderansicht;

	@FXML
	private TableColumn<person, SimpleStringProperty> tablecolumnKalenderArbeitsbeginn;

	@FXML
	private TableColumn<person, SimpleStringProperty> tablecolumnKalenderArbeitsende;

	@FXML
	private TableColumn<person, SimpleStringProperty> tablecolumnKalenderZusatzpause;

	@FXML
	private TableColumn<person, SimpleStringProperty> tablecolumnKalenderGleitzeit;

	@FXML
	private TableColumn<person, LocalDate> birthdayColumn;

	@FXML
	private CheckBox checkboxZeiterfassungAbwesenheit;

	@FXML
	private DatePicker vacationDatePicker;

	@FXML
	private ComboBox<String> comboBoxAbwesenheit;

	@FXML
	private ComboBox<String> comboBoxKalenderMonatsauswahl;

	@FXML
	private ComboBox<String> comboBoxKalenderQuartalsauswahl;

	@FXML
	private ComboBox<String> comboBoxKalenderJahresauswahl;

	@FXML
	private Button buttonKalenderSwitchToTimeViolation;

	@FXML
	private TabPane tabPaneAnsicht;

	@FXML
	void initialize() {
		assert labelZeiterfassungTag != null : "fx:id=\"labelZeiterfassungTag\" was not injected: check your FXML file 'Sample.fxml'.";
		assert labelZeiterfassungArbeitsbeginn != null : "fx:id=\"labelZeiterfassungArbeitsbeginn\" was not injected: check your FXML file 'Sample.fxml'.";
		assert labelZeiterfassungGesetzlichesmaximum != null : "fx:id=\"labelZeiterfassungGesetzlichesmaximum\" was not injected: check your FXML file 'Sample.fxml'.";
		assert labelZeiterfassungArbeitsende != null : "fx:id=\"labelZeiterfassungArbeitsende\" was not injected: check your FXML file 'Sample.fxml'.";
		assert checkboxZeiterfassungZusatzpause != null : "fx:id=\"checkboxZeiterfassungZusatzpause\" was not injected: check your FXML file 'Sample.fxml'.";
		assert labelZeiterfassungZusatzpause != null : "fx:id=\"labelZeiterfassungZusatzpause\" was not injected: check your FXML file 'Sample.fxml'.";
		assert textfieldZeiterfassungArbeitsbeginn != null : "fx:id=\"textfieldZeiterfassungArbeitsbeginn\" was not injected: check your FXML file 'Sample.fxml'.";
		assert textfieldZeiterfassungGesetzlichesmaximum != null : "fx:id=\"textfieldZeiterfassungGesetzlichesmaximum\" was not injected: check your FXML file 'Sample.fxml'.";
		assert textfieldZeiterfassungArbeitsende != null : "fx:id=\"textfieldZeiterfassungArbeitsende\" was not injected: check your FXML file 'Sample.fxml'.";
		assert textfieldZeiterfassungZusatzpause != null : "fx:id=\"textfieldZeiterfassungZusatzpause\" was not injected: check your FXML file 'Sample.fxml'.";
		assert birthdayDatePicker != null : "fx:id=\"datepickerZeiterfassungTag\" was not injected: check your FXML file 'Sample.fxml'.";
		assert buttonZeiterfassungDatenÜbernehmen != null : "fx:id=\"buttonZeiterfassungDatenÜbernehmen\" was not injected: check your FXML file 'Sample.fxml'.";
		assert labelEinstellungenAltesPasswort != null : "fx:id=\"labelEinstellungenAltesPasswort\" was not injected: check your FXML file 'Sample.fxml'.";
		assert labelEinstellungenSprache != null : "fx:id=\"labelEinstellungenSprache\" was not injected: check your FXML file 'Sample.fxml'.";
		assert labelEinstellungenWochenarbeitszeit != null : "fx:id=\"labelEinstellungenWochenarbeitszeit\" was not injected: check your FXML file 'Sample.fxml'.";
		assert labelEinstellungenErsteWarnstufe != null : "fx:id=\"labelEinstellungenErsteWarnstufe\" was not injected: check your FXML file 'Sample.fxml'.";
		assert labelEinstellungenZweiteWarnstufe != null : "fx:id=\"labelEinstellungenZweiteWarnstufe\" was not injected: check your FXML file 'Sample.fxml'.";
		assert passwortfiedEinstellungenAltesPasswort != null : "fx:id=\"passwortfiedEinstellungenAltesPasswort\" was not injected: check your FXML file 'Sample.fxml'.";
		assert radioButtonEinstellungDeutsch != null : "fx:id=\"radioButtonEinstellungDeutsch\" was not injected: check your FXML file 'Sample.fxml'.";
		assert Sprache != null : "fx:id=\"Sprache\" was not injected: check your FXML file 'Sample.fxml'.";
		assert radioButtonEinstellungenEnglisch != null : "fx:id=\"radioButtonEinstellungenEnglisch\" was not injected: check your FXML file 'Sample.fxml'.";
		assert choiceBoxEinstellungenWochenarbeitszeit != null : "fx:id=\"comboboxEinstellungenWochenarbeitszeit\" was not injected: check your FXML file 'Sample.fxml'.";
		assert textfieldEinstellungenErsteWarnstufe != null : "fx:id=\"textfieldEinstellungenErsteWarnstufe\" was not injected: check your FXML file 'Sample.fxml'.";
		assert textfieldEinstellungenZweiteWarnstufe != null : "fx:id=\"textfieldEinstellungenZweiteWarnstufe\" was not injected: check your FXML file 'Sample.fxml'.";
		assert buttonEinstellungenEinstellungenÜbernehmen != null : "fx:id=\"buttonEinstellungenEinstellungenÜbernehmen\" was not injected: check your FXML file 'Sample.fxml'.";
		assert labelEinstellungenNeuesPasswort1 != null : "fx:id=\"labelEinstellungenNeuesPasswort1\" was not injected: check your FXML file 'Sample.fxml'.";
		assert passwortfiedEinstellungenNeuesPasswort1 != null : "fx:id=\"passwortfiedEinstellungenNeuesPasswort1\" was not injected: check your FXML file 'Sample.fxml'.";
		assert labelEinstellungenNeuesPasswort2 != null : "fx:id=\"labelEinstellungenNeuesPasswort2\" was not injected: check your FXML file 'Sample.fxml'.";
		assert passwortfiedEinstellungenNeuesPasswort2 != null : "fx:id=\"passwortfiedEinstellungenNeuesPasswort2\" was not injected: check your FXML file 'Sample.fxml'.";

		// Hinterlegen der Wochenarbeitszeitstunden bei Minderjährigen und Volljährigen
		methoden md = new methoden();

		try {
			if (md.unter18check() == 1) {
				choiceBoxEinstellungenWochenarbeitszeit.getItems().removeAll(Array.stunden);
				choiceBoxEinstellungenWochenarbeitszeit.getItems().addAll(Array.unter18);
			} else {
				choiceBoxEinstellungenWochenarbeitszeit.getItems().removeAll(Array.unter18);
				choiceBoxEinstellungenWochenarbeitszeit.getItems().addAll(Array.stunden);
			}
		} catch (ParseException | IllegalArgumentException e) {
			// TODO Auto-generated catch block
			choiceBoxEinstellungenWochenarbeitszeit.getItems().removeAll(Array.stunden);
			e.printStackTrace();
		}

		comboBoxKalenderMonatsauswahl.getItems().addAll(Array.monate);
		comboBoxKalenderQuartalsauswahl.getItems().addAll(Array.quartale);
		comboBoxKalenderJahresauswahl.getItems().addAll(Array.jahre);

		comboBoxBeginnStunden.getItems().addAll(Array.ganzeStunden);
		comboBoxBeginnStunden.setVisibleRowCount(10);
		comboBoxBeginnStunden.getSelectionModel().select("06");
		comboBoxBeginnMinuten.getItems().addAll(Array.ganzeMinuten);
		comboBoxBeginnMinuten.setVisibleRowCount(15);
		comboBoxBeginnMinuten.getSelectionModel().selectFirst();
		comboBoxEndeStunden.getItems().addAll(Array.ganzeStunden);
		comboBoxEndeStunden.setVisibleRowCount(10);
		comboBoxEndeStunden.getSelectionModel().select("22");
		comboBoxEndeMinuten.getItems().addAll(Array.ganzeMinuten);
		comboBoxEndeMinuten.setVisibleRowCount(15);
		comboBoxEndeMinuten.getSelectionModel().selectFirst();
		textfieldZeiterfassungZusatzpause.setText("0");

		birthdayColumn.setCellValueFactory(new PropertyValueFactory<person, LocalDate>("birthday"));
		tablecolumnKalenderArbeitsbeginn
				.setCellValueFactory(new PropertyValueFactory<person, SimpleStringProperty>("Arbeitsbeginn"));
		tablecolumnKalenderArbeitsende
				.setCellValueFactory(new PropertyValueFactory<person, SimpleStringProperty>("Arbeitsende"));
		tablecolumnKalenderZusatzpause
				.setCellValueFactory(new PropertyValueFactory<person, SimpleStringProperty>("Pause"));
		tablecolumnKalenderGleitzeit
				.setCellValueFactory(new PropertyValueFactory<person, SimpleStringProperty>("Overtime"));

		birthdayDatePicker.setEditable(false);

		UserConfig uc = new UserConfig();
		List<person> zeiten = uc.getTimes();

		for (person p : zeiten) {

			tableViewKalenderKalenderansicht.getItems().add(p);

		}
		tableViewRowColor();

		tableViewKalenderKalenderansicht.setEditable(false);
		try {
			schreibeGleitzeitJahr(null);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	//Methode um die Tableview bzw. einzelne Zeilen farbig hervorzuheben
	public void tableViewRowColor() {
		tableViewKalenderKalenderansicht.setRowFactory(tv -> new TableRow<person>() {
			@Override
			protected void updateItem(person item, boolean empty) {
				super.updateItem(item, empty);

				if (item != null && item.getPause().equals("25")) {
					setStyle("-fx-background-color:green;");
				}
			}
		});
	}

	public void newPersonButtonPushed(ActionEvent event) throws IOException, ParseException {
		UserConfig uc = new UserConfig();
		// Code von newZeitenBerechnung, da leider nicht weiß wie ich die Methode hier
		// aufrufen soll
		methoden m1 = new methoden();
		String s1 = comboBoxBeginnStunden.getSelectionModel().getSelectedItem();
		String s2 = comboBoxBeginnMinuten.getSelectionModel().getSelectedItem();
		String s3 = comboBoxEndeStunden.getSelectionModel().getSelectedItem();
		String s4 = comboBoxEndeMinuten.getSelectionModel().getSelectedItem();
		String s5 = textfieldZeiterfassungZusatzpause.getText();
		if (s1 != null && s2 != null && s3 != null && s4 != null) {
			m1.setStartStunde(s1);
			m1.setStartMinute(s2);
			m1.setEndeStunde(s3);
			m1.setEndeMinute(s4);
			m1.setPauseExtra(s5);
			m1.MaxStundenErlaubt();
			m1.AuswahlWochenStundenMaxErlaubt();
			String result = m1.MaxStundenErlaubt();
			textfieldZeiterfassungGesetzlichesmaximum.setText(result);
			// System.out.println(m1.berechneArbeitszeitMitPause());

		}

		if (checkboxZeiterfassungAbwesenheit.isSelected() && !comboBoxAbwesenheit.getSelectionModel().isEmpty()
				&& vacationDatePicker.getValue() != null) {
			if (uc.saveTime(vacationDatePicker.getValue(), comboBoxAbwesenheit.getSelectionModel().getSelectedItem(),
					"", "", "")) {
				if (uc.getLanguage() == 1) {
					locale = new Locale("en");
					Locale.setDefault(Locale.ENGLISH);
				}
				if (uc.getLanguage() == 0) {
					locale = new Locale("de");
					Locale.setDefault(Locale.GERMAN);
				}

				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("Sample.fxml"));
				loader.setResources(ResourceBundle.getBundle("bundles.language", locale));

				Parent root = loader.load();

				Scene tableViewscene = new Scene(root);
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(tableViewscene);
				window.show();

				ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", locale);

				JOptionPane.showMessageDialog(null, bundle.getString("joption.success"));

			}
		}

		else if (birthdayDatePicker.getValue() != null && !comboBoxBeginnStunden.getSelectionModel().isEmpty()
				&& !comboBoxBeginnMinuten.getSelectionModel().isEmpty()
				&& !comboBoxEndeStunden.getSelectionModel().isEmpty()
				&& !comboBoxEndeMinuten.getSelectionModel().isEmpty()) {

			String pause = m1.getPausenDauer();
			String zusatzpause = "0";
			String arbeitsbeginn = "";
			String arbeitsende = "";

			String beginnStunden = comboBoxBeginnStunden.getValue();
			String beginnMinuten = comboBoxBeginnMinuten.getValue();
			arbeitsbeginn = beginnStunden + ":" + beginnMinuten;

			String endeStunden = comboBoxEndeStunden.getValue();
			String endeMinuten = comboBoxEndeMinuten.getValue();
			arbeitsende = endeStunden + ":" + endeMinuten;

			LocalDate date = birthdayDatePicker.getValue();

			boolean pausenummer = true;
			if (!textfieldZeiterfassungZusatzpause.getText().trim().isEmpty()) {
				for (int i = 0; i < textfieldZeiterfassungZusatzpause.getLength(); i++) {
					char c = textfieldZeiterfassungZusatzpause.getText().charAt(i);
					if (!Character.isDigit(c)) {
						pausenummer = false;
						break;
					}
				}
				if (pausenummer) {
					zusatzpause = textfieldZeiterfassungZusatzpause.getText();
				}
			}
			if (pausenummer) {
				if (uc.saveTime(date, arbeitsbeginn, arbeitsende, pause, zusatzpause)) {

					String overtime = gleitzeitTag(date) / 60 + ":" + gleitzeitTag(date) % 60;
					uc.writeOvertime(date, overtime);

					if (uc.getLanguage() == 1) {
						locale = new Locale("en");
						Locale.setDefault(Locale.ENGLISH);
					}
					if (uc.getLanguage() == 0) {
						locale = new Locale("de");
						Locale.setDefault(Locale.GERMAN);
					}

					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("Sample.fxml"));
					loader.setResources(ResourceBundle.getBundle("bundles.language", locale));

					Parent root = loader.load();

					Scene tableViewscene = new Scene(root);
					Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
					window.setScene(tableViewscene);
					window.show();

					ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", locale);
					JOptionPane.showMessageDialog(null, bundle.getString("joption.success"));

				}
			} else {
				if (uc.getLanguage() == 1) {
					locale = new Locale("en");
					Locale.setDefault(Locale.ENGLISH);
				}
				if (uc.getLanguage() == 0) {
					locale = new Locale("de");
					Locale.setDefault(Locale.GERMAN);
				}

				ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", locale);
				JOptionPane.showMessageDialog(null, bundle.getString("joption.zusatzpause"));

			}
		}
	}

	public void newSettingButtonPushed(ActionEvent event) throws IOException {
		UserConfig uc = new UserConfig();
		boolean settingsChanged = false;

		if (!passwortfiedEinstellungenAltesPasswort.getText().equals("")
				&& !passwortfiedEinstellungenNeuesPasswort1.getText().equals("")
				&& !passwortfiedEinstellungenNeuesPasswort2.getText().equals("")

				&& passwortfiedEinstellungenNeuesPasswort1.getText()
						.equals(passwortfiedEinstellungenNeuesPasswort2.getText())

				&& !passwortfiedEinstellungenAltesPasswort.getText()
						.equals(passwortfiedEinstellungenNeuesPasswort1.getText())) {

			if (uc.newPassword(passwortfiedEinstellungenAltesPasswort.getText(),
					passwortfiedEinstellungenNeuesPasswort1.getText())) {
				passwortfiedEinstellungenAltesPasswort.setText("");
				passwortfiedEinstellungenNeuesPasswort1.setText("");
				passwortfiedEinstellungenNeuesPasswort2.setText("");
				settingsChanged = true;
			} else {
				if (uc.getLanguage() == 1) {
					locale = new Locale("en");
					Locale.setDefault(Locale.ENGLISH);
				}
				if (uc.getLanguage() == 0) {
					locale = new Locale("de");
					Locale.setDefault(Locale.GERMAN);
				}
				ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", locale);

				JOptionPane.showMessageDialog(null, bundle.getString("joption.oldpass"));
			}

		} else if (!passwortfiedEinstellungenAltesPasswort.getText().equals("")
				&& !passwortfiedEinstellungenNeuesPasswort1.getText()
						.equals(passwortfiedEinstellungenNeuesPasswort2.getText())) {
			if (uc.getLanguage() == 1) {
				locale = new Locale("en");
				Locale.setDefault(Locale.ENGLISH);
			}
			if (uc.getLanguage() == 0) {
				locale = new Locale("de");
				Locale.setDefault(Locale.GERMAN);
			}
			ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", locale);

			JOptionPane.showMessageDialog(null, bundle.getString("joption.newpass"));
		} else if (!passwortfiedEinstellungenAltesPasswort.getText().equals("")
				&& passwortfiedEinstellungenNeuesPasswort1.getText()
						.equals(passwortfiedEinstellungenAltesPasswort.getText())) {
			if (uc.getLanguage() == 1) {
				locale = new Locale("en");
				Locale.setDefault(Locale.ENGLISH);
			}
			if (uc.getLanguage() == 0) {
				locale = new Locale("de");
				Locale.setDefault(Locale.GERMAN);
			}
			ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", locale);

			JOptionPane.showMessageDialog(null, bundle.getString("joption.passoldnew"));
		}

		if (radioButtonEinstellungDeutsch.isSelected()) {
			uc.setLanguage('d');
			Locale.setDefault(Locale.GERMAN);
			radioButtonEinstellungDeutsch.setSelected(false);
			locale = new Locale("de");

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("Sample.fxml"));
			loader.setResources(ResourceBundle.getBundle("bundles.language", locale));

			Parent root = loader.load();

			Scene tableViewscene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(tableViewscene);
			window.show();
		}

		if (radioButtonEinstellungenEnglisch.isSelected()) {
			uc.setLanguage('e');
			Locale.setDefault(Locale.ENGLISH);
			radioButtonEinstellungenEnglisch.setSelected(false);
			locale = new Locale("en");

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("Sample.fxml"));
			loader.setResources(ResourceBundle.getBundle("bundles.language", locale));

			Parent root = loader.load();

			Scene tableViewscene = new Scene(root);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(tableViewscene);
			window.show();
		}

		if (choiceBoxEinstellungenWochenarbeitszeit.getSelectionModel().getSelectedItem() != null) {
			String s = choiceBoxEinstellungenWochenarbeitszeit.getValue();
			int wochenarbeitszeit = Integer.parseInt(s.substring(0, 2));
			uc.setWeeklyWorktime(String.valueOf(wochenarbeitszeit));
			choiceBoxEinstellungenWochenarbeitszeit.setValue(null);
			settingsChanged = true;
		}

		if (!textfieldEinstellungenErsteWarnstufe.getText().equals("")) {
			int fw = 0;
			try {
				fw = Integer.parseInt(textfieldEinstellungenErsteWarnstufe.getText());

				int sw = uc.getSecondWarning();

				if (fw > sw) {
					if (uc.getLanguage() == 1) {
						locale = new Locale("en");
						Locale.setDefault(Locale.ENGLISH);

						ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", locale);

						JOptionPane.showMessageDialog(null, bundle.getString("joption.falert1") + fw
								+ bundle.getString("joption.falert2") + sw + ")!");
					}
					if (uc.getLanguage() == 0) {
						locale = new Locale("de");
						Locale.setDefault(Locale.GERMAN);

						ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", locale);

						JOptionPane.showMessageDialog(null, bundle.getString("joption.falert1") + fw
								+ bundle.getString("joption.falert2") + sw + bundle.getString("joption.falert3"));
					}
				} else {
					uc.setFirstWarning(textfieldEinstellungenErsteWarnstufe.getText());
					textfieldEinstellungenErsteWarnstufe.setText("");
					settingsChanged = true;
				}
			} catch (NumberFormatException e) {
				if (uc.getLanguage() == 1) {
					locale = new Locale("en");
					Locale.setDefault(Locale.ENGLISH);
				}
				if (uc.getLanguage() == 0) {
					locale = new Locale("de");
					Locale.setDefault(Locale.GERMAN);
				}
				ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", locale);

				JOptionPane.showMessageDialog(null, bundle.getString("joption.wrongformat"));

			}
			try {
				schreibeGleitzeitJahr(event);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (!textfieldEinstellungenZweiteWarnstufe.getText().equals("")) {

			try {
				int sw = 0;
				sw = Integer.parseInt(textfieldEinstellungenZweiteWarnstufe.getText());

				int fw = uc.getFirstWarning();

				if (fw > sw) {
					if (uc.getLanguage() == 1) {
						locale = new Locale("en");
						Locale.setDefault(Locale.ENGLISH);

						ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", locale);
						comboBoxAbwesenheit.getItems().addAll(Array.abwesenheitEN);
						JOptionPane.showMessageDialog(null, bundle.getString("joption.falert1") + fw
								+ bundle.getString("joption.falert2") + sw + ")!");
					}
					if (uc.getLanguage() == 0) {
						locale = new Locale("de");
						Locale.setDefault(Locale.GERMAN);
						comboBoxAbwesenheit.getItems().addAll(Array.abwesenheitDE);
						ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", locale);

						JOptionPane.showMessageDialog(null, bundle.getString("joption.falert1") + fw
								+ bundle.getString("joption.falert2") + sw + bundle.getString("joption.falert3"));
					}
				} else {
					uc.setSecondWarning(textfieldEinstellungenZweiteWarnstufe.getText());
					textfieldEinstellungenZweiteWarnstufe.setText("");
					settingsChanged = true;
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();

				if (uc.getLanguage() == 1) {
					locale = new Locale("en");
					Locale.setDefault(Locale.ENGLISH);
				}
				if (uc.getLanguage() == 0) {
					locale = new Locale("de");
					Locale.setDefault(Locale.GERMAN);
				}
				ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", locale);

				JOptionPane.showMessageDialog(null, bundle.getString("joption.wrongformat"));
			}
			try {
				schreibeGleitzeitJahr(event);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (settingsChanged) {
			if (uc.getLanguage() == 1) {
				locale = new Locale("en");
				Locale.setDefault(Locale.ENGLISH);
			}
			if (uc.getLanguage() == 0) {
				locale = new Locale("de");
				Locale.setDefault(Locale.GERMAN);
			}
			ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", locale);

			JOptionPane.showMessageDialog(null, bundle.getString("joption.settings"));
		}

	}

	//Methode um eine Zusatzpause buchen zu können
	//wenn die Checkbox aktiviert ist, dann werden die Felder angezeigt
	public void mehrPause() {

		if (checkboxZeiterfassungZusatzpause.isSelected()) {
			labelZeiterfassungZusatzpause.setVisible(true);
			textfieldZeiterfassungZusatzpause.setVisible(true);

		} else {

			labelZeiterfassungZusatzpause.setVisible(false);
			textfieldZeiterfassungZusatzpause.setVisible(false);

		}

	}

	//Bei Auswahl der "Abwesenheit" erscheint ein zuvor ausgeblendetes Auswahlmenü mit Dropdown für
	// Urlaub bzw Feiertag und ein Datepicker um das Datum zu wählen
	//zusätzlich wird immer "Urlaub" in der entsprechend eingestellten Sprache als Standard gesetzt
	public void abweseneheit() {
		UserConfig uc = new UserConfig();

		if (checkboxZeiterfassungAbwesenheit.isSelected()) {
			if (uc.getLanguage() == 1) {

				locale = new Locale("en");
				Locale.setDefault(Locale.ENGLISH);
				comboBoxAbwesenheit.setVisible(true);
				vacationDatePicker.setVisible(true);
				if (comboBoxAbwesenheit.getItems().isEmpty()) {
					comboBoxAbwesenheit.getItems().addAll(Array.abwesenheitEN);
					comboBoxAbwesenheit.getSelectionModel().select("Vacation");
				}

			} else {
				locale = new Locale("de");
				Locale.setDefault(Locale.GERMAN);
				comboBoxAbwesenheit.setVisible(true);
				vacationDatePicker.setVisible(true);
				if (comboBoxAbwesenheit.getItems().isEmpty()) {
					comboBoxAbwesenheit.getItems().addAll(Array.abwesenheitDE);
					comboBoxAbwesenheit.getSelectionModel().select("Urlaub");
				}

			}
		} else {

			comboBoxAbwesenheit.setVisible(false);
			vacationDatePicker.setVisible(false);

		}

	}

	
	//Funktionalität des Buttons "Logout" bei den Einstellungen
	//Man springt aus dem Programm und es wird automatisch wieder der Loginbereich geladen
	public void switchBack(ActionEvent event) throws IOException {

		//Gewährleistung, dass die richtige Sprache geladen wird
		UserConfig uc = new UserConfig();
		if (uc.getLanguage() == 0) {
			locale = new Locale("de");
			Array.locale = new Locale("de");
		}
		if (uc.getLanguage() == 1) {
			locale = new Locale("en");
			Array.locale = new Locale("en");
		}

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Login.fxml"));
		loader.setResources(ResourceBundle.getBundle("bundles.language", locale));

		Parent root = loader.load();
		Scene tableViewscene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		tableViewscene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		window.setScene(tableViewscene);
		window.show();
	}

	public void newZeitenBerechnung(ActionEvent event) throws IOException, ParseException {
		methoden m1 = new methoden();
		String s1 = comboBoxBeginnStunden.getSelectionModel().getSelectedItem();
		String s2 = comboBoxBeginnMinuten.getSelectionModel().getSelectedItem();
		String s3 = comboBoxEndeStunden.getSelectionModel().getSelectedItem();
		String s4 = comboBoxEndeMinuten.getSelectionModel().getSelectedItem();
		String s5 = textfieldZeiterfassungZusatzpause.getText();
		if (s1 != null && s2 != null && s3 != null && s4 != null) {
			m1.setStartStunde(s1);
			m1.setStartMinute(s2);
			m1.setEndeStunde(s3);
			m1.setEndeMinute(s4);
			m1.setPauseExtra(s5);
			m1.MaxStundenErlaubt();
			m1.AuswahlWochenStundenMaxErlaubt();
			String result = m1.MaxStundenErlaubt();
			textfieldZeiterfassungGesetzlichesmaximum.setText(result);
			// System.out.println(m1.berechneArbeitszeitMitPause());
			// 1Zeile drüber raus
		}
	}

	public void schreibeGleitzeitJahr(ActionEvent event) throws IOException, ParseException {
		int year = LocalDate.now().getYear();
		if (comboBoxKalenderJahresauswahl.getSelectionModel().getSelectedItem() != null) {
			year = Integer.parseInt(comboBoxKalenderJahresauswahl.getSelectionModel().getSelectedItem());
		}
		int gleitzeitJahr = 0;
		for (int i = 1; i <= 12; i++) {
			gleitzeitJahr += gleitzeitMonat(year, i);
		}
		if (gleitzeitJahr < 0) {
			gleitzeitJahr = gleitzeitJahr * (-1);
			textfieldKalenderJahresStunden.setText("-" + gleitzeitJahr / 60 + ":" + gleitzeitJahr % 60);

		} else {
			textfieldKalenderJahresStunden.setText("" + gleitzeitJahr / 60 + ":" + gleitzeitJahr % 60);
		}
		UserConfig uc = new UserConfig();
		if ((((double) gleitzeitJahr) / 60) > uc.getFirstWarning()
				&& (((double) gleitzeitJahr) / 60) < uc.getSecondWarning()) {
			circleAmpelansichtColorYellow.setFill(Color.YELLOW);
			circleAmpelansichtColorRed.setFill(Color.WHITE);
			circleAmpelansichtColorGreen.setFill(Color.WHITE);
		} else if ((((double) gleitzeitJahr) / 60) > uc.getSecondWarning()) {
			circleAmpelansichtColorYellow.setFill(Color.WHITE);
			circleAmpelansichtColorRed.setFill(Color.RED);
			circleAmpelansichtColorGreen.setFill(Color.WHITE);
		} else if ((((double) gleitzeitJahr) / 60) < uc.getFirstWarning()) {
			circleAmpelansichtColorYellow.setFill(Color.WHITE);
			circleAmpelansichtColorRed.setFill(Color.WHITE);
			circleAmpelansichtColorGreen.setFill(Color.LAWNGREEN);
		}
		schreibeGleitzeitMonat(event);
		schreibeGleitzeitQuartal(event);
	}

	public void schreibeGleitzeitQuartal(ActionEvent event) throws IOException, ParseException {
		String month = "" + LocalDate.now().getMonthValue();
		String quartal = "" + 1;
		if (3 < Integer.parseInt(month) && Integer.parseInt(month) < 7) {
			quartal = "" + 2;
		}
		if (6 < Integer.parseInt(month) && Integer.parseInt(month) < 10) {
			quartal = "" + 3;
		}
		if (9 < Integer.parseInt(month) && Integer.parseInt(month) < 12) {
			quartal = "" + 4;
		}
		if (comboBoxKalenderQuartalsauswahl.getSelectionModel().getSelectedItem() != null) {
			quartal = comboBoxKalenderQuartalsauswahl.getSelectionModel().getSelectedItem();
		}
		if (comboBoxKalenderMonatsauswahl.getSelectionModel().getSelectedItem() != null) {
			month = comboBoxKalenderMonatsauswahl.getSelectionModel().getSelectedItem();
		}
		int year = LocalDate.now().getYear();
		if (comboBoxKalenderJahresauswahl.getSelectionModel().getSelectedItem() != null) {
			year = Integer.parseInt(comboBoxKalenderJahresauswahl.getSelectionModel().getSelectedItem());
		}
		int gleitzeitQuartal = 0;
		for (int i = ((Integer.parseInt(quartal) * 3) - 2); i <= (Integer.parseInt(quartal) * 3); i++) {
			gleitzeitQuartal += gleitzeitMonat(year, i);
		}
		if (gleitzeitQuartal < 0) {
			gleitzeitQuartal = gleitzeitQuartal * (-1);
			textfieldKalenderQuartalsStunden.setText("-" + gleitzeitQuartal / 60 + ":" + gleitzeitQuartal % 60);

		} else {
			textfieldKalenderQuartalsStunden.setText("" + gleitzeitQuartal / 60 + ":" + gleitzeitQuartal % 60);
		}
	}

	public int schreibeGleitzeitMonat(ActionEvent event) throws IOException, ParseException {
		String month = "" + LocalDate.now().getMonthValue();
		if (comboBoxKalenderMonatsauswahl.getSelectionModel().getSelectedItem() != null) {
			month = comboBoxKalenderMonatsauswahl.getSelectionModel().getSelectedItem();
		}
		int year = LocalDate.now().getYear();
		if (comboBoxKalenderJahresauswahl.getSelectionModel().getSelectedItem() != null) {
			year = Integer.parseInt(comboBoxKalenderJahresauswahl.getSelectionModel().getSelectedItem());
		}
		int m = Integer.parseInt(month);
		int gleitzeitMonat = gleitzeitMonat(year, m);
		if (gleitzeitMonat < 0) {
			gleitzeitMonat = gleitzeitMonat * (-1);
			textfieldKalenderMonatsStunden.setText("-" + gleitzeitMonat / 60 + ":" + gleitzeitMonat % 60);
			gleitzeitMonat = gleitzeitMonat * (-1);

		} else {
			textfieldKalenderMonatsStunden.setText("" + gleitzeitMonat / 60 + ":" + gleitzeitMonat % 60);
		}
		return gleitzeitMonat;

	}

	public int gleitzeitMonat(int year, int m) throws ParseException {

		YearMonth yearMonthObject = YearMonth.of(year, m);
		int daysInMonth = yearMonthObject.lengthOfMonth(); // 28
		int gleitzeitMonat = 0;

		for (int i = 1; i <= daysInMonth; i++) {
			LocalDate date = LocalDate.of(year, m, i);
			gleitzeitMonat += gleitzeitTag(date);
		}
		return gleitzeitMonat;

	}

	public int gleitzeitTag(LocalDate d) throws ParseException {
		methoden m2 = new methoden();
		UserConfig uc = new UserConfig();
		String[] gz = uc.getDayData(d);
		try {
			if (gz[0] != "") {

				m2.setStartStunde(gz[0].split(":")[0]);
				m2.setStartMinute(gz[0].split(":")[1]);
				m2.setEndeStunde(gz[1].split(":")[0]);
				m2.setEndeMinute(gz[1].split(":")[1]);
				m2.setPauseExtra(gz[3]);
				m2.MaxStundenErlaubt();
				m2.AuswahlWochenStundenMaxErlaubt();
				m2.MaxStundenErlaubt();
				String[] str = m2.berechneArbeitszeitMitPause().split(":");
				int zeit = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);

				zeit = zeit - ((Integer.parseInt(uc.getWorktime()) / 5) * 60);
				return zeit;
			}
		} catch (NumberFormatException e) {
			return 0;
		}
		return 0;

	}

	
	//Wenn eine Arbeitszeitverletzung vorliegt, dann wird ein roter Button im Kalender sichtbar und man kann per Klick zu dem Tab
	// Arbeitszeitverletzung springen
	public void switchToTimeViolation() {
		buttonKalenderSwitchToTimeViolation.setOnMouseClicked(e -> tabPaneAnsicht.getSelectionModel().select(3));
	}

}
