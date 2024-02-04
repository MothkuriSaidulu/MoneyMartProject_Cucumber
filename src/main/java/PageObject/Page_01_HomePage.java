package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Actions.OnlineActions;

public class Page_01_HomePage extends OnlineActions{

	public WebDriver driver;

	public  Page_01_HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, xpath = "//div[@class='header__nav-top'] //span[text()='Sign In / Sign Up']")
	private WebElement sign_in_signUp;

	
	public void Click_On_Sign_In_SignUp() throws InterruptedException 
	{
		waitForElementToClickable(sign_in_signUp, "Wait Till Element To Clickable");
		Click(sign_in_signUp, "Click On Element");
	}
}
