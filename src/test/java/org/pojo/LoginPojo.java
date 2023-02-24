package org.pojo;

import org.baseclass.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends Baseclass {

	
	public LoginPojo() {

		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindAll({

			@FindBy(xpath = "//div[@role=\"alert\"]"), @FindBy(xpath = "//div[@id=\"toast-container\"]")

	})
	private WebElement toastMsg;

	
	public WebElement getToastMsg() {
		return toastMsg;
	}

	@CacheLookup
	@FindAll({

			@FindBy(xpath="//input[@name=\"username\"]"), @FindBy(xpath = "//span[text()=\"Username\"]") })
	private WebElement txtUser;

	@FindBy(xpath="//input[@name=\"password\"]")
	private WebElement txtPass;

	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement btnLogin;

	public WebElement getTxtUser() {
		return txtUser;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}


}
