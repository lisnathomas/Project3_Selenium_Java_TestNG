package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pages.LoginPage;

public class LoginTest extends BaseTest {
		
	@DataProvider(name = "successfulLogin")
	public Object[][] loginData() {
		return new Object[][] { { "standard_user", "secret_sauce" }, { "locked_out_user", "secret_sauce" },
				{ "problem_user", "secret_sauce" }, { "performance_glitch_user", "secret_sauce" },
				{ "error_user", "secret_sauce" }, { "visual_user", "secret_sauce" } };
	}

	@DataProvider(name = "loginWithInvalidCredentials")
	public Object[][] loginWithInvalidCredentials() {
		return new Object[][] {
				{ "un-standard_user", "secret_sauce",
						"Epic sadface: Username and password do not match any user in this service" },
				{ "standard_user", "secret_saucess1",
						"Epic sadface: Username and password do not match any user in this service" },
				{ "", "secret_sauce", "Epic sadface: Username is required" },
				{ "standard_user", "", "Epic sadface: Password is required" } };
	}

	@Test(dataProvider = "successfulLogin")
	public void testSuccessfulLogin(String username, String password) {

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();

		System.out.println("User logged in successfully");
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}

	@Test(dataProvider = "loginWithInvalidCredentials")
	public void testLoginWithInvalidCredentials(String username, String password, String message) {
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();

		String errorNotification = loginPage.getErrorNotificationMessage();
		Assert.assertEquals(errorNotification, message);
	}
}
