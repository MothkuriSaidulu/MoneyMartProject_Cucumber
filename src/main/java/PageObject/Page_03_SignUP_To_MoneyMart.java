package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Actions.OnlineActions;

public class Page_03_SignUP_To_MoneyMart extends OnlineActions {

	public WebDriver driver;

	public Page_03_SignUP_To_MoneyMart(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h1[@class='mm-login-page__title']")
	private WebElement SignUp_Page_Text;

	// Type 1
	@FindBy(how = How.XPATH, using = "//input[@name='firstName']")
	private WebElement First_Name_txt;

	// Type 2
	// By userName2 = By.xpath("//input[@id='userEmail']");

	// Type 3
	@FindBy(css = "input[name='lastName']")
	private WebElement Last_Name_txt;

//	@FindBy(css = "button[class='arrowbtn']")	
	@FindBy(xpath = "//input[@placeholder='YYYY/MM/DD']")
	private WebElement DOB_btn;
	/*
	 * @FindBy(xpath =
	 * "//div[@class='mm-calendar__wrapper'] //select[@name='year']") private
	 * WebElement yearDropDown;
	 * 
	 * @FindBy(xpath = "//select[@name='year'] //option") private List<WebElement>
	 * yearsList;
	 * 
	 * @FindBy(xpath =
	 * "//div[@class='mm-calendar__wrapper'] //select[@name='month']") private
	 * WebElement monthDropDown;
	 * 
	 * @FindBy(how = How.XPATH, using = "//select[@name='month'] //option") private
	 * List<WebElement> monthList;
	 * 
	 * @FindBy(xpath =
	 * "//div[@class='mm-calendar__wrapper'] //div[@class='mm-calendar__day ']")
	 * private List<WebElement> daysList;
	 */
	@FindBy(css = "input[name='phoneNumber']")
	private WebElement Phone_Number_txt;

	@FindBy(css = "input[name='email']")
	private WebElement Email_txt;

	@FindBy(xpath = "//input[@name='dob']")
	private WebElement date_Of_birth;

	@FindBy(xpath = "//span[@class='mm-select']")
	private WebElement Security_DropDown;

	@FindBy(xpath = "//div[@class='mm-dropdown__menu'] //button")
	private List<WebElement> Security_Options;

	@FindBy(css = "input[aria-label='securityQuesAns']")
	private WebElement Security_QuesAns;

	@FindBy(xpath = "//input[@name='newPassword']")
	private WebElement New_Password_txt;

	@FindBy(xpath = "//input[@name='confirmPassword']")
	private WebElement Confirm_Password_txt;

	@FindBy(xpath = "//button[@value='Create Account']")
	private WebElement Create_Account_Btn;

	@FindBy(xpath = "//div[@class='mm-alert mm-alert--success']")
	private WebElement Success_Message;

	public void Enter_Details_For_SignUP() throws InterruptedException {

		verifyText(SignUp_Page_Text, "Veriy page Text", "Sign up to Money Mart");

		String first_Name = "saida" + random_String();
		Enter_Text(First_Name_txt, "User Entering First Name", first_Name);
        System.out.println("Customer First Name : " + first_Name);
		
		String last_Name = "saida" + random_String();
		Enter_Text(Last_Name_txt, "User Entering First Name", last_Name);
		System.out.println("Customer Last Name :  " + last_Name);
		
		
		Enter_Text(date_Of_birth, "User entering Date Of birth", generateDynamicDOB());

		Enter_Text(Phone_Number_txt, "User Entering Phone Number", Random_Ph_Number());

		Enter_Text(Email_txt, "User Entering EmailID", random_String() + "@yopmail.com");
		System.out.println(Email_txt.getText());
		System.out.println("Email ID : " + Email_txt.getText());
		
		Security_DropDown.click();

		for (int i = 0; i < Security_Options.size(); i++) {
			String Web_Security_Options = Security_Options.get(i).getText();
			if (Web_Security_Options.equalsIgnoreCase("What was your childhood nickname?")) {
				Security_Options.get(i).click();
				break;
			}
		}

		Security_QuesAns.sendKeys("Chary");

		String password = "Chary@" + randomNumeric();
		System.out.println(password);
		Enter_Text(New_Password_txt, "User Entering Password", password);
		Enter_Text(Confirm_Password_txt,"User Entering Confirm passord", password);

	}

	public void Click_On_Create_Button() {
		Click(Create_Account_Btn, "User Clicking on Create Button");

	}

}
