package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)



@CucumberOptions(features = "C:\\Users\\ar287\\eclipse-workspace\\LIMS-MultipleLogin\\src\\test\\resources\\FeatureFiles", glue = "org.stepdefinition",


		dryRun = false, monochrome = true, tags = ("@login"), plugin = {

				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:C:\\Users\\ar287\\eclipse-workspace\\LIMS-MultipleLogin\\Reports\\JsonReports\\report.json",
				"rerun:C:\\Users\\ar287\\eclipse-workspace\\LIMS-MultipleLogin\\ReRun\\failedCases.txt" })


public class RunnerClass {

}
