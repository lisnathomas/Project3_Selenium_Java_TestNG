package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	public void enterFirstName(String firstName) {
		WebElement firstNameElement = driver.findElement(By.id("first-name"));
		firstNameElement.click();
		firstNameElement.sendKeys(firstName);
	}
	public void enterLastName(String lastName) {
		WebElement lastNameElement = driver.findElement(By.id("last-name"));
		lastNameElement.click();
		lastNameElement.sendKeys(lastName);
	}
	public void enterZipCode(String zipCode) {
		WebElement zipCodeElement = driver.findElement(By.id("postal-code"));
		zipCodeElement.click();
		zipCodeElement.sendKeys(zipCode);
	}
	public void clickOnContinueButton() {
		WebElement continuebtn = driver.findElement(By.id("continue"));
		continuebtn.click();
	}
	public String getErrorNotification() {
		return driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
	}
	public String getCheckoutPageTwoTitleValue() {
		return driver.findElement(By.xpath("//span[@class='title']")).getText();
	}
	public String getPaymentInformation() {
		return driver.findElement(By.xpath("//div[@class='summary_info']/div[2]")).getText();
	}
	public String getPriceTotal() {
		return driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']")).getText();
	}
	public void clickOnFinishButton() {
		WebElement finishButton = driver.findElement(By.id("finish"));
		finishButton.click();		
	}
	public String getCompleteOrderText() {
		return driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
	}
}
