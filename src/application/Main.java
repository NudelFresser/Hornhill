package application;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;

class Array {
	public static String[] stunden = { "30", "35", "40" };
	public static String[] ganzeStunden = { "00","01","02","03","04","05", "06","07","08","09","10","11","12","13","14",
											"15","16","17","18","19","20","21","22","23" };
	public static String[] ganzeMinuten = { "00","01","02","03","04","05", "06","07","08","09","10","11","12","13","14",
			"15","16","17","18","19","20","21","22","23","24","25","26",
			"27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48"
			,"49","50","51","52","53","54","55","56","57","58","59"};
	
	public static String [] abwesenheitDE = {"Urlaub", "Feiertag"};
	public static String [] abwesenheitEN = {"vacation", "public holiday"};
	public static Locale locale = new Locale("de");
}

public class Main extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {

		//LanguageSupp
				String defaultLocale = Locale.getDefault().toString();
				String deLocale = new String("de_DE");
				String locale = new String();
				
				
				if(deLocale.equals(defaultLocale))
				{
					locale = defaultLocale.toString().trim().substring(0, 2);
				}
				else {
					locale = new String("en");
				}
				
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("Login.fxml"));
				loader.setResources(ResourceBundle.getBundle("bundles.language_"+ locale));
				//
				
				Parent root = loader.load();

				Scene scene = new Scene(root);

				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}