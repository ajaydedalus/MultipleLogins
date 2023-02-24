package org.stepdefinition;

import org.baseclass.Baseclass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.pojo.LoginPojo;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks extends Baseclass {

	@Before("@login")
	public void befLogin() throws InterruptedException {
		browserLaunch();
		maxWindow();
		impWait();
	}

	@After("@login")
	public void aftLogin() {
		driver.quit();

	}

	@AfterStep
	public void snapMethod(Scenario s) {
		if (s.isFailed()) {

			byte[] screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			s.attach(screenshotAs, "image/png", "error msg");

		}

	}

}
