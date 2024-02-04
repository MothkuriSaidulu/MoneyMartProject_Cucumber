package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import PageObject.Page_01_HomePage;
import PageObject.Page_02_SignIn;
import PageObject.Page_03_SignUP_To_MoneyMart;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;

	public static Page_01_HomePage Obj_HomePage;
	public static Page_02_SignIn Obj_SignIn;
	public static Page_03_SignUP_To_MoneyMart Obj_SignUp;

	
	public WebDriver Initiate_Browser() throws IOException {

		Properties config_Property = new Properties();

		FileInputStream file = new FileInputStream("config.properties");

		config_Property.load(file);

		String Browser_Name = config_Property.getProperty("Browser");

		if (Browser_Name.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();

		} else if (Browser_Name.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().deleteAllCookies();

		}
		driver.manage().window().maximize();

		return driver;

	}

	public void Launch_Web_Url() throws IOException {
//		driver = Initiate_Browser();
		Properties config_Property = new Properties();

		FileInputStream file = new FileInputStream("config.properties");

		config_Property.load(file);

		String Url = config_Property.getProperty("Url");
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

}
