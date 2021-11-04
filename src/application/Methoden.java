package application;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Methoden
{

	private long startStunde = 0;
	private long startMinute = 0;
	private long endeStunde = 0;
	private long endeMinute = 0;
	private long ArbeitohnePauseStunde = 0;
	private long ArbeitohnePauseMinute = 0;
	private long ArbeitmitPauseStunde = 0;
	private long ArbeitmitPauseMinute = 0;
	private long pausendauer = 0;
	private long pauseExtra = 0;
	private long maxerlaubt = 0;


	SampleController m1 = new SampleController();
	
	//get und set Methoden
	public void setStartStunde(String startzeit) {
		startStunde = Long.parseLong(startzeit);
	}

	public void setStartMinute(String startminute) {
		startMinute = Long.parseLong(startminute);
	}

	public void setEndeStunde(String endestunde) {
		endeStunde = Long.parseLong(endestunde);
	}

	public void setEndeMinute(String endeminute) {
		endeMinute = Long.parseLong(endeminute);
	}

	public void setPauseExtra(String extrapause) {
		pauseExtra = Long.parseLong(extrapause);
	}


	public String getStartStunde() {
		String s = Long.toString(startStunde);
		if(s.length() < 2) {
			String formatted = ("0" + s);
			return formatted;
	}
		return s;
	}

	public String getPausenDauer() {
		return Long.toString(pausendauer);
	}

	public long getMaxErlaubt() {
		return maxerlaubt;
	}

	public String getZusatzPause() {
		return Long.toString(pauseExtra);
	}

	public long getArbeitmitPauseStunde() {
		return ArbeitmitPauseStunde;
	}

	public long getArbeitmitPauseMinute() {
		return ArbeitmitPauseMinute;
	}

	    // Diese Methode berechnet anhand des Geburtsdatums aus der user.xml ob die Person Minderjährig ist oder nicht.
		// Zudem wird ermittelt ob die Person unter 16 ist.
public int unter18check() throws ParseException {

		
		UserConfig u1 = new UserConfig();
		String string = u1.getBirthday();


		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate d1 = LocalDate.parse(string, formatter);
		LocalDate d2 = LocalDate.now();


		if(d1.isAfter(d2)) {
			throw new IllegalArgumentException("Sie exestieren noch nicht");
		}

		int jahr1 = d1.getYear();
		int jahr2 = d2.getYear();
		int monat1 = d1.getMonthValue();
		int monat2 = d2.getMonthValue();
		int tag1 = d1.getDayOfMonth();
		int tag2 = d2.getDayOfMonth();

		int alter = jahr2 - jahr1;

		if(monat1 > monat2) {
			alter--;
		}
		else if (monat1 == monat2) {
			if(tag1 > tag2) {
				alter--;
			}
		}
		//initialisierung mit Wert der nicht 0 ist
		int rückgabe = 5;

		if(alter < 16) {
			rückgabe = 0;
		}
		else if(alter < 18 && alter >= 16){
			rückgabe = 1;
		}
		else if (alter >= 18){
			rückgabe = 2;
		}
		return rückgabe;
	}

//Diese Methode ist funktional absolut gleich wie der erste unter18check, jedoch hat diese Variante der methode 
//einen Eingabewert (LocalDate) da diese Methode bei der Regestrierung verwendet wird.
public int unter18check(LocalDate gebDatum) throws ParseException {


		LocalDate d1;
		d1 = gebDatum;
		LocalDate d2 = LocalDate.now();


		if(d1.isAfter(d2)) {
			throw new IllegalArgumentException("Sie exestieren noch nicht");
		}

		int jahr1 = d1.getYear();
		int jahr2 = d2.getYear();
		int monat1 = d1.getMonthValue();
		int monat2 = d2.getMonthValue();
		int tag1 = d1.getDayOfMonth();
		int tag2 = d2.getDayOfMonth();

		int alter = jahr2 - jahr1;

		if(monat1 > monat2) {
			alter--;
		}
		else if (monat1 == monat2) {
			if(tag1 > tag2) {
				alter--;
			}
		}
		//initialisierung mit Wert der nicht 0 ist
		int rückgabe = 5;

		if(alter < 16) {
			rückgabe = 0;
		}
		else if(alter < 18 && alter >= 16){
			rückgabe = 1;
		}
		else if (alter >= 18){
			rückgabe = 2;
		}
		return rückgabe;
	}

// Diese Methode liest aus der User.xml die Zeile "Worktime" aus und setzt dementsprechend die täglich erlaubten Stunden.
public void AuswahlWochenStundenMaxErlaubt() throws ParseException {

	UserConfig u1 = new UserConfig();
	int i =  Integer.parseInt(u1.getWorktime());
	if (unter18check() == 1) {
		i = 35;
	}
	switch(i) {


	case 30:
		maxerlaubt = 6;
		break;

	case 35:
		maxerlaubt = 7;
		break;

	case 40:
		maxerlaubt = 8;
		break;
	}
}


// Diese Methode berechnet die Maximal Gesetzliche Arbeitszeit anhand der Wochenstunden + Gesetzliche Pausen + Extrapausen
public String MaxStundenErlaubt() throws ParseException {

	//Dieses if-Statement exestieren, da die Betriebszeiten zwischen 06:00 und 22:00 liegen --> Davor oder Danach ist außerhalb der Arbeitszeit
	if(startStunde < 6) {
		startStunde = 6;
		startMinute = 0;
	}
	

	long ergebnisStunde = startStunde + maxerlaubt;
	long ergebnisMinute = startMinute + pauseExtra;


	berechneArbeitszeitOhnePause();
	
	
	if(unter18check() == 1) {
		
		//Gesetzliche Pausen für Minderjährige
		if(ArbeitohnePauseStunde > 4 && ArbeitohnePauseStunde < 6 || ArbeitohnePauseStunde >= 4 && ArbeitohnePauseMinute >= 30 && ArbeitohnePauseStunde < 6) {
			ergebnisMinute = ergebnisMinute + 30;
			pausendauer = 30;
		}
		if(ArbeitohnePauseStunde >= 6) {
			ergebnisStunde++;
			pausendauer = 60;
		}
	}
	else {
		//Gesetzliche Pausen für Volljährige
		if(ArbeitohnePauseStunde >= 6 && ArbeitohnePauseStunde < 9 ) {
			ergebnisMinute = ergebnisMinute + 30;
			pausendauer = 30;
		}
		else if(ArbeitohnePauseStunde >= 9) {
			ergebnisMinute = ergebnisMinute + 45;
			pausendauer = 45;
		}

	}


		if(ergebnisStunde > 24) {
			ergebnisStunde = ergebnisStunde - 24;
		}

		if(ergebnisMinute >= 60) {
			while(ergebnisMinute >= 60) {
				ergebnisMinute = ergebnisMinute - 60;
				ergebnisStunde++;
			}
		}



		//Zusammenfügen von ergebnisStunde und ergebnisMinute zu einem gemiensamen String.
		String s = Long.toString(ergebnisStunde);
		String s2 = Long.toString(ergebnisMinute);
		String result = "0";
		
		// Falls ein ergebnis nur einzeilig ist (z.B. ergebnisMinute = 9), dann wird eine Null vorne hinzugefügt damit das
		// später in der Ausgabe schön aussieht ( -> ergebnisMinute = 09).
		if(s.length() < 2) {
			String f1 = ("0" + s);

			if(s2.length() < 2) {
				String f2 = ("0" + s2);
				result = f1 + ":" + f2;
			}
			else {
				result = f1 + ":" + s2;
			}
		}
		else if(s2.length() < 2) {
				String f2 = ("0" + s2);
				result = s + ":" + f2;

		}
		else{
			    result = s + ":" + s2;
		}
		return result;
	}


	public void berechneArbeitszeitOhnePause() {
		//Diese Zwei if Statements exestieren, da die Betriebszeiten zwischen 06:00 und 22:00 liegen --> Davor oder Danach ist außerhalb der Arbeitszeit
		if(startStunde < 6) {
			startStunde = 6;
			startMinute = 0;
		}
		if(endeStunde > 22) {
			endeStunde = 22;
			endeMinute = 0;
		}

		ArbeitohnePauseStunde = endeStunde - startStunde;
		ArbeitohnePauseMinute = endeMinute - startMinute;
	}

	public String berechneArbeitszeitMitPause() {
		long pdauerStunden = 0;
		long pdauerMinuten = pausendauer + pauseExtra;
		if(pdauerMinuten >= 60) {
			while(pdauerMinuten >= 60) {
				pdauerMinuten = pdauerMinuten - 60;
				pdauerStunden++;
			}
		}

		ArbeitmitPauseStunde = ArbeitohnePauseStunde - pdauerStunden;
		ArbeitmitPauseMinute = ArbeitohnePauseMinute - pdauerMinuten;

		if(ArbeitmitPauseMinute < 0) {
			ArbeitmitPauseMinute = ArbeitmitPauseMinute + 60;
			ArbeitmitPauseStunde--;
		}

		String s = Long.toString(ArbeitmitPauseStunde);
		String s2 = Long.toString(ArbeitmitPauseMinute);
		String result = "0";

		if(s.length() < 2) {
			String f1 = ("0" + s);

			if(s2.length() < 2) {
				String f2 = ("0" + s2);
				result = f1 + ":" + f2;
			}
			else {
				result = f1 + ":" + s2;
			}
		}
		else if(s2.length() < 2) {
				String f2 = ("0" + s2);
				result = s + ":" + f2;

		}
		else{
			    result = s + ":" + s2;
		}
		return result;
	}

	public void extraPause() {
		pausendauer = pausendauer + pauseExtra;
	}
	}


