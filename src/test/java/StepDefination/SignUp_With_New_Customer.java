package StepDefination;

import java.io.IOException;
import PageObject.Page_01_HomePage;
import PageObject.Page_02_SignIn;
import PageObject.Page_03_SignUP_To_MoneyMart;
import Utilities.BaseClass;
import io.cucumber.java.en.*;

public class SignUp_With_New_Customer extends BaseClass {

	@Given("User Launch The Brower")
	public void user_launch_the_brower() throws IOException {

		Initiate_Browser();

	}

	@When("User Entered Url {string}")
	public void user_entered_url(String url) throws IOException {
		Launch_Web_Url();

	}

	@When("User Clicked On SignIn Signup Option")
	public void user_clicked_on_sign_in_signup_option() throws InterruptedException {
		Obj_HomePage = new Page_01_HomePage(driver);
		Obj_HomePage.Click_On_Sign_In_SignUp();
	}

	@When("User Clicked On Sign Up Now Option")
	public void user_clicked_on_sign_up_now_option() throws InterruptedException {

		Obj_SignIn = new Page_02_SignIn(driver);
		Obj_SignIn.Click_On_SignUp_Now();
	}

	@Then("User Enter the details")
	public void user_enter_the_details() throws InterruptedException {
		Obj_SignUp = new Page_03_SignUP_To_MoneyMart(driver);
		Obj_SignUp.Enter_Details_For_SignUP();
	}

	@Then("User Clicked On Creat Account button")
	public void user_clicked_on_creat_account_button() {

		Obj_SignUp = new Page_03_SignUP_To_MoneyMart(driver);
		Obj_SignUp.Click_On_Create_Button();

	}

	@Then("Close The browser")
	public void close_the_browser() {

//		driver.quit();
		
	}

}
