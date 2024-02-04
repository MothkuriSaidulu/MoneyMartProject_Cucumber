package Actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineActions {

	static WebDriver driver;

	@SuppressWarnings("static-access")
	public OnlineActions(WebDriver driver) {
		this.driver = driver;

	}

	public static WebDriverWait applyWebDriverWait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotInteractableException.class);
		return wait;
	}

	public static void waitForElementToVisable(WebElement element, String elementDesc) {
		try {
			WebDriverWait wait = applyWebDriverWait();
			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {

			Assert.fail("WebDriverException : WHILE TRYING TO WAIT FOR ELEMENT TO VISABLE ON THE SPECIFIED WEB ELEMENT"
					+ "<b>" + elementDesc + "</b>" + " is not visible _due_to_the_Exception:- " + e.getMessage());
		}

	}

	public static void waitForElementToClickable(WebElement element, String elementDesc) {

		try {
			WebDriverWait wait = applyWebDriverWait();
			wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Exception e) {
			Assert.fail(
					"WebDriverException : WHILE TRYING TO WAIT FOR ELEMENT TO CLICKABLE ON THE SPECIFIED WEB ELEMENT"
							+ "<b>" + elementDesc + "</b>" + " is not visible _due_to_the_Exception:- "
							+ e.getMessage());

		}

	}

	public void Click(WebElement element, String elementDesc) {
		try {
			waitForElementToVisable(element, elementDesc);
			element.click();

		} catch (Exception e) {

			Assert.fail("WebDriverException : WHILE TRYING TO CLICK ON THE SPECIFIED WEB ELEMENT" + "<b>" + elementDesc
					+ "</b>" + " is not visible _due_to_the_Exception:- " + e.getMessage());

		}

	}

	public void Enter_Text(WebElement element, String elementDesc, String text) {

		try {
			waitForElementToClickable(element, elementDesc);
			element.clear();
			element.sendKeys(text);

		} catch (Exception e) {
			Assert.fail("WebDriverException : WHILE TRYING TO ENTER TEXT INSIDE THE SPECIFIED WEB ELEMENT" + "<b>"
					+ elementDesc + "</b>" + " is not visible _due_to_the_Exception:- " + e.getMessage());

		}
	}

	public void verifyText(WebElement element, String elementDesc, String expectedText) {

		try {

			waitForElementToVisable(element, elementDesc);
			String ActualTeext = element.getText().trim().toLowerCase();
			String ExpectedText = expectedText.trim().toLowerCase();
			Assert.assertEquals(ExpectedText, ActualTeext);

		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("Exception : WHILE TRYING TO VERIFY THE TEXT INSIDE A WEB ELEMENT : "
					+ "Actual and expected texts are not matching for: " + "<b>" + elementDesc + "</b>"
					+ " due to the Exception: " + e.getMessage());

		}

	}

	public static String generateDynamicDOB() {

		Calendar calendar = Calendar.getInstance();
		Random random = new Random();

		int minAge = 31; // Minimum required age (more than 30)
		int maxAge = 44; // Maximum required age (less than 45)
		int maxYearDiff = maxAge - minAge; // Maximum year difference between minAge and maxAge

		int yearDiff = random.nextInt(maxYearDiff + 1) + minAge; // Generate a random year difference between minAge and
																	// maxAge

		calendar.add(Calendar.YEAR, -yearDiff); // Subtract the year difference from the current year
		calendar.add(Calendar.DAY_OF_MONTH, -1); // Subtract 1 day to ensure age >= minAge

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String generateDynamicDOB = dateFormat.format(calendar.getTime());

		return generateDynamicDOB;
	}

	public String Property_Configuration(String Property_Name) throws IOException {
		Properties config_Property = new Properties();

		FileInputStream file = new FileInputStream("config.properties");

		config_Property.load(file);

		String Property_Config_Name = config_Property.getProperty("Property_Name");

		return Property_Config_Name;
	}

	@SuppressWarnings("static-access")
	public String random_String() {

		String random_String = new RandomStringUtils().randomAlphabetic(10);
		return random_String;

	}

	@SuppressWarnings("static-access")
	public String randomNumeric() {

		String randomNumericValue = new RandomStringUtils().randomNumeric(3);
		return randomNumericValue;

	}

	@SuppressWarnings("static-access")
	public String Random_Ph_Number() {

		String ph_Number = new RandomStringUtils().randomNumeric(10);
		return ph_Number;
	}

}
