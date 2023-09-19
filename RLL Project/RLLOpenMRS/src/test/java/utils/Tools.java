package utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tools {
	
	protected static WebDriver driver;
	public static RequestSpecification httprequest;
	public static Response response;
	public static Logger logger;
	public static String ID;
	
	public Tools() {
		logger = Logger.getLogger("LogDemo");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
}
