package PropertiesLoader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
	static FileReader file;
	
	public static String readBrowser(String browser) {
		
		try {
			file = new FileReader("./src/main/resources/PropertiesFiles/BrowserConfigure.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties P1 =new Properties();
		
		try {
			P1.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String Browser = P1.getProperty(browser);
		return Browser;
	}
	
	public static String readBaseURL(){
		
		try {
			file = new FileReader("./src/main/resources/PropertiesFiles/BrowserConfigure.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties P1 =new Properties();
		
		try {
			P1.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String url = P1.getProperty("BaseURL");
		return url;
	}

}
