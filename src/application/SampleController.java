package application;

import java.io.IOException;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Collections;
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
import javafx.scene.control.TextArea;
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
	private TableView<Person> tableViewKalenderKalenderansicht;

	@FXML
	private TableColumn<Person, SimpleStringProperty> tablecolumnKalenderArbeitsbeginn;

	@FXML
	private TableColumn<Person, SimpleStringProperty> tablecolumnKalenderArbeitsende;

	@FXML
	private TableColumn<Person, SimpleStringProperty> tablecolumnKalenderZusatzpause;

	@FXML
	private TableColumn<Person, SimpleStringProperty> tablecolumnKalenderGleitzeit;

	@FXML
	private TableColumn<Person, LocalDate> birthdayColumn;

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
	private TextArea textareaViolationtype;

	@FXML
	private TextField textfieldViolationDay;

	@FXML
	private Button buttonReportViolation;

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
		Methoden md = new Methoden();

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

		birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birthday"));
		tablecolumnKalenderArbeitsbeginn
				.setCellValueFactory(new PropertyValueFactory<Person, SimpleStringProperty>("Arbeitsbeginn"));
		tablecolumnKalenderArbeitsende
				.setCellValueFactory(new PropertyValueFactory<Person, SimpleStringProperty>("Arbeitsende"));
		tablecolumnKalenderZusatzpause
				.setCellValueFactory(new PropertyValueFactory<Person, SimpleStringProperty>("Pause"));
		tablecolumnKalenderGleitzeit
				.setCellValueFactory(new PropertyValueFactory<Person, SimpleStringProperty>("Overtime"));

		birthdayDatePicker.setEditable(false);

		// füllen der Kalender-Tabelle mit den Daten aus der worktime.xml
		UserConfig uc = new UserConfig();
		List<Person> zeiten = uc.getTimes();
		Collections.reverse(zeiten);
		for (Person p : zeiten) {

			tableViewKalenderKalenderansicht.getItems().add(p);

		}
		tableViewRowColor();

		tableViewKalenderKalenderansicht.setEditable(false);
		try {
			buttonKalenderSwitchToTimeViolation.setVisible(false);
			schreibeGleitzeitJahr(null);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// Methode um die Tableview bzw. einzelne Zeilen farbig hervorzuheben
	public void tableViewRowColor() {
		UserConfig uc = new UserConfig();
		tableViewKalenderKalenderansicht.setRowFactory(tv -> new TableRow<Person>() {
			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);

				LocalDate lc = birthdayColumn.getCellData(item);
				if (item != null && uc.getReported(lc) == 2) {
					setStyle("-fx-background-color: red ;");
				}
				if (item != null && uc.getReported(lc) == 1) {
					setStyle(null);
				}
			}
		});
	}

	// neuer Eintrag in die worktime.xml über die Hilfsklasse "Person" als
	// gespiegeltes Tabellenelement
	public void newPersonButtonPushed(ActionEvent event) throws IOException, ParseException {
		UserConfig uc = new UserConfig();
		// Code von newZeitenBerechnung, da leider nicht weiß wie ich die Methode hier
		// aufrufen soll
		Methoden m1 = new Methoden();
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

		// falls Abwesenheit gebucht werden soll (Urlaub, Feiertag)
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
				tableViewscene.getStylesheets().add(getClass().getResource("sample.css").toExternalForm());
				window.setScene(tableViewscene);
				window.show();

				ResourceBundle bundle = ResourceBundle.getBundle("bundles.language", locale);

				JOptionPane.showMessageDialog(null, bundle.getString("joption.success"));

			}
		}

		// falls normaler Arbeitstag gebucht werden soll
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

					int flexitime = gleitzeitTag(date);
					String overtime = "";
					if (flexitime < 0) {
						flexitime = flexitime * (-1);
						if((flexitime%60)<10) {
							overtime = "-" + flexitime / 60 + ":0" + flexitime % 60;
						}else {
						overtime = "-" + flexitime / 60 + ":" + flexitime % 60;
						}
					} else {
						if((flexitime%60)<10) {
							overtime = flexitime / 60 + ":0" + flexitime % 60;
						}else {
						overtime = flexitime / 60 + ":" + flexitime % 60;
						}
					}

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
					tableViewscene.getStylesheets().add(getClass().getResource("sample.css").toExternalForm());
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

	// Änderungen der Nutzereinstellungen, werden in der user.xml abgespeichert
	public void newSettingButtonPushed(ActionEvent event) throws IOException {
		UserConfig uc = new UserConfig();
		boolean settingsChanged = false;

		// Passwortänderungen Werte prüfen und ggfs. neues Passwort setzen
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

		// Sprache Deutsch festlegen
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
			tableViewscene.getStylesheets().add(getClass().getResource("sample.css").toExternalForm());
			window.setScene(tableViewscene);
			window.show();
		}

		// Sprache Englisch festlegen
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
			tableViewscene.getStylesheets().add(getClass().getResource("sample.css").toExternalForm());
			window.setScene(tableViewscene);
			window.show();
		}

		// Wochenarbeitszeit ändern
		if (choiceBoxEinstellungenWochenarbeitszeit.getSelectionModel().getSelectedItem() != null) {
			String s = choiceBoxEinstellungenWochenarbeitszeit.getValue();
			int wochenarbeitszeit = Integer.parseInt(s.substring(0, 2));
			uc.setWeeklyWorktime(String.valueOf(wochenarbeitszeit));
			choiceBoxEinstellungenWochenarbeitszeit.setValue(null);
			settingsChanged = true;
		}

		// Warnstufen für Ampellogik ändern falls Werte valide sind (erste Warnstufe
		// kann nicht größer sein wie zweite z.B.)
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

		// User-Feedback falls Änderungen gespeichert wurden
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

	// Methode um eine Zusatzpause buchen zu können
	// wenn die Checkbox aktiviert ist, dann werden die Felder angezeigt
	public void mehrPause() {

		if (checkboxZeiterfassungZusatzpause.isSelected()) {
			labelZeiterfassungZusatzpause.setVisible(true);
			textfieldZeiterfassungZusatzpause.setVisible(true);

		} else {

			labelZeiterfassungZusatzpause.setVisible(false);
			textfieldZeiterfassungZusatzpause.setVisible(false);

		}

	}

	// Bei Auswahl der "Abwesenheit" erscheint ein zuvor ausgeblendetes Auswahlmenü
	// mit Dropdown für
	// Urlaub bzw Feiertag und ein Datepicker um das Datum zu wählen
	// zusätzlich wird immer "Urlaub" in der entsprechend eingestellten Sprache als
	// Standard gesetzt
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
					comboBoxAbwesenheit.getSelectionModel().select("vacation");
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

	// Funktionalität des Buttons "Logout" bei den Einstellungen.
	// Man springt aus dem Programm und es wird automatisch wieder der Loginbereich
	// geladen.
	// Es wird automatisch die entsprechend hinterlegte bzw. abgespeicherte Sprache
	// gewählt und geladen.
	public void switchBack(ActionEvent event) throws IOException {

		// Gewährleistung, dass die richtige Sprache geladen wird
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

	// Wenn im Tab "Zeiterfassung" Arbeitsbeginn oder Arbeitsende verändert werden,
	// wird dieser Code ausgeführt
	// welcher Arbeitsbeginn und Ende einliest und daraufhin das gesetzliche
	// Arbeitsmaximum ausgibt.
	public void newZeitenBerechnung(ActionEvent event) throws IOException, ParseException {
		Methoden m1 = new Methoden();
		String s1 = comboBoxBeginnStunden.getSelectionModel().getSelectedItem();
		String s2 = comboBoxBeginnMinuten.getSelectionModel().getSelectedItem();
		String s3 = comboBoxEndeStunden.getSelectionModel().getSelectedItem();
		String s4 = comboBoxEndeMinuten.getSelectionModel().getSelectedItem();
		String s5 = textfieldZeiterfassungZusatzpause.getText();
		// Berechnung findet nur statt, wenn alle comboBoxen einen gültigen Wert
		// enthalten
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
		}
	}

	// schreibt die Gleitzeit ins Jahresfed
	// je nachem welches Jahr ausgewählt wurde (nichts=> aktuelles)
	public void schreibeGleitzeitJahr(ActionEvent event) throws IOException, ParseException {
		// auswahl Jahr
		int year = LocalDate.now().getYear();
		if (comboBoxKalenderJahresauswahl.getSelectionModel().getSelectedItem() != null) {
			year = Integer.parseInt(comboBoxKalenderJahresauswahl.getSelectionModel().getSelectedItem());
		}
		int gleitzeitJahr = 0;
		for (int i = 1; i <= 12; i++) {// durchgehen aller Monate
			gleitzeitJahr += gleitzeitMonat(year, i);
		}
		// schreiben
		if (gleitzeitJahr < 0) {
			gleitzeitJahr = gleitzeitJahr * (-1);
			if ((gleitzeitJahr % 60) < 10) {
				textfieldKalenderJahresStunden.setText("-" + gleitzeitJahr / 60 + ":0" + gleitzeitJahr % 60);
			} else {
				textfieldKalenderJahresStunden.setText("-" + gleitzeitJahr / 60 + ":" + gleitzeitJahr % 60);
			}
		} else {
			if ((gleitzeitJahr % 60) < 10) {
				textfieldKalenderJahresStunden.setText("" + gleitzeitJahr / 60 + ":0" + gleitzeitJahr % 60);
			} else {
				textfieldKalenderJahresStunden.setText("" + gleitzeitJahr / 60 + ":" + gleitzeitJahr % 60);
			}
		}

		int ap = ampel(gleitzeitJahr);
		switch (ap) {// färben der Ampel
		case 0:
			circleAmpelansichtColorYellow.setFill(Color.WHITE);
			circleAmpelansichtColorRed.setFill(Color.WHITE);
			circleAmpelansichtColorGreen.setFill(Color.LAWNGREEN);
			break;
		case 1:
			circleAmpelansichtColorYellow.setFill(Color.YELLOW);
			circleAmpelansichtColorRed.setFill(Color.WHITE);
			circleAmpelansichtColorGreen.setFill(Color.WHITE);
			break;
		case 2:
			circleAmpelansichtColorYellow.setFill(Color.WHITE);
			circleAmpelansichtColorRed.setFill(Color.RED);
			circleAmpelansichtColorGreen.setFill(Color.WHITE);
			break;
		}

		// aufruf der Quartals und Monatsschreiben Methode
		// sie ändern sich auch jenachdem welches Jahr ausgewählt wurde
		schreibeGleitzeitMonat(event);
		schreibeGleitzeitQuartal(event);
		// Aufruf arbeitszeitverletzungsmethode
		// prüft für das aktuell ausgewählte Jahr
		arbeitszeitverletzung(year);
	}

	// prüft was die Ampel anzeigen soll und gibt es dann zurück
	public int ampel(int gleitzeitJahr) {
		int ap = 0;
		UserConfig uc = new UserConfig();
		if ((((double) gleitzeitJahr) / 60) > uc.getFirstWarning()
				&& (((double) gleitzeitJahr) / 60) < uc.getSecondWarning()) {
			ap = 1;// gelb
		} else if ((((double) gleitzeitJahr) / 60) > uc.getSecondWarning()) {
			ap = 2;// rot
		} else if ((((double) gleitzeitJahr) / 60) < uc.getFirstWarning()) {
			ap = 0;// grün
		}
		return ap;
	}

	// Schreiben der Gleitzeit in das Quartalsfeld
	// jenachdem welches Quartal+Jahr ausgewählt wurde (nichts=> aktuell)
	public void schreibeGleitzeitQuartal(ActionEvent event) throws IOException, ParseException {
		// Quartalsauswahl
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
		int year = LocalDate.now().getYear();// es kann sich auch nur das Quartal angesehen werden
		if (comboBoxKalenderJahresauswahl.getSelectionModel().getSelectedItem() != null) {
			year = Integer.parseInt(comboBoxKalenderJahresauswahl.getSelectionModel().getSelectedItem());
		}
		int gleitzeitQuartal = 0;
		// errechnen der Quartalsgleitzeit in min
		for (int i = ((Integer.parseInt(quartal) * 3) - 2); i <= (Integer.parseInt(quartal) * 3); i++) {
			gleitzeitQuartal += gleitzeitMonat(year, i);
		}
		// schreiben
		if (gleitzeitQuartal < 0) {
			gleitzeitQuartal = gleitzeitQuartal * (-1);
			if ((gleitzeitQuartal % 60) < 10) {
				textfieldKalenderQuartalsStunden.setText("-" + gleitzeitQuartal / 60 + ":0" + gleitzeitQuartal % 60);
			} else {
				textfieldKalenderQuartalsStunden.setText("-" + gleitzeitQuartal / 60 + ":" + gleitzeitQuartal % 60);
			}
		} else {
			if ((gleitzeitQuartal % 60) < 10) {
				textfieldKalenderQuartalsStunden.setText("" + gleitzeitQuartal / 60 + ":0" + gleitzeitQuartal % 60);
			} else {
				textfieldKalenderQuartalsStunden.setText("" + gleitzeitQuartal / 60 + ":" + gleitzeitQuartal % 60);
			}
		}
	}

	// Schreiben der Gleitzeit in das Monatsfeld
	// je nachdem welcher Monat+Jahr ausgewählt wurde (nichts=> aktuell)
	public int schreibeGleitzeitMonat(ActionEvent event) throws IOException, ParseException {
		// Monatsauswahl
		String month = "" + LocalDate.now().getMonthValue();
		if (comboBoxKalenderMonatsauswahl.getSelectionModel().getSelectedItem() != null) {
			month = comboBoxKalenderMonatsauswahl.getSelectionModel().getSelectedItem();
		}
		int year = LocalDate.now().getYear();// es kann sich auch nur das Quartal angesehen werden
		if (comboBoxKalenderJahresauswahl.getSelectionModel().getSelectedItem() != null) {
			year = Integer.parseInt(comboBoxKalenderJahresauswahl.getSelectionModel().getSelectedItem());
		}

		int m = Integer.parseInt(month);
		int gleitzeitMonat = gleitzeitMonat(year, m);// errrechnen der Quartalsgleitzeit (min)
		// schreiben
		if (gleitzeitMonat < 0) {
			gleitzeitMonat = gleitzeitMonat * (-1);
			if ((gleitzeitMonat % 60) < 10) {
				textfieldKalenderMonatsStunden.setText("-" + gleitzeitMonat / 60 + ":0" + gleitzeitMonat % 60);
			} else {
				textfieldKalenderMonatsStunden.setText("-" + gleitzeitMonat / 60 + ":" + gleitzeitMonat % 60);
			}
			gleitzeitMonat = gleitzeitMonat * (-1);

		} else {
			if ((gleitzeitMonat % 60) < 10) {
				textfieldKalenderMonatsStunden.setText("" + gleitzeitMonat / 60 + ":0" + gleitzeitMonat % 60);
			} else {
				textfieldKalenderMonatsStunden.setText("" + gleitzeitMonat / 60 + ":" + gleitzeitMonat % 60);
			}
		}
		return gleitzeitMonat;

	}

	// Berechnung der Gleitzeit in Minuten in einem Monat
	public int gleitzeitMonat(int year, int m) throws ParseException {

		YearMonth yearMonthObject = YearMonth.of(year, m);
		int daysInMonth = yearMonthObject.lengthOfMonth(); // Monatsläne
		int gleitzeitMonat = 0;
		// abrufen der Monatstage durch summieren der Tagesgleitzeit
		for (int i = 1; i <= daysInMonth; i++) {
			LocalDate date = LocalDate.of(year, m, i);
			gleitzeitMonat += gleitzeitTag(date);
		}
		return gleitzeitMonat;

	}

	// Berechnung der Gleitzeit in Minuten an einem Tag
	public int gleitzeitTag(LocalDate d) throws ParseException {
		Methoden m2 = new Methoden();
		UserConfig uc = new UserConfig();
		String[] gz = uc.getDayData(d);// Tagesdaten abrufen
		try {

			m2.setStartStunde(gz[0].split(":")[0]);
			m2.setStartMinute(gz[0].split(":")[1]);
			m2.setEndeStunde(gz[1].split(":")[0]);
			m2.setEndeMinute(gz[1].split(":")[1]);
			m2.setPauseExtra(gz[3]);
			m2.MaxStundenErlaubt();
			m2.AuswahlWochenStundenMaxErlaubt();
			m2.MaxStundenErlaubt();
			String[] str = m2.berechneArbeitszeitMitPause().split(":");// Arbeitszeit errechen
			int zeit = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);// in Minuten umwandeln

			zeit = zeit - ((Integer.parseInt(uc.getWorktime()) / 5) * 60);// Abziehen der Täglichenvertraglichen
																			// Arbeitsminuten
			return zeit;

		} catch (NumberFormatException e) {
			return 0;
		}

	}

	// Wenn eine Arbeitszeitverletzung vorliegt, dann wird ein roter Button im
	// Kalender sichtbar und man kann per Klick zu dem Tab
	// Arbeitszeitverletzung springen
	public void switchToTimeViolation() {
		buttonKalenderSwitchToTimeViolation.setOnMouseClicked(e -> tabPaneAnsicht.getSelectionModel().select(3));
	}

	// Diese Methode prüft ob eine Arbeitszeitverletzung im aktuellen / ausgewählten
	// Jahr vorliegt
	// Dafür wird das Jahr Systematisch nach den Tagen auf arbeitszeitverletzungen
	// überprüft
	public void arbeitszeitverletzung(int year) {
		textareaViolationtype.setText("");
		textfieldViolationDay.setText("");
		buttonReportViolation.setVisible(false);
		buttonKalenderSwitchToTimeViolation.setStyle("-fx-background-color: red");
		buttonKalenderSwitchToTimeViolation.setVisible(false);
		UserConfig uc = new UserConfig();
		boolean azMonatverl = true;
		Methoden methode = new Methoden();
		int ueber18 = 0;
		try {
			ueber18 = methode.unter18check();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// Erwachsene
		if (ueber18 == 2) {
			String azVerletzung = "";
			double[] dMonat = new double[17];

			for (int m = 1; m <= 12; m++) {
				long azMonat = 0;
				int arbeitsTage = 0;

				YearMonth yearMonthObject = YearMonth.of(year, m);
				int daysInMonth = yearMonthObject.lengthOfMonth();
				int aevorherigerTag = -1;

				for (int i = 1; i <= daysInMonth; i++) {
					azVerletzung = "";
					// 11 Stunden ruhezeit
					LocalDate date = LocalDate.of(year, m, i);
					String[] gz = uc.getDayData(date);
					if (uc.getReported(date) == 0 || uc.getReported(date) == 2) {
						if (gz[0].equals("Urlaub") || gz[0].equals("Feiertag") || gz[0].equals("public holiday")
								|| gz[0].equals("vacation") || gz[0].equals("")) {// wenn Tag Urlaub || nicht gearbeitet
																					// => egal
							aevorherigerTag = -1;
						} else if (aevorherigerTag == -1) {// nach Urlaub
							int h = Integer.parseInt(gz[1].split(":")[0]);
							int min = Integer.parseInt(gz[1].split(":")[1]);
							aevorherigerTag = ((24 * 60) - (h * 60 + min));
						} else {// nach normalem Tag
							int hn = Integer.parseInt(gz[0].split(":")[0]);
							int minn = Integer.parseInt(gz[0].split(":")[1]);
							int aa = (hn * 60 + minn);
							if ((aevorherigerTag + aa) < (11 * 60)) {// az verletzung

								if (uc.getLanguage() == 1) {
									azVerletzung = azVerletzung
											+ "\nThere were less than 11 hours break between the two working days";
								} else {
									azVerletzung = azVerletzung + "Weniger als 11h Pause zwischen 2 Arbeitstagen";
								}

							}
							int h = Integer.parseInt(gz[1].split(":")[0]);
							int min = Integer.parseInt(gz[1].split(":")[1]);
							aevorherigerTag = ((24 * 60) - (h * 60 + min));
						}

						// max 10h am Tag
						if (gz[0].equals("Urlaub") || gz[0].equals("Feiertag") || gz[0].equals("public holiday")
								|| gz[0].equals("vacation") || gz[0].equals("")) {//

						} else {// wenn Tag Urlaub || nicht gearbeitet => egal
							int tatlAz = 0;
							tatlAz = tatlAz - Integer.parseInt(gz[0].split(":")[0]) * 60;
							tatlAz = tatlAz - Integer.parseInt(gz[0].split(":")[1]);
							tatlAz = tatlAz + Integer.parseInt(gz[1].split(":")[0]) * 60;
							tatlAz = tatlAz + Integer.parseInt(gz[1].split(":")[1]);
							tatlAz = tatlAz - Integer.parseInt(gz[2]);
							tatlAz = tatlAz - Integer.parseInt(gz[3]);

							if (tatlAz > (10 * 60)) {
								if (uc.getLanguage() == 1) {
									azVerletzung = azVerletzung + "\nWorked more than 10h!";
								} else {
									azVerletzung = azVerletzung + "\nMehr als 10h gearbeitet";
								}
								// Az Verletzung
							}

							DayOfWeek dayOfWeek = DayOfWeek.from(date);
							if (dayOfWeek.getValue() == 7) {
								if (uc.getLanguage() == 1) {
									azVerletzung = azVerletzung + "\nWorked on a sunday";
								} else {
									azVerletzung = azVerletzung + "\nAm Sonntag gearbeitet";
								}

							}
						}

					}
					if (gz[0].equals("Urlaub") || gz[0].equals("Feiertag") || gz[0].equals("public holiday")
							|| gz[0].equals("vacation") || gz[0].equals("")) {//

					} else {// wenn Tag Urlaub || nicht gearbeitet => egal
						int tatlAz = 0;
						tatlAz = tatlAz - Integer.parseInt(gz[0].split(":")[0]) * 60;
						tatlAz = tatlAz - Integer.parseInt(gz[0].split(":")[1]);
						tatlAz = tatlAz + Integer.parseInt(gz[1].split(":")[0]) * 60;
						tatlAz = tatlAz + Integer.parseInt(gz[1].split(":")[1]);
						tatlAz = tatlAz - Integer.parseInt(gz[2]);
						tatlAz = tatlAz - Integer.parseInt(gz[3]);

						azMonat += tatlAz;
						arbeitsTage++;
					}
					if (!azVerletzung.equals("")) {
						azMonatverl = false;
						textareaViolationtype.setText(azVerletzung);
						textfieldViolationDay.setText(i + "-" + m + "-" + year);
						uc.writeReported(date, "2");
						buttonKalenderSwitchToTimeViolation.setVisible(true);
						buttonReportViolation.setVisible(true);
					}
				} // for Tag

				// max 8h Durchschnitt
				// DurchschnittlicheAz für 24 Monate(6vorher und 6Nachher)
				if (arbeitsTage > 0) {
					dMonat[m + 4] = (double) azMonat / (double) arbeitsTage;
				}
			}
			// 8h Durchschnitt
			for (int x = 8; x <= 12; x++) {
				YearMonth yearMonthObject = YearMonth.of(year - 1, x);
				int daysInMonth = yearMonthObject.lengthOfMonth();
				long azMonat = 0;
				int arbeitsTage = 0;
				for (int i = 1; i <= daysInMonth; i++) {
					int tatlAz = 0;
					LocalDate date = LocalDate.of(year - 1, x, i);
					if (uc.getReported(date) == 0) {

						String[] gz = uc.getDayData(date);

						if (gz[0].equals("Urlaub") || gz[0].equals("Feiertag") || gz[0].equals("public holiday")
								|| gz[0].equals("vacation") || gz[0].equals("")) {// wenn Tag Urlaub || nicht gearbeitet
																					// => egal
						} else {
							tatlAz = tatlAz - Integer.parseInt(gz[0].split(":")[0]) * 60;
							tatlAz = tatlAz - Integer.parseInt(gz[0].split(":")[1]);
							tatlAz = tatlAz + Integer.parseInt(gz[1].split(":")[0]) * 60;
							tatlAz = tatlAz + Integer.parseInt(gz[1].split(":")[1]);
							tatlAz = tatlAz - Integer.parseInt(gz[2]);
							tatlAz = tatlAz - Integer.parseInt(gz[3]);
							azMonat += tatlAz;
							arbeitsTage++;
						}
						if (arbeitsTage > 0) {
							dMonat[x - 8] = (double) azMonat / (double) arbeitsTage;
						}
					}
				}
			}
			if (azMonatverl == true) {
				for (int i = 5; i < dMonat.length; i++) {
					double gesdAz = 0;
					double gesdAzZ = 0;

					if (dMonat[i - 5] == 0) {
						for (int x = i; x <= i + 5; x++) {
							gesdAzZ = 0;
							int z =0;
							if (x < 17) {
								gesdAzZ = gesdAzZ+ dMonat[x];
								z++;
							}
							if (gesdAzZ > (8 * 60*z)) {
								if ((dMonat[i] > (8 * 60*2))) {
									if (uc.getLanguage() == 1) {
										textareaViolationtype.setText("In the month " + (i - 4)
												+ " you were working more than 8 hours in average.\nYou don't have to report this but please try to equaize it in the next 6 months.");
										buttonKalenderSwitchToTimeViolation.setVisible(true);
										buttonKalenderSwitchToTimeViolation.setStyle("-fx-background-color: orange");
									} else {
										textareaViolationtype.setText("Im Monat " + (i - 4)
												+ " arbeiten Sie im Schnitt mehr als 8 Stunden. \nSie müssen dies nicht melden aber achten sie darauf dies in den nächsten 6 Monaten auszugleichen.");
										buttonKalenderSwitchToTimeViolation.setVisible(true);
										buttonKalenderSwitchToTimeViolation.setStyle("-fx-background-color: orange");
									}
								}
							}
						}
						
					} else {
						for (int x = i - 5; x <= i; x++) {
							gesdAz += dMonat[x];
						}
						if (gesdAz > (8 * 60*6)) {
							if (uc.getLanguage() == 1) {
								textareaViolationtype
										.setText("You have worked in the past six months in average more than 8 hours"
												+ (i - 4) + "Month");
								buttonKalenderSwitchToTimeViolation.setVisible(true);

							} else {

								textareaViolationtype.setText(
										"Sie haben innerhalb der letzten 6 Monate im Schnitt länger als 8 Stunden gearbeitet"
												+ (i - 4) + "Monat");
								buttonKalenderSwitchToTimeViolation.setVisible(true);
							}
						}
					}
				}
			}

		}

		else {// Jugendliche
			for (int m = 1; m <= 12; m++) {
				String azVerletzung = "";
				YearMonth yearMonthObject = YearMonth.of(year, m);
				int daysInMonth = yearMonthObject.lengthOfMonth();
				int aevorherigerTag = -1;
				for (int i = 1; i <= daysInMonth; i++) {
					LocalDate date = LocalDate.of(year, m, i);
					azVerletzung = "";
					if (uc.getReported(date) == 0) {
						String[] gz = uc.getDayData(date);
						// Nachtruhe
						if (gz[0].equals("Urlaub") || gz[0].equals("Feiertag") || gz[0].equals("public holiday")
								|| gz[0].equals("vacation") || gz[0].equals("")) {// wenn Tag Urlaub || nicht gearbeitet
																					// => egal
							aevorherigerTag = -1;
						} else if (aevorherigerTag == -1) {// nach Urlaub
							int h = Integer.parseInt(gz[1].split(":")[0]);
							int min = Integer.parseInt(gz[1].split(":")[1]);
							aevorherigerTag = ((24 * 60) - (h * 60 + min));
						} else {// nach normalem Tag
							int hn = Integer.parseInt(gz[0].split(":")[0]);
							int minn = Integer.parseInt(gz[0].split(":")[1]);
							int aa = (hn * 60 + minn);
							if ((aevorherigerTag + aa) < (12 * 60)) {
								if (uc.getLanguage() == 1) {
									// az verletzung
									azVerletzung = azVerletzung
											+ "There were less than 12 hours break between the two different days";

								} else {
									azVerletzung = azVerletzung + "Weniger als 12h Pause zwischen 2 Arbeitstagen";
								}

							}
							int h = Integer.parseInt(gz[1].split(":")[0]);
							int min = Integer.parseInt(gz[1].split(":")[1]);
							aevorherigerTag = ((24 * 60) - (h * 60 + min));
						}

						if (gz[0].equals("Urlaub") || gz[0].equals("Feiertag") || gz[0].equals("public holiday")
								|| gz[0].equals("vacation") || gz[0].equals("")) {//
						}

						else {// wenn Tag Urlaub || nicht gearbeitet => egal
								// max 8h Arbeit
							int tatlAz = 0;
							tatlAz = tatlAz - Integer.parseInt(gz[0].split(":")[0]) * 60;
							tatlAz = tatlAz - Integer.parseInt(gz[0].split(":")[1]);
							tatlAz = tatlAz + Integer.parseInt(gz[1].split(":")[0]) * 60;
							tatlAz = tatlAz + Integer.parseInt(gz[1].split(":")[1]);
							tatlAz = tatlAz - Integer.parseInt(gz[2]);
							tatlAz = tatlAz - Integer.parseInt(gz[3]);

							if (tatlAz > (8 * 60)) {
								if (uc.getLanguage() == 1) {
									azVerletzung = azVerletzung + "\nWorked more than 8h!";
								} else {
									azVerletzung = azVerletzung
											+ "\nMehr als 8h gearbeitet --> Verstoß gegen das JArbSchG";
								}

								// Az Verletzung
							}

							// nicht vor 6:00 / nach 20:00
							if (Integer.parseInt(gz[0].split(":")[0]) < 6) {
								if (uc.getLanguage() == 1) {
									// az verletzung
									azVerletzung = azVerletzung + "\nYou have worked bevor 06:00 A.M.";

								} else {
									azVerletzung = azVerletzung + "\nVor 06:00 gearbeitet";
								}

							} else if (Integer.parseInt(gz[1].split(":")[0]) > 22) {
								if (uc.getLanguage() == 1) {
									// az verletzung
									azVerletzung = azVerletzung + "\nYou have worked after 10:00 P.M.";

								} else {
									azVerletzung = azVerletzung + "\nNach 22:00 gearbeitet";
								}

							} else if (Integer.parseInt(gz[1].split(":")[0]) == 22
									&& Integer.parseInt(gz[1].split(":")[1]) > 0) {

								if (uc.getLanguage() == 1) {
									// az verletzung
									azVerletzung = azVerletzung + "\nYou have worked after 10:00 P.M.";

								} else {
									azVerletzung = azVerletzung + "\nNach 22:00 gearbeitet";
								}

							}

							DayOfWeek dayOfWeek = DayOfWeek.from(date);
							if (dayOfWeek.getValue() == 7) {
								if (uc.getLanguage() == 1) {
									azVerletzung = azVerletzung + "\nWorked on a sunday.";
								} else {
									azVerletzung = azVerletzung + "\nAm Sonntag gearbeitet";
								}
							}
							if (dayOfWeek.getValue() == 6) {
								if (uc.getLanguage() == 1) {
									azVerletzung = azVerletzung + "\nWorked on a saturday";
								} else {

									azVerletzung = azVerletzung + "\nAm Samstag gearbeitet";
								}
							}
						}

					}
					if (!azVerletzung.equals("")) {
						textareaViolationtype.setText(azVerletzung);
						textfieldViolationDay.setText(i + "-" + m + "-" + year);
						uc.writeReported(date, "2");
						buttonKalenderSwitchToTimeViolation.setVisible(true);
						buttonReportViolation.setVisible(true);
					}
				} // for

			}
		}
//		if (textareaViolationtype.getText().isEmpty() == true) {
//			buttonKalenderSwitchToTimeViolation.setVisible(false);
//		}
	}

	// Melden der Azverletzung
	// taucht dann nicht nochmal auf
	public void reportTimeviolation() {
		if (!textfieldViolationDay.getText().equals("")) {
			UserConfig uc = new UserConfig();
			String tag = textfieldViolationDay.getText();
			int y = Integer.parseInt(tag.split("-")[2]);
			int m = Integer.parseInt(tag.split("-")[1]);
			int t = Integer.parseInt(tag.split("-")[0]);
			LocalDate d = LocalDate.of(y, m, t);
			uc.writeReported(d, "1");
			buttonReportViolation.setOnMouseClicked(e -> tabPaneAnsicht.getSelectionModel().select(1));
			try {
				schreibeGleitzeitJahr(null);
				tableViewRowColor();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			;
		}

		tableViewRowColor();
	}
}
