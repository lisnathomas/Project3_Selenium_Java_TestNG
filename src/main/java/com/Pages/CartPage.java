package com.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	public List<String> getTempListOfProductsAddedToCompare() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("Sauce Labs Bolt T-Shirt");
		stringList.add("Test.allTheThings() T-Shirt (Red)");
		return stringList;
	}
	public List<WebElement> getListOfProductsAddedFromWebsite() {
		List<WebElement> itemList = driver.findElements(By.xpath("//div[@class='cart_item_label']/a[1]/div[1]"));
		return itemList;
	}
	public boolean compare(List<String> listOfProducts, List<WebElement> listOfProductsFromWebsite) {
		for (WebElement webElement : listOfProductsFromWebsite) {
			 boolean isTheRightProductAdded = listOfProducts.contains(webElement.getText());
			 if(isTheRightProductAdded == false) {
				 return false;
			 }
		}
		return true;
	}
	public void clickOnCheckoutButton() {
		 WebElement checkoutButton = driver.findElement(By.id("checkout"));
		 checkoutButton.click();
	}
}
