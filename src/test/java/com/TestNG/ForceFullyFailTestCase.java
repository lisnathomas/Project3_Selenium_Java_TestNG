package com.TestNG;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import tests.BaseTest;

@Listeners(ScreenshotListener.class)
public class ForceFullyFailTestCase extends BaseTest {
	@DataProvider(name = "successfulLogin")
	public Object[][] loginData() {
		return new Object[][] { { "standard_user", "secret_sauce" } };
	}

//	@Test(dataProvider = "successfulLogin")
//	public void forcefullyFailTestCase(String username, String password) {
//
//		loginPage.enterUsername(username);
//		loginPage.enterPassword(password);
//		loginPage.clickOnLoginButton();
//
//		System.out.println("User logged in successfully");
//		Assert.assertEquals(driver.getTitle(), "No Swag Labs");
//	}

	public WebDriver getDriver() {
		return driver;
	}
	
	
}
