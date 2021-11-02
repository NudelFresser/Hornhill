package application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class methoden
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
	
	
	public boolean unter18check() throws ParseException {
		
		// Abruf des Geburtsdatums aus der XML
		UserConfig u1 = new UserConfig();
		String string = u1.getBirthday();
		
		// Zum Testen mit per Hand eingegebenem Datum in Testklasse
		//String string = gebDatum; 
		
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
		
		if(alter < 18) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void AuswahlWochenStundenMaxErlaubt() throws ParseException {
		
		UserConfig u1 = new UserConfig();
		int i =  Integer.parseInt(u1.getWorktime()); 
		if (unter18check() == true) {
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
	
	public String MaxStundenErlaubt() throws ParseException {
	
		//Dieses if-Statement exestieren, da die Betriebszeiten zwischen 06:00 und 22:00 liegen --> Davor oder Danach ist auﬂerhalb der Arbeitszeit
		if(startStunde < 6) {
			startStunde = 6;
		}
		
		
		long ergebnisStunde = startStunde + maxerlaubt;
		long ergebnisMinute = startMinute + pauseExtra;
		
		
		berechneArbeitszeitOhnePause();
		
		if(unter18check() == true) {
			
			if(ArbeitohnePauseStunde >= 4 && ArbeitohnePauseStunde < 6 && ArbeitohnePauseMinute >= 30 ) {
				ergebnisMinute = ergebnisMinute + 30;
				pausendauer = 30;
			}
			
		}
		else {
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
		
		
		
		String s = Long.toString(ergebnisStunde);
		String s2 = Long.toString(ergebnisMinute);
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
	
	
	public void berechneArbeitszeitOhnePause() {
		//Diese Zwei if Statements exestieren, da die Betriebszeiten zwischen 06:00 und 22:00 liegen --> Davor oder Danach ist auﬂerhalb der Arbeitszeit
		if(startStunde < 6) {
			startStunde = 6;
		}
		if(endeStunde > 22) {
			endeStunde = 22;
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
	
	
	public String parseDateToString(Date date) {
		Date input = date;
		
		DateFormat outputFormat = new SimpleDateFormat("HH:mm");
		String outputText = outputFormat.format(input);
		
		return outputText;
	
	}
	
	public Date parseStringToDate(String string) throws ParseException {
		String s = string;
		Date date1 = new SimpleDateFormat("HH:mm").parse(s);
		return date1;
			
	}
	
	
}
