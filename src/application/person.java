package application;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;

public class person {

	private LocalDate birthday;

	private SimpleStringProperty arbeitsbeginn, arbeitsende, pause;

	public person() {
		this.birthday = null;
		this.arbeitsbeginn = new SimpleStringProperty("");
		this.arbeitsende = new SimpleStringProperty("");
		this.pause = new SimpleStringProperty("");
	}

	public person(LocalDate birthday, String arbeitsbeginn, String arbeitsende, String pause) {
		this.birthday = birthday;
		this.arbeitsbeginn = new SimpleStringProperty(arbeitsbeginn);
		this.arbeitsende = new SimpleStringProperty(arbeitsende);
		this.pause = new SimpleStringProperty(pause);

	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getArbeitsbeginn() {
		return arbeitsbeginn.get();
	}

	public void setArbeitsbeginn(SimpleStringProperty arbeitsbeginn) {
		this.arbeitsbeginn = arbeitsbeginn;
	}

	public String getArbeitsende() {
		return arbeitsende.get();
	}

	public void setArbeitsende(SimpleStringProperty arbeitsende) {
		this.arbeitsende = arbeitsende;
	}

	public String getPause() {
		return pause.get();
	}

	public void setPause(SimpleStringProperty pause) {
		this.pause = pause;
	}

}