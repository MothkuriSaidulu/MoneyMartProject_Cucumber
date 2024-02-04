package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Actions.OnlineActions;

public class Page_02_SignIn extends OnlineActions{
	
	
	public WebDriver driver;
	
	public  Page_02_SignIn(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath = "//h1[text()='Sign in to Money Mart']")
	private WebElement signInPageTitle;

	@FindBy(xpath = "//a[@href='/my-account/sign-up']")
	private WebElement SignUp_Now;

	@FindBy(id = "emailAddress")
	private WebElement Email_ID;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement Password;

	@FindBy(css = "div.login_button_wrap")
	private WebElement SignIn_btn;
	
	public void Click_On_SignUp_Now() throws InterruptedException 
	{
		verifyText(signInPageTitle, " PAge Title ", "Sign in to Money Mart");
		Click(SignUp_Now, "User Clicking On Sign Up Button");
		
		
	}


	
	
	
}


