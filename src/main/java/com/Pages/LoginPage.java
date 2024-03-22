package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		WebElement usernameInput = driver.findElement(By.id("user-name"));
		usernameInput.sendKeys(username);
	}
	public void enterPassword(String password) {
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(password);
	}
	public void clickOnLoginButton() {
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
	}

	public String getErrorNotificationMessage() {
		return driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
	}
	public void clickLogoutButton()
	{
		WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
		menuButton.click();
		WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
		logoutButton.click();
	}

	public String getLoginLogoText() {
		return driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
	}
}
