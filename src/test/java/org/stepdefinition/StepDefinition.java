package org.stepdefinition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.baseclass.Baseclass;
import org.pojo.LoginPojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends Baseclass{

	LoginPojo l = new LoginPojo();
	public String currentUrl = "";
	
	@Given("User in Login page")
	public void user_in_Login_page() throws InterruptedException {

		urlLaunch();
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}

	@When("User enters invalid username and invalid password")
	public String user_enters_invalid_username_and_invalid_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), excelRead(1, 0));
		toPassInput(l.getTxtPass(), excelRead(1, 1));
		clickBtn(l.getBtnLogin());
		expWait(l.getTxtUser());
		currentUrl = driver.getCurrentUrl();
		assertTrue("url check", currentUrl.contains("Login"));
		return currentUrl;

	}

	@When("User enters valid username and invalid password")
	public void user_enters_valid_username_and_invalid_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), excelRead(2, 0));
		toPassInput(l.getTxtPass(), excelRead(2, 1));
		clickBtn(l.getBtnLogin());
		expWait(l.getTxtUser());
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@When("User enters invalid username and valid password")
	public void user_enters_invalid_username_and_valid_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), excelRead(3, 0));
		toPassInput(l.getTxtPass(), excelRead(3, 1));
		clickBtn(l.getBtnLogin());
		expWait(l.getTxtUser());
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@Then("Verifying toast message Invalid username and Invalid password")
	public void verifying_toast_message_invalid_username_and_invalid_password() {
		expWait(l.getToastMsg());
		String toastmsg1 = l.getToastMsg().getText();
		assertTrue("Verify toast message", toastmsg1.contains("Invalid Username or Password"));
	}

	@When("User enters empty username and valid password")
	public void user_enters_empty_username_and_valid_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), "");
		toPassInput(l.getTxtPass(), excelRead(4, 1));
		clickBtn(l.getBtnLogin());
		expWait(l.getTxtUser());
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@Then("Verifying toast message Enter the username")
	public void verifying_toast_message_enter_the_username() {
		expWait(l.getToastMsg());
		String toast2 = l.getToastMsg().getText();
		assertTrue("toast2", toast2.contains("Enter the username"));
	}

	@When("User enters empty username and invalid password")
	public void user_enters_empty_username_and_invalid_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), "");
		toPassInput(l.getTxtPass(), excelRead(5, 1));
		clickBtn(l.getBtnLogin());
		expWait(l.getTxtUser());
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@When("User enters valid username and empty password")
	public void user_enters_valid_username_and_empty_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), excelRead(6, 0));
		toPassInput(l.getTxtPass(), "");
		clickBtn(l.getBtnLogin());
		expWait(l.getTxtUser());
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@Then("Verifying toast message Enter the password")
	public void verifying_toast_message_enter_the_password() {
		expWait(l.getToastMsg());
		String toast3 = l.getToastMsg().getText();
		System.out.println("toast : " + toast3);
		assertTrue("toast3", toast3.contains("Enter the password"));
	}

	@When("User enters invalid username and empty password")
	public void user_enters_invalid_username_and_empty_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), excelRead(7, 0));
		toPassInput(l.getTxtPass(), "");
		clickBtn(l.getBtnLogin());
		expWait(l.getTxtUser());
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@When("User enters empty username and empty password")
	public void user_enters_empty_username_and_empty_password() throws IOException, InterruptedException {
		toPassInput(l.getTxtUser(), "");
		toPassInput(l.getTxtPass(), "");
		clickBtn(l.getBtnLogin());
		expWait(l.getTxtUser());
		assertFalse("url check", currentUrl.contains("Mainpage"));

	}

	@When("User enters valid username and valid password")
	public void user_enters_valid_username_and_valid_password() throws IOException, InterruptedException, AWTException {
		toPassInput(l.getTxtUser(), excelRead(9, 0));
		toPassInput(l.getTxtPass(), excelRead(9, 1));
		clickBtn(l.getBtnLogin());
		Thread.sleep(10000);

	}

	@When("User confirming that he is home page")
	public void user_confirming_that_he_is_home_page() throws IOException, InterruptedException {
		assertFalse("Url check", currentUrl.contains("Login"));

	}


	
}
